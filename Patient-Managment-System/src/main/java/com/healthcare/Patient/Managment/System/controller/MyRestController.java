package com.healthcare.Patient.Managment.System.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.Patient.Managment.System.entity.Department;
import com.healthcare.Patient.Managment.System.service.ServiceDao;



@RestController
public class MyRestController {

	@Autowired
	ServiceDao serviceDao;
	
	@GetMapping("/api/departments")
	@Transactional(propagation=Propagation.NEVER)
	private List<Department> getDepartments(){
		List<Department> departments = new ArrayList<Department>();
		departments = serviceDao.listDepartments();
		
		for(int i=0; i<departments.size(); i++) {
		departments.get(i).getHead().setSsn(00000);
		}
		
		return departments;
	}
	
	@GetMapping("/api/departments/{id}")
	@Transactional(propagation=Propagation.NEVER)
	private Department getDepartment(@PathVariable("id") int id){
		Department department = new Department();
		department = serviceDao.findDepartment(id);
		department.getHead().setSsn(0);
		return department;
	}
	
	@PostMapping("/api/departments")
	private Department postDepartment(@RequestBody Department department) {
		serviceDao.addDepartment(department);	
		return department;
		
	}
}
