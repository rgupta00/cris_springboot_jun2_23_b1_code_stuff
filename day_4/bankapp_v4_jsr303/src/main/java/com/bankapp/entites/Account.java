package com.bankapp.entites;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

import com.bankapp.util.DataPattern;

//violation of SRP
@Entity
@Table(name = "account_table2")
public class Account {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "{account.name.absent}")
	@Pattern(regexp = DataPattern.EMAIL_PATTERN, message = "{account.name.invalid}")
	private String name;
	
	@NotNull(message = "{account.balance.absent}")
	@Range(min = 100, max = 100000, message = "{account.balance.invalid}")
	private BigDecimal balance;
	

	@NotNull(message = "{account.phone.absent}")
	@Pattern(regexp = "[789][0-9]{9}", message = "{account.phone.invalid}")
	private String phone;
	
	@Email(message = "{account.email.invalid}")
	@NotNull(message = "{account.email.absent}")
	private String email;
	
	public Account(String name, BigDecimal balance, String phone, String email) {
		this.name = name;
		this.balance = balance;
		this.phone = phone;
		this.email = email;
	}

	public Account() {}



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
	
	
	
}
