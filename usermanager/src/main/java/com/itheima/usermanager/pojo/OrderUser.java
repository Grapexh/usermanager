package com.itheima.usermanager.pojo;

public class OrderUser extends Order {
	private String userName;
	
	private String password;
	
	private String name;
	
	private Integer age;

	public String getUsername() {
		return userName;
	}


	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "OrderUser [username=" + userName + ", password=" + password + ", name=" + name + ", age=" + age + "]";
	}
	
}
