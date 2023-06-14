package com.bankapp.basics;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "account_table")
 public class Account {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
    private Integer id;
	@Column(name = "account_name", nullable = false, length = 100)
    private String name;
	@Column(name = "account_balance", nullable = false)
    private BigDecimal balance;
    
	@Enumerated(EnumType.STRING)
    private CustomerType customerType;

	@Temporal(TemporalType.DATE)
    private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account(String name, BigDecimal balance, CustomerType customerType, Date date) {
		super();
		this.name = name;
		this.balance = balance;
		this.customerType = customerType;
		this.date = date;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + ", customerType=" + customerType
				+ ", date=" + date + "]";
	}
	
	

}




