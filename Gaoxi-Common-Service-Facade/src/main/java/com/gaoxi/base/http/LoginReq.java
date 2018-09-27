package com.gaoxi.base.http;

import java.io.Serializable;

public class LoginReq implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3639129842912671921L;

	private String username;
	
	private String pwd;

	public String getUsername() {
		return username;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}
	

	public String getPwd() {
		return pwd;
	}
	

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	
}
