package com.qa.tdl.TDLWA.dto;

public class PlayerDTO {

	private int squadNumber;
	
	private String name;
	
	private String position;
	
	private int joined;
	
	private int contractLength;
	
	private int contractSigned;
	
	private int age;
	
	public PlayerDTO() {
		super();
	}

	public PlayerDTO(int squadNumber, String name, String position, int joined, int contractLength, int contractSigned,
			int age) {
		super();
		this.squadNumber = squadNumber;
		this.name = name;
		this.position = position;
		this.joined = joined;
		this.contractLength = contractLength;
		this.contractSigned = contractSigned;
		this.age = age;
	}

	public int getSquadNumber() {
		return squadNumber;
	}

	public void setSquadNumber(int squadNumber) {
		this.squadNumber = squadNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getJoined() {
		return joined;
	}

	public void setJoined(int joined) {
		this.joined = joined;
	}

	public int getContractLength() {
		return contractLength;
	}

	public void setContractLength(int contractLength) {
		this.contractLength = contractLength;
	}

	public int getContractSigned() {
		return contractSigned;
	}

	public void setContractSigned(int contractSigned) {
		this.contractSigned = contractSigned;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "PlayerDTO [squadNumber=" + squadNumber + ", name=" + name + ", position=" + position + ", joined="
				+ joined + ", contractLength=" + contractLength + ", contractSigned=" + contractSigned + ", age=" + age
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + contractLength;
		result = prime * result + contractSigned;
		result = prime * result + joined;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + squadNumber;
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
		PlayerDTO other = (PlayerDTO) obj;
		if (age != other.age)
			return false;
		if (contractLength != other.contractLength)
			return false;
		if (contractSigned != other.contractSigned)
			return false;
		if (joined != other.joined)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (squadNumber != other.squadNumber)
			return false;
		return true;
	}

	
	
}
