package com.bankapp.api;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountDetails;
import com.bankapp.dto.AccountDto;
import com.bankapp.entites.Account;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path = "api/accountcrud")
public class AccountCrudApi {

	private AccountService accountService;

	//ResponseEntity= data + status code
	
	
	@Autowired
	public AccountCrudApi(AccountService accountService) {
		this.accountService = accountService;
	}
	
	//MethodArgumentNotValidException
	//create
	@PostMapping(path = "accounts")
	public ResponseEntity<AccountDto> createNewAccount( @RequestBody  @Valid AccountDto accountDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body( accountService.createAccount(accountDto));
		
	}
	
	//update
	@PutMapping(path = "accounts")
	public ResponseEntity<AccountDto> updateAccount( @RequestBody AccountDetails accountDetails) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(accountService.updateAccount(accountDetails));
	}
	
	//getAll
//	@GetMapping(path = "accounts")
//	public ResponseEntity<List<Account>> getAll(){
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(accountService.getAll());
//	}
	
	@GetMapping(path = "accounts", 
			produces = {MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	@ResponseStatus(code = HttpStatus.OK)
	public List<AccountDto> getAll(@RequestHeader Map<String, String> map  ){
		System.out.println("------------------------------------------");
		map.forEach((k, v)-> System.out.println(k+" : "+v));
		return  accountService.getAll();
	}
	
	
	//getById
	@GetMapping(path = "accounts/{id}")
	public ResponseEntity<AccountDto> getById(@PathVariable(name="id")  int id) {
		AccountDto account=accountService.getById(id);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(account);
	}
	
	//delete
//	@DeleteMapping(path = "accounts/{id}")
//	public ResponseEntity<Void> deleteAccountV1(@PathVariable(name="id")  int id) {
//		accountService.deleteAccount(id);
//		return ResponseEntity.status(HttpStatus.NO_CONTENT)
//				.build();
//	}
	
	@DeleteMapping(path = "accounts/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteAccountV2(@PathVariable(name="id")  int id) {
		accountService.deleteAccount(id); 
	}
	
}






