package com.bankapp.dto;

import java.math.BigDecimal;

public class DepositDto {
	private Integer accId;
	private BigDecimal amount;
	public Integer getAccId() {
		return accId;
	}
	public void setAccId(Integer accId) {
		this.accId = accId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public DepositDto(Integer accId, BigDecimal amount) {
		this.accId = accId;
		this.amount = amount;
	}
	public DepositDto() {}
	
	
	
	
	
}
