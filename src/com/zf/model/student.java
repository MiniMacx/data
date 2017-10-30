package com.zf.model;

public class student {
	private Integer user_id;
	private String telephone;
	private String password;
	private String username;
	private Integer age;

	

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}



	@Override
	public String toString() {
		return "student [user_id=" + user_id + ", telephone=" + telephone + ", password=" + password + ", username="
				+ username + ", age=" + age + "]";
	}


	
}
