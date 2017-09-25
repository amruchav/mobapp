package com.cg.enquiry.DTO;

public class EnquiryDetails {
	
	private int enquiryId;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String domain;
	private String location;
	
	public EnquiryDetails(){
		
	}
	
	//Gettter and setter for all fields
	public int getEnquiryId() {
		return enquiryId;
	}
	public void setEnquiryId(int enquiryId) {
		this.enquiryId = enquiryId;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	//Constructor to add enquiry details
	
	public EnquiryDetails(String firstName, String lastName, String phoneNo,
			String domain, String location) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.domain = domain;
		this.location = location;
	}
	
	//Constructor to retrive enquiry details
	public EnquiryDetails(int enquiryId, String firstName, String lastName,
			String phoneNo, String domain, String location) {
		super();
		this.enquiryId = enquiryId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.domain = domain;
		this.location = location;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	

}
