package com.healthcare.Patient.Managment.System.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="trained_in")
public class TrainedIn {
	
	@EmbeddedId
	private TrainedInId trainedInId;
	@MapsId("EmployeeID") 
	@JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
 	@ManyToOne(fetch=FetchType.EAGER)
	private Physician physician;
	@MapsId("Treatment") 
	@JoinColumn(name = "Treatment", referencedColumnName = "Codes")
 	@ManyToOne(fetch=FetchType.EAGER)
	private Procedures procedures;
	@Column(name="certificationdate")
	private Timestamp certificationDate;
	@Column(name="certificationexpires")
	private Timestamp certificationExpires;
	
	public TrainedIn() {
		super();
	}

	public TrainedInId getTrainedInId() {
		return trainedInId;
	}

	public void setTrainedInId(TrainedInId trainedInId) {
		this.trainedInId = trainedInId;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Procedures getProcedures() {
		return procedures;
	}

	public void setProcedures(Procedures procedures) {
		this.procedures = procedures;
	}

	public Date getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(Timestamp certificationDate) {
		this.certificationDate = certificationDate;
	}

	public Timestamp getCertificationExpires() {
		return certificationExpires;
	}

	public void setCertificationExpires(Timestamp certificationExpires) {
		this.certificationExpires = certificationExpires;
	}
}
