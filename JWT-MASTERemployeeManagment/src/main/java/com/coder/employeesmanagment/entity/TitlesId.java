package com.coder.employeesmanagment.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Embeddable
public class TitlesId implements Serializable{
	
    @Column(name="emp_no")
    int empNo;
    @Column(name="to_date")
    Date toDate;
	
	
	public TitlesId() {
	}
	
	public void setEmployees(int employees) {
		this.empNo = employees;
	}

	public int getEmployees() {
		return empNo;
	}
	public void setEmp_no(int employees) {
		this.empNo = employees;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	/*
	int emp_no;
	Date toDate;
	
	public int getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	 public int hashCode() {
	        return (int) toDate.hashCode() + employees;
	    }

	    public boolean equals(Object obj) {
	        if (obj == this) return true;
	        if (!(obj instanceof TitlesId)) return false;
	        if (obj == null) return false;
	        TitlesId pk = (TitlesId) obj;
	        return pk.emp_no == emp_no && pk.toDate.equals(toDate);
	    }
	    */
}
