package com.hcp.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcp.domain.Patient;
import com.hcp.service.PatientService;

@Controller
@RequestMapping("/mobile")
public class MobileController {

	@Resource
	private PatientService patientService;

	@RequestMapping("/login")
	public String login(String username, String password) {
		int state = 0;
		Patient patient = patientService.login(username, password);
		if (patient == null) {
			state = 1;
		}
		return null;
	}

	public String register() {
		return null;
	}

	public String getGluPatinentInfo() {
		return null;
	}

	public String getGluPatientMedicineRecord() {
		return null;
	}

	public String getGluPatientRecord() {
		return null;
	}

	public String getHdPatinentInfo() {
		return null;
	}

	public String getHdPatientMedicineRecord() {
		return null;
	}

	public String getHdPatientRecord() {
		return null;
	}

	public String getHplPatientInfo() {
		return null;
	}

	public String getHplPatientMedicineRecord() {
		return null;
	}

	public String getHplPatientRecord() {
		return null;
	}

	public String getHtnPatientInfo() {
		return null;
	}

	public String getHtnPatientMedicineRecord() {
		return null;
	}

	public String getHtnPatientRecord() {
		return null;
	}

	public String getDoctorList() {
		return null;
	}

	public String getPatientInfo() {
		return null;
	}

	public String updatePatientInfo() {
		return null;
	}

	public String forgetPassword() {
		return null;
	}

	public String getDoctorInfo() {
		return null;
	}

	public String getHospitals() {
		return null;
	}

	public String getMedicineById() {
		return null;
	}

	public String getPrescription() {
		return null;
	}
}
