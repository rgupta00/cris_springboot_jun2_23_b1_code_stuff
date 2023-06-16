package com.bankapp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bankapp.entity.UserEntity;
import com.bankapp.service.UserService;

@SpringBootApplication
public class BankappSecApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(BankappSecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.addUser(new UserEntity("raj", passwordEncoder.encode("raj123"), 
				Arrays.asList("ROLE_MGR","ROLE_CLERK")));
		
		userService.addUser(new UserEntity("ekta",passwordEncoder.encode("ekta123") , 
				Arrays.asList("ROLE_CLERK")));
		
		UserEntity userEntity=userService.findByUsername("raj");
		System.out.println(userEntity);
	}

}
