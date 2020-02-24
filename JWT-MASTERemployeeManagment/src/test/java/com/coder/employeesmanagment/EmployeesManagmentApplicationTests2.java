package com.coder.employeesmanagment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coder.employeesmanagment.entity.Employees;
import com.coder.employeesmanagment.entity.EmployeesList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesManagmentApplicationTests2 {

	@Autowired
	EntityManager em;
	
	@Test
	public void contextLoads() {
 	}
	
	@Test
	public void emplListTest() {
		List<EmployeesList>  employeesList= new ArrayList();
		List<Employees> employees = (List<Employees>)em.createQuery("FROM Employees e").getResultList();
		for(int i=0; i<employees.size(); i++) {
			EmployeesList empList = new EmployeesList();
			empList.setEmp_no(employees.get(i).getEmployeeNo());
			empList.setFirstName(employees.get(i).getFirstName());
			empList.setLastName(employees.get(i).getLastName());
			empList.setDeptName(employees.get(i).getDept_empl().iterator().next().getDepartments().getDeptName());
			employeesList.add(empList);
		}
	for(int i=0; i<employeesList.size(); i++) {
		System.out.println(employeesList.get(i).getDeptName());
		}
	}
}
