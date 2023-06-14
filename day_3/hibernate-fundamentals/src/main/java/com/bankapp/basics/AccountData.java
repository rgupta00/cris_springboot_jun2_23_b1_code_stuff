package com.bankapp.basics;

import java.math.BigDecimal;

import javax.persistence.Column;

public class AccountData {
	private String name;
	private BigDecimal balance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public AccountData(String name, BigDecimal balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	public AccountData() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AccountData [name=" + name + ", balance=" + balance + "]";
	}
	
	

}
