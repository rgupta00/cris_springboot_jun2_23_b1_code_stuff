package com.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//RAD
@RestController
public class HelloRestController {

	//hello2?pageNo=1&noOfrecords=20
	@GetMapping(path = "hello2")
	public String hello2(@RequestParam int pageNo, @RequestParam int noOfrecords) {
		return "hello cris champs! "+pageNo + " "+ noOfrecords;
	}
	
	
	@GetMapping(path = "hello/{name}/{city}")
	public String hello(@PathVariable(name = "name")  String username,
			@PathVariable(name = "city")  String city) {
		return "hello cris champs! "+username+" and your city is "+ city;
	}
}
