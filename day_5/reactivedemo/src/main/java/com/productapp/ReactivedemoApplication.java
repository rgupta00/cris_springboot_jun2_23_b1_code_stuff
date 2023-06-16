package com.productapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactivedemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ReactivedemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		   Mono<?> monoString = Mono.just("java champs")
//	                .then(Mono.error(new RuntimeException("Exception occured")))
//	                .log();
//	        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
	        
	        
//	        Flux<String> fluxString = Flux.just("Spring", "Spring Boot", "Hibernate", "microservice")
//	                .concatWithValues("AWS")
//	                .concatWith(Flux.error(new RuntimeException("Exception occured in Flux")))
//	                .concatWithValues("cloud")
//	                .log();
//
//	        fluxString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
//	        
	}

}
