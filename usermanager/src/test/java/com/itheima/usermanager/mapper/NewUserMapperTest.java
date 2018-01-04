package com.itheima.usermanager.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.itheima.usermanager.pojo.User;

public class NewUserMapperTest {

	NewUserMapper newUserMapper;
	
	@SuppressWarnings("resource")
	@Before
	public void setUp() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml","spring/applicationContext-mybatis.xml");
		this.newUserMapper = context.getBean(NewUserMapper.class);
	}

	@Test
	public void testSelectOne() {
		User record = new User();
		record.setId(1l);
		record.setAge(31);
		System.out.println(newUserMapper.selectOne(record));
	}

	@Test
	public void testSelect() {
		System.out.println(newUserMapper.select(null));
	}

	@Test
	public void testSelectCount() {
		User record = new User();
		record.setPassword("123456");
		System.out.println(newUserMapper.selectCount(record));
	}

	@Test
	public void testSelectByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByPrimaryKeySelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectCountByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteByExample() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectByExample() {
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		criteria.andBetween("age", "20", 30);
		Criteria criteria2 = example.createCriteria();
		criteria2.andLessThan("age", 10);
		example.or(criteria2);
		List<User> list = newUserMapper.selectByExample(example);
		for (User user : list) {
			System.out.println(user);
		}
	}

	@Test
	public void testUpdateByExampleSelective() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByExample() {
		fail("Not yet implemented");
	}

}
