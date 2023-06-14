package com.bankapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.DepositDto;
import com.bankapp.dto.TransferDto;
import com.bankapp.dto.WithdrawDto;
import com.bankapp.service.AccountService;

@RestController
@RequestMapping(path = "api/transactions")
public class AccountTransactionApi {
	
	private AccountService accountService;
	
	@Autowired
	private Environment environment;
	
	
	@Autowired
	public AccountTransactionApi(AccountService accountService) {
		this.accountService = accountService;
	}


	//deposit
	@PostMapping(path = "deposit")
	public String deposit(DepositDto depositDto) {
		accountService.deposit(depositDto.getAccId(), depositDto.getAmount());

		return environment.getProperty("ACCOUNT.DEPOSIT.SUCCESS.MESSAGE");
	}
	
	//withdraw
	@PostMapping(path = "withdraw")
	public String withdraw(WithdrawDto withdrawDto) {
		accountService.withdraw(withdrawDto.getAccId(), withdrawDto.getAmount());
		return environment.getProperty("ACCOUNT.WITHDRAW.SUCCESS.MESSAGE");
	}
	
	//transfer
	@PostMapping(path = "transfer")
	public String transfer(TransferDto transferDto) {
		accountService.transfer(transferDto.getFromAccId(), 
				transferDto.getToAccId(), transferDto.getAmount());
		return environment.getProperty("ACCOUNT.TRANSFER.SUCCESS.MESSAGE");
		
	}
}






