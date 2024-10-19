package com.sonarqube.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class TestApp1 {
	
	public void m1() {
		//systrace
		System.out.println("TestApp1.m1()");
	 	String s1="";
		List<Integer> list=new ArrayList();
		list.add(10);
		list.add(20);
		list=null;
		list.add(40);
	}
	
	public void m2() {
		System.out.println("TestApp1.m2()");
	}
	
	public void addUser(String name, String address, String email, float salary, Date dob) {
		//sysout
	}
	
	public static void main(String[] args) {
		String s=null;
		int a = 10;
		System.out.println("a value :"+a);
		System.out.println("TestApp1.main()-> (start)");
	
		TestApp1 app1 = new TestApp1();
		app1.m1();
		
		System.out.println("TestApp1.main()-> (End)");
	}

}
