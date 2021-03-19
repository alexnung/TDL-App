package com.qa.tdl.TDLWA.exceptions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TasksNotFoundExceptionTest {

	@Test
	public void TasksNotFoundExceptionTest1() {
		TaskNotFoundException tnfe = new TaskNotFoundException();
		assertThat(tnfe).isNotNull().isInstanceOf(TaskNotFoundException.class);
		
	}
	
}
