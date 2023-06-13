package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Passanger-->Car
/*
 * <bean id="p" class="com.demo.Passenger" autowire="byType">
		<property name="name" value="raj"/>
	</bean>
 */

@Component(value = "p")
public class Passenger {
	
	private String name;
	
	private Vehicle vehicle;

	
	@Value("raj")
	public void setName(String name) {
		this.name = name;
	}
	
	@Autowired
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void travel() {
		System.out.println("passanger name: " + name);
		vehicle.move();
	}

}
