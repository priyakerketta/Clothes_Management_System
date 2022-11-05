package com.cloth_management.Models;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdminPhoneNo {
	
	private String ad_phoneno ;
	private int ad_id ;
    
    public AdminPhoneNo(String ad_phoneno, int ad_id) {
		super();
		this.ad_phoneno = ad_phoneno;
		this.ad_id = ad_id;
	}
    
	public String getAd_phoneno() {
		return ad_phoneno;
	}
	public void setAd_phoneno(String ad_phoneno) {
		this.ad_phoneno = ad_phoneno;
	}
	public int getAd_id() {
		return ad_id;
	}
	public void setAd_id(int ad_id) {
		this.ad_id = ad_id;
	}
	

}
