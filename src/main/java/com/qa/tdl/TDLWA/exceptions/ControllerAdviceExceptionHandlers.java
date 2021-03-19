package com.qa.tdl.TDLWA.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceExceptionHandlers {

	@ExceptionHandler(value = TaskNotFoundException.class)
	public ResponseEntity<String> TaskNotFoundException(TaskNotFoundException tnfe) {

		return new ResponseEntity<String>(tnfe.getMessage(), HttpStatus.OK);
	}
	
	@ExceptionHandler(value = PersonNotFoundException.class)
	public ResponseEntity<String> PersonNotFoundException(PersonNotFoundException pnfe) {

		return new ResponseEntity<String>(pnfe.getMessage(), HttpStatus.OK);
	}

}
