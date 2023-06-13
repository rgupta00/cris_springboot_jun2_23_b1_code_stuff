package com.bankapp.service.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bankapp.service.AccountServiceImpl;

@Service
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	//i need to handle ex
	@AfterThrowing(pointcut = "execution( *  com.bankapp.service..*.*(..) )" , throwing = "ex")
	public void errorLogger(Exception ex) {
		System.out.println("**************************************");
		logger.error(ex.getMessage());
	}
	
	
	@Around("execution(public void transfer(..) )")
	public Object aroundLogging(ProceedingJoinPoint joinPoint)throws Throwable {
		long start = System.currentTimeMillis();

		//i need to call actual logic
		Object result =joinPoint.proceed();
		
		long end = System.currentTimeMillis();

		logger.info("time taken to execute trasfer method " + (end - start) + " ms ");
		return result;
	}

}





