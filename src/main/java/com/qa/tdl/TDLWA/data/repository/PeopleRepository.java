package com.qa.tdl.TDLWA.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.tdl.TDLWA.data.model.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer>{

}
