package com.healthcare.Patient.Managment.System;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientManagmentSystemApplicationTests3 {

	@Autowired
	EntityManager em;
	
	@Test
	public void contextLoads() {
		//System.out.println(em.find(Patient.class, 100000002).getPhysician().getName());
		System.out.println(em.find(Physician.class, 2).getName());
 		for(int i=0; i<em.find(Physician.class, 2).getPatient().size(); i++) {
			System.out.println(em.find(Physician.class, 2).getPatient().iterator().next().getName());
		}

	}
}
