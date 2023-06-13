package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWithSpring {

	public static void main(String[] args) {

		// Spring : DI
		// Spring need some help form you
		// Bean wiring: XML, annotation , java config

		ApplicationContext ctx = new ClassPathXmlApplicationContext("demo.xml");
		Passenger passenger = (Passenger) ctx.getBean("p");
		passenger.travel();
	}

}
