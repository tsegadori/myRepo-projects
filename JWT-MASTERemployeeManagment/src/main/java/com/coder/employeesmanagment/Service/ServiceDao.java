package com.coder.employeesmanagment.Service;

import java.util.List;

import com.coder.employeesmanagment.entity.Departments;
import com.coder.employeesmanagment.entity.DeptInfo;
import com.coder.employeesmanagment.entity.Employees;
import com.coder.employeesmanagment.entity.EmployeesList;

public interface ServiceDao {

	List<DeptInfo> DepartmentsDaoImpl();
	Employees findEmployeeById(int id);
	List<EmployeesList> listEmployees();
}
