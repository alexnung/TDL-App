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
	private int squad_number;
	
	@NotNull
	private String name;
	
	@NotNull
	private String position;
	
	@NotNull
	private int joined;
	
	@NotNull
	@Min(1)
	@Max(6)
	private int contract_length;
	
	@NotNull
	private int contract_signed;
	
	@NotNull
	private int age;
	
	@NotNull
	private float salary;

	

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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
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
		result = prime * result + Float.floatToIntBits(salary);
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
		Player other = (Player) obj;
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
		if (Float.floatToIntBits(salary) != Float.floatToIntBits(other.salary))
			return false;
		if (squad_number != other.squad_number)
			return false;
		return true;
	}
	
	
}
