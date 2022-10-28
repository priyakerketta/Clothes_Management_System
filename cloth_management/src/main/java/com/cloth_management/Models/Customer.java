package com.cloth_management.Models;

public class Customer {
	
	private int  cust_id  ;
    private String cust_fname ;
    private String cust_lname ;
    private String username ;
    private String cust_email ;
    private String city ;
    private String street ;
    private int pin;
    
	public Customer(int cust_id, String cust_fname, String cust_lname, String username, String cust_email, String city,
			String street, int pin) {
		super();
		this.cust_id = cust_id;
		this.cust_fname = cust_fname;
		this.cust_lname = cust_lname;
		this.username = username;
		this.cust_email = cust_email;
		this.city = city;
		this.street = street;
		this.pin = pin;
	}
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_fname() {
		return cust_fname;
	}
	public void setCust_fname(String cust_fname) {
		this.cust_fname = cust_fname;
	}
	public String getCust_lname() {
		return cust_lname;
	}
	public void setCust_lname(String cust_lname) {
		this.cust_lname = cust_lname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCust_email() {
		return cust_email;
	}
	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}
