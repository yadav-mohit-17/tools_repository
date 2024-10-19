package com.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {
	
	public static Calculator calc;
	
	@BeforeClass
	public static void init() {
		calc=new Calculator();
	}

	@Test
	@Ignore
	public void TestAdd() {
	//	Calculator calc = new Calculator();
		Integer actualResult=calc.add(10, 20);
		Integer expectedResult=30;
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	@Ignore
	public void TestSubtract() {
	//	Calculator calc = new Calculator();
		Integer actualResult=calc.subtract(20, 10);
		Integer expectedResult=10;
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void TestMultiply() {
	//	Calculator calc = new Calculator();
		Integer actualResult=calc.multiply(20, 10);
		Integer expectedResult=200;
		assertEquals(actualResult, expectedResult);
	}

	@Test
	public void TestDivide() {
	//	Calculator calc = new Calculator();
		Integer actualResult=calc.div(20, 10);
		Integer expectedResult=2;
		assertEquals(actualResult, expectedResult);
	}
	
	@Test(expected = ArithmeticException.class)
	public void TestDivide_01() {
	//	Calculator calc = new Calculator();
		calc.div(20, 0);	
	}
	
	@Test(timeout = 1005)
	public void TestDivide_02() {
		Calculator calc = new Calculator();
		calc.div(20, 2);	
	}
	
	@AfterClass
	public static void destroy() {
		calc=null;
	}
}
