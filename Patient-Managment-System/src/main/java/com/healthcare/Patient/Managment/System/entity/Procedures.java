package com.healthcare.Patient.Managment.System.entity;

import javax.persistence.*;

@Entity
@Table(name="procedures")
public class Procedures {

	@Id
	@Column(name="Codes")
	private int code;
	@Column(name="Name")
	private String name;
	@Column(name="Cost")
	private int cost;
	
	public Procedures() {
		super();
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
}
