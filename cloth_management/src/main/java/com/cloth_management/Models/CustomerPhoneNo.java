package com.cloth_management.Models;

public class CustomerPhoneNo {
	
	private String cust_phoneno ;
	private int cust_id ;
	
    public CustomerPhoneNo(String cust_phoneno, int cust_id) {
		super();
		this.cust_phoneno = cust_phoneno;
		this.cust_id = cust_id;
	}
    
	public String getCust_phoneno() {
		return cust_phoneno;
	}
	public void setCust_phoneno(String cust_phoneno) {
		this.cust_phoneno = cust_phoneno;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	
}
