package com.hcp.service;

import java.util.List;

import javax.print.Doc;

import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.GluPatientInfo;
import com.hcp.domain.HdPatientInfo;
import com.hcp.domain.Hospital;
import com.hcp.domain.HplPatientInfo;
import com.hcp.domain.HtnPatientInfo;
import com.hcp.domain.MealTime;
import com.hcp.domain.Medicine;
import com.hcp.domain.MedicineUnit;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;

public interface DoctorService {
	
	
	public abstract Doctor login(String username, String password);

	public abstract List<Hospital> getHospitals();

	public abstract DoctorGroup getDefaultGroup();

	public abstract Hospital getHospitalById(int hospital_id);

	public abstract boolean register(Doctor doctor);

	public abstract Doctor getDoctorById(Integer doctor_id);

	public abstract boolean updateDoctor(Doctor doctor);

	public abstract Patient getPatientByName(String username);

	public abstract boolean isHasPermission(DoctorGroup doctorGroup, PatientGroup patientGroup,int permission_id);

	public abstract boolean isHasPermission(Doctor doctor, Patient patient, int permission_id);

	public abstract boolean hasPatien(Doctor doctor, Patient patient);

	public abstract Patient getPatientByID(String id);

	public abstract Patient getPatientByIdNumber(String idNumber);

	public abstract List<Patient> getPatientByDoctor(Doctor doctor);

	public abstract boolean updatePatient(Patient patient);

	public abstract List<MedicineUnit> getmedicineUnitList();

	public abstract List<MealTime> getMealTimeList();

	public abstract List<Medicine> getMedicineList();
	
}
