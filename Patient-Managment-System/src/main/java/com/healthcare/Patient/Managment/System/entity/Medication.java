package com.healthcare.Patient.Managment.System.entity;

import javax.persistence.*;

@Entity
@Table(name="medication")
public class Medication {

	@Id
	@Column(name="Codes")
	private int code;
	@Column(name="Name")
	private String name;
	@Column(name="Brand")
	private String brand;
	@Column(name="Descriptions")
	private String description;
	
	public Medication() {
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
