package com.qa.tdl.TDLWA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.data.repository.PeopleRepository;
import com.qa.tdl.TDLWA.dto.PeopleDTO;
import com.qa.tdl.TDLWA.exceptions.PersonNotFoundException;
import com.qa.tdl.TDLWA.exceptions.TaskNotFoundException;
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

	public PeopleDTO readById(Integer id) {
		if (!peopleRepository.existsById(id)) {
			throw new PersonNotFoundException("Input existing ID");
		}
		People people = peopleRepository.findByIdJPQL(id);

		return peopleMapper.mapToDTO(people);
	}

	public PeopleDTO createPeople(People people) {
		People savedPeople = peopleRepository.save(people);

		return peopleMapper.mapToDTO(savedPeople);
	}

	@Transactional
	public PeopleDTO updatePeople(Integer id, People people) throws EntityNotFoundException {
		Optional<People> peopleInDbOpt = peopleRepository.findById(id);
		People peopleInDb;

		if (peopleInDbOpt.isPresent()) {
			peopleInDb = peopleInDbOpt.get();
		} else {
			throw new TaskNotFoundException("Input existing ID");
		}

//		peopleInDb.setId(people.getId()); //dont want to edit id in database
		peopleInDb.setName(people.getName());
		peopleInDb.setTitle(people.getTitle());
		peopleInDb.setTasks(people.getTasks());

		People updatedPeople = peopleRepository.save(peopleInDb);

		return peopleMapper.mapToDTO(updatedPeople);
	}

	public boolean deletePeople(Integer id) {

		if (peopleRepository.existsById(id)) {
			peopleRepository.deleteById(id);
		} else {
			throw new PersonNotFoundException("Input existing ID");
		}

		boolean doesItExistStill = peopleRepository.existsById(id);

		return !doesItExistStill;
		 
	}

}
