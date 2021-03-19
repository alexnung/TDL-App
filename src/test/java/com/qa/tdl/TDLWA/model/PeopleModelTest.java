package com.qa.tdl.TDLWA.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.data.model.Tasks;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PeopleModelTest {

	static People people;
	
	@BeforeEach
	void setup() {
		people = new People("Eric", "Analyst");
	}
	
	@Test
	void testEquals() {
		EqualsVerifier.simple().forClass(People.class)
				.withPrefabValues(Tasks.class, new Tasks("Eric", "08/04/2021", "Ongoing", "N/A"), new Tasks("Tim", "08/04/2021", "Ongoing", "N/A")).verify();
	}	

	@Test
	void toStringTest() {
		assertThat(people).hasToString(
				"People [id=" + people.getId() + ", name=" + people.getName() + ", title=" + people.getTitle() + ", tasks=" + people.getTasks() + "]");

	}
	
}
