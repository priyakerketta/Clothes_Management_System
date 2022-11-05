package com.cloth_management.Models;

public class Admin {
	
	private int ad_id ;
	private String ad_fname ;
	private String ad_lname ;
	private String username ;
	private String ad_email ;
	
	public Admin(int ad_id, String ad_fname, String ad_lname, String username, String ad_email) {
		super();
		this.ad_id = ad_id;
		this.ad_fname = ad_fname;
		this.ad_lname = ad_lname;
		this.username = username;
		this.ad_email = ad_email;
	}
	
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	public String getAd_fname() {
		return ad_fname;
	}
	public void setAd_fname(String ad_fname) {
		this.ad_fname = ad_fname;
	}
	public String getAd_lname() {
		return ad_lname;
	}
	public void setAd_lname(String ad_lname) {
		this.ad_lname = ad_lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAd_email() {
		return ad_email;
	}
	public void setAd_email(String ad_email) {
		this.ad_email = ad_email;
	}
	

}
