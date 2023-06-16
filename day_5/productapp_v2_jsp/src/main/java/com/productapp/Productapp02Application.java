package com.productapp;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.productapp.dao.Product;
import com.productapp.dao.ProductRepo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
//if want to do something when spring boot strt 
@SpringBootApplication
@EnableAspectJAutoProxy

@OpenAPIDefinition
(info = @Info(title = "Product API", version = "2.0" , 
description = "CRIS API"))
public class Productapp02Application implements CommandLineRunner{

	@Autowired
	private ProductRepo productRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Productapp02Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		productRepo.save(new Product("Laptop", new BigDecimal(78000),"IT"));
		productRepo.save(new Product("Laptop cool pad", new BigDecimal(2000),"IT"));
		productRepo.save(new Product("Rich dad poor dad", new BigDecimal(2000),"BOOK"));
		System.out.println("--------------------------");
	}

}







