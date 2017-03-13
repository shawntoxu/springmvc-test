package com.demo.domain;

public class User {
	
    private Integer id;

    private String name;

    private String tel;

    private String pwd;
    
    private String avatar_url ; 
    
    public String getAvatar_url() {
		return avatar_url;
	}

	public void setAvatar_url(String avatar_url) {
		this.avatar_url = avatar_url;
	}

	public String getAvatar_mtime() {
		return avatar_mtime;
	}

	public void setAvatar_mtime(String avatar_mtime) {
		this.avatar_mtime = avatar_mtime;
	}

	private String avatar_mtime ;

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
}