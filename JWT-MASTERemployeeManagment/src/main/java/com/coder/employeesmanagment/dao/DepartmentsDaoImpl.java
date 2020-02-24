package com.coder.employeesmanagment.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coder.employeesmanagment.entity.Departments;
import com.coder.employeesmanagment.entity.DeptInfo;

@Repository
public class DepartmentsDaoImpl implements DepartmentsDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<DeptInfo> listDepartments() {
		List<DeptInfo> deptInfos = new ArrayList();
		
		Query q = entityManager.createQuery("From Departments d");
		List<Departments> departments = (List<Departments>)q.getResultList();
				
		for (int i=0; i<departments.size(); i++) {
			DeptInfo deptInfo = new DeptInfo();
			deptInfo.setDeptName(departments.get(i).getDeptName());
			
			if(departments.get(i).getDept_Manager().size()>0) {
				deptInfo.setManager(departments.get(i).getDept_Manager().iterator().next().getEmployees().getFirstName());
				deptInfos.add(deptInfo);
			}
			else {
				deptInfo.setManager("No Manager information!");
				deptInfos.add(deptInfo);
			}
			
		}	
		return deptInfos;
	}
}
