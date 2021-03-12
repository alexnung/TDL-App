package com.qa.tdl.TDLWA.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qa.tdl.TDLWA.data.model.Player;
import com.qa.tdl.TDLWA.dto.PlayerDTO;

@Component
public class PlayerMapper {

	private ModelMapper modelMapper;
	
	@Autowired
	public PlayerMapper(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}
	
	public PlayerDTO mapToDTO(Player player) {
		return this.modelMapper.map(player, PlayerDTO.class);
	}
	
	public Player mapToPlayer(PlayerDTO playerDTO) {
		return this.modelMapper.map(playerDTO, Player.class);
	}
}
