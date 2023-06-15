package com.bankapp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entites.Account;
import com.bankapp.repo.AccountRepo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info =@Info(title = "Bankapp CRIS API",version   = "3.0", description = 
"CRIS internal project") )
public class BankappSpringDataApplication implements CommandLineRunner{

	@Autowired
	private AccountRepo accountRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BankappSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Account account=new Account("amit", BigDecimal.valueOf(1000), 
				"9955667700", "amit@gmail.com");
		
		
		Account account2=new Account("sumit", BigDecimal.valueOf(1000), 
				"8855667700", "sumit@gmail.com");
		
		
		accountRepo.save(account);
		accountRepo.save(account2);
//		List<Account> accounts=Arrays.asList(account, account2);
//		accountRepo.saveAll(accounts);
	

	}
}
