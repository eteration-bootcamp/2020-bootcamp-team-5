package com.team5.Noteapp.HashCode;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class HashCode {
	
	@Id
	@GeneratedValue
	private int id;
	
	private int userId;
	
	private String code;
	
	private Date exDate;

	public HashCode() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getExDate() {
		return exDate;
	}

	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}
}
