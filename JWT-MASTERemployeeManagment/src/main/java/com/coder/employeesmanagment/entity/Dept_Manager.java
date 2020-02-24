package com.coder.employeesmanagment.entity;

import java.io.Serializable;
import java.sql.Date;

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
@Table(name="dept_manager")
public class Dept_Manager {
	
	@EmbeddedId
	private Dept_ManagerId id;
	@MapsId("emp_no") 
	@JoinColumn(name = "emp_no", referencedColumnName = "emp_no")
 	@ManyToOne(fetch=FetchType.EAGER)
	private Employees employees;
	@MapsId("dept_no") 
	@JoinColumn(name = "dept_no",  referencedColumnName = "dept_no")
	@ManyToOne(fetch=FetchType.EAGER)
	private Departments departments;
	@Column(name="from_date")
	private Date fromDate;
	@Column(name="to_date")
	private Date toDate;
	
	public Dept_Manager() {
	}

	public int getEmplNo() {
		return employees.getEmployeeNo();
	}

	public void setEmplNo(int emplNo) {
		this.employees.setEmployeeNo(emplNo);
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	

	public Dept_ManagerId getId() {
		return id;
	}

	public void setId(Dept_ManagerId id) {
		this.id = id;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

}
