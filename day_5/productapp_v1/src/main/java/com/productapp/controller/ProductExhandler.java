package com.productapp.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.productapp.dto.ErrorInfo;
import com.productapp.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class ProductExhandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorInfo handle404(ProductNotFoundException ex) {
		ErrorInfo info=new ErrorInfo();
		info.setDateTime(LocalDateTime.now());
		info.setErrorMessage(ex.getMessage());
		info.setStatusCode(HttpStatus.NOT_FOUND.toString());
		info.setToContact("raj@info.com");
		
		return info;
		
	}
	
	//MethodArgumentNotValidException
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorInfo handle400(MethodArgumentNotValidException ex) {
		
		String errorInfoString= ex.getBindingResult()
				.getAllErrors()
				.stream()
				.map(e->e.getDefaultMessage())
				.collect(Collectors.joining(" ,"));
		
				
		ErrorInfo info=new ErrorInfo();
	
		info.setDateTime(LocalDateTime.now());
		info.setErrorMessage(errorInfoString);
		info.setStatusCode(HttpStatus.BAD_REQUEST.toString());
		info.setToContact("raj@info.com");
		
		return info;
		
	}
	
//	@ResponseStatus(code=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(Exception.class)
//	public ErrorInfo handle500(Exception ex) {
//		ErrorInfo info=new ErrorInfo();
//		info.setDateTime(LocalDateTime.now());
//		//log4j 
//		info.setErrorMessage("pls try after some time");
//		info.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.toString());
//		info.setToContact("raj@info.com");
//		
//		return info;
//		
//	}
	
}
