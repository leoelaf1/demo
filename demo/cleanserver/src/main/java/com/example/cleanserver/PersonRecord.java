package com.example.cleanserver;

import java.util.ArrayList;

public class PersonRecord {
	private Long recordNumber;
	private String id;
	private String firstName; 
	private String lastName;
	private String companyName;
	private String email;
	private String address1;
	private String address2;
	private String zip;
	private String city;
	private String stateLong;
	private String state;
	private String phone;
	private ArrayList<Long> duplicates;
	
	
	public PersonRecord() {
		super();
		this.duplicates = new ArrayList<Long>();
	}
	
	public Long getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(Long recordNumber) {
		this.recordNumber = recordNumber;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateLong() {
		return stateLong;
	}
	public void setStateLong(String stateLong) {
		this.stateLong = stateLong;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public ArrayList<Long> getDuplicates() {
		return duplicates;
	}
	public void addDuplicate(Long l) {
		this.duplicates.add(l);
	}
	
}
	