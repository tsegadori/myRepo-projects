package com.healthcare.Patient.Managment.System.dao;

import java.util.List;

import com.healthcare.Patient.Managment.System.entity.Department;

public interface DepartmentDao {

	List<Department> listDepartments();
	Department findDepartment(int id);
	Department addDepartment(Department department);
	void findTest(int id);
}
