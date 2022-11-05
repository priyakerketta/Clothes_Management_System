package com.cloth_management.Models;

public class EmployeePhoneNo {
	
	private String emp_phoneno ;
	private int emp_id ;
	
    public EmployeePhoneNo(String emp_phoneno, int emp_id) {
		super();
		this.emp_phoneno = emp_phoneno;
		this.emp_id = emp_id;
	}
    
	public String getEmp_phoneno() {
		return emp_phoneno;
	}
	public void setEmp_phoneno(String emp_phoneno) {
		this.emp_phoneno = emp_phoneno;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	

}
