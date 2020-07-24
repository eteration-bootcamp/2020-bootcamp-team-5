package com.team5.Noteapp.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.team5.Noteapp.Validator.Email;
import com.team5.Noteapp.Validator.PhoneNumber;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	private String name;
	

	@Column(nullable = false)
	private String surname;
	
	@PhoneNumber
	private String phoneNumber;
	
	@Email
	private String mail;
	
	@Column(nullable = false)
	private int userInfoId;
	
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	
}
