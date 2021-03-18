package com.qa.tdl.TDLWA.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.tdl.TDLWA.data.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {


	@Query("SELECT p FROM People p WHERE p.id = ?1")
	public People findByIdJPQL(int id);
	public People deleteById(int id);
	
}
