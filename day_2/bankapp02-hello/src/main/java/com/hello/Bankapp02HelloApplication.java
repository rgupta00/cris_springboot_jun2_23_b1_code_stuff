package com.hello;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Bankapp02HelloApplication implements CommandLineRunner {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;//reduce boilerplate code

	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(Bankapp02HelloApplication.class, args);
		
//	     String[]beansNames=ctx.getBeanDefinitionNames();
//	     for(String name: beansNames) {
//	    	 System.out.println(name);
//	     }
	}

	@Override
	public void run(String... args) throws Exception {
		
		if(dataSource!=null) {
			System.out.println("ds is cofigured :)");
		}
		
		if(jdbcTemplate!=null) {
			System.out.println("jdbcTemplate is configured");
		}
		//jdbcTemplate
		
		System.out.println("it allow u to override a method run .. inside that method u can do some imp work");
	}

}



