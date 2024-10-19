package com.service.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.junit.dao.ContactDao;
import com.junit.entity.Contact;
import com.junit.service.ContactServiceImpl;

public class ContactServiceImplTest {
	
	private static ContactServiceImpl service=null;
	
	@BeforeClass
	public static void init() {
		//Creating proxy object 
		ContactDao daoProxy=EasyMock.createMock(ContactDao.class);
		
		//set the behaviour for method-1
		EasyMock.expect(daoProxy.findNameById(101)).andReturn("Nihit");
		EasyMock.expect(daoProxy.findNameById(102)).andReturn("Rithanya");
		
		//set the behaviour for method-2
		List<String> names= new ArrayList();
		names.add("Nihit Kumar");
		names.add("Divisha");
		names.add("Murari");
		names.add("Rithanya");
		EasyMock.expect(daoProxy.findNames()).andReturn(names);
		
		//set the behaviour for method-3
		Contact c = new Contact();
		c.setContactId(101);
		c.setContactName("Mohit");
		c.setContactNumber(9128441424l);
		EasyMock.expect(daoProxy.findById(101)).andReturn(c);
		
		//save the behaviour of proxy object
		EasyMock.replay(daoProxy);
		
		//creating target class object
		service=new ContactServiceImpl();
		
		//injecting proxy object into target
		service.setContactDao(daoProxy);
	}
	
	@Test
	public void testGetNameById() {
		String name=service.getNameById(101);
		assertNotNull(name);
	}
	
	@Ignore
	@Test
	public void testGetNames() {
		List<String>contactNames=service.getAllContactNames();
		assertNotNull(contactNames);
	}
	
	@Ignore
	@Test
	public void testGetContactById() {		
		Contact con = service.getContactById(101);
		assertNotNull(con);	
	}
	
	@AfterClass
	public static void destroy() {
		service=null;
	}
}
