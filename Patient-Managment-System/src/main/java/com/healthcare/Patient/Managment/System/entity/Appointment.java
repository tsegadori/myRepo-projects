package com.healthcare.Patient.Managment.System.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@Column(name="AppointmentID")
	private int appointmentId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Patient", referencedColumnName="SSN")
	private Patient patient;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="prepnurse", referencedColumnName="NurseID")
	private Nurse nurse;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="physician_employeeid", referencedColumnName="EmployeeID")
	private Physician physician;
	@Column(name="Start")
	private Date start;
	@Column(name="End")
	private Date end;
	@Column(name="examinationroom")
	private String examinationRoom;
	
	public Appointment() {
		super();
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getExaminationRoom() {
		return examinationRoom;
	}

	public void setExaminationRoom(String examinationRoom) {
		this.examinationRoom = examinationRoom;
	}
}
