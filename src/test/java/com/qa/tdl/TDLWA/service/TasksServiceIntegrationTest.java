package com.qa.tdl.TDLWA.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.tdl.TDLWA.data.model.Tasks;
import com.qa.tdl.TDLWA.data.repository.TasksRepository;
import com.qa.tdl.TDLWA.dto.TasksDTO;
import com.qa.tdl.TDLWA.mappers.TasksMapper;

@SpringBootTest
public class TasksServiceIntegrationTest {

	@Autowired
	private TasksService tasksService;

	@Autowired
	private TasksRepository tasksRepository;

	@Autowired
	private TasksMapper tasksMapper;

	private List<Tasks> tasks;
	private List<TasksDTO> tasksDTOs;
//	private List<TasksDTO> emptyTasksDTOs;

	private Tasks validTasks;
	private TasksDTO validTasksDTO;
//	private TasksDTO emptyValidTasksDTO;

	@BeforeEach
	public void init() {
		validTasks = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A");
		tasks = new ArrayList<Tasks>();
		tasksDTOs = new ArrayList<TasksDTO>();
//		emptyTasksDTOs = new ArrayList<TasksDTO>();
		tasksRepository.deleteAll();
		validTasks = tasksRepository.save(validTasks);
		validTasksDTO = tasksMapper.mapToDTO(validTasks);
		tasks.add(validTasks);
		tasksDTOs.add(validTasksDTO);
	}

	@Test
	public void readAllTasksTest() {
		List<TasksDTO> tasksInDb = tasksService.readAllTasks();
		assertThat(tasksDTOs).isEqualTo(tasksInDb);
	}

	@Test
	public void readByIdTest() {
		assertThat(validTasksDTO).isEqualTo(tasksService.readById(validTasks.getId()));
	}

	/*
	 * @Test public void readByIdExceptionTest() {
	 * assertThat(emptyValidTasksDTO).isEqualTo(tasksService.readById(validTasks.
	 * getId())); }
	 */

	@Test
	public void createTasksTest() {
		Tasks newTasks = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A");
		TasksDTO expectedTasksDTO = tasksMapper.mapToDTO(newTasks);
		TasksDTO savedTasks = tasksService.createTask(newTasks);
		expectedTasksDTO.setId(savedTasks.getId());
		assertThat(savedTasks).isEqualTo(expectedTasksDTO);
	}

	@Test
	public void updateTasksTest() {
		Tasks newTasks = new Tasks(5, "Eric", "08/04/2021", "Ongoing", "N/A");
		TasksDTO newTasksDTO = tasksMapper.mapToDTO(newTasks);
		TasksDTO toTasksDTO = tasksService.updateTasks(validTasks.getId(), newTasks);
		assertThat(newTasksDTO).isEqualTo(toTasksDTO);
	}

	@Test
	public void deleteTasksTest() {
		assertThat(true).isEqualTo(tasksService.deleteTask(validTasks.getId()));
	}

}
