package com.junit.service;

import java.util.List;

import com.junit.entity.Contact;

public interface ContactService {
	
	public String getNameById(Integer id);
	public List<String> getAllContactNames();
	public Contact getContactById(Integer id);

}
