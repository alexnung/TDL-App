package com.qa.tdl.TDLWA.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.dto.PeopleDTO;
import com.qa.tdl.TDLWA.service.PeopleService;

@WebMvcTest(PeopleController.class)
public class PeopleControllerUnitTest {

	@Autowired
	private PeopleController peopleController;

	@MockBean
	private PeopleService peopleService;

	private List<People> people;
	private List<PeopleDTO> peopleDTO;

	private People validPeople;
	private PeopleDTO validPeopleDTO;

	@BeforeEach
	public void init() {
		validPeople = new People(1, "Eric", "analyst");
		validPeopleDTO = new PeopleDTO(1, "Eric", "analyst", null);

		people = new ArrayList<People>();
		peopleDTO = new ArrayList<PeopleDTO>();

		people.add(validPeople);
		peopleDTO.add(validPeopleDTO);
	}

	@Test
	public void readAllPeople() {
		when(peopleService.readAllPeople()).thenReturn(peopleDTO);
		ResponseEntity<List<PeopleDTO>> response = new ResponseEntity<List<PeopleDTO>>(peopleDTO, HttpStatus.OK);
		assertThat(response).isEqualTo(peopleController.getAllPeople());
		verify(peopleService, times(1)).readAllPeople();
	}

	@Test
	public void getPeopleById() {
		when(peopleService.readById(validPeopleDTO.getId())).thenReturn(validPeopleDTO);
		ResponseEntity<PeopleDTO> response = new ResponseEntity<PeopleDTO>(validPeopleDTO, HttpStatus.OK);
		assertThat(response).isEqualTo(peopleController.getPeopleById(validPeopleDTO.getId()));
		verify(peopleService, times(1)).readById(validPeopleDTO.getId());
	}

	@Test
	public void createPeopleTest() {
		when(peopleService.createPeople(validPeople)).thenReturn(validPeopleDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(validPeopleDTO.getId()));
		ResponseEntity<PeopleDTO> response = new ResponseEntity<PeopleDTO>(validPeopleDTO, headers, HttpStatus.CREATED);
		assertThat(response).isEqualTo(peopleController.createPeople(validPeople));
		verify(peopleService, times(1)).createPeople(validPeople);
	}

	@Test
	public void updatePeopleTest() {
		when(peopleService.updatePeople(validPeople.getId(), validPeople)).thenReturn(validPeopleDTO);
		ResponseEntity<PeopleDTO> response = new ResponseEntity<PeopleDTO>(validPeopleDTO, HttpStatus.OK);
		assertThat(response).isEqualTo(peopleController.updatePeople(validPeople.getId(), validPeople));
		verify(peopleService, times(1)).updatePeople(validPeople.getId(), validPeople);
	}

	@Test
	public void deletePeopleTest() {
		when(peopleService.deletePeople(validPeople.getId())).thenReturn(true);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		assertThat(response).isEqualTo(peopleController.deletePeople(validPeople.getId()));
		verify(peopleService, times(1)).deletePeople(validPeople.getId());
	}

}
