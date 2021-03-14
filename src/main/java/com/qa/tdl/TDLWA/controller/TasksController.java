package com.qa.tdl.TDLWA.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.tdl.TDLWA.data.model.Tasks;
import com.qa.tdl.TDLWA.dto.TasksDTO;
import com.qa.tdl.TDLWA.service.TasksService;

@RestController
@RequestMapping(path = "/tasks") // This controller has a base path of /player (localhost:8080/tasks)
@CrossOrigin // Enables CORS (allows us to make a request from localhost:5000 (or any other
				// address) to our api on localhost:8080)
public class TasksController {

	private TasksService tasksService;

	@Autowired // constructor injection (injected from the application context)
	public TasksController(TasksService tasksService) {
		this.tasksService = tasksService;
	}

	// localhost:8080/tasks
	@GetMapping
	public ResponseEntity<List<TasksDTO>> getAllTasks() {
		// Requesting our TasksDTO data from the tasksService
		List<TasksDTO> data = tasksService.readAllTasks();

		// returning a response of type ResponseEntity(Body, Headers, HttpStatus)
		return new ResponseEntity<List<TasksDTO>>(data, HttpStatus.OK);
	}

	// localhost:8080/tasks/id/1
	@GetMapping("/id/{id}")
	public ResponseEntity<TasksDTO> getTasksById(@PathVariable("id") Integer id) {
		TasksDTO tasks = tasksService.readById(id);
		return new ResponseEntity<TasksDTO>(tasks, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TasksDTO> createTask(@Valid @RequestBody Tasks tasks) {
		// A Player is retrieved from the incoming request body (the conversion from
		// json to duck is automatic)
		// - `@RequestBody Player player` makes this happen
		// - @Valid is used to employ our models validation on the incoming request

		TasksDTO newTask = tasksService.createTask(tasks);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newTask.getId()));

		return new ResponseEntity<TasksDTO>(newTask, headers, HttpStatus.CREATED);
	}

	@PutMapping("/id/{id}")
	public ResponseEntity<TasksDTO> updateTask(@PathVariable("id") int id, @RequestBody Tasks tasks) {
		TasksDTO updatedTasks = tasksService.updateTasks(id, tasks);

		return new ResponseEntity<TasksDTO>(updatedTasks, HttpStatus.OK);
	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<Boolean> deleteTask(@PathVariable("id") int id) {
		return new ResponseEntity<Boolean>(tasksService.deleteTask(id), HttpStatus.OK);
	}

}
