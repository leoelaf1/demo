package com.example.cleanserver;

import java.util.ArrayList;

public class CleanOutput {

	private String filename;
	private String errorMessage;
	private ArrayList<PersonRecord> personRecords; 
	private ArrayList<PersonRecord> nonDuplicates;
	private ArrayList<DuplicateGroup> duplicateGroups;
	
	public CleanOutput() {
		super();
		this.nonDuplicates = new ArrayList<PersonRecord>();
		this.duplicateGroups = new ArrayList<DuplicateGroup>();
	}
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ArrayList<PersonRecord> getPersonRecords() {
		return personRecords;
	}

	public void setPersonRecords(ArrayList<PersonRecord> personRecords) {
		this.personRecords = personRecords;
	}

	public ArrayList<PersonRecord> getNonDuplicates() {
		return nonDuplicates;
	}

	public void addNonDuplicate(PersonRecord nonDuplicate) {
		this.nonDuplicates.add(nonDuplicate);
	}

	public ArrayList<DuplicateGroup> getDuplicateGroups() {
		return duplicateGroups;
	}

	public void addDuplicateGroup(DuplicateGroup duplicateGroup) {
		this.duplicateGroups.add(duplicateGroup);
	}

}
