package com.healthcare.Patient.Managment.System.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.Patient.Managment.System.entity.OfficeWorkPatientInfoView;
import com.healthcare.Patient.Managment.System.entity.Patient;
import com.healthcare.Patient.Managment.System.entity.PhysiciansPatientInfoView;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	EntityManager em;
	
	@Override
	public Patient findPatientBySsn(int ssn) {
		return em.find(Patient.class, ssn);		 
	}

	@Override
	public List<OfficeWorkPatientInfoView> findPatientByInsuranceId(int insuranceId) {
		List<OfficeWorkPatientInfoView> patient = new ArrayList();
				patient = em.createQuery("Select u "
						+ "From OfficeWorkPatientInfoView u where u.insuranceId=?1", OfficeWorkPatientInfoView.class)
				.setParameter(1, insuranceId).getResultList(); 
		return patient;
	}

	@Override
	public List<PhysiciansPatientInfoView> hWfindPatientBySSN(int ssn) {
		List<PhysiciansPatientInfoView> patient = new ArrayList();
		patient = em.createQuery("Select u "
				+ "From PhysiciansPatientInfoView u where u.patientSSN=?1", PhysiciansPatientInfoView.class)
		.setParameter(1, ssn).getResultList(); 
		return patient;	
	}

}
