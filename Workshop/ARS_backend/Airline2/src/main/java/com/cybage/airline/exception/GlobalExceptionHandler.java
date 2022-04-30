package com.cybage.airline.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> handleException(RecordNotFoundException err){
		return new ResponseEntity<String>(err.getMessage(),HttpStatus.OK);
	}
}
