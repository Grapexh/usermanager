package com.itheima.usermanager.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.entity.Example;
import com.github.abel533.entity.Example.Criteria;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.usermanager.mapper.NewUserMapper;
import com.itheima.usermanager.mapper.UserMapper;
import com.itheima.usermanager.pojo.EasyUIPageBean;
import com.itheima.usermanager.pojo.User;
import com.itheima.usermanager.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private NewUserMapper newUserMapper;
	
	@Override
	public EasyUIPageBean queryUserListByPage(Integer pageNum, Integer pageSize) {
		EasyUIPageBean easyUIPageBean = new EasyUIPageBean();
		PageHelper.startPage(pageNum, pageSize);
		List<User> list = newUserMapper.select(null);
		PageInfo<User> page = new PageInfo<User>(list);
		easyUIPageBean.setTotal(page.getTotal());
		easyUIPageBean.setRows(page.getList());
		return easyUIPageBean;
	}

	@Override
	public boolean insertUser(User user) throws Exception{
		Date date = new Date();
		user.setCreated(date);
		user.setUpdated(date);
		int count = newUserMapper.insertSelective(user);
		if(count > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		user.setUpdated(new Date());
		int count = newUserMapper.updateByPrimaryKeySelective(user);
		return count > 0;
	}

	@Override
	public boolean deleteUserByIds(List<Object> ids) {
		Example example = new Example(User.class);
		Criteria criteria = example.createCriteria();
		criteria.andIn("id", ids);
		int count = newUserMapper.deleteByExample(example);
		return count > 0;
	}

	@Override
	public User queryUserById(Long id) {
		return newUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleteUserById(Long id) {
		newUserMapper.deleteByPrimaryKey(id);
	}
}
