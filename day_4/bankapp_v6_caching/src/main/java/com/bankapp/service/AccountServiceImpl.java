package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dto.AccountDetails;
import com.bankapp.dto.AccountDto;
import com.bankapp.entites.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.repo.AccountRepo;
import com.bankapp.util.AccountUtil;
@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	private Logger logger=LoggerFactory.getLogger(AccountServiceImpl.class);
	
	private AccountRepo accountRepo;
	
	@Autowired
	public AccountServiceImpl(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}

	@Cacheable(value = "accounts")
	@Override
	public List<AccountDto> getAll() {

		logger.info("**************************************");
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {}
		return accountRepo.findAll().stream()
				.map(AccountUtil::convertToAccountDto)
				.collect(Collectors.toList());
	}

	@Cacheable(value = "accounts", key = "#id")
	@Override
	public AccountDto getById(int id) {
		//Optional works as a streams
		return accountRepo.findById(id)
				.map(AccountUtil::convertToAccountDto)
		.orElseThrow(()->new BankAccountNotFoundException("account not found"));

	}

	@Cacheable(value = "accounts", key = "#result.id")
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account accountToAdd=AccountUtil.convertToAccount(accountDto);
		accountRepo.save(accountToAdd);
		return AccountUtil.convertToAccountDto(accountToAdd);
	}

	@CacheEvict(value ="accounts", key="#id" )
	@Override
	public AccountDto deleteAccount(int id) {
		AccountDto accountDtoToDelete= getById(id);
		accountRepo.delete(AccountUtil.convertToAccount(accountDtoToDelete));
		return accountDtoToDelete;
	}

	@Override
	public AccountDto updateAccount(AccountDetails accountDetails) {
		
		AccountDto accountDtoToUpdate= getById(accountDetails.getId());
		
		accountDtoToUpdate.setEmail(accountDetails.getEmail());
		accountDtoToUpdate.setPhone(accountDetails.getPhone());
		
		accountRepo.save(AccountUtil.convertToAccount(accountDtoToUpdate));//how it works?
		
		return accountDtoToUpdate;
	}

	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
		
		AccountDto fromDtoAcc=getById(fromAccId);
		AccountDto toDtoAcc=getById(toAccId);
		
		fromDtoAcc.setBalance(fromDtoAcc.getBalance().subtract(amount));
		toDtoAcc.setBalance(toDtoAcc.getBalance().add(amount));
		
		accountRepo.save(AccountUtil.convertToAccount(fromDtoAcc));
		accountRepo.save(AccountUtil.convertToAccount(toDtoAcc));
	}

	@Override
	public void deposit(int accId, BigDecimal amount) {
		AccountDto accDto=getById(accId);
		accDto.setBalance(accDto.getBalance().add(amount));
		accountRepo.save(AccountUtil.convertToAccount(accDto));
	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {
		AccountDto accDto=getById(accId);
		accDto.setBalance(accDto.getBalance().subtract(amount));
		accountRepo.save(AccountUtil.convertToAccount(accDto));
	}

	//Cron job
	
	@CacheEvict(value ="accounts", allEntries = true )
	@Override
	public void removeCache() {}

}





