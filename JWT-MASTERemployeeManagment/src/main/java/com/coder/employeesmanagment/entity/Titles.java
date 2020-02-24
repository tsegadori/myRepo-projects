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
@Table(name="titles")
public class Titles implements Serializable{
	
	@EmbeddedId
	private TitlesId id;
	@MapsId("empNo") 
	@JoinColumn(name = "emp_no", referencedColumnName = "emp_no")
 	@ManyToOne
	Employees employees;
	@Column(name="title")
	private String title;
	@Column(name="from_date")
	private Date fromDate;
	
	public Titles() {
	}

	public TitlesId getId() {
		return id;
	}

	public void setId(TitlesId id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	
/*
	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	*/
	
}
