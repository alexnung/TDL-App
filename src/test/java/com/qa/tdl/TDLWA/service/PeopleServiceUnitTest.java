package com.qa.tdl.TDLWA.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.data.repository.PeopleRepository;
import com.qa.tdl.TDLWA.dto.PeopleDTO;
import com.qa.tdl.TDLWA.mappers.PeopleMapper;

@ExtendWith(MockitoExtension.class)
public class PeopleServiceUnitTest {

	@InjectMocks
	private PeopleService peopleService;

	@Mock
	private PeopleRepository peopleRepository;

	@Mock
	private PeopleMapper peopleMapper;

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
	public void readAllPeopleTest() {
		when(peopleRepository.findAll()).thenReturn(people);
		when(peopleMapper.mapToDTO(validPeople)).thenReturn(validPeopleDTO);
		assertThat(peopleDTO).isEqualTo(peopleService.readAllPeople());
		verify(peopleRepository, times(1)).findAll();
		verify(peopleMapper, times(1)).mapToDTO(validPeople);
	}

	@Test
	public void getPeopleByIdTest() {
		when(peopleRepository.existsById(Mockito.any(Integer.class))).thenReturn(true);
		when(peopleRepository.findByIdJPQL(Mockito.any(Integer.class))).thenReturn(validPeople);
		when(peopleMapper.mapToDTO(validPeople)).thenReturn(validPeopleDTO);
		assertThat(validPeopleDTO).isEqualTo(peopleService.readById(Mockito.any(Integer.class)));
		verify(peopleRepository, times(1)).existsById(Mockito.any(Integer.class));
		verify(peopleRepository, times(1)).findByIdJPQL(Mockito.any(Integer.class));
		verify(peopleMapper, times(1)).mapToDTO(validPeople);
	}

	@Test
	public void createPeopleTest() {
		when(peopleRepository.save(Mockito.any(People.class))).thenReturn(validPeople);
		when(peopleMapper.mapToDTO(Mockito.any(People.class))).thenReturn(validPeopleDTO);
		assertThat(validPeopleDTO).isEqualTo(peopleService.createPeople(validPeople));
		verify(peopleRepository, times(1)).save(Mockito.any(People.class));
		verify(peopleMapper, times(1)).mapToDTO(Mockito.any(People.class));
	}

	@Test
	public void updatePeopleTest() {
		People updatedPeople = new People(1, "Eric", "analyst");
		PeopleDTO updatedPeopleDTO = new PeopleDTO(1, "Eric", "analyst", null);
		when(peopleRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(validPeople));
		when(peopleRepository.save(Mockito.any(People.class))).thenReturn(updatedPeople);
		when(peopleMapper.mapToDTO(Mockito.any(People.class))).thenReturn(updatedPeopleDTO);
		PeopleDTO testDTO = peopleService.updatePeople(validPeople.getId(), updatedPeople);
		assertThat(updatedPeopleDTO).isEqualTo(testDTO);
	}

	@Test
	public void deletePeopleTest() {
		when(peopleRepository.existsById(Mockito.any(Integer.class))).thenReturn(true).thenReturn(false);
		assertThat(true).isEqualTo(peopleService.deletePeople(1));
		verify(peopleRepository, times(2)).existsById(Mockito.any(Integer.class));
		verify(peopleRepository, times(1)).deleteById(Mockito.any(Integer.class));
	}

}
