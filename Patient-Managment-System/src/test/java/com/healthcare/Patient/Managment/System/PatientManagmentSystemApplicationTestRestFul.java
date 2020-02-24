package com.healthcare.Patient.Managment.System;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.Patient.Managment.System.configuration.AppUser;
import com.healthcare.Patient.Managment.System.configuration.Authorities;
import com.healthcare.Patient.Managment.System.configuration.AuthoritiesId;
import com.healthcare.Patient.Managment.System.entity.AffiliatedWith;
import com.healthcare.Patient.Managment.System.entity.AffiliatedWithId;
import com.healthcare.Patient.Managment.System.entity.Appointment;
import com.healthcare.Patient.Managment.System.entity.Block;
import com.healthcare.Patient.Managment.System.entity.BlockId;
import com.healthcare.Patient.Managment.System.entity.Department;
import com.healthcare.Patient.Managment.System.entity.Medication;
import com.healthcare.Patient.Managment.System.entity.Nurse;
import com.healthcare.Patient.Managment.System.entity.OnCall;
import com.healthcare.Patient.Managment.System.entity.OnCallId;
import com.healthcare.Patient.Managment.System.entity.Patient;
import com.healthcare.Patient.Managment.System.entity.Physician;
import com.healthcare.Patient.Managment.System.entity.Prescribes;
import com.healthcare.Patient.Managment.System.entity.PrescribesId;
import com.healthcare.Patient.Managment.System.entity.Procedures;
import com.healthcare.Patient.Managment.System.entity.Room;
import com.healthcare.Patient.Managment.System.entity.Stay;
import com.healthcare.Patient.Managment.System.entity.TrainedIn;
import com.healthcare.Patient.Managment.System.entity.TrainedInId;
import com.healthcare.Patient.Managment.System.entity.Undergoes;
import com.healthcare.Patient.Managment.System.entity.UndergoesId;
import com.healthcare.Patient.Managment.System.service.ServiceDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientManagmentSystemApplicationTestRestFul {

	@Autowired
	EntityManager em;
	
	@Autowired
	ServiceDao serviceDao;
	
	Logger log = LoggerFactory.getLogger(PatientManagmentSystemApplicationTestRestFul.class);
	/*
	@Test
	public void contextLoads() {
		List<Department> dept = new ArrayList<Department>();
				dept = em.createQuery("Select d From Department d", Department.class).getResultList();
		for(Department d : dept) {
				log.info(d.getHead().getName());
		}
	}
	
	@Test
	public void contextLoads2() {
	//List<PhysiciansPatientInfoView> patientInfo = new ArrayList<PhysiciansPatientInfoView>();
			//patientInfo = serviceDao.hWfindPatientBySSN(pp.getPatientSSN());
			for(int i=0; i<serviceDao.hWfindPatientBySSN(100000004).size(); i++) {
				log.info(Integer.toString(serviceDao.hWfindPatientBySSN(100000004).get(i).getId()));
			}
	}
	
	@Test
	public void testAddRestful() {
		Department department = new Department();
		department.setDepartmentId(4);
		department.setName("Dental");
		department.setHead(em.find(Physician.class, 10));
		serviceDao.addDepartment(department);
	}
	*/
	@Test
	@Transactional
	@Rollback(false)
	public void testAddUser() {
	/*	AppUser appUser = new AppUser();
		appUser.setUserName("john");
		String encoded=new BCryptPasswordEncoder().encode("123");
		System.out.println(encoded);
		appUser.setEncrytedPassword(encoded);
		appUser.setEnabled(1);
		em.persist(appUser);  */
		AuthoritiesId authoritiesid = new AuthoritiesId();
		authoritiesid.setUserName("john");
		
		authoritiesid.setAuthorities("ROLE_USER");
	//	authoritiesid.setAuthorities("ROLE_ADMIN");
		Authorities authorities = new Authorities();
		authorities.setAuthoritiesId(authoritiesid);
		em.persist(authorities);
	}
}
