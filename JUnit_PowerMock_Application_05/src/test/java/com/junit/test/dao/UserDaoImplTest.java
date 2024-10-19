package com.junit.test.dao;

import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.junit.powermock.service.UserService;


@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class) 
public class UserDaoImplTest {


	
	@Ignore
	@Test
	public void testFormatMsg() throws Exception {
		
		UserService service = new UserService();
		Class<?> clz=Class.forName("com.junit.powermock.service.UserService");
		Object obj = clz.newInstance();
		Method method = clz.getDeclaredMethod("formatMsg", String.class);
		method.setAccessible(true);
		Object returnVal=method.invoke(obj, "test msg");
		String expected="TEST MSG";
		assertEquals(expected, returnVal);
	}
}
