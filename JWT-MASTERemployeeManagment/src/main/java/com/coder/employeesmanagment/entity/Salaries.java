package com.coder.employeesmanagment.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="salaries")
public class Salaries implements Serializable{
	 
	@EmbeddedId
	private SalariesId id;
	@MapsId("empNo") 
	@JoinColumn(name = "emp_no", referencedColumnName = "emp_no")
 	@ManyToOne
	Employees employees;
	@Column(name="salary")
	private double salary;
	@Column(name="to_date")
	private Date toDate;
	
	public Salaries() {
	}

	public SalariesId getId() {
		return id;
	}

	public void setId(SalariesId id) {
		this.id = id;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public int getEmplno() {
		return employees.getEmployeeNo();
	}

	public void setEmplno(int emplno) {
		this.employees.setEmployeeNo(emplno);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
