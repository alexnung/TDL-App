package com.qa.tdl.TDLWA.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.tdl.TDLWA.data.model.Player;
import com.qa.tdl.TDLWA.data.repository.PlayerRepository;
import com.qa.tdl.TDLWA.exceptions.PlayerNotFoundException;

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
		List<PlayerDTO> duckDTOs = new ArrayList<PlayerDTO>();

		players.forEach(player -> playerDTOs.add(playerMapper.mapToDTO(player)));

		return playerDTOs;
	}

	public PlayerDTO readBySquadNumber(Integer squad_number) {
		Player player = playerRepository.findBySquadNumberJPQL(squad_number);

		return playerMapper.mapToDTO(player);
	}

	public PlayerDTO createPlayer(Player player) {
		Player newPlayer = playerRepository.save(player);

		return PlayerMapper.mapToDTO(newPlayer);
	}

	public PlayerDTO updateDuck(Integer squad_number, Player player) throws EntityNotFoundException {
		Optional<Player> playerInDbOpt = playerRepository.findById(squad_number);
		Player playerInDb;

		if (playerInDbOpt.isPresent()) {
			playerInDb = playerInDbOpt.get();
		} else {
			throw new PlayerNotFoundException("Input existing squad number");
		}

		playerInDb.setName(player.getName());
		playerInDb.setPosition(player.getPosition());
		playerInDb.setJoined(player.getJoined());
		playerInDb.setContract_length(player.getContract_length());
		playerInDb.setContract_signed(player.getContract_signed());
		playerInDb.setAge(player.getAge());
		playerInDb.setSalary(player.getSalary());

		Player playerDuck = playerRepository.save(playerInDb);

		return playerMapper.mapToDTO(playerDuck);
	}

	public boolean deletePLayer(Integer squad_number) {
		if (!playerRepository.existsById(squad_number)) {
			throw new PlayerNotFoundException();
		}
		playerRepository.deleteById(squad_number);

		boolean exists = playerRepository.existsById(squad_number);

		return !exists;
	}

}
