package com.qa.tdl.TDLWA.dto;

public class PlayerDTO {

	private int squad_number;
	
	private String name;
	
	private String position;
	
	private int joined;
	
	private int contract_length;
	
	private int contract_signed;
	
	private int age;
	
	public PlayerDTO() {
		super();
	}

	public PlayerDTO(int squad_number, String name, String position, int joined, int contract_length,
			int contract_signed, int age) {
		super();
		this.squad_number = squad_number;
		this.name = name;
		this.position = position;
		this.joined = joined;
		this.contract_length = contract_length;
		this.contract_signed = contract_signed;
		this.age = age;
	}

	public int getSquad_number() {
		return squad_number;
	}

	public void setSquad_number(int squad_number) {
		this.squad_number = squad_number;
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

	public int getContract_length() {
		return contract_length;
	}

	public void setContract_length(int contract_length) {
		this.contract_length = contract_length;
	}

	public int getContract_signed() {
		return contract_signed;
	}

	public void setContract_signed(int contract_signed) {
		this.contract_signed = contract_signed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + contract_length;
		result = prime * result + contract_signed;
		result = prime * result + joined;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + squad_number;
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
		if (contract_length != other.contract_length)
			return false;
		if (contract_signed != other.contract_signed)
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
		if (squad_number != other.squad_number)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerDTO [squad_number=" + squad_number + ", name=" + name + ", position=" + position + ", joined="
				+ joined + ", contract_length=" + contract_length + ", contract_signed=" + contract_signed + ", age="
				+ age + "]";
	}
	
}
