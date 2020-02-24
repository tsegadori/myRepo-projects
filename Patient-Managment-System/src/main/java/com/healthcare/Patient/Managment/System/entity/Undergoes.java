package com.healthcare.Patient.Managment.System.entity;

import javax.persistence.*;

@Entity
@Table(name="undergoes")
public class Undergoes {

	@EmbeddedId
	private UndergoesId undergoesId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Physician_EmployeeID", referencedColumnName="EmployeeID")
	private Physician physician;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="AssistingNurse", referencedColumnName="NurseID")
	private Nurse nurse;
	
	public Undergoes() {
		super();
	}

	public UndergoesId getUndergoesId() {
		return undergoesId;
	}

	public void setUndergoesId(UndergoesId undergoesId) {
		this.undergoesId = undergoesId;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	@Override
	public String toString() {
		return "Undergoes [undergoesId=" + undergoesId + ", physician=" + physician + ", assistingNurse="
				+ nurse + "]";
	}
	
	
}
