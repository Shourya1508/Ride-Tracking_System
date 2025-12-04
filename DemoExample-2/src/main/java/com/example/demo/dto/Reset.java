package com.example.demo.dto;

public class Reset {

	private String password;
	private String confirm_password;
	public Reset(String password, String confirm_password) {
		super();
		this.password = password;
		this.confirm_password = confirm_password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	
	
	
}
