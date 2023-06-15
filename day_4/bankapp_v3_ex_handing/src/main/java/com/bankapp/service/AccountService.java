package com.bankapp.service;
import java.math.BigDecimal;
import java.util.*;

import com.bankapp.dto.AccountDetails;
import com.bankapp.entites.Account;
public interface AccountService {
	public List<Account> getAll();
	public Account getById(int id);
	public Account createAccount(Account account);
	public Account deleteAccount(int id);
	
	public Account updateAccount(AccountDetails accountDetails);
	
	public void transfer(int fromAcc, int toAcc, BigDecimal amount);
	public void deposit(int accId,  BigDecimal amount);
	public void withdraw(int accId,  BigDecimal amount);

}










