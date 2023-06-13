package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@EnableAspectJAutoProxy
@SpringBootApplication
public class Bankapp01Application {

	public static void main(String[] args) {
		SpringApplication.run(Bankapp01Application.class, args);
	}

}
