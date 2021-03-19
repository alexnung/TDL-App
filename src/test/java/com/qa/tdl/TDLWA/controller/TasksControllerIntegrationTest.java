package com.qa.tdl.TDLWA.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.tdl.TDLWA.data.model.Tasks;
import com.qa.tdl.TDLWA.dto.TasksDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // configures the MockMvc object (used to send requests to our API)
@Sql(scripts = { "classpath:test-schema.sql",
		"classpath:test-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
public class TasksControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper objectMapper;

//	private Tasks validTask = new Tasks(1, "Eric", "08/04/2021", "Ongoing", "N/A");
	private TasksDTO taskDTO = new TasksDTO(1, "Eric", "08/04/2021", "Ongoing");

//	private List<Tasks> validTasks = List.of(validTask);
	private List<TasksDTO> validTasksDTO = List.of(taskDTO);

	@Test
	public void createTasksTest() throws Exception {
		Tasks tasksToSave = new Tasks("Eric", "08/04/2021", "Ongoing", "n/a");
		TasksDTO expectedTasks = new TasksDTO(2, "Eric", "08/04/2021", "Ongoing");
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/tasks");
		mockRequest.contentType(MediaType.APPLICATION_JSON);
		mockRequest.content(objectMapper.writeValueAsString(tasksToSave));
		mockRequest.accept(MediaType.APPLICATION_JSON);
		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isCreated();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedTasks));
		ResultMatcher headerMatcher = MockMvcResultMatchers.header().string("Location", "2");
		mvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher).andExpect(headerMatcher);

	}

	@Test
	public void getAllTasksTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/tasks");
		mockRequest.accept(MediaType.APPLICATION_JSON);

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(validTasksDTO));

		mvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

	@Test
	public void getTasksByIdTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "/tasks/id/1");
		mockRequest.accept(MediaType.APPLICATION_JSON);

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(taskDTO));

		mvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

	@Test
	public void updateTasksTest() throws Exception {
		Tasks tasksToSave = new Tasks("Eric", "08/04/2021", "Ongoing", "N/A");
		TasksDTO expectedTasks = new TasksDTO(1, "Eric", "08/04/2021", "Ongoing");

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "/tasks/id/1");

		mockRequest.contentType(MediaType.APPLICATION_JSON); // Mime-Type
		mockRequest.content(objectMapper.writeValueAsString(tasksToSave)); // sending Duck in

		// Specify what data type we expect in response
		mockRequest.accept(MediaType.APPLICATION_JSON);

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isOk();

		ResultMatcher contentMatcher = MockMvcResultMatchers.content()
				.json(objectMapper.writeValueAsString(expectedTasks)); // expecting DuckDTO back

		mvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

	@Test
	public void deleteTasksTest() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "/tasks/id/1");
		mockRequest.accept(MediaType.APPLICATION_JSON);

		ResultMatcher statusMatcher = MockMvcResultMatchers.status().isNoContent();
		ResultMatcher contentMatcher = MockMvcResultMatchers.content().string("true");

		mvc.perform(mockRequest).andExpect(statusMatcher).andExpect(contentMatcher);
	}

}
