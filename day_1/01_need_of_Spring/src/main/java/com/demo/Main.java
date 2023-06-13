package com.demo;

public class Main {
	
	public static void main(String[] args) {
		
		//Spring : DI
		//Spring need some help form you
		//Bean wiring: XML, annotation , java config
		
		
		
		Vehicle vehicle=new Car();
		
		Passenger passenger=new Passenger();
		
		passenger.setName("raj");
		passenger.setVehicle(vehicle);
		
		
		passenger.travel();
	}

}
