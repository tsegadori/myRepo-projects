package com.healthcare.Patient.Managment.System.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name="stay")
public class Stay {

	@Id
	@Column(name="StayID")
	private int stayId;
	@ManyToOne
	@JoinColumn(name="SSN", referencedColumnName="SSN")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="Room", referencedColumnName="Numbers")
	private Room room;
	@Column(name="Start")
	private Timestamp start;
	@Column(name="End")
	private Timestamp end;
	
	public Stay() {
		super();
	}

	public int getStayId() {
		return stayId;
	}

	public void setStayId(int stayId) {
		this.stayId = stayId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}
}
