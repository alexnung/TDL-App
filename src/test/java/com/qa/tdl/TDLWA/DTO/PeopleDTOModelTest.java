package com.qa.tdl.TDLWA.DTO;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.tdl.TDLWA.dto.PeopleDTO;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PeopleDTOModelTest {

	static PeopleDTO peopleDTO;

	@BeforeEach
	void setup() {
		peopleDTO = new PeopleDTO(1, "Eric", "analyst", null);
	}

	@Test
	void testEquals() {
		EqualsVerifier.simple().forClass(PeopleDTO.class).verify();
	}

	@Test
	void toStringTest() {
		assertThat(peopleDTO).hasToString("PeopleDTO [id=" + peopleDTO.getId() + ", name=" + peopleDTO.getName()
				+ ", title=" + peopleDTO.getTitle() + ", tasks=" + peopleDTO.getTasks() + "]");
	}

}
