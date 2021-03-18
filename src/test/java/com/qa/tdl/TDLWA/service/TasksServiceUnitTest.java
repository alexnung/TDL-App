package com.qa.tdl.TDLWA.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.tdl.TDLWA.data.model.Tasks;
import com.qa.tdl.TDLWA.data.repository.TasksRepository;
import com.qa.tdl.TDLWA.dto.TasksDTO;
import com.qa.tdl.TDLWA.mappers.TasksMapper;

@ExtendWith(MockitoExtension.class)
public class TasksServiceUnitTest {

	@InjectMocks
	private TasksService tasksService;

	@Mock
	private TasksRepository tasksRepository;

	@Mock
	private TasksMapper tasksMapper;

	private List<Tasks> tasks;
	private List<TasksDTO> tasksDTO;
//	private List<TasksDTO> emptyTasksDTO;

	private Tasks validTasks;
	private TasksDTO validTasksDTO;
//	private Tasks validEmptyTasksDTO;

	@BeforeEach
	public void init() {
		validTasks = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A");
		validTasksDTO = new TasksDTO(1, "Eric", "08/04/2021", "Ongoing");

		tasks = new ArrayList<Tasks>();
		tasksDTO = new ArrayList<TasksDTO>();
//		emptyTasksDTO = new ArrayList<TasksDTO>();

		tasks.add(validTasks);
		tasksDTO.add(validTasksDTO);
	}

	@Test
	public void readAllTasksTest() {
		when(tasksRepository.findAll()).thenReturn(tasks);
		when(tasksMapper.mapToDTO(validTasks)).thenReturn(validTasksDTO);
		assertThat(tasksDTO).isEqualTo(tasksService.readAllTasks());
		verify(tasksRepository, times(1)).findAll();
		verify(tasksMapper, times(1)).mapToDTO(validTasks);
	}

	@Test
	public void getTasksByIdTest() {
		when(tasksRepository.existsById(Mockito.any(Integer.class))).thenReturn(true);
		when(tasksRepository.findByIdJPQL(Mockito.any(Integer.class))).thenReturn(validTasks);
		when(tasksMapper.mapToDTO(validTasks)).thenReturn(validTasksDTO);
		assertThat(validTasksDTO).isEqualTo(tasksService.readById(Mockito.any(Integer.class)));
		verify(tasksRepository, times(1)).existsById(Mockito.any(Integer.class));
		verify(tasksRepository, times(1)).findByIdJPQL(Mockito.any(Integer.class));
		verify(tasksMapper, times(1)).mapToDTO(validTasks);
	}
/*
	@Test
	public void getTasksByIdExceptionTest() {
		tasksDTO.clear();
		when(tasksRepository.existsById(Mockito.any(Integer.class))).thenReturn(false);
		when(tasksRepository.findByIdJPQL(Mockito.any(Integer.class))).thenReturn(validEmptyTasksDTO);
		assertThat(validEmptyTasksDTO).isEqualTo(tasksService.readById(Mockito.any(Integer.class)));
		verify(tasksRepository, times(1)).existsById(Mockito.any(Integer.class));
		verify(tasksRepository, times(1)).findByIdJPQL(Mockito.any(Integer.class));
	}
	*/

	@Test
	public void createTaskTest() {
		when(tasksRepository.save(Mockito.any(Tasks.class))).thenReturn(validTasks);
		when(tasksMapper.mapToDTO(Mockito.any(Tasks.class))).thenReturn(validTasksDTO);
		assertThat(validTasksDTO).isEqualTo(tasksService.createTask(validTasks));
		verify(tasksRepository, times(1)).save(Mockito.any(Tasks.class));
		verify(tasksMapper, times(1)).mapToDTO(Mockito.any(Tasks.class));
	}

	@Test
	public void updateTasksTest() {
		Tasks updatedTasks = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A");
		TasksDTO updatedTasksDTO = new TasksDTO(1, "Eric", "08/04/2021", "Ongoing");
		when(tasksRepository.findById(Mockito.any(Integer.class))).thenReturn(Optional.of(validTasks));
		when(tasksRepository.save(Mockito.any(Tasks.class))).thenReturn(updatedTasks);
		when(tasksMapper.mapToDTO(Mockito.any(Tasks.class))).thenReturn(updatedTasksDTO);
		TasksDTO testDTO = tasksService.updateTasks(validTasks.getId(), updatedTasks);
		assertThat(updatedTasksDTO).isEqualTo(testDTO);
	}

	@Test
	public void deleteTasksTest() {
		when(tasksRepository.existsById(Mockito.any(Integer.class))).thenReturn(true).thenReturn(false);
		assertThat(true).isEqualTo(tasksService.deleteTask(1));
		verify(tasksRepository, times(2)).existsById(Mockito.any(Integer.class));
		verify(tasksRepository, times(1)).deleteById(Mockito.any(Integer.class));
	}

}
