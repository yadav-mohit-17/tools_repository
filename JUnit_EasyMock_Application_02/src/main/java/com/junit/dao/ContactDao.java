package com.junit.dao;

import java.util.List;

import com.junit.entity.Contact;

public interface ContactDao {
	
	public String findNameById(Integer id);
	public List<String> findNames();
	public Contact findById(Integer id);

}
