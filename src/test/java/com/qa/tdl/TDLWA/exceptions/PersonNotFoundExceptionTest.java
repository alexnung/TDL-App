package com.qa.tdl.TDLWA.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PersonNotFoundExceptionTest {

	@Test
	public void PersonNotFoundExceptionTest1() {
		PersonNotFoundException pnfe = new PersonNotFoundException();
		assertThat(pnfe).isNotNull().isInstanceOf(PersonNotFoundException.class);

	}
	
}
