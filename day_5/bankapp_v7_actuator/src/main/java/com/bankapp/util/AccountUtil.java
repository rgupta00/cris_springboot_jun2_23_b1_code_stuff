package com.bankapp.util;

import com.bankapp.dto.AccountDto;
import com.bankapp.entites.Account;

public class AccountUtil {
	
	//AccountDto to Account
	
	public  static AccountDto convertToAccountDto(Account account) {
		AccountDto accountDto=new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setBalance(account.getBalance());
		accountDto.setEmail(account.getEmail());
		accountDto.setPhone(account.getPhone());
		accountDto.setName(account.getName());
		return accountDto;
	}
	
	//Account to AccountDto
	
	public  static Account convertToAccount(AccountDto accountDto) {
		Account account=new Account();
		account.setId(accountDto.getId());
		account.setBalance(accountDto.getBalance());
		account.setEmail(accountDto.getEmail());
		account.setPhone(accountDto.getPhone());
		account.setName(accountDto.getName());
		return account;
	}

}
