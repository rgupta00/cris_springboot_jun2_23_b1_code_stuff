package com.bankapp.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bankapp.dto.ErrorInfo;
import com.bankapp.exceptions.BankAccountNotFoundException;

//it use aop uder the hood

@RestControllerAdvice
public class BankAppExHandlerApi {

	@Value("${ADMIN.EMAIL}")
	private String adminEmail;
	
	@ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorInfo> handle404(BankAccountNotFoundException ex) {
		
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorMessage(ex.getMessage());
		errorInfo.setTimestemp(LocalDateTime.now());
		
		errorInfo.setToContactEmail(adminEmail);
		errorInfo.setStatuscode(HttpStatus.NOT_FOUND.toString());
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(errorInfo);
		
	}
	
	//catch all
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorInfo> handle500(Exception ex) {
//		
//		ErrorInfo errorInfo=new ErrorInfo();
//		errorInfo.setErrorMessage("pls try after some time");
//		errorInfo.setTimestemp(LocalDateTime.now());
//		
//		errorInfo.setToContactEmail(adminEmail);
//		errorInfo.setStatuscode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//				.body(errorInfo);
//		
//	}
}






