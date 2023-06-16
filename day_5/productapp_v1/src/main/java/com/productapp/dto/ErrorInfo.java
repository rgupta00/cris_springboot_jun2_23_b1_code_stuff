package com.productapp.dto;
//it will hold the error that send to the clinet

import java.time.LocalDateTime;

public class ErrorInfo {
	private String errorMessage;
	private String statusCode;
	private LocalDateTime dateTime;
	private String toContact;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getToContact() {
		return toContact;
	}
	public void setToContact(String toContact) {
		this.toContact = toContact;
	}
	public ErrorInfo(String errorMessage, String statusCode, LocalDateTime dateTime, String toContact) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
		this.dateTime = dateTime;
		this.toContact = toContact;
	}
	public ErrorInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
