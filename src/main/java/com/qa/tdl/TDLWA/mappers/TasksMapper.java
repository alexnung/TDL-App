package com.qa.tdl.TDLWA.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.tdl.TDLWA.data.model.Tasks;
import com.qa.tdl.TDLWA.dto.TasksDTO;

@Component
public class TasksMapper {

	private ModelMapper modelMapper;

	@Autowired
	public TasksMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	public TasksDTO mapToDTO(Tasks tasks) {
		return this.modelMapper.map(tasks, TasksDTO.class);
	}

	public Tasks mapToPlayer(TasksDTO tasksDTO) {
		return this.modelMapper.map(tasksDTO, Tasks.class);
	}
}
