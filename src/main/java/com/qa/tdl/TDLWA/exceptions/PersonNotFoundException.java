package com.qa.tdl.TDLWA.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "An invalid id was inputed")
public class PersonNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = -4048859636717288032L;

	public PersonNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
