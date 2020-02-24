package com.coder.employeesmanagment.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="dept_emp")
public class Dept_Empl {

	@EmbeddedId
	private DepartmentEmployeesId departmentEmplId;
 	@ManyToOne	
	@MapsId("emp_no")
	@JoinColumn(name="emp_no")
	private Employees employees;
	@ManyToOne
	@MapsId("dept_no")
	@JoinColumn(name="dept_no")
	private Departments departments;
	@Column(name="from_date")
	private Date fromDate;
	@Column(name="to_date")
	private Date toDate;
	
	public Dept_Empl() {
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

	public DepartmentEmployeesId getDepartmentEmplId() {
		return departmentEmplId;
	}

	public void setDepartmentEmplId(DepartmentEmployeesId departmentEmplId) {
		this.departmentEmplId = departmentEmplId;
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
