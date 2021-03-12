package com.qa.tdl.TDLWA.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.tdl.TDLWA.data.model.GroupedPositions;
import com.qa.tdl.TDLWA.data.repository.GroupedPositionsRepository;
import com.qa.tdl.TDLWA.dto.GroupedPositionsDTO;
import com.qa.tdl.TDLWA.mappers.GroupedPositionsMapper;

@Service
public class GroupedPositionsService {

	private GroupedPositionsRepository groupedPositionsRepository;

	private GroupedPositionsMapper groupedPositionsMapper;

	@Autowired
	public GroupedPositionsService(GroupedPositionsRepository groupedPositionsRepository,
			GroupedPositionsMapper groupedPositionsMapper) {
		this.groupedPositionsRepository = groupedPositionsRepository;
		this.groupedPositionsMapper = groupedPositionsMapper;
	}

	@Transactional
	public List<GroupedPositionsDTO> readAllGroupedPositions() {
		List<GroupedPositions> groupedPositionsInDb = groupedPositionsRepository.findAll();
		List<GroupedPositionsDTO> returnables = new ArrayList<GroupedPositionsDTO>();
		groupedPositionsInDb.forEach(groupedPositions -> {
			returnables.add(groupedPositionsMapper.mapToDTO(groupedPositions));
		});
		return returnables;
	}
	
	public GroupedPositionsDTO createGroupedPositions(GroupedPositions groupedPositions) {
		GroupedPositions savedGroupedPositions = groupedPositionsRepository.save(groupedPositions);
		
		return groupedPositionsMapper.mapToDTO(savedGroupedPositions);
	}
	
	public Boolean deleteGroupedPositions(Integer id) {
		if (groupedPositionsRepository.existsById(id)) {
			groupedPositionsRepository.deleteById(id);
		} else {
			throw new EntityNotFoundException();
		}
		
		boolean doesItExistStill = groupedPositionsRepository.existsById(id);
		
		// if doesItExistStill is true, the entity was not deleted and so false is returned
		return !doesItExistStill;
	}
	

}
