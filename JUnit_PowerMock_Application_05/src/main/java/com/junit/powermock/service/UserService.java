package com.junit.powermock.service;

import com.junit.powermock.dao.UserDao;

public class UserService {
	
	private UserDao dao;
	
	public UserService() {
		
	}
	
	public UserService(UserDao dao) {
		this.dao=dao;
	}

	public String getNameById(Integer id) {
		String name=dao.findNameById(id);
		return name;
	}
	
	public String getEmailById(Integer id) {
		String email=dao.findEmailById(id);
		return email;
	}
	
	public void doProcess() {
		System.out.println("doProcess() method started");
		pushMsgToKafkaTopic("msg");
		System.out.println("doProcess() method ended");
	}

	public void pushMsgToKafkaTopic(String msg) {
		System.out.println("Message Pushing to Kafka.....");
	}
	
	public String doWork(String msg) {
		String formattedMsg=formatMsg(msg);
		return formattedMsg;
	}
	
	private String formatMsg(String msg) {
		return msg.toUpperCase();
	}
	
}
