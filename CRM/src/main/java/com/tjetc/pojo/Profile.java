package com.tjetc.pojo;

public class Profile {
	private int id;
	private String name;
	private String password;
	private String url;
	private String driver;
	
	public Profile(int id, String name, String password, String url, String driver) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.url = url;
		this.driver = driver;
	}
	public Profile() {
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", password=" + password + ", url=" + url + ", driver=" + driver
				+ "]";
	}
	
}
