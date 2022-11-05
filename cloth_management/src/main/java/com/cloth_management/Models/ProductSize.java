package com.cloth_management.Models;

public class ProductSize {
	
	private String size ;
    private int prod_id ;
    private int quantity ;
    
	public ProductSize(String size, int prod_id, int quantity) {
		super();
		this.size = size;
		this.prod_id = prod_id;
		this.quantity = quantity;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getProd_id() {
		return prod_id;
	}
	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
