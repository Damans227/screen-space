package com.screenspace.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class userModel {

	
    public userModel() {
		super();
	}
	@Id
	private String uname;
	private String pass;
	private String phone;
	private String email;

	
	public userModel(String uname, String pass, String phone, String email) {
		super();
		this.uname = uname;
		this.pass = pass;
		this.phone = phone;
		this.email = email;
	}
	@Override
	public String toString() {
		return "userModel [uname=" + uname + ", pass=" + pass + ", phone=" + phone + ", email=" + email + "]";
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/*You should use IDENTITY generator. The IDENTITY generator 
	 * allows an integer and bigint column to be auto-incremented on demand. 
	 * The increment process is very efficient since it uses a database internal 
	 * lightweight locking mechanism as opposed to the more heavyweight transactional 
	 * course-grain locks.*/
	
	
	
	
}
