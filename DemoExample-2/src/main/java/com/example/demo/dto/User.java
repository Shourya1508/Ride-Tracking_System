package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {

@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int user_id;

@Column	
private String user_name;
@Column	
private String email;
@Column	
private String mobile;
@Column	
private String password;
@Column	
private String confirm_password;

//
//public User(int user_id, String user_name, String email, String mobile, String password, String confirm_password) {
//	super();
//	this.user_id = user_id;
//	this.user_name = user_name;
//	this.email = email;
//	this.mobile = mobile;
//	this.password = password;
//	this.confirm_password = confirm_password;
//}

public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getUser_name() {
	return user_name;
}
public void setUser_name(String user_name) {
	this.user_name = user_name;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
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
