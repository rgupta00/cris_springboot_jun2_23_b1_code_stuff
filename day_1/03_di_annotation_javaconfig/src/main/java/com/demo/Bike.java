package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component(value = "v1")
@Profile("dev")
public class Bike  implements Vehicle{
	public void move() {
		System.out.println("moving on a bike");
	}
}
