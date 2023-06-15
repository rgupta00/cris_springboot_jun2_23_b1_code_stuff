package com.bankapp.service;
import java.math.BigDecimal;
import java.util.*;

import com.bankapp.dto.AccountDetails;
import com.bankapp.dto.AccountDto;
import com.bankapp.entites.Account;
//independent o of tech:
//
public interface AccountService {
	public List<AccountDto> getAll();
	public AccountDto getById(int id);
	public AccountDto createAccount(AccountDto account);
	public AccountDto deleteAccount(int id);
	
	public AccountDto updateAccount(AccountDetails accountDetails);
	
	public void transfer(int fromAcc, int toAcc, BigDecimal amount);
	public void deposit(int accId,  BigDecimal amount);
	public void withdraw(int accId,  BigDecimal amount);
	
	//I want to clean the cache (all cache ) periodically after
	public void removeCache();

}










