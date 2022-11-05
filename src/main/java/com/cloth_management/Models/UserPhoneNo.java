package com.cloth_management.Models;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserPhoneNo {
	
	private String user_phoneno ;
	private int user_id ;
	
    public UserPhoneNo(String user_phoneno, int user_id) {
		super();
		this.user_phoneno = user_phoneno;
		this.user_id = user_id;
	}
    
	public String getUser_phoneno() {
		return user_phoneno;
	}
	public void setUser_phoneno(String user_phoneno) {
		this.user_phoneno = user_phoneno;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
