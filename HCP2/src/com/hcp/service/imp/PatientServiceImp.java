package com.hcp.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.PatientDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.Hospital;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.service.PatientService;

@Service("patientService")
public class PatientServiceImp implements PatientService {

	@Resource
	private PatientDAO patientDAO;
	
	@Override
	public Patient login(String username, String password) {
		// TODO Auto-generated method stub
		return patientDAO.login(username, password);
	}

	@Override
	public List<Hospital> getHospitals() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hospital getHospitalByID(String hospital_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientGroup getDefaultGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor getDoctorById(String doctor_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean register(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient getPatientByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient getPatientById(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
