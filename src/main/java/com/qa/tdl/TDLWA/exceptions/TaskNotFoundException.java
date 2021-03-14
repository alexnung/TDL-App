package com.qa.tdl.TDLWA.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "An invalid id was inputed")
public class TaskNotFoundException extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8053811335663883537L;

	public TaskNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
