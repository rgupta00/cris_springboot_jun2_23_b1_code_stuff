package com.demo;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class F1 implements Filter {

   
	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		System.out.println("I am watching you!");
		System.out.println(req.getRequestURI());
		
		chain.doFilter(request, response);
		
		System.out.println("hello");
	}
	
	
	public void destroy() {
		// TODO Auto-generated method stub
	}




}
