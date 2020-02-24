package com.healthcare.Patient.Managment.System.entity;

import javax.persistence.*;

@Entity
@Table(name="room")
public class Room {

	@Id
	@Column(name="Numbers")
	private int number;
	@Column(name="Type_s")
	private String type;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Codes", referencedColumnName="Codes")
	@JoinColumn(name="Floor", referencedColumnName="Floor")
	private Block block;
	@Column(name="Unavailable")
	private boolean unavailable;
	
	public Room() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Block getBlock() {
		return this.block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public boolean isUnavailable() {
		return unavailable;
	}

	public void setUnavailable(boolean unavailable) {
		this.unavailable = unavailable;
	}	
}
