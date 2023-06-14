package com.bankapp.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountDetails;
import com.bankapp.entites.Account;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path = "api/accountcrud")
public class AccountCrudApi {

	private AccountService accountService;

	@Autowired
	public AccountCrudApi(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//create
	@PostMapping(path = "accounts")
	public Account createNewAccount( @RequestBody Account account) {
		return accountService.createAccount(account);
	}
	
	//update
	@PutMapping(path = "accounts")
	public Account updateAccount( @RequestBody AccountDetails accountDetails) {
		return accountService.updateAccount(accountDetails);
	}
	
	//getAll
	@GetMapping(path = "accounts")
	public List<Account> getAll(){
		return accountService.getAll();
	}
	
	//getById
	@GetMapping(path = "accounts/{id}")
	public Account getById(@PathVariable(name="id")  int id) {
		return accountService.getById(id);
	}
	
	//delete
	@DeleteMapping(path = "accounts/{id}")
	public Account deleteAccount(@PathVariable(name="id")  int id) {
		return accountService.deleteAccount(id);
	}
	
}






