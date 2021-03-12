package com.qa.tdl.TDLWA.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Player {

	@Id
	@Column(name = "squad_number", unique = true)
	@NotNull
	private int squadNumber;
	
	@NotNull
	private String name;
	
	@NotNull
	private String position;
	
	@NotNull
	private int joined;
	
	@NotNull
	@Min(1)
	@Max(6)
	private int contractLength;
	
	@NotNull
	private int contractSigned;
	
	@NotNull
	private int age;
	
	@NotNull
	private float salary;

	public Player() {
		super();
	}

	public Player(@NotNull int squadNumber, @NotNull String name, @NotNull String position, @NotNull int joined,
			@NotNull @Min(1) @Max(6) int contractLength, @NotNull int contractSigned, @NotNull int age,
			@NotNull float salary) {
		super();
		this.squadNumber = squadNumber;
		this.name = name;
		this.position = position;
		this.joined = joined;
		this.contractLength = contractLength;
		this.contractSigned = contractSigned;
		this.age = age;
		this.salary = salary;
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Player [squadNumber=" + squadNumber + ", name=" + name + ", position=" + position + ", joined=" + joined
				+ ", contractLength=" + contractLength + ", contractSigned=" + contractSigned + ", age=" + age
				+ ", salary=" + salary + "]";
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
		result = prime * result + Float.floatToIntBits(salary);
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
		Player other = (Player) obj;
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
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		if (squadNumber != other.squadNumber)
			return false;
		return true;
	}

	
}
