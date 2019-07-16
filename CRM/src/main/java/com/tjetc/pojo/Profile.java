package com.tjetc.pojo;

public class Profile {
	//db.properties配置文件的id
    private Integer id;
    //数据库用户名
    private String name;
    //数据库用户的密码
    private String password;
    //用的数据库名
    private String url;
    //数据库ip地址
    private String driver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }

	@Override
	public String toString() {
		return "Profile [id=" + id + ", name=" + name + ", password=" + password + ", url=" + url + ", driver=" + driver
				+ "]";
	}
    
}