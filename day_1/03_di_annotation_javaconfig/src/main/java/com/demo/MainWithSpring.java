package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.config.AppConfig;

public class MainWithSpring {

	public static void main(String[] args) {

		// Spring : DI
		// Spring need some help form you
		// Bean wiring: XML, annotation , java config

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Passenger passenger = (Passenger) ctx.getBean("p");
		passenger.travel();
	}

}











