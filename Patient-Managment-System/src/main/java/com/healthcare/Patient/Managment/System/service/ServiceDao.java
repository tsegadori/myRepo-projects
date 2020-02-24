package com.healthcare.Patient.Managment.System.service;

import java.util.List;

import org.springframework.ui.Model;

import com.healthcare.Patient.Managment.System.configuration.AppUser;
import com.healthcare.Patient.Managment.System.entity.Department;
import com.healthcare.Patient.Managment.System.entity.OfficeWorkPatientInfoView;
import com.healthcare.Patient.Managment.System.entity.Patient;
import com.healthcare.Patient.Managment.System.entity.PhysiciansPatientInfoView;

public interface ServiceDao {
	Patient patientDaoImpl(int ssn);
	List<OfficeWorkPatientInfoView> findPatientByInsuranceId(int insuranceId);
	List<PhysiciansPatientInfoView> hWfindPatientBySSN(int ssn);
	List<Department> listDepartments();
	Department findDepartment(int id);
	Department addDepartment(Department department);
	void searchAppUser(AppUser newUser, Model newModel);
	void updateAppUser(AppUser newUser);
	void addNewUser(AppUser newUser);
	String passwordEncoder(String password);
	void addAuthorities(AppUser newUser);
	void findTest(int id);

}
