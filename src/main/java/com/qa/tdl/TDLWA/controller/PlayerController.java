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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qa.tdl.TDLWA.data.model.Player;

@RestController
@RequestMapping(path = "/player") // This controller has a base path of /player (localhost:8080/player)
@CrossOrigin // Enables CORS (allows us to make a request from localhost:5000 (or any other address) to our api on localhost:8080)
public class PlayerController {

	private PlayerService playerService;
	
	
	@Autowired // constructor injection (injected from the application context)
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	// localhost:8080/duck
	@GetMapping
	public ResponseEntity<List<PlayerDTO>> getAllPlayers() {
		// Requesting our PLayerDTO data from the playerService
		List<PlayerDTO> data = playerService.readAllPlayerss();
		
		// returning a response of type ResponseEntity(Body, Headers, HttpStatus)
		return new ResponseEntity<List<PlayerDTO>>(data, HttpStatus.OK);
	}
	
	// localhost:8080/player/Squad Number/1
	@GetMapping("/squad_number/{squad_number}")
	public ResponseEntity<PlayerDTO> getPlayerBySquadNumber(@PathVariable("squad_number") Integer squad_number) {
		PlayerDTO Player = PlayerService.readByName(squad_number);
		
		return new ResponseEntity<PlayerDTO>(player, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PlayerDTO> createPlayer(@Valid @RequestBody Player player) {
		// A Player is retrieved from the incoming request body (the conversion from json to duck is automatic)
		// - `@RequestBody Player player` makes this happen
		// - @Valid is used to employ our models validation on the incoming request
		
		PlayerDTO newPlayer = playerService.createPlayer(player);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newPlayer.getSquad_Number()));
	
		return new ResponseEntity<PlayerDTO>(newPlayer, headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/{squad_number}")
	public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable("squad_number") int squad_number,
										   @RequestBody Player player) {
		PlayerDTO updatedPlayer = playerService.updatePlayer(squad_number, player);
		
		return new ResponseEntity<PlayerDTO>(updatedPlayer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{squad_number}")
	public ResponseEntity<Boolean> deletePLayer(@PathVariable("squad_number") int squad_number) {		
		return new ResponseEntity<Boolean>(playerService.deletePlayer(squad_number), HttpStatus.OK);
	}
	
	
}
