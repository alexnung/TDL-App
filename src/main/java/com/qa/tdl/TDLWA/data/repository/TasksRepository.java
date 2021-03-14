package com.qa.tdl.TDLWA.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.tdl.TDLWA.data.model.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Integer> {
    
	@Query("SELECT t FROM Tasks t WHERE t.id = ?1")
	public Tasks findByIdJPQL(int id);
	public List<Tasks> findByTask(String task);
	public List<Tasks> findByStatus(String status);
	public List<Tasks> findByDueDate(String dueDate);
	public List<Tasks> findByCompletedOnTime(String completedOnTime);
	
}
