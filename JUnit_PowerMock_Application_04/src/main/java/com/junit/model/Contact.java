package com.junit.model;

public class Contact {
	
	private Integer contactId;
	private String contactName;
	private Long contactNum;
	private String contactEmail;
	
	
	public Contact(Integer contactId, String contactName, Long contactNum, String contactEmail) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNum = contactNum;
		this.contactEmail = contactEmail;
	}
	
	public String getContactEmail() {
		return contactEmail;
	}


}
