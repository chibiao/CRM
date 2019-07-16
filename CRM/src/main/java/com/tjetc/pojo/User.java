package com.tjetc.pojo;

import java.util.ArrayList;
import java.util.List;

public class User {
	private int id;
	private String name; // 姓名（登录账号）
	private String password; // 密码
	private String sex; // 性别
	private String phone; // 电话
	private String birthday; // 生日
	private String email; // email
	private String userdate; // 入职时间
	private String image; // 照片
	private List<Role> roles = new ArrayList<>(); // 用户所拥有的角色

	public User(int id, String name, String password, String sex, String phone, String birthday, String email,
			String userdate, String image, List<Role> roles) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.birthday = birthday;
		this.email = email;
		this.userdate = userdate;
		this.image = image;
		this.roles = roles;
	}

	public User(String name, String password, String sex, String phone, String birthday, String email, String userdate,
			String image, List<Role> roles) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.birthday = birthday;
		this.email = email;
		this.userdate = userdate;
		this.image = image;
		this.roles = roles;
	}

	public User(String name, String password, String sex, String phone, String birthday, String email, String userdate,
			String image) {
		super();
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.phone = phone;
		this.birthday = birthday;
		this.email = email;
		this.userdate = userdate;
		this.image = image;
	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserdate() {
		return userdate;
	}

	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", phone=" + phone
				+ ", birthday=" + birthday + ", email=" + email + ", userdate=" + userdate + ", image=" + image + "]";
	}

}
