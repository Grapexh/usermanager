package com.itheima.usermanager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itheima.usermanager.pojo.User;

public interface UserMapper {
	
	public User queryUserById (@Param("id")Long id);

	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<User> queryUserList();

	/**
	 * 保存一个用户
	 * @param user
	 * @return
	 */
	public int insertUser(User user);
}
