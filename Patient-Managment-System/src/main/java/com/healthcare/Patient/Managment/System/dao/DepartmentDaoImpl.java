package com.healthcare.Patient.Managment.System.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.Patient.Managment.System.entity.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {

	@Autowired 
	EntityManager em;
	
	
	public DepartmentDaoImpl() {
		super();
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Department> listDepartments() {
		return em.createQuery("Select d From Department d", Department.class).getResultList();
	}

	@Override
	public Department findDepartment(int id) {
		return em.find(Department.class, id);
	}
	@Override
	public void findTest(int id) {
		System.out.println("---->tihs is test<----"+ id);
	}

	@Override
	public Department addDepartment(Department department) {
		em.persist(department);
		return department;
	}

}
