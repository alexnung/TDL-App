package com.qa.tdl.TDLWA.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.qa.tdl.TDLWA.data.model.Tasks;
import com.qa.tdl.TDLWA.dto.TasksDTO;
import com.qa.tdl.TDLWA.service.TasksService;

@WebMvcTest(TasksController.class)
public class TasksControllerUnitTest {

	@Autowired
	private TasksController tasksController;

	@MockBean
	private TasksService tasksService;

	private List<Tasks> tasks;
	private List<TasksDTO> tasksDTO;

	private Tasks validTasks;
	private TasksDTO validTasksDTO;

	@BeforeEach
	public void init() {
		validTasks = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A");
		validTasksDTO = new TasksDTO(1, "Eric", "08/04/2021", "Ongoing");

		tasks = new ArrayList<Tasks>();
		tasksDTO = new ArrayList<TasksDTO>();

		tasks.add(validTasks);
		tasksDTO.add(validTasksDTO);
	}

	@Test
	public void getAllTasksTest() {
		when(tasksService.readAllTasks()).thenReturn(tasksDTO);
		ResponseEntity<List<TasksDTO>> response = new ResponseEntity<List<TasksDTO>>(tasksDTO, HttpStatus.OK);
		assertThat(response).isEqualTo(tasksController.getAllTasks());
		verify(tasksService, times(1)).readAllTasks();
	}

	@Test
	public void getTasksById() {
		when(tasksService.readById(validTasksDTO.getId())).thenReturn(validTasksDTO);
		ResponseEntity<TasksDTO> response = new ResponseEntity<TasksDTO>(validTasksDTO, HttpStatus.OK);
		assertThat(response).isEqualTo(tasksController.getTasksById(validTasksDTO.getId()));
		verify(tasksService, times(1)).readById(validTasksDTO.getId());
	}

	@Test
	public void createTaskTest() {
		when(tasksService.createTask(validTasks)).thenReturn(validTasksDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(validTasksDTO.getId()));
		ResponseEntity<TasksDTO> response = new ResponseEntity<TasksDTO>(validTasksDTO, headers, HttpStatus.CREATED);
		assertThat(response).isEqualTo(tasksController.createTask(validTasks));
		verify(tasksService, times(1)).createTask(validTasks);
	}

	@Test
	public void updateTaskTest() {
		when(tasksService.updateTasks(validTasks.getId(), validTasks)).thenReturn(validTasksDTO);
		ResponseEntity<TasksDTO> response = new ResponseEntity<TasksDTO>(validTasksDTO, HttpStatus.OK);
		assertThat(response).isEqualTo(tasksController.updateTask(validTasks.getId(), validTasks));
		verify(tasksService, times(1)).updateTasks(validTasks.getId(), validTasks);
	}

	@Test
	public void deleteTaskTest() {
		when(tasksService.deleteTask(validTasks.getId())).thenReturn(true);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
		assertThat(response).isEqualTo(tasksController.deleteTask(validTasks.getId()));
		verify(tasksService, times(1)).deleteTask(validTasks.getId());
	}

}