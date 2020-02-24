package com.coder.employeesmanagment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coder.employeesmanagment.dao.DepartmentsDao;
import com.coder.employeesmanagment.dao.EmployeesDao;
import com.coder.employeesmanagment.dao.EmployeesDaoImpl;
import com.coder.employeesmanagment.entity.Departments;
import com.coder.employeesmanagment.entity.DeptInfo;
import com.coder.employeesmanagment.entity.Employees;
import com.coder.employeesmanagment.entity.EmployeesList;

@Service
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	EmployeesDao empDaoImpl;
	
	@Autowired
	DepartmentsDao dptDaoImpl;
	
	@Override
	public List<DeptInfo> DepartmentsDaoImpl() {
		return dptDaoImpl.listDepartments();
	}

	@Override
	public Employees findEmployeeById(int id) {
		return empDaoImpl.findEmployee(id);
	}

	@Override
	public List<EmployeesList> listEmployees() {
		return empDaoImpl.listEmployees();
	}

}
