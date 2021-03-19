package com.qa.tdl.TDLWA.DTO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.tdl.TDLWA.dto.PeopleDTO;
import com.qa.tdl.TDLWA.dto.TasksDTO;

import nl.jqno.equalsverifier.EqualsVerifier;

public class TasksDTOModelTest {

	static TasksDTO tasksDTO;
	
	@BeforeEach
	void setup() {
		tasksDTO = new TasksDTO(1, "Eric", "08/04/2021", "Ongoing");
	}
	
	@Test
	void testEquals() {
		EqualsVerifier.simple().forClass(TasksDTO.class)
				.withPrefabValues(PeopleDTO.class, new PeopleDTO(1, "test", "test", null), new PeopleDTO(2, "test2", "test2", null)).verify();
	}
	
	@Test
	void toStringTest() {
		assertThat(tasksDTO).hasToString(
				"TasksDTO [id=" + tasksDTO.getId() + ", task=" + tasksDTO.getTask() + ", dueDate=" + tasksDTO.getDueDate() + ", status=" + tasksDTO.getStatus() + "]");
	}
	
}
