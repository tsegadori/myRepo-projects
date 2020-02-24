package com.coder.employeesmanagment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class EmployeesList {

	private int emp_no;
	//@Column(name="first_name")
	private String firstName;
	//@Column(name="last_name")
	private String lastName;
	//@Column(name="dept_name")
	private String deptName;
	
	public EmployeesList() {
	}

	public int getEmp_no() {
		return emp_no;
	}


	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}	
}
