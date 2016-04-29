package com.hcp.service;

import java.util.List;

import com.hcp.domain.Doctor;
import com.hcp.domain.Hospital;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;


public interface PatientService {

	public abstract Patient login(String username, String password);

	public abstract List<Hospital> getHospitals();

	public abstract Hospital getHospitalByID(String hospital_id);

	public abstract PatientGroup getDefaultGroup();

	public abstract Doctor getDoctorById(String doctor_id);

	public abstract boolean register(Patient patient);

	public abstract Patient getPatientByName(String username);

	public abstract boolean updatePatient(Patient patient);

	public abstract Patient getPatientById(Integer patient_id);

	public abstract List<Doctor> getDoctorList();
}
