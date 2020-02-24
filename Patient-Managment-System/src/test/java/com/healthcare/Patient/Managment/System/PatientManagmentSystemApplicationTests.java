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
public class PatientManagmentSystemApplicationTests {

	@Autowired
	EntityManager em;
	/*
	@Test
	public void contextLoads() {
		List<Integer> i = new ArrayList();
				i = em.createQuery("Select floor From Block b Where Codes=1").getResultList();
		for(int e : i) {
				System.out.println(e);
		}
	}
	*/
	@Test
	public void contextLoadsReads() {
		UndergoesId newId = new UndergoesId();
		String str="2008-05-13 00:00:00";
		Timestamp date=Timestamp.valueOf(str);
//<--- Undergoes Entity Test--->		
		newId.setCodes(4);
		newId.setDate(date);
		newId.setPatientSSN(100000004);
		newId.setStayId(3217);
		System.out.println(em.find(Undergoes.class, newId).getNurse().getName());
		System.out.println(em.find(Undergoes.class, newId).getPhysician().getName());
//<--- AffiliatedWith Entity Test--->				
		AffiliatedWithId afId = new AffiliatedWithId();
		afId.setPhysician(2);
		afId.setDepartment(1);
		System.out.println(em.find(AffiliatedWith.class, afId).getDepartment().getName());
//<--- Appointment Entity Test--->		
		System.out.println(em.find(Appointment.class, 36549879).getExaminationRoom());
//<--- Block Entity Test--->				
		BlockId bid = new BlockId();
		bid.setCodes(1);
		bid.setFloor(1);
		System.out.println(em.find(Block.class, bid).getBlockId().getFloor());
//<--- Department Entity Test--->				
		System.out.println(em.find(Department.class, 3).getName());
//<--- Medication Entity Test--->		
		System.out.println(em.find(Medication.class, 2).getName());
//<--- Nurse Entity Test--->	
		System.out.println(em.find(Nurse.class, 102).getSsn());
//<--- OnCall Entity Test--->				
		OnCallId oi = new OnCallId();
		oi.setCodes(2);
		oi.setFloor(1);
		oi.setStart(Timestamp.valueOf("2008-11-04 11:00:00"));
		oi.setEnd(Timestamp.valueOf("2008-11-04 19:00:00"));
		oi.setNurseEmployeeId(101);
		System.out.println(em.find(OnCall.class, oi).getOnCallId().getNurseEmployeeId());
//<--- Patient Entity Test--->				
		System.out.println(em.find(Patient.class, 100000002).getAddress());
//<--- Physician Entity Test--->		
		System.out.println(em.find(Physician.class, 2).getName());
//<--- Prescribes Entity Test--->		
		PrescribesId pid = new PrescribesId();
		pid.setDate(Timestamp.valueOf("2008-04-27 10:53:00"));
		pid.setMedication(2);
		pid.setPatientSSN(100000004);
		pid.setPhysicianId(9);
		System.out.println(em.find(Prescribes.class, pid).getDose());
		System.out.println(em.find(Prescribes.class, pid).getAppointment().getPhysician().getName());
//<--- Procedures Entity Test--->				
		System.out.println(em.find(Procedures.class, 4).getCost());
//<--- Room Entity Test--->				
		System.out.println(em.find(Room.class, 102).getType());
		
//<--- Stay Entity Test--->				
		System.out.println(em.find(Stay.class, 3216).getRoom().getNumber());
//<--- TrainedIn Entity Test--->	
		TrainedInId tid = new TrainedInId();
		tid.setEmployeeId(3);
		tid.setTreatment(6);
		System.out.println(em.find(TrainedIn.class, tid).getCertificationExpires());
//<--- Undergoes Entity Test--->	
		UndergoesId uid = new UndergoesId();
		uid.setCodes(1);
		uid.setDate(Timestamp.valueOf("2008-05-07 00:00:00"));
		uid.setPatientSSN(100000004);
		uid.setStayId(3217);
		System.out.println("Assisting Nurse Name: "+em.find(Undergoes.class, uid).getNurse().getName()
				+", & Physician Name: "+em.find(Undergoes.class, uid).getPhysician().getName());		
	}
	
}
