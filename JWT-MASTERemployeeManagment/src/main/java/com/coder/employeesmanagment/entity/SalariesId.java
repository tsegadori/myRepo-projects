package com.coder.employeesmanagment.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SalariesId implements Serializable{

	@Column(name="emp_no")
    int empNo;
    @Column(name="from_date")
    Date fromDate;
	
    public SalariesId() {
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
}
