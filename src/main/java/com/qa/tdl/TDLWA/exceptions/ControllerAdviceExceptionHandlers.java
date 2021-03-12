package com.qa.tdl.TDLWA.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandlers {

	@ExceptionHandler (value = PlayerNotFoundException.class)
	public ResponseEntity<String> PlayerNotFoundException(PlayerNotFoundException pnfe) {
		
		return new ResponseEntity<String>(pnfe.getMessage(),HttpStatus.OK);
	}
	
}
