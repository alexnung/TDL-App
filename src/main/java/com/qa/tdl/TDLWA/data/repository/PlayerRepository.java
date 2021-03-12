package com.qa.tdl.TDLWA.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.tdl.TDLWA.data.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    
	@Query("SELECT p FROM Player p WHERE p.squadNumber = ?1")
	public Player findBySquadNumberJPQL(int squadNumber);
	public List<Player> findByName(String name);
	public List<Player> findByPosition(String position);
    public List<Player> findByJoined(int joined);
    public List<Player> findByContractLength(int contractLength);
    public List<Player> findByContractSigned(int contractSigned);
    public List<Player> findByAge(int age);
    public List<Player> findBySalary(float salary);
	
}
