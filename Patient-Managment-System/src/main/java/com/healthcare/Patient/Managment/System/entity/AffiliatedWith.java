package com.healthcare.Patient.Managment.System.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="AffiliatedWith", schema = "hospitaldb")
public class AffiliatedWith {

	@EmbeddedId
	private AffiliatedWithId affiliatedWithId;
	@MapsId("EmployeeID") 
	@JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
 	@ManyToOne(fetch=FetchType.EAGER)
	private Physician physician;
	@MapsId("DepartmentID") 
	@JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID")
 	@ManyToOne(fetch=FetchType.EAGER)
	private Department department;
	@Column(name="primaryaffiliation")
	private boolean primary_affiliation;
	
	public AffiliatedWith() {
		super();
	}

	public AffiliatedWithId getAffiliatedWithId() {
		return affiliatedWithId;
	}

	public void setAffiliatedWithId(AffiliatedWithId affiliatedWithId) {
		this.affiliatedWithId = affiliatedWithId;
	}

	public Physician getPhysician() {
		return physician;
	}

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public boolean isPrimaryAffiliation() {
		return primary_affiliation;
	}

	public void setPrimaryAffiliation(boolean primaryAffiliation) {
		this.primary_affiliation = primaryAffiliation;
	}
}
