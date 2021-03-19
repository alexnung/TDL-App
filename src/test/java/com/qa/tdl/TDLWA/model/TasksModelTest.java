package com.qa.tdl.TDLWA.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.data.model.Tasks;

import nl.jqno.equalsverifier.EqualsVerifier;

class TasksModelTest {

	static Tasks tasks;

	@BeforeEach
	void setup() {
		tasks = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A");
	}

	@Test
	void testEquals() {
		EqualsVerifier.simple().forClass(Tasks.class)
				.withPrefabValues(People.class, new People("test", "test"), new People("test2", "test2")).verify();
	}
	
	@Test
    void categoryWithIdTest() {
        Tasks task1 = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A", null);
        assertThat(task1).isNotNull().isInstanceOf(Tasks.class);
        assertThat(task1.getId()).isEqualTo(1);
        assertThat(task1.getTask()).isEqualTo("Eric");
        assertThat(task1.getDueDate()).isEqualTo("08/04/2021");
        assertThat(task1.getStatus()).isEqualTo("Ongoing");
        assertThat(task1.getCompletedOnTime()).isEqualTo("N/A");
        assertThat(task1.getPeople()).isEqualTo(null);
    }
	
	@Test
	void hashCodeTest() {
		Tasks tasks1 = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A");
		Tasks tasks2 = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A");
		assertThat(tasks1).hasSameHashCodeAs(tasks2);
	}

	@Test
	void toStringTest() {
		assertThat(tasks).hasToString(
				"Player [id=" + tasks.getId() + ", task=" + tasks.getTask() + ", dueDate=" + tasks.getDueDate()
						+ ", status=" + tasks.getStatus() + ", completedOnTime=" + tasks.getCompletedOnTime() + "]");
	}

}
