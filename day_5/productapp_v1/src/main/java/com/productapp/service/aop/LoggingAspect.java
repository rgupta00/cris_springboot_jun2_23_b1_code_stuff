package com.productapp.service.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.productapp.dao.Product;
import com.productapp.service.ProductServiceImpl;


public class LoggingAspect {
	
	private Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	//if any method of service layer is called then put infor in a log file
	//@Before("execution( * com.productapp.service.*Impl.*(..))")
	public void loggingBefore() {
		//joinpoint give information about target method using java reflection
		logger.info("********#######################************** ");
	}

}









