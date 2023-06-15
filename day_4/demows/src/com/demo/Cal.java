package com.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;

/*
 * J2EE
 * 	JaX RS: for rest
 *  jax ws: for SOAP
 */
@WebService
public class Cal {
	
	@WebMethod
	public int add(int a, int b) {
		return a+b;
	}

}
