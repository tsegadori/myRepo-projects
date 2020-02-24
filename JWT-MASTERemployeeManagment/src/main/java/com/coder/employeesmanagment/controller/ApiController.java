package com.coder.employeesmanagment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coder.employeesmanagment.Service.ServiceDao;
import com.coder.employeesmanagment.entity.Employees;

@RestController
public class ApiController {

	@Autowired
	ServiceDao serviceDaoimpl;
	
	@GetMapping(value="/api/employees/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Employees findEmployeePage(@PathVariable("id") int empid) {
		Employees employee = serviceDaoimpl.findEmployeeById(empid);
		return employee; 
	 }
}
