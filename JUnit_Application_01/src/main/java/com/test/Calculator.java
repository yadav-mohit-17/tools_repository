package com.test;

public class Calculator {
	
	public Integer add(Integer a, Integer b) {
		return a+b;
	}
	
	public Integer subtract(Integer a, Integer b) {
		return a-b;
	}
	
	public Integer multiply(Integer a, Integer b) {
		return a*b;
	}
	
	public Integer div(Integer a, Integer b) {
		try {
			Thread.sleep(1005);
		}
		catch(InterruptedException ie) {
			ie.printStackTrace();
		}
		return a/b;
	}

}
