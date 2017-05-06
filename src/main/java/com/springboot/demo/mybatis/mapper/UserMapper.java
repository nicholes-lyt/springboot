package com.springboot.demo.mybatis.mapper;

import java.util.Date;

public class UserMapper {
	
	private String username;
	
	private String realname;
	
	private Date cratedate;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Date getCratedate() {
		return cratedate;
	}

	public void setCratedate(Date cratedate) {
		this.cratedate = cratedate;
	}

	@Override
	public String toString() {
		return "UserMapper [username=" + username + ", realname=" + realname + ", cratedate=" + cratedate + "]";
	}

	
	
	
	
}
