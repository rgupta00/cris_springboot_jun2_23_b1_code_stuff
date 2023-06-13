package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dao.Account;
import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;
//What is the difference bw @RequestMapping vs @GetMapping
@RestController
@RequestMapping(path = "api/accountapi")
public class AccountRestController {
	
	private AccountService accountService;
	
	@Autowired
	public AccountRestController(AccountService accountService) {
		this.accountService = accountService;
	}

	//-------getting all accounts-----
	
	//@RequestMapping(path = "accounts", method = RequestMethod.GET)
	@GetMapping(path = "accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	//-------get a specific account
	@GetMapping(path = "accounts/{id}")
	public Account getById( @PathVariable int id) {
		return accountService.getById(id);
	}
	
	//Fund transfer
	@PostMapping(path = "transfer")
	public String fundTransfer(@RequestBody  TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(),
				transferDto.getToAccId(), transferDto.getAmount());
		
		return "fund transfer happen successfully";
		
	}
	
	@PostMapping(path = "deposit")
	public String depost(@RequestBody  DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());
		
		return "deposit happen successfully";
		
	}
	
	@PostMapping(path = "withdraw")
	public String withdraw(@RequestBody  WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		
		return "withdraw happen successfully";
		
	}
	

}
















