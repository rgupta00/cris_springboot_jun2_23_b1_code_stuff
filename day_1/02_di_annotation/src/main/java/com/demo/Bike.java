package com.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//<bean id="v1" class="com.demo.Bike" />
@Component(value = "v1")
@Primary
public class Bike  implements Vehicle{
	public void move() {
		System.out.println("moving on a bike");
	}
}
