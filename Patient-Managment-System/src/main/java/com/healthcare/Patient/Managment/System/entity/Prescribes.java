package com.healthcare.Patient.Managment.System.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="prescribes")
public class Prescribes {

	@EmbeddedId
	private PrescribesId prescribesId;
	//@MapsId("EmployeeID") 
	@JoinColumn(name = "physicianemployeeid", referencedColumnName = "EmployeeID", insertable=false,  updatable=false) 
 	@ManyToOne(fetch=FetchType.LAZY)
	private Physician physician;
	@MapsId("Patient") 
	@JoinColumn(name = "Patient", referencedColumnName = "SSN")
 	@ManyToOne(fetch=FetchType.EAGER)
	private Patient patient;
	@MapsId("Medication") 
	@JoinColumn(name = "Medication", referencedColumnName = "Codes")
 	@ManyToOne(fetch=FetchType.EAGER)
	private Medication medication;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="AppointmentID", referencedColumnName = "appointmentId")
	private Appointment appointment;
	@Column(name="Dose")
	private String dose;
	
	public Prescribes() {
		super();
	}

	public PrescribesId getPrescribesId() {
		return prescribesId;
	}

	public void setPrescribesId(PrescribesId prescribesId) {
		this.prescribesId = prescribesId;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medication getMedication() {
		return medication;
	}

	public void setMedication(Medication medication) {
		this.medication = medication;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}
}
