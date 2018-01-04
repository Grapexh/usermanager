package com.itheima.usermanager.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.usermanager.pojo.EasyUIPageBean;
import com.itheima.usermanager.pojo.User;
import com.itheima.usermanager.service.UserService;

/**
 * @author admin
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 通用页面跳转
	 * @param pageName
	 * @return
	 */
	@RequestMapping("page/{pageName}")
	public String toUser(@PathVariable("pageName")String pageName){
		return pageName;
	}
	
	/**
	 * 分页查询用户信息
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("list")
	@ResponseBody
	public EasyUIPageBean queryUserListByPage(@RequestParam("page")Integer pageNum,@RequestParam("rows")Integer pageSize){
		EasyUIPageBean easyUIPageBean = userService.queryUserListByPage(pageNum,pageSize);
		return easyUIPageBean;
	}
	
	
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public Map<String,Object> saveUser(User user){
		Map<String, Object> map = new HashMap<>();
		try {
			boolean result = userService.insertUser(user);
			if(result){
				map.put("status", 200);
			}else{
				map.put("status", 500);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 500);
		}
		return map;
	}
	
	/**
	 * 根据id对用户信息进行修改
	 * @param user
	 * @return
	 */
	@RequestMapping("edit")
	@ResponseBody
	public Map<String,Object> updateUser(User user){
		Map<String, Object> map = new HashMap<>();
		try {
			boolean result = userService.updateUser(user);
			if(result){
				map.put("status", 200);
			}else{
				map.put("status", 500);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 500);
		}
		return map;
	}
	
	/**
	 * 根据id集合 批量删除用户
	 * @param ids
	 * @return
	 */
	@RequestMapping("delete")
	@ResponseBody
	public Map<String,Object> deleteUserByIds(@RequestParam("ids")List<Object> ids){
		Map<String, Object> map = new HashMap<>();
		try {
			boolean result = userService.deleteUserByIds(ids);
			if(result){
				map.put("status", 200);
			}else{
				map.put("status", 500);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 500);
		}
		return map;
	}
	
	/**
	 * 导出Excel表格,通过BeanNameViewResolver解析到UserExcelView
	 * @param model
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("export/excel")
	public String exportExcelByPage(Model model,@RequestParam("page")Integer pageNum,@RequestParam("rows")Integer pageSize){
		EasyUIPageBean pageBean = userService.queryUserListByPage(pageNum, pageSize);
		model.addAttribute("userList", pageBean.getRows());
		return "userExcelView";
	}
	
}
