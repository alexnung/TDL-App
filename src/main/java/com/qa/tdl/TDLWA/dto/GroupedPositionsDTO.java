package com.qa.tdl.TDLWA.dto;

import java.util.List;

public class GroupedPositionsDTO {

	private int id;

	private String groupPosition;

	private List<PlayerDTO> players;

	public GroupedPositionsDTO() {
	}

	public GroupedPositionsDTO(int id, String groupPosition, List<PlayerDTO> player) {
		super();
		this.id = id;
		this.groupPosition = groupPosition;
		this.players = player;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupPosition() {
		return groupPosition;
	}

	public void setGroupPosition(String groupPosition) {
		this.groupPosition = groupPosition;
	}

	public List<PlayerDTO> getPlayers() {
		return players;
	}

	public void setPlayers(List<PlayerDTO> player) {
		players = player;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + ((groupPosition == null) ? 0 : groupPosition.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupedPositionsDTO other = (GroupedPositionsDTO) obj;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (groupPosition == null) {
			if (other.groupPosition != null)
				return false;
		} else if (!groupPosition.equals(other.groupPosition))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupedPositionsDTO [id=" + id + ", groupPosition=" + groupPosition + ", players=" + players + "]";
	}

}
