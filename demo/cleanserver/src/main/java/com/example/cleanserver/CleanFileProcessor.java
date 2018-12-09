package com.example.cleanserver;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.logging.Log;
import org.apache.commons.text.similarity.LevenshteinDistance;

public class CleanFileProcessor {

	public CleanFileProcessor() {
		super();
	}

	public CleanOutput processFile(String filename) {
		CleanOutput output = new CleanOutput();
		output.setFilename(filename);

		try {
			ArrayList<PersonRecord> personRecords = this.prepData(filename);
			this.detectDuplicates(personRecords);
			this.formatOutput(output, personRecords);
		} catch (Exception e) {
			e.printStackTrace();
			output.setErrorMessage(e.getMessage());
		}

		return output;
	}

	private void formatOutput(CleanOutput output, ArrayList<PersonRecord> personRecords) {
		// track processed dups to avoid double counting
		Map<Long, PersonRecord> processedDups = new HashMap<Long, PersonRecord>();
		for (PersonRecord record : personRecords) {
			if (record.getDuplicates().isEmpty()) {
				output.addNonDuplicate(record);
			} else { // record has dupes
				if (processedDups.containsKey(record.getRecordNumber()) == false) {
					DuplicateGroup duplicateGroup = null;
					for (Long duplicate : record.getDuplicates()) {
						if (processedDups.containsKey(duplicate) == false) {
							if (duplicateGroup == null) {
								duplicateGroup = new DuplicateGroup();
								duplicateGroup.addDuplicate(record);
								processedDups.put(record.getRecordNumber(), record);
							}
							PersonRecord aDup = personRecords.get(duplicate.intValue() - 1);
							duplicateGroup.addDuplicate(aDup);
							processedDups.put(duplicate, aDup);
						}
					}
					if (duplicateGroup != null) {
						output.addDuplicateGroup(duplicateGroup);
					}
				}
			}
		}
	}
	
	private ArrayList<PersonRecord> prepData(String filename) throws IOException {
		Reader in = new FileReader(filename);
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		ArrayList<PersonRecord> personRecords = new ArrayList<PersonRecord>();
		for (CSVRecord record : records) {
			PersonRecord person = new PersonRecord();
			// TODO look into cleaning data via lowercase, trim, etc to improve comparisons
			// TODO look into normalizing fields such as 
			// 		removing co, inc etc from company, 
			//		parsing out phone and addresses to allow comparison of each part
			// 		getting the root of first and last names
			person.setRecordNumber(record.getRecordNumber());
			//person.setId(record.get("id")); // TODO find out why this does not work inexplicably
			person.setId(record.get(0)); 
			person.setFirstName(record.get("first_name"));
			person.setLastName(record.get("last_name"));
			person.setCompanyName(record.get("company"));
			person.setEmail(record.get("email"));
			person.setAddress1(record.get("address1"));
			person.setAddress2(record.get("address2"));
			person.setZip(record.get("zip"));
			person.setCity(record.get("city"));
			person.setStateLong(record.get("state_long"));
			person.setState(record.get("state"));
			person.setPhone(record.get("phone"));
			personRecords.add(person);
		}
				
		return personRecords;
	}
	
	private void detectDuplicates(ArrayList<PersonRecord> personRecords) {
		// TODO look into more efficient selection of records to compare
		for (int i=0; i < personRecords.size(); i++)  {
			for (int ii=i+1; ii < personRecords.size(); ii++) {
				PersonRecord a = personRecords.get(i);
				PersonRecord b = personRecords.get(ii);
				if (compare(a, b)) {
					a.addDuplicate(b.getRecordNumber());
					b.addDuplicate(a.getRecordNumber());
				}
			}
		}
	}
	
	// TODO use interface and inject different comparators to try out different algorithms
	private boolean compare(PersonRecord a, PersonRecord b) {
		// consider same email as same person
		if (a.getEmail().equals(b.getEmail()))
			return true;
		
		// consider same phone with similar name as same person
		if (a.getPhone().equals(b.getPhone())) {
			LevenshteinDistance ld = new LevenshteinDistance();
			Integer firstNameDistance = ld.apply(a.getFirstName(), b.getFirstName());
			Integer lastNameDistance = ld.apply(a.getLastName(), b.getLastName());
			if (firstNameDistance < 3 && lastNameDistance < 3) {
				return true;			
			}
		}

		return false;
	}
	
}
