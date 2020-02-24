package com.healthcare.Patient.Managment.System.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Patient")
public class Patient {

	@Id
	@Column(name="SSN")
	private int ssn;
	@Column(name="Name")
	private String name;
	@Column(name="Address")
	private String address;
	@Column(name="Phone")
	private String phone;
	@Column(name="InsuranceID")
	private int insuranceId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PCP", referencedColumnName="EmployeeID")
 	private Physician physician;
	
	public Patient() {
		super();
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}

		public void setPhysician(Physician physician) {
		this.physician = physician;
	}

		public Physician getPhysician() {
			return physician;
		}
		
}
