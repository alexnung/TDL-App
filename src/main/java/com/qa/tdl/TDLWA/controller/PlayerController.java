package com.qa.tdl.TDLWA.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.tdl.TDLWA.data.model.Player;
import com.qa.tdl.TDLWA.dto.PlayerDTO;
import com.qa.tdl.TDLWA.service.PlayerService;

@RestController
@RequestMapping(path = "/player") // This controller has a base path of /player (localhost:8080/player)
@CrossOrigin // Enables CORS (allows us to make a request from localhost:5000 (or any other address) to our api on localhost:8080)
public class PlayerController {

	private PlayerService playerService;
	
	
	@Autowired // constructor injection (injected from the application context)
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	// localhost:8080/player
	@GetMapping
	public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
		// Requesting our PLayerDTO data from the playerService
		List<PlayerDTO> data = playerService.readAllPlayers();
		
		// returning a response of type ResponseEntity(Body, Headers, HttpStatus)
		return new ResponseEntity<List<PlayerDTO>>(data, HttpStatus.OK);
	}
	
	// localhost:8080/player/Squad Number/1
	@GetMapping("/squadnumber/{squadnumber}")
	public ResponseEntity<PlayerDTO> getPlayerBySquadNumber(@PathVariable("squadNumber") Integer squadNumber) {
		PlayerDTO player = playerService.readBySquadNumber(squadNumber);
		return new ResponseEntity<PlayerDTO>(player, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PlayerDTO> createPlayer(@Valid @RequestBody Player player) {
		// A Player is retrieved from the incoming request body (the conversion from json to duck is automatic)
		// - `@RequestBody Player player` makes this happen
		// - @Valid is used to employ our models validation on the incoming request
		
		PlayerDTO newPlayer = playerService.createPlayer(player);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newPlayer.getSquadNumber()));
	
		return new ResponseEntity<PlayerDTO>(newPlayer, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/squadnumber/{squadNumber}")
	public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable("squadNumber") int squadNumber,
										   @RequestBody Player player) {
		PlayerDTO updatedPlayer = playerService.updatePlayer(squadNumber, player);
		
		return new ResponseEntity<PlayerDTO>(updatedPlayer, HttpStatus.OK);
	}
	
	@DeleteMapping("/squadnumber/{squadNumber}")
	public ResponseEntity<Boolean> deletePLayer(@PathVariable("squadNumber") int squadNumber) {		
		return new ResponseEntity<Boolean>(playerService.deletePlayer(squadNumber), HttpStatus.OK);
	}
	
}
