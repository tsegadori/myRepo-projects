package com.healthcare.Patient.Managment.System.dao;

import java.util.List;

import com.healthcare.Patient.Managment.System.entity.OfficeWorkPatientInfoView;
import com.healthcare.Patient.Managment.System.entity.Patient;
import com.healthcare.Patient.Managment.System.entity.PhysiciansPatientInfoView;

public interface PatientDao {

	Patient findPatientBySsn(int ssn);
	List<OfficeWorkPatientInfoView> findPatientByInsuranceId(int insuranceId);
	List<PhysiciansPatientInfoView> hWfindPatientBySSN(int ssn);
}
