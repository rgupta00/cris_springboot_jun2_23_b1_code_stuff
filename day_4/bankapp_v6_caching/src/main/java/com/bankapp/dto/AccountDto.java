package com.bankapp.dto;

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

public class AccountDto {
	
	private Integer id;
	
	@NotEmpty(message = "{accountDto.name.absent}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{accountDto.name.invalid}")
	private String name;
	
	@NotNull(message = "{accountDto.balance.absent}")
	@Range(min = 100, max = 100000, message = "{accountDto.balance.invalid}")
	private BigDecimal balance;
	

	@NotNull(message = "{accountDto.phone.absent}")
	@Pattern(regexp = "[789][0-9]{9}", message = "{accountDto.phone.invalid}")
	private String phone;
	
	@Email(message = "{accountDto.email.invalid}")
	@NotNull(message = "{accountDto.email.absent}")
	private String email;
	
	public AccountDto(String name, BigDecimal balance, String phone, String email) {
		this.name = name;
		this.balance = balance;
		this.phone = phone;
		this.email = email;
	}

	public AccountDto() {}



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
