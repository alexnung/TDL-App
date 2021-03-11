package com.qa.tdl.TDLWA.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.tdl.TDLWA.data.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    
	@Query("SELECT p FROM PLayer d WHERE d.squad_number = ?1")
	public Player findBySquadNumberJPQL(int squad_number);
	public List<Player> findByNameJPQL(String name);
	public List<Player> findByPositionJPQL(String position);
    public List<Player> findByJoinedJPQL(int joined);
    public List<Player> findByContractLengthJPQL(int contract_length);
    public List<Player> findByContractSignedJPQL(int contract_signed);
    public List<Player> findByAgeJPQL(int age);
    public List<Player> findBySalaryJPQL(float salary);
	
}
