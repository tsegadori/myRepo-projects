package com.healthcare.Patient.Managment.System.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

@Embeddable
public class UndergoesId implements Serializable{

	@Column(name="SSN")
	private int patientSSN;
	@Column(name="Codes")
	private int codes;
	@Column(name="StayID")
	private int stayId;
	@Column(name="Date")
	private Timestamp date;
	
	public UndergoesId() {
		super();
	}

	public int getPatientSSN() {
		return patientSSN;
	}

	public void setPatientSSN(int patientSSN) {
		this.patientSSN = patientSSN;
	}

	public int getCodes() {
		return codes;
	}

	public void setCodes(int codes) {
		this.codes = codes;
	}

	public int getStayId() {
		return stayId;
	}

	public void setStayId(int stayId) {
		this.stayId = stayId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp d) {
		this.date = d;
	} 
}
