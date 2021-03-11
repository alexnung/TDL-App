package com.qa.tdl.TDLWA.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Player {

	@Column(name = "Squad Number", unique = true)
	@NotNull
	private int Squad_Number;
	
	@NotNull
	private String name;
	
	@NotNull
	private String position;
	
	@NotNull
	private int joined;
	
	@Column(name = "Contract Length")
	@NotNull
	@Min(1)
	@Max(6)
	private int Contract_length;
	
	@Column(name = "Contract Signed")
	@NotNull
	private int Contract_signed;
	
	@NotNull
	private int age;
	
	@NotNull
	private float salary;
}
