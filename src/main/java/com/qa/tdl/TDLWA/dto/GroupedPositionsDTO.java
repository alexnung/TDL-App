package com.qa.tdl.TDLWA.dto;

import java.util.List;

public class GroupedPositionsDTO {

	private int id;

	private String groupPosition;

	private List<PlayerDTO> Player;

	public GroupedPositionsDTO() {
	}

	public GroupedPositionsDTO(int id, String groupPosition, List<PlayerDTO> player) {
		super();
		this.id = id;
		this.groupPosition = groupPosition;
		this.Player = player;
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

	public List<PlayerDTO> getPlayer() {
		return Player;
	}

	public void setPlayer(List<PlayerDTO> player) {
		Player = player;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Player == null) ? 0 : Player.hashCode());
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
		if (Player == null) {
			if (other.Player != null)
				return false;
		} else if (!Player.equals(other.Player))
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
		return "GroupedPositionsDTO [id=" + id + ", groupPosition=" + groupPosition + ", Player=" + Player + "]";
	}

}
