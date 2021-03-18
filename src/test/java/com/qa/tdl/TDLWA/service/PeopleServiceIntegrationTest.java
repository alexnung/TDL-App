package com.qa.tdl.TDLWA.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.data.model.Tasks;
import com.qa.tdl.TDLWA.data.repository.PeopleRepository;
import com.qa.tdl.TDLWA.dto.PeopleDTO;
import com.qa.tdl.TDLWA.mappers.PeopleMapper;

@SpringBootTest
public class PeopleServiceIntegrationTest {

	@Autowired
	private PeopleService peopleService;

	@Autowired
	private PeopleRepository peopleRepository;

	@Autowired
	private PeopleMapper peopleMapper;

	private List<People> people;
	private List<PeopleDTO> peopleDTO;

	private People validPeople;
	private PeopleDTO validPeopleDTO;

	@BeforeEach
	public void init() {
		validPeople = new People(1, "Eric", "analyst", new ArrayList<Tasks>());
		people = new ArrayList<People>();
		peopleDTO = new ArrayList<PeopleDTO>();
		peopleRepository.deleteAll();
		validPeople = peopleRepository.save(validPeople);
		validPeopleDTO = peopleMapper.mapToDTO(validPeople);
		people.add(validPeople);
		peopleDTO.add(validPeopleDTO);
	}

	@Test
	public void readAllPeopleTest() {
		List<PeopleDTO> peopleInDb = peopleService.readAllPeople();
		assertThat(peopleDTO).isEqualTo(peopleInDb);
	}

	@Test
	public void createPeopleTest() {
		People newPeople = new People(1, "Eric", "analyst", new ArrayList<Tasks>());
		PeopleDTO expectedPeopleDTO = peopleMapper.mapToDTO(newPeople);
		PeopleDTO savedPeople = peopleService.createPeople(newPeople);
		expectedPeopleDTO.setId(savedPeople.getId());
		assertThat(savedPeople).isEqualTo(expectedPeopleDTO);
	}

	@Test
	public void updatePeopleTest() {
		People newPeople = new People(5, "Eric", "analyst", new ArrayList<Tasks>());
		PeopleDTO newPeopleDTO = peopleMapper.mapToDTO(newPeople);
		PeopleDTO toPeopleDTO = peopleService.updatePeople(validPeople.getId(), newPeople);
		assertThat(newPeopleDTO).isEqualTo(toPeopleDTO);
	}

	@Test
	public void deletePeopleTest() {
		assertThat(true).isEqualTo(peopleService.deletePeople(validPeople.getId()));
	}

}
