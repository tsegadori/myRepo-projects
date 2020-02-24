package com.healthcare.Patient.Managment.System.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

@Embeddable
public class OnCallId implements Serializable{
	
	@Column(name="Nurse_EmployeeID")
	private int nurseEmployeeId;
	@Column(name="Floor")
	private int floor;
	@Column(name="Codes")
	private int codes;
	@Column(name="Start")
	private Timestamp start;
	@Column(name="End")
	private Timestamp end;
	
	public OnCallId() {
		super();
	}

	public int getNurseEmployeeId() {
		return nurseEmployeeId;
	}

	public void setNurseEmployeeId(int nurseEmployeeId) {
		this.nurseEmployeeId = nurseEmployeeId;
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

	public Date getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}
}
