package com.junit.service;

import java.util.List;

import com.junit.dao.ContactDao;
import com.junit.entity.Contact;
import com.junit.exception.NoDataFoundException;

public class ContactServiceImpl implements ContactService {

	private ContactDao contactDao;
	
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	public String getNameById(Integer id) {
		String name=contactDao.findNameById(id);
		String formattedName=name.toUpperCase();
		return formattedName;
	}

	public List<String> getAllContactNames() {
		List<String> names=contactDao.findNames();
		if(!names.isEmpty()) {
			return names;
		}
		return null;
	}

	public Contact getContactById(Integer id) {
		Contact contact = contactDao.findById(id);
		if(contact==null) {
			throw new NoDataFoundException();
		}
		return contact;
	}

}
