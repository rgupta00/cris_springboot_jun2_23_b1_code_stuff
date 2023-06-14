package com.bankapp.dto;

import java.math.BigDecimal;

public class WithdrawDto {
	private Integer AccId;
	private BigDecimal amount;
	public Integer getAccId() {
		return AccId;
	}
	public void setAccId(Integer accId) {
		AccId = accId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public WithdrawDto(Integer accId, BigDecimal amount) {
		super();
		AccId = accId;
		this.amount = amount;
	}
	public WithdrawDto() {}
	
	
}
