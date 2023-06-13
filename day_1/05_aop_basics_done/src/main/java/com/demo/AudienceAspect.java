package com.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect	//Aspect =advice + pointcut*
public class AudienceAspect {
	
	//@AfterReturning vs @After
	
	
	//Aroud advice
	
	@Around("execution( * com.demo..*.do*(..))")
	public Object clapping1(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("*************");
		
		Object result =joinPoint.proceed();
		
		System.out.println("$$$$$$$$$$");
		
		return result;
		
	}
	
	
	
	
	//RestControllerAdivice
	
//	@AfterThrowing(pointcut = "execution( * com.demo..*.do*(..))", throwing = "ex")
//	public void clapping1(Exception ex) {
//		System.out.println(ex.getMessage());
//		System.out.println("*************");
//	}
//	
	
	
//	@AfterReturning("execution( * com.demo..*.do*(..))")
//	public void clapping1() {
//		System.out.println("clapping");
//	}

}

