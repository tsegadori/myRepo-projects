package com.healthcare.Patient.Managment.System.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TrainedInId implements Serializable{
	
	@Column(name="EmployeeID")
	private int employeeId;
	@Column(name="Treatment")
	private int treatment;
	
	public TrainedInId() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getTreatment() {
		return treatment;
	}

	public void setTreatment(int treatment) {
		this.treatment = treatment;
	}
}
