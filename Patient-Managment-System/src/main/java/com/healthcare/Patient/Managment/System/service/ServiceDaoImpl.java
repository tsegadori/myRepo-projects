package com.healthcare.Patient.Managment.System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.healthcare.Patient.Managment.System.configuration.AppUser;
import com.healthcare.Patient.Managment.System.dao.DepartmentDao;
import com.healthcare.Patient.Managment.System.dao.PatientDao;
import com.healthcare.Patient.Managment.System.dao.UserDao;
import com.healthcare.Patient.Managment.System.entity.Department;
import com.healthcare.Patient.Managment.System.entity.OfficeWorkPatientInfoView;
import com.healthcare.Patient.Managment.System.entity.Patient;
import com.healthcare.Patient.Managment.System.entity.PhysiciansPatientInfoView;

@Service
@Transactional
public class ServiceDaoImpl implements ServiceDao {

	@Autowired
	PatientDao patientinfo;
	
	@Autowired
	DepartmentDao deptDao;
	
	@Autowired
	UserDao userDao;
	
	public ServiceDaoImpl() {
		super();
	}

	public PatientDao getPatientinfo() {
		return patientinfo;
	}


	public void setPatientinfo(PatientDao patientinfo) {
		this.patientinfo = patientinfo;
	}


	public DepartmentDao getDeptDao() {
		return deptDao;
	}


	public void setDeptDao(DepartmentDao deptDao) {
		this.deptDao = deptDao;
	}


	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public Patient patientDaoImpl(int ssn) {
		return patientinfo.findPatientBySsn(ssn);
	}

	@Override
	public List<OfficeWorkPatientInfoView> findPatientByInsuranceId(int insuranceId) {
		return patientinfo.findPatientByInsuranceId(insuranceId);
	}

	@Override
	public List<PhysiciansPatientInfoView> hWfindPatientBySSN(int ssn) {
 		return patientinfo.hWfindPatientBySSN(ssn);
	}

	@Override
	public List<Department> listDepartments() {
		return deptDao.listDepartments();
	}

	@Override
	public Department findDepartment(int id) {
		return deptDao.findDepartment(id);
	}

	@Override
	public Department addDepartment(Department department) {
		return deptDao.addDepartment(department);
	}

	@Override
	public void searchAppUser(AppUser newUser, Model newModel) {
		userDao.searchAppUser(newUser, newModel);		
	}

	@Override
	public void updateAppUser(AppUser newUser) {
		userDao.updateAppUser(newUser);		
	}

	@Override
	public void addNewUser(AppUser newUser) {
		userDao.addNewUser(newUser);
		
	}

	@Override
	public String passwordEncoder(String password) {
		return userDao.passwordEncoder(password);
	}

	@Override
	public void addAuthorities(AppUser newUser) {
		  addAuthorities(newUser);
	}

	@Override
	public void findTest(int id) {
		deptDao.findTest(id);		
	}

}
