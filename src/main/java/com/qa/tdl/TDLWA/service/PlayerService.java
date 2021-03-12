package com.qa.tdl.TDLWA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.tdl.TDLWA.data.model.Player;
import com.qa.tdl.TDLWA.data.repository.PlayerRepository;
import com.qa.tdl.TDLWA.dto.PlayerDTO;
import com.qa.tdl.TDLWA.exceptions.PlayerNotFoundException;
import com.qa.tdl.TDLWA.mappers.PlayerMapper;

@Service
public class PlayerService {

	private PlayerRepository playerRepository;

	private PlayerMapper playerMapper;

	@Autowired
	public PlayerService(PlayerRepository playerRepository, PlayerMapper playerMapper) {
		this.playerRepository = playerRepository;
		this.playerMapper = playerMapper;
	}

	public List<PlayerDTO> readAllPlayers() {
		List<Player> players = playerRepository.findAll();
		List<PlayerDTO> playerDTOs = new ArrayList<PlayerDTO>();

		players.forEach(player -> playerDTOs.add(playerMapper.mapToDTO(player)));

		return playerDTOs;
	}

	public PlayerDTO readBySquadNumber(Integer squadNumber) {
		Player player = playerRepository.findBySquadNumberJPQL(squadNumber);

		return playerMapper.mapToDTO(player);
	}

	public PlayerDTO createPlayer(Player player) {
		Player newPlayer = playerRepository.save(player);

		return playerMapper.mapToDTO(newPlayer);
	}

	public PlayerDTO updatePlayer(Integer squadNumber, Player player) throws EntityNotFoundException {
		Optional<Player> playerInDbOpt = playerRepository.findById(squadNumber);
		Player playerInDb;

		if (playerInDbOpt.isPresent()) {
			playerInDb = playerInDbOpt.get();
		} else {
			throw new PlayerNotFoundException("Input existing squad number");
		}

		playerInDb.setName(player.getName());
		playerInDb.setPosition(player.getPosition());
		playerInDb.setJoined(player.getJoined());
		playerInDb.setContractLength(player.getContractLength());
		playerInDb.setContractSigned(player.getContractSigned());
		playerInDb.setAge(player.getAge());
		playerInDb.setSalary(player.getSalary());

		Player updatedPlayer = playerRepository.save(playerInDb);

		return playerMapper.mapToDTO(updatedPlayer);
	}

	public boolean deletePlayer(Integer squadNumber) {
		if (!playerRepository.existsById(squadNumber)) {
			throw new PlayerNotFoundException();
		}
		playerRepository.deleteById(squadNumber);

		boolean exists = playerRepository.existsById(squadNumber);

		return !exists;
	}

}
