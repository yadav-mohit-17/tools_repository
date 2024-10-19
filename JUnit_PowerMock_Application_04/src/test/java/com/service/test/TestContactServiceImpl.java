package com.service.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.junit.dao.ContactDao;
import com.junit.exception.NoDataFoundException;
import com.junit.model.Contact;
import com.junit.service.ContactServiceImpl;
import com.junit.util.EmailUtils;

public class TestContactServiceImpl {
	
	@Test
	public void testGetContactNumByName_01() {
		ContactDao daoMock = PowerMockito.mock(ContactDao.class);
		PowerMockito.when(daoMock.findContactNumByName("Mohit")).thenReturn(9128441424l);
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDao(daoMock);
		Long num=service.getContactNumByName("Mohit");
		assertNotNull(num);
	}
	
	@Test
	public void testGetContactNumByName_02() {
		ContactDao daoMock = PowerMockito.mock(ContactDao.class);
		PowerMockito.when(daoMock.findContactNumByName("Nihit")).thenReturn(null);
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDao(daoMock);
		Long num=service.getContactNumByName("Nihit");
		assertNull(num);	
	}
	
	@Test
	public void testGetAllContacts_01() {
		ContactDao daoMock = PowerMockito.mock(ContactDao.class);
		List<Contact> contactList=new ArrayList<Contact>();
		contactList.add(new Contact(101,"Mohit",9128441424l,"abc@gmail.com"));
		contactList.add(new Contact(102,"Nihit",7644090034l,"bcd@gmail.com"));
		contactList.add(new Contact(101,"Rithanya",2378472898l,"efg@gmail.com"));
		contactList.add(new Contact(101,"Divisha",12434567543l,"hig@gmail.com"));
		
		PowerMockito.when(daoMock.findAll()).thenReturn(contactList);
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDao(daoMock);
		List<Contact> list = service.getAllContacts();
		assertNotNull(list);
	}
	
	@Test(expected = NoDataFoundException.class)
	public void testGetAllContacts_02() {
		ContactDao daoMock= PowerMockito.mock(ContactDao.class);
		PowerMockito.when(daoMock.findAll()).thenReturn(null);
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDao(daoMock);
		service.getAllContacts();
	}
	
	@Test(expected = NoDataFoundException.class)
	public void testInActiveRecords_01() {
		ContactDao daoMock=PowerMockito.mock(ContactDao.class);
		PowerMockito.when(daoMock.findInActiveRecords()).thenReturn(null);
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDao(daoMock);
		service.getInActiveRecords();
	}
	
	@Test(expected = NullPointerException.class)
	public void testInActiveRecords_02() {
		ContactDao daoMock = PowerMockito.mock(ContactDao.class);
		PowerMockito.when(daoMock.findInActiveRecords()).thenThrow(NullPointerException.class);
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDao(daoMock);
		service.getInActiveRecords();
	}
	
	@Test
	public void testSaveContact() {
		ContactDao daoMock = PowerMockito.mock(ContactDao.class);
		EmailUtils emailMock=PowerMockito.mock(EmailUtils.class);
		Contact c = new Contact(101, "Mohit", 9128441424l, "mohit@gmail.com");
		
		PowerMockito.when(daoMock.saveContact(c)).thenReturn(true);
		PowerMockito.when(emailMock.sendEmail(c.getContactEmail())).thenReturn(true);
		ContactServiceImpl service = new ContactServiceImpl();
		service.setDao(daoMock);
		service.setEmailUtils(emailMock);
		
		boolean saveContact=service.saveContact(c);
		assertTrue(saveContact);
	}
}
