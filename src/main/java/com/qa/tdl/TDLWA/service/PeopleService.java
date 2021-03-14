package com.qa.tdl.TDLWA.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.data.repository.PeopleRepository;
import com.qa.tdl.TDLWA.dto.PeopleDTO;
import com.qa.tdl.TDLWA.mappers.PeopleMapper;

@Service
public class PeopleService {

	private PeopleRepository peopleRepository;

	private PeopleMapper peopleMapper;

	@Autowired
	public PeopleService(PeopleRepository peopleRepository, PeopleMapper peopleMapper) {
		this.peopleRepository = peopleRepository;
		this.peopleMapper = peopleMapper;
	}

	@Transactional
	public List<PeopleDTO> readAllPeople() {
		List<People> peopleInDb = peopleRepository.findAll();
		List<PeopleDTO> newPerson = new ArrayList<PeopleDTO>();
		peopleInDb.forEach(people -> {
			newPerson.add(peopleMapper.mapToDTO(people));
		});
		return newPerson;
	}

	public PeopleDTO createPeople(People people) {
		People savedPeople = peopleRepository.save(people);

		return peopleMapper.mapToDTO(savedPeople);
	}

	public Boolean deletePeople(Integer id) {
		if (peopleRepository.existsById(id)) {
			peopleRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}

		boolean doesItExistStill = peopleRepository.existsById(id);

		// if doesItExistStill is true, the entity was not deleted and so false is
		// returned
		return !doesItExistStill;
	}

}
