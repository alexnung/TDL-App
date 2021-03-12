package com.qa.tdl.TDLWA.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.tdl.TDLWA.data.model.GroupedPositions;
import com.qa.tdl.TDLWA.dto.GroupedPositionsDTO;

@Component
public class GroupedPositionsMapper {

	private ModelMapper modelMapper;
	
	@Autowired
	public GroupedPositionsMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public GroupedPositionsDTO mapToDTO(GroupedPositions groupedPositions) {
		return this.modelMapper.map(groupedPositions, GroupedPositionsDTO.class);
	}
	
	public GroupedPositions mapToPond(GroupedPositionsDTO groupedPositionsDTO) {
		return this.modelMapper.map(groupedPositionsDTO, GroupedPositions.class);
	}
	
}
