package com.qa.tdl.TDLWA.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.dto.PeopleDTO;
import com.qa.tdl.TDLWA.service.PeopleService;

@RestController
@RequestMapping("/people")
public class PeopleController {

	private PeopleService peopleService;

	@Autowired
	public PeopleController(PeopleService peopleService) {
		this.peopleService = peopleService;
	}

	@GetMapping
	public ResponseEntity<List<PeopleDTO>> getAllPeople() {
		List<PeopleDTO> data = peopleService.readAllPeople();

		return new ResponseEntity<List<PeopleDTO>>(data, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<PeopleDTO> createPeople(@Valid @RequestBody People people) {
		PeopleDTO newPeople = peopleService.createPeople(people);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newPeople.getId()));

		return new ResponseEntity<PeopleDTO>(newPeople, headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Boolean> deletePeople(@PathVariable("id") int id) {
		return new ResponseEntity<Boolean>(peopleService.deletePeople(id), HttpStatus.OK);
	}

}
