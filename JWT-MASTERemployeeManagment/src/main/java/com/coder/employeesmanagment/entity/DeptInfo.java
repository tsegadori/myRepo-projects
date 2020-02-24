package com.coder.employeesmanagment.entity;

import javax.persistence.Entity;


public class DeptInfo {

	private String deptName;
	private String manager;
	
	public DeptInfo() {
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}
}
