package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.service.AccountService;

@Controller
public class AccountController {
	
	private AccountService accountService;

	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	@GetMapping(path = "getallaccounts")
	public ModelAndView showAll(ModelAndView mv) {
		mv.addObject("accounts", accountService.getAll());
		mv.setViewName("showall");
		
		return mv;
	}

}









