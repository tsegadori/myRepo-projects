package com.coder.employeesmanagment.dao;

import java.util.List;

import com.coder.employeesmanagment.entity.Employees;
import com.coder.employeesmanagment.entity.EmployeesList;

public interface EmployeesDao {

	Employees findEmployee(int Id);
	List<EmployeesList> listEmployees();
}
