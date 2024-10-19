package com.junit.powermock.dao;

public class UserDaoImpl implements UserDao {
	
	public String findNameById(Integer id) {
		System.out.println("FindNameById() method called");
		return "Nick";
	}

	
	public String findEmailById(Integer id) {
		System.out.println("findEmailById() method called");
		return "abc@gmail.com";
	}

}
