package com.bankapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;

public class MyController {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		AccountService accountService = (AccountService) ctx.getBean("accountService");
		
		System.out.println(accountService.getClass());
		System.out.println("----before transfer ------------");
		
		Account account=accountService.getById(200);
		System.out.println(account);
		
//		List<Account> accounts = accountService.getAll();
//
//		accounts.forEach(a -> System.out.println(a));
//
//		accountService.transfer(1, 2, 10);
//
//		System.out.println("----after transfer ------------");
//		accounts = accountService.getAll();
//
//		accounts.forEach(a -> System.out.println(a));

	}

}
