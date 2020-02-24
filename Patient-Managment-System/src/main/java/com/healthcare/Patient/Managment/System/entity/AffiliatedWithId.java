package com.healthcare.Patient.Managment.System.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AffiliatedWithId implements Serializable{
	
	@Column(name="EmployeeID")
	private int physician;
	@Column(name="DepartmentID")
	private int department;
	
	public AffiliatedWithId() {
		super();
	}

	public int getPhysician() {
		return physician;
	}

	public void setPhysician(int physician) {
		this.physician = physician;
	}

	public int getDepartment() {
		return department;
	}

	public void setDepartment(int department) {
		this.department = department;
	}
}
