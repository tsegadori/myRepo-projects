package com.coder.employeesmanagment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coder.employeesmanagment.entity.Employees;
import com.coder.employeesmanagment.entity.EmployeesList;

@Repository
public class EmployeesDaoImpl implements EmployeesDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Employees findEmployee(int id) {
 		return entityManager.find(Employees.class, id); 
	}

	@Override
	public List<EmployeesList> listEmployees() {
		List<EmployeesList>  employeesList= new ArrayList();
		List<Employees> employees = (List<Employees>)entityManager.createQuery("FROM Employees e").getResultList();
		for(int i=0; i<employees.size(); i++) {
			EmployeesList empList = new EmployeesList();
			empList.setEmp_no(employees.get(i).getEmployeeNo());
			empList.setFirstName(employees.get(i).getFirstName());
			empList.setLastName(employees.get(i).getLastName());
			empList.setDeptName(employees.get(i).getDept_empl().iterator().next().getDepartments().getDeptName());
			employeesList.add(empList);
			
		}
		return employeesList;
	}

}
