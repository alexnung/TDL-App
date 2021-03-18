package com.qa.tdl.TDLWA.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.tdl.TDLWA.data.model.People;
import com.qa.tdl.TDLWA.dto.PeopleDTO;

@Component
public class PeopleMapper {

	private ModelMapper modelMapper;

	@Autowired
	public PeopleMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public PeopleDTO mapToDTO(People people) {
		return this.modelMapper.map(people, PeopleDTO.class);
	}

	public People mapToPeople(PeopleDTO peopleDTO) {
		return this.modelMapper.map(peopleDTO, People.class);
	}

}
