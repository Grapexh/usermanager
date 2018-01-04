package com.itheima.usermanager.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.usermanager.service.UserService;

public class UserServiceImplTest {

	UserService userService;

	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml",
				"spring/applicationContext-mybatis.xml", "spring/applicationContext-transaction.xml");
		this.userService = context.getBean(UserService.class);
	}

	@Test
	public void testTest() {
	}

}
