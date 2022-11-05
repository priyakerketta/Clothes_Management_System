package com.cloth_management.Models;

public class LoginDetails {
	
	private String username ;
    private String user_password ;
    private String user_type ;
    
	public LoginDetails(String username, String user_password, String user_type) {
		super();
		this.username = username;
		this.user_password = user_password;
		this.user_type = user_type;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

}
