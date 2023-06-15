package com.bankapp.service.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bankapp.service.AccountService;

@Service
public class ScheduleService {

	private AccountService accountService;
	
	@Autowired
	public ScheduleService(AccountService accountService) {
		this.accountService = accountService;
	}


	@Scheduled(cron = "0/5  * * * * *")
	public void removeCacheAferEach5Sec() {
		accountService.removeCache();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
	
	@Scheduled(initialDelay = 1000,fixedDelay = 1500)
	public void demo() {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
}







