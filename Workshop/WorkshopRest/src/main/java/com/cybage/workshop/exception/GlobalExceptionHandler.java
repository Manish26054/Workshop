package com.cybage.workshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler extends Exception {

	
	private static final long serialVersionUID = -7635788203218927549L;

	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> exceptionHandler(CustomerNotFoundException exception){
		return new ResponseEntity<>("Customer not found!!!",HttpStatus.NOT_FOUND);
	}
}
