package com.healthcare.Patient.Managment.System.entity;

import javax.persistence.*;

@Entity
@Table(name="nurse")
public class Nurse {

	@Id
	@Column(name="NurseID")
	private int nurseId;
	@Column(name="Name")
	private String name;
	@Column(name="Position")
	private String position;
	@Column(name="Registered")
	private Boolean registered;
	@Column(name="SSN")
	private int ssn;
	
	public Nurse() {
	}

	public int getNurseId() {
		return nurseId;
	}

	public void setNurseId(int nurseId) {
		this.nurseId = nurseId;
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

	public Boolean getRegistered() {
		return registered;
	}

	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
}
