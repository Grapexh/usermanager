package com.itheima.usermanager.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itheima.usermanager.pojo.User;

public class UserMapperTest {

	private UserMapper userMapper;
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml","spring/applicationContext-mybatis.xml");
		this.userMapper = context.getBean(UserMapper.class);
		
	}

	@Test
	public void test() {
		User user = userMapper.queryUserById(1l);
		System.out.println(user);
	}

}
