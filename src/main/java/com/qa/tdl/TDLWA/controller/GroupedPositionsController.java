package com.qa.tdl.TDLWA.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.tdl.TDLWA.data.model.GroupedPositions;
import com.qa.tdl.TDLWA.dto.GroupedPositionsDTO;

@RestController
@RequestMapping("/GroupedPositions")
public class GroupedPositionsController {

	private GroupedPositionsService groupPositionsService;
	
	@Autowired
	public GroupedPositionsController(GroupedPositionsService groupedPositionsService) {
		this.groupPositionsService = groupedPositionsService;
	}
	
	@GetMapping
	public ResponseEntity<List<GroupedPositionsDTO>> getAllGroupedPositions() {
		List<GroupedPositionsDTO> data = groupedPositionsService.readAllGroupedPositions();
		
		return new ResponseEntity<List<GroupedPositionsDTO>>(data, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<GroupedPositionsDTO> createGroupedPositions(@Valid @RequestBody GroupedPositions groupedPositions) {
		GroupedPositionsDTO newGroupedPositions = groupedPositionsService.createGroupedPositions(groupedPositions);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", String.valueOf(newGroupPositions.get()));
	
		return new ResponseEntity<GroupedPositionsDTO>(newGroupedPositions, headers, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteDuck(@PathVariable("id") Integer id) {		
		return new ResponseEntity<Boolean>(groupedPositionsService.deleteId(id), HttpStatus.OK);
	}
	
}
