package com.qa.tdl.TDLWA.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.dto.PeopleDTO;
import com.qa.tdl.TDLWA.mappers.PeopleMapper;

@SpringBootTest
public class PeopleMapperTest {

	@Autowired
	PeopleMapper peopleMapper;
	People people;
	PeopleDTO peopleDTO;

	@BeforeEach
	void setup() {
		people = new People(1, "Eric", "Analyst", null);
		peopleDTO = new PeopleDTO(1, "Eric", "Analyst", null);
	}

	@Test
	void mapToDTOTest() {
		assertThat(peopleMapper.mapToDTO(people)).isEqualTo(peopleDTO);
	}

	@Test
	void mapToPeopleTest() {
		assertThat(peopleMapper.mapToPeople(peopleDTO)).isEqualTo(people);
	}
}
