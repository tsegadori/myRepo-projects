package com.healthcare.Patient.Managment.System.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PrescribesId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="physicianemployeeid")
	private int physicianId;
	@Column(name="Patient")
	private int patientSSN;
	@Column(name="Medication")
	private int medication;
	@Column(name="Date")
	private Timestamp date;
	
	public PrescribesId() {
		super();
	}

	public int getPhysicianId() {
		return physicianId;
	}

	public void setPhysicianId(int physicianId) {
		this.physicianId = physicianId;
	}

	public int getPatientSSN() {
		return patientSSN;
	}

	public void setPatientSSN(int patientSSN) {
		this.patientSSN = patientSSN;
	}

	public int getMedication() {
		return medication;
	}

	public void setMedication(int medication) {
		this.medication = medication;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
}
