package com.qa.tdl.TDLWA.data.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "groupedPositions")
public class GroupedPositions {

	@Id
	@NotNull
	@Column(name = "groupPosition", unique = true)
	private String groupPosition;

	@OneToMany(mappedBy = "groupedPositions", fetch = FetchType.LAZY, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Player> players;

	public GroupedPositions() {
	}

	public GroupedPositions(String groupPosition) {
		super();
		this.groupPosition = groupPosition;
	}

	public String getGroupPosition() {
		return groupPosition;
	}

	public void setGroupPosition(String groupPosition) {
		this.groupPosition = groupPosition;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupPosition == null) ? 0 : groupPosition.hashCode());
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
		GroupedPositions other = (GroupedPositions) obj;
		if (groupPosition == null) {
			if (other.groupPosition != null)
				return false;
		} else if (!groupPosition.equals(other.groupPosition))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GroupedPositions [groupPosition=" + groupPosition + "]";
	}

}
