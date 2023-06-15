package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dto.AccountDetails;
import com.bankapp.entites.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	private AccountRepo accountRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Override
	public List<Account> getAll() {
//		if(1==1)
//			throw new NullPointerException("some random problem in our code");
		return accountRepo.findAll();
	}

	@Override
	public Account getById(int id) {
		
		return accountRepo.findById(id)
		.orElseThrow(()->new BankAccountNotFoundException("account not found"));

	}

	@Override
	public Account createAccount(Account account) {
		accountRepo.save(account);
		return account;
	}

	@Override
	public Account deleteAccount(int id) {
		Account accountToDelete= getById(id);
		accountRepo.delete(accountToDelete);
		return accountToDelete;
	}

	@Override
	public Account updateAccount(AccountDetails accountDetails) {
		
		Account accountToUpdate= getById(accountDetails.getId());
		accountToUpdate.setEmail(accountDetails.getEmail());
		accountToUpdate.setPhone(accountDetails.getPhone());
		accountRepo.save(accountToUpdate);//how it works?
		return accountToUpdate;
	}

	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
		Account fromAcc=getById(fromAccId);
		Account toAcc=getById(toAccId);
		
		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
		toAcc.setBalance(toAcc.getBalance().add(amount));
		
		accountRepo.save(fromAcc);
		accountRepo.save(toAcc);
	}

	@Override
	public void deposit(int accId, BigDecimal amount) {
		Account acc=getById(accId);
		acc.setBalance(acc.getBalance().add(amount));
		accountRepo.save(acc);
	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {
		Account acc=getById(accId);
		acc.setBalance(acc.getBalance().subtract(amount));
		accountRepo.save(acc);
	}

}





