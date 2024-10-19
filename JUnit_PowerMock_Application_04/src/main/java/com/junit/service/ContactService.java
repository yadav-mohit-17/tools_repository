package com.junit.service;

import java.util.List;

import com.junit.model.Contact;

public interface ContactService {
	
	public Long getContactNumByName(String name);
	
	public List<Contact> getAllContacts();
	
	public List<Contact> getInActiveRecords();
	
	public boolean saveContact(Contact c);

}
