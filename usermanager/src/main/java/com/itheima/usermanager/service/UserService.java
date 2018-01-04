package com.itheima.usermanager.service;

import java.util.List;

import com.itheima.usermanager.pojo.EasyUIPageBean;
import com.itheima.usermanager.pojo.User;

public interface UserService {

	/**
	 * 分页查询用户集合
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public EasyUIPageBean queryUserListByPage(Integer pageNum, Integer pageSize);

	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	public boolean insertUser (User user) throws Exception;

	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);

	/**
	 * 根据id集合 批量删除用户
	 * @param ids
	 * @return
	 */
	public boolean deleteUserByIds(List<Object> ids);

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	public User queryUserById(Long id);

	/**根据id删除用户
	 * @param id
	 */
	public void deleteUserById(Long id);
}
