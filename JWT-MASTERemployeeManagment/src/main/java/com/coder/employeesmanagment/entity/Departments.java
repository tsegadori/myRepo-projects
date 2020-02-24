package com.coder.employeesmanagment.entity;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Departments {

	@Id
	@Column(name="dept_no")
	private String dept_no;
	@OneToMany(mappedBy="departments", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Dept_Empl> dept_empl = new HashSet<>();
	@OneToMany(mappedBy="departments", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Set<Dept_Manager> dept_Manager = new HashSet<>();
	@Column(name="dept_name")
	private String deptName;
	
	public Departments() {
	}

	public Set<Dept_Manager> getDept_Manager() {
		return dept_Manager;
	}

	public void setDept_Manager(Set<Dept_Manager> dept_Manager) {
		this.dept_Manager = dept_Manager;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Dept_Empl> getDept_empl() {
		return dept_empl;
	}

	public void setDept_empl(Set<Dept_Empl> dept_empl) {
		this.dept_empl = dept_empl;
	}
}
