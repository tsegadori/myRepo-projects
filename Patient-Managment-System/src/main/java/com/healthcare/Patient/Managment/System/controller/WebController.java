package com.healthcare.Patient.Managment.System.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.healthcare.Patient.Managment.System.configuration.AppUser;
import com.healthcare.Patient.Managment.System.configuration.WebUtils;
import com.healthcare.Patient.Managment.System.entity.OfficeWorkPatientInfoView;
import com.healthcare.Patient.Managment.System.entity.PhysiciansPatientInfoView;
import com.healthcare.Patient.Managment.System.service.ServiceDao;

@Controller
 public class WebController {
 	
	@Autowired
 	ServiceDao serviceDao;
	
	@RequestMapping("/pms/searchPatient")
	private String findPatient() {
		return "findPatientPage";
	}
	
	@RequestMapping(value="/pms/PatientPage", method = RequestMethod.GET)
	private String patientSearch(@RequestParam("iid") int iid, Model model) {
		List<OfficeWorkPatientInfoView> patientInfo = new ArrayList<OfficeWorkPatientInfoView>();
		System.out.println(serviceDao.findPatientByInsuranceId(iid).get(0).getPatientName());
		patientInfo = serviceDao.findPatientByInsuranceId(iid);
		model.addAttribute("patient", patientInfo );
		return "PatientPage";
	}
	
	@RequestMapping("/pms/findPatientHealthCare")
	private String findPatientHw(Model model) {
		PhysiciansPatientInfoView pp = new PhysiciansPatientInfoView();
		model.addAttribute("pp", pp);
		return "findPatientHealthCare";
	}
	
	
	
	@RequestMapping("/pms/PatientPageForHealthWorks")
	private String patientSearchHw(@Valid  @ModelAttribute("pp") PhysiciansPatientInfoView pp, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "findPatientHealthCare";
		}
		int ssn = pp.getPatientSSN();
		List<PhysiciansPatientInfoView> patientInfo = new ArrayList<PhysiciansPatientInfoView>();
		patientInfo = serviceDao.hWfindPatientBySSN(ssn);
 		model.addAttribute("patient", patientInfo );
		return "PatientPageForHealthWorks";
	}
 
	@RequestMapping("/pms/officeWorks")
	private String officeWorkPage() {
		return "officeWorks";
	}
	
	@RequestMapping("/pms/physiciansPage")
	private String physiciansPage() {
		return "physiciansPage";
	}
	
	
}
