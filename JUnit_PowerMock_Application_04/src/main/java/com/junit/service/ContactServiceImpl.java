package com.junit.service;

import java.util.List;

import com.junit.dao.ContactDao;
import com.junit.exception.NoDataFoundException;
import com.junit.model.Contact;
import com.junit.util.EmailUtils;

public class ContactServiceImpl implements ContactService {

	private ContactDao dao;
	private EmailUtils emailUtils;


	public void setDao(ContactDao dao) {
		this.dao = dao;
	}

	public void setEmailUtils(EmailUtils emailUtils) {
		this.emailUtils = emailUtils;
	}



	public Long getContactNumByName(String name) {
		return dao.findContactNumByName(name);
	}


	public List<Contact> getAllContacts() {
		List<Contact> contacts=dao.findAll();
		if(contacts==null) {
			throw new NoDataFoundException();
		}
		return contacts;
	}


	public List<Contact> getInActiveRecords() {
		List<Contact> inActive=dao.findInActiveRecords();
		if(inActive==null) {
			throw new NoDataFoundException();
		}
		return inActive;
	}


	public boolean saveContact(Contact c) {
		boolean isSave=dao.saveContact(c);
		boolean isSent=false;
		if(isSave) {
			isSent=emailUtils.sendEmail(c.getContactEmail());
		}
		return isSent;
	}

}
