package com.demo;

public class Demo {

	public static void main(String[] args) {

		Runnable runnable =()-> System.out.println("job of a thread...");
			
		

		Runnable runnable2 = ()-> System.out.println("job of a thread 2...");
			
		

//		Runnable runnable=new Runnable() {
//			
//			@Override
//			public void run() {
//					System.out.println("job of a thread...");
//			}
//		};
//		
//		Runnable runnable2=new Runnable() {
//			
//			@Override
//			public void run() {
//					System.out.println("job of a thread 2...");
//			}
//		};

	}

}
