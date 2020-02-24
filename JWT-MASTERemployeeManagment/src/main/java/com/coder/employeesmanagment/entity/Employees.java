package com.coder.employeesmanagment.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="employees")
public class Employees {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_no")
	private int employeeNo;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="gender")
	private String gender;
	@Column(name="birth_date")
	private Date birthDate;
	@Column(name="hire_date")
	private Date hireDate;
	@OneToMany(mappedBy = "employees", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Salaries> salaries = new HashSet<>();
	@OneToMany(mappedBy = "employees", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Titles> titles = new HashSet<>();
	@OneToMany(mappedBy = "employees", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Dept_Empl> dept_empl = new HashSet<>();
	@OneToMany(mappedBy = "employees", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JsonIgnore
	private Set<Dept_Manager> dept_manager = new HashSet<>();
	
	public Employees() {
		super();
	}

	public int getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}

	public Set<Titles> getTitles() {
		return titles;
	}

	public void setTitles(Set<Titles> titles) {
		this.titles = titles;
	}

	public void setSalaries(Set<Salaries> salaries) {
		this.salaries = salaries;
	}

	public void setDept_empl(Set<Dept_Empl> dept_empl) {
		this.dept_empl = dept_empl;
	}

	public void setDept_manager(Set<Dept_Manager> dept_manager) {
		this.dept_manager = dept_manager;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "Employees [employeeNo=" + employeeNo + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", birthDate=" + birthDate + ", hireDate=" + hireDate + "]";
	}

	public Set<Salaries> getSalaries() {
		return salaries;
	}

	public void setSalaries(Salaries salaries) {
		this.salaries.add(salaries);
	}

//	public List<Titles> getTitles() {
//		return titles;
//	}

	public void setTitles(Titles titles) {
//		this.titles.add(titles);
	}

	public Set<Dept_Empl> getDept_empl() {
		return dept_empl;
	}

	public void setDept_empl(Dept_Empl dept_empl) {
		this.dept_empl.add(dept_empl);
	}

	public Set<Dept_Manager> getDept_manager() {
		return dept_manager;
	}

	public void setDept_manager(Dept_Manager dept_manager) {
		this.dept_manager.add(dept_manager);
	}
		
	
}
