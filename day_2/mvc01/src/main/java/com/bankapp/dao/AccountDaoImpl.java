package com.bankapp.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class AccountDaoImpl implements AccountDao{

	@Override
	public List<Account> getAll() {
		
		return Arrays.asList(new Account(1, "amit", 1000), new Account(2, "sumit", 1000));
	}

}
