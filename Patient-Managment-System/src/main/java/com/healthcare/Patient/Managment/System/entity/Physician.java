package com.healthcare.Patient.Managment.System.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GeneratorType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Physician")
public class Physician {

	@Id
	@Column(name="EmployeeID")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@Column(name="Name")
	private String name;
	@Column(name="Position")
	private String position;
	@Column(name="SSN")
	private int ssn;
	@OneToMany(fetch=FetchType.EAGER, mappedBy="physician")
 	private Set<Patient> patient = new HashSet<Patient>();
	
	public Physician() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public Set<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}
	
}
