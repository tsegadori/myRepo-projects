package com.coder.employeesmanagment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.coder.employeesmanagment.entity.Departments;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesManagmentApplicationTests4 {

	@Autowired
	EntityManager em;
	
	@Test
	public void contextLoads() {
		Query q = em.createQuery("From Departments d");
		List<Departments> departments = (List<Departments>)q.getResultList();
	
		for (Departments e: departments) {
			
			System.out.print(e.getDeptName());
			
			if(e.getDept_Manager().size()>0) {
				System.out.print(",  "+e.getDept_Manager().iterator().next().getEmployees().getFirstName());
				System.out.println();
			}
			else {
				System.out.print(",  "+"No Manager information!");
				System.out.println();
			}
		}
	}
}
