package com.example.cleanserver;

import java.util.ArrayList;

public class DuplicateGroup {

	private ArrayList<PersonRecord> duplicates;

	public DuplicateGroup() {
		super();
		this.duplicates = new ArrayList<PersonRecord>();
	}

	public ArrayList<PersonRecord> getDuplicates() {
		return duplicates;
	}

	public void addDuplicate(PersonRecord duplicate) {
		this.duplicates.add(duplicate);
	}
	
}
