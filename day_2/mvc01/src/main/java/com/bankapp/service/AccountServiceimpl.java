package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDao;
@Service
public class AccountServiceimpl implements AccountService {

	private AccountDao accountDao;
	
	@Autowired
	public AccountServiceimpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}


	@Override
	public List<Account> getAll() {
		return accountDao.getAll();
	}

}
