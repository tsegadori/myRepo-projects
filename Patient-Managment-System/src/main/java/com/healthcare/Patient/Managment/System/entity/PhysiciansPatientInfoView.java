package com.healthcare.Patient.Managment.System.entity;

import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name="patient_info_for_pcp")
public class PhysiciansPatientInfoView {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="patient_name")
	private String patientName;
	@Column(name="patient_SSN")
	@Min(value=100000000, message="must be nine digit number")
	@Max(value=999999999, message="must be nine digit number")
	private int patientSSN;
	@Column(name="procedure_name")
	private String procedureName;
	@Column(name="date_undergoes")
	private Timestamp dateUndergoes;
	@Column(name="medication")
	private String medication;
	@Column(name="prescribtion_date")
	private Timestamp prescribtionDate;
	@Column(name="dose")
	private int dose;
	@Column(name="PCP")
	private String pcp;
	
	public PhysiciansPatientInfoView() {
		super();
	}
	
	public void setPatientSSN(int patientSSN) {
		this.patientSSN = patientSSN;
	}


	public int getId() {
		return id;
	}
	public String getPatientName() {
		return patientName;
	}
	public int getPatientSSN() {
		return patientSSN;
	}
	public String getProcedureName() {
		return procedureName;
	}
	public Timestamp getDateUndergoes() {
		return dateUndergoes;
	}
	public String getMedication() {
		return medication;
	}
	public Timestamp getPrescribtionDate() {
		return prescribtionDate;
	}
	public int getDose() {
		return dose;
	}
	public String getPcp() {
		return pcp;
	}
	
	
}
