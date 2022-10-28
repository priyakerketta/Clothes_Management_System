package com.cloth_management.Models;

public class Cart {
	
	private int cust_id  ;
    private int prod_id ;
    private String size ;
    private int prod_quantity ;
    
	public Cart(int cust_id, int prod_id, String size, int prod_quantity) {
		super();
		this.cust_id = cust_id;
		this.prod_id = prod_id;
		this.size = size;
		this.prod_quantity = prod_quantity;
	}
	
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getProd_quantity() {
		return prod_quantity;
	}
	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}

}
