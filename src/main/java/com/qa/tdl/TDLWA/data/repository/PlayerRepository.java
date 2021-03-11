package com.qa.tdl.TDLWA.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.tdl.TDLWA.data.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    
    public List<Player> findByName(String name);
	public List<Player> findByPosition(String position);
    public List<Player> findByJoined(int joined);
    public List<Player> findByContractLength(int contract_length);
    public List<Player> findByContractSigned(int contract_signed);
    public List<Player> findByAge(int age);
    public List<Player> findBySalary(float salary);
	
}
