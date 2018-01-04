package com.itheima.usermanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.druid.util.StringUtils;
import com.itheima.usermanager.pojo.EasyUIPageBean;
import com.itheima.usermanager.pojo.User;
import com.itheima.usermanager.service.UserService;

@Controller
@RequestMapping("rest/user")
public class NewUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<EasyUIPageBean> queryUserListByPage(@RequestParam("page")Integer pageNum, @RequestParam("rows")Integer pageSize){
		try {
			EasyUIPageBean easyUIPageBean = userService.queryUserListByPage(pageNum, pageSize);
			return ResponseEntity.ok(easyUIPageBean);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public ResponseEntity<User> queryUserById(@PathVariable("id")Long id){
		try {
			if(id == null || id <= 0){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
			User user = userService.queryUserById(id);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insertUser(User user){
		try {
			if(user == null || StringUtils.isEmpty(user.getUserName())){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			userService.insertUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(User user){
		try {
			if(user == null || user.getId() == null){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			userService.updateUser(user);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUserById(@RequestParam("id")Long id){
		try {
			if(id == null || id <= 0){
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
			userService.deleteUserById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
