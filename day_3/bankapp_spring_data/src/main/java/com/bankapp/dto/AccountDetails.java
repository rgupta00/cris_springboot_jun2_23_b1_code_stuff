package com.bankapp.dto;

public class AccountDetails {
	private Integer id;
	private String phone;
	private String email;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public AccountDetails(Integer id, String phone, String email) {
		super();
		this.id = id;
		this.phone = phone;
		this.email = email;
	}
	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
