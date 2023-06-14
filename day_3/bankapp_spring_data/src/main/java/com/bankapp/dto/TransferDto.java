package com.bankapp.dto;

import java.math.BigDecimal;

public class TransferDto {

	private Integer fromAccId;
	private Integer toAccId;
	private BigDecimal amount;
	public Integer getFromAccId() {
		return fromAccId;
	}
	public void setFromAccId(Integer fromAccId) {
		this.fromAccId = fromAccId;
	}
	public Integer getToAccId() {
		return toAccId;
	}
	public void setToAccId(Integer toAccId) {
		this.toAccId = toAccId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public TransferDto(Integer fromAccId, Integer toAccId, BigDecimal amount) {
		super();
		this.fromAccId = fromAccId;
		this.toAccId = toAccId;
		this.amount = amount;
	}
	public TransferDto() {}
	
	
	
	
}
