package com.healthcare.Patient.Managment.System.entity;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class BlockId implements Serializable{
	
	@Column(name="Floor")
	private int floor;
	@Column(name="Codes")
	private int codes;
	
	public BlockId() {
		super();
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getCodes() {
		return codes;
	}

	public void setCodes(int codes) {
		this.codes = codes;
	}
}
