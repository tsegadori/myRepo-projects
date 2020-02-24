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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
public class PatientManagmentSystemApplicationTestsWrite {

	@Autowired
	EntityManager em;
	
	@Test
	@Transactional
	//@Rollback(false)
	public void contextLoadsReads() {
		
//<--- Undergoes Entity Test--->		
		UndergoesId uid = new UndergoesId();
		uid.setCodes(4);
		uid.setPatientSSN(100000005);
		uid.setDate(Timestamp.valueOf("2008-04-28 10:00:00"));
		uid.setStayId(3216);
		Undergoes ug = new Undergoes();
		ug.setUndergoesId(uid);
		ug.setPhysician(em.find(Physician.class, 10));
		ug.setNurse(em.find(Nurse.class,102));
		em.persist(ug);
//<--- AffiliatedWith Entity Test--->				
		AffiliatedWith af = new AffiliatedWith();
		AffiliatedWithId afid = new AffiliatedWithId();
		afid.setPhysician(10);
		afid.setDepartment(2);
		af.setAffiliatedWithId(afid);
		af.setPrimaryAffiliation(true);
		em.persist(af);
//<--- Appointment Entity Test--->		
		Appointment ap = new Appointment();
		ap.setAppointmentId(93216549);
		ap.setPatient(em.find(Patient.class,100000003));
		ap.setPhysician(em.find(Physician.class, 10));
		ap.setNurse(em.find(Nurse.class, 103));
		ap.setExaminationRoom("B");
		ap.setStart(Timestamp.valueOf("2008-04-28 10:00:00"));
		ap.setEnd(Timestamp.valueOf("2008-04-28 11:00:00"));
		em.persist(ap);
//<--- Block Entity Test--->				
		Block bk1 = new Block();
		BlockId bi1 = new BlockId();
		bi1.setCodes(1);
		bi1.setFloor(5);
		bk1.setBlockId(bi1);
		em.persist(bk1);
//<--- Department Entity Test--->				
		Department dept = new Department();
		dept.setDepartmentId(4);
		dept.setHead(em.find(Physician.class, 4));
		dept.setName("Gynacology");
		em.persist(dept);
//<--- Medication Entity Test--->		
		Medication med = new Medication();
		med.setBrand("EPharm");
		med.setCode(6);
		med.setDescription("Anti-biotic");
		med.setName("Amoxilin");
		em.persist(med);
//<--- Nurse Entity Test--->	
		Nurse nu = new Nurse();
		nu.setNurseId(104);
		nu.setName(" Zenash Tesema");
		nu.setPosition("Metron");
		nu.setRegistered(true);
		nu.setSsn(333334440);
		em.persist(nu);
//<--- OnCall Entity Test--->				
		OnCallId oid = new OnCallId();
		OnCall oc = new OnCall();
		oid.setCodes(2);
		oid.setEnd(Timestamp.valueOf("2008-11-04 11:00:00"));
		oid.setFloor(1);
		oid.setNurseEmployeeId(102);
		oid.setStart(Timestamp.valueOf("2008-11-04 09:00:00"));
		oc.setOnCallId(oid);
		em.persist(oc);
//<--- Patient Entity Test--->				
		Patient pa = new Patient();
		Physician ph1 = em.find(Physician.class, 10);
		pa.setAddress("45 Washington Blvd");
		pa.setInsuranceId(36546329);
		pa.setName("nike frenzy");
		pa.setPhone("324-4857");
		pa.setPhysician(ph1);
		pa.setSsn(100000005);
		em.persist(pa);
//<--- Physician Entity Test--->		
		Physician ph = new Physician();
		ph.setEmployeeId(11);
		ph.setName("Solomon Tafese");
		ph.setPosition("Internist");
		ph.setSsn(10000002);
		em.persist(ph);
//<--- Prescribes Entity Test--->		
		PrescribesId prscid = new PrescribesId();
		prscid.setPhysicianId(10);
		prscid.setPatientSSN(100000003);
		prscid.setMedication(2);
		prscid.setDate(Timestamp.valueOf("2008-11-04 09:00:00"));
		Prescribes pr = new Prescribes();
		pr.setPrescribesId(prscid);
		pr.setDose("8");
		pr.setAppointment(em.find(Appointment.class, 86213939));
		em.persist(pr);
//<--- Procedures Entity Test--->				
		Procedures proc = new Procedures();
		proc.setCode(8);
		proc.setCost(2500);
		proc.setName("Surgery");
		em.persist(proc);
//<--- Room Entity Test--->				
		Room rm = new Room();
		Block bk = new Block();
		BlockId bi = new BlockId();
		bi.setCodes(1);
		bi.setFloor(5);
		bk.setBlockId(bi);
		rm.setBlock(bk);
		rm.setNumber(424);
		rm.setType("Single");
		rm.setUnavailable(false);
		em.persist(rm);
//<--- Stay Entity Test--->				
		Stay st = new Stay();
		st.setEnd(Timestamp.valueOf("2008-03-19 00:00:00"));
		st.setStart(Timestamp.valueOf("2008-03-14 00:00:00"));
		st.setPatient(em.find(Patient.class, 100000004));
		st.setRoom(em.find(Room.class, 112));
		st.setStayId(3218);
		em.persist(st);
//<--- TrainedIn Entity Test--->	
		TrainedInId trid = new TrainedInId();
		trid.setEmployeeId(10);
		trid.setTreatment(2);
		TrainedIn tr = new TrainedIn();
		tr.setTrainedInId(trid);
		tr.setCertificationDate(Timestamp.valueOf("2008-01-01 00:00:00"));
		tr.setCertificationExpires(Timestamp.valueOf("2008-12-31 00:00:00"));
		em.persist(tr);
	}
	
}
