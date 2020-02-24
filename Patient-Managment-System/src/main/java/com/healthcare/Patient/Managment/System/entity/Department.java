package com.healthcare.Patient.Managment.System.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name="DepartmentID")
	private int departmentId;
	@Column(name="Name")
	private String name;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Head", referencedColumnName="EmployeeID")
	private Physician head;
		
	public Department() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Physician getHead() {
		return head;
	}

	public void setHead(Physician head) {
		this.head = head;
	}
}
