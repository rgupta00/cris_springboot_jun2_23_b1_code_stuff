package com.demo;

public class Main {

	
	public static void main(String[] args) {
		//When magician show magic after then Audience must do clapping 
		
		//dp: Proxy dp
		
		Magician magician=new MagicianProxy();
		magician.doMagic();
	}
}
