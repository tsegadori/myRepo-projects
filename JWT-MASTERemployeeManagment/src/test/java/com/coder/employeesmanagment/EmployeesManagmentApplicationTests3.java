package com.coder.employeesmanagment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coder.employeesmanagment.entity.Employees;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesManagmentApplicationTests3 {

	@Autowired
	EntityManager em;
	
	@Test
	public void contextLoads() {
		Query q = em.createQuery("From Employees e");
		List<Employees> employees = (List<Employees>)q.getResultList();
		for (Employees e: employees) {
			System.out.println(e.getFirstName());
			System.out.print(" "+e.getTitles().iterator().next().getTitle());
			System.out.println(" "+e.getDept_empl().iterator().next().getDepartments().getDeptName());


		}
	}
}
