package com.demo.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@Value("${my.data}")
	private String propvalue;
	
	@GetMapping(path = "hello")
	public String sayHello() {
		
		return "hello"+  propvalue;
	}

}
