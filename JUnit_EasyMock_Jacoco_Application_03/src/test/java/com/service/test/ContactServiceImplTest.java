package com.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.junit.dao.ContactDao;
import com.junit.entity.Contact;
import com.junit.exception.NoDataFoundException;
import com.junit.service.ContactServiceImpl;

public class ContactServiceImplTest {
	
	public static ContactServiceImpl service=null;
	
	@BeforeClass
	public static void init() {
		
		ContactDao daoProxy = EasyMock.createMock(ContactDao.class);
		
		//Method-1
		EasyMock.expect(daoProxy.findNameById(101)).andReturn("Mohit");
		EasyMock.expect(daoProxy.findNameById(102)).andReturn(null);
		
		//Method-2
		List<String> names = new ArrayList<>();
		names.add("Nihit");
		names.add("Divisha");
		names.add("Murari");
		names.add("Rithanya");
		EasyMock.expect(daoProxy.findNames()).andReturn(names);
		EasyMock.expect(daoProxy.findNames()).andReturn(null);
		
		//Method-3
		Contact c = new Contact();
		c.setContactId(101);
		c.setContactName("Nihit");
		c.setContactNumber(9128441424l);
		EasyMock.expect(daoProxy.findContactById(101)).andReturn(c);
		EasyMock.expect(daoProxy.findContactById(102)).andReturn(null);
		
		
		EasyMock.replay(daoProxy);
		service=new ContactServiceImpl();
		service.setContactDao(daoProxy);
	}

	@Test
	public void testGetNameById() {
		String name = service.getNameById(101);
		assertNotNull(name);
	}
	
	@Test
	public void testGetNameById_01() {
		String name=service.getNameById(102);
		assertNull(name);
	}

	@Test
	public void testGetAllNames() {
		List<String> allContactNames = service.getAllContactNames();
		assertNotNull(allContactNames);
	}
	
	@Test
	public void testGetAllNames_01() {
		List<String> allContactNames = service.getAllContactNames();
		assertNull(allContactNames);
	}

	@Test
	public void testGetContactById() {
		Contact contact = service.getContactById(101);
		assertNotNull(contact);
	}
	
	@Test(expected = NoDataFoundException.class)
	public void testGetContactById_01() {
		service.getContactById(102);	
	}
	
	@AfterClass
	public static void destroy() {
		service=null;
	}
}
