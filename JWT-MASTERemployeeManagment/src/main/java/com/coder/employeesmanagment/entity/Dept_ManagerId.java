package com.coder.employeesmanagment.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Dept_ManagerId implements Serializable{

	@Column(name="emp_no")
	private int emp_no;
	@Column(name="dept_no")
	private String dept_no;
	
	
	public Dept_ManagerId() {
	}
	
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public String getDept_no() {
		return dept_no;
	}
	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}
}
