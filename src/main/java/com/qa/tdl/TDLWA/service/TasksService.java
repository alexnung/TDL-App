package com.qa.tdl.TDLWA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.tdl.TDLWA.data.model.Tasks;
import com.qa.tdl.TDLWA.data.repository.TasksRepository;
import com.qa.tdl.TDLWA.dto.TasksDTO;
import com.qa.tdl.TDLWA.exceptions.TaskNotFoundException;
import com.qa.tdl.TDLWA.mappers.TasksMapper;

@Service
public class TasksService {

	private TasksRepository tasksRepository;

	private TasksMapper tasksMapper;

	@Autowired
	public TasksService(TasksRepository tasksRepository, TasksMapper tasksMapper) {
		this.tasksRepository = tasksRepository;
		this.tasksMapper = tasksMapper;
	}

	public List<TasksDTO> readAllTasks() {
		List<Tasks> tasks = tasksRepository.findAll();
		List<TasksDTO> tasksDTOs = new ArrayList<TasksDTO>();

		tasks.forEach(task -> tasksDTOs.add(tasksMapper.mapToDTO(task)));

		return tasksDTOs;
	}

	public TasksDTO readById(Integer id) {
		if (!tasksRepository.existsById(id)) {
			throw new TaskNotFoundException("Input existing ID");
		}
		Tasks tasks = tasksRepository.findByIdJPQL(id);

		return tasksMapper.mapToDTO(tasks);
	}

	public TasksDTO createTask(Tasks tasks) {
		Tasks newTask = tasksRepository.save(tasks);

		return tasksMapper.mapToDTO(newTask);
	}

	@Transactional
	public TasksDTO updateTasks(Integer id, Tasks tasks) throws EntityNotFoundException {
		Optional<Tasks> tasksInDbOpt = tasksRepository.findById(id);
		Tasks tasksInDb;

		if (tasksInDbOpt.isPresent()) {
			tasksInDb = tasksInDbOpt.get();
		} else {
			throw new TaskNotFoundException("Input existing ID");
		}

//		tasksInDb.setId(tasks.getId());
		tasksInDb.setTask(tasks.getTask());
		tasksInDb.setDueDate(tasks.getDueDate());
		tasksInDb.setStatus(tasks.getStatus());
		tasksInDb.setCompletedOnTime(tasks.getCompletedOnTime());

		Tasks updatedTask = tasksRepository.save(tasksInDb);

		return tasksMapper.mapToDTO(updatedTask);
	}

	public boolean deleteTask(Integer id) {
		if (!tasksRepository.existsById(id)) {
			throw new TaskNotFoundException("Input existing ID");
		}
		tasksRepository.deleteById(id);

		boolean exists = tasksRepository.existsById(id);

		return !exists;
	}

}
