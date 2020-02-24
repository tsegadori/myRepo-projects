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
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.healthcare.Patient.Managment.System.entity.AffiliatedWith;
import com.healthcare.Patient.Managment.System.entity.AffiliatedWithId;
import com.healthcare.Patient.Managment.System.entity.Appointment;
import com.healthcare.Patient.Managment.System.entity.Block;
import com.healthcare.Patient.Managment.System.entity.BlockId;
import com.healthcare.Patient.Managment.System.entity.Department;
import com.healthcare.Patient.Managment.System.entity.Medication;
import com.healthcare.Patient.Managment.System.entity.Nurse;
import com.healthcare.Patient.Managment.System.entity.OfficeWorkPatientInfoView;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientManagmentSystemApplicationTestsViews {

	@Autowired
	EntityManager em;
	
	//@Autowired
	Logger log= LoggerFactory.getLogger(PatientManagmentSystemApplicationTestsViews.class);
	
	@Test
	public void contextLoads() {
	/*	List<Integer> i = new ArrayList();
				i = em.createQuery("Select insuranceId From OfficeWorkPatientInfoView"
						+ " Where patient_name='John Smith'").getResultList();
		for(int e : i) {
				System.out.println(e);
				log.info("---> "+e);
		}  
		*/
		//OfficeWorkPatientInfoView o = new OfficeWorkPatientInfoView();
		List<OfficeWorkPatientInfoView> test = 
				em.createQuery("Select u "
						+ "From OfficeWorkPatientInfoView u where u.insuranceId=?1", OfficeWorkPatientInfoView.class)
				.setParameter(1, 68476213).getResultList(); 
		for(int i=0; i<test.size(); i++) {
			log.info("---> "+test.get(i).getAssistingNurse() );
			}
	/*	List<OfficeWorkPatientInfoView> test 
				 = em.createQuery("Select u From OfficeWorkPatientInfoView u", OfficeWorkPatientInfoView.class).getResultList();			;
				
			for(int i=0; i<test.size(); i++) {
			log.info("---> "+test.get(i).getAssistingNurse() );
	}*/
	}
}
