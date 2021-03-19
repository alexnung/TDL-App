package com.qa.tdl.TDLWA.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.tdl.TDLWA.data.model.Tasks;
import com.qa.tdl.TDLWA.dto.TasksDTO;
import com.qa.tdl.TDLWA.mappers.TasksMapper;

@SpringBootTest
public class TasksMapperTest {

	@Autowired
	TasksMapper tasksMapper;
	Tasks tasks;
	TasksDTO tasksDTO;
	
	@BeforeEach
	void setup() {
		tasks = new Tasks(1, "Eric", "08/04/2021", "Ongoing", null);
		tasksDTO = new TasksDTO(1, "Eric", "08/04/2021", "Ongoing");
	}
	
    @Test
    void mapToDTOTest() {
        assertThat(tasksMapper.mapToDTO(tasks)).isEqualTo(tasksDTO);
    }

    @Test
    void mapToTasksTest() {
        assertThat(tasksMapper.mapToTasks(tasksDTO)).isEqualTo(tasks);
    }
	
}
