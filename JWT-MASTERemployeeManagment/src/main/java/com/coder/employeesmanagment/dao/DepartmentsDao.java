package com.coder.employeesmanagment.dao;

import java.util.List;

import com.coder.employeesmanagment.entity.Departments;
import com.coder.employeesmanagment.entity.DeptInfo;

public interface DepartmentsDao {
	
	List<DeptInfo> listDepartments();
}
