package com.coder.employeesmanagment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.coder.employeesmanagment.Service.ServiceDao;
import com.coder.employeesmanagment.entity.Departments;
import com.coder.employeesmanagment.entity.DeptInfo;
import com.coder.employeesmanagment.entity.EmployeesList;

@Controller
public class WebController {

	@Autowired
	ServiceDao serviceDaoImpl;
	
	@RequestMapping("/")
	 public String homePage() {
		 return "home";
	 }
	
	@RequestMapping("/find-employee")
	 public String findEmployeePage() {
		 return "find-employee";
	 }
	
	@RequestMapping("/employees-list")
	 public String listEmployeePage(Model model) {
		List<EmployeesList> empList = serviceDaoImpl.listEmployees();
		model.addAttribute("employeesList", empList);
		 return "employees-list";
	 }
	
	@RequestMapping("/departments-list")
	 public String listDepartments(Model model) {
		List<DeptInfo> departments = new ArrayList();
		departments = serviceDaoImpl.DepartmentsDaoImpl();
		model.addAttribute("departments", departments);
		 return "departments-list";
	 }
	
	@RequestMapping("/employees-page")
	 public String employeesPage() {
		 return "employees-page";
	 }
}
