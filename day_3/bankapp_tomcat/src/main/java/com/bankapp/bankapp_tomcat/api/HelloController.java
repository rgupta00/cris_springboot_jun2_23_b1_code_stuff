package com.bankapp.bankapp_tomcat.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(path = "hellourl")
	public String hello() {
		return "hello all champs!";
	}

}

