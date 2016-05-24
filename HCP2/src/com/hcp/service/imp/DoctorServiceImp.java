package com.hcp.service.imp;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.DoctorDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Emr;
import com.hcp.domain.Hospital;
import com.hcp.domain.MealTime;
import com.hcp.domain.Medicine;
import com.hcp.domain.MedicineUnit;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.service.DoctorService;

@Service("doctorService")
public class DoctorServiceImp implements DoctorService {

	@Resource
	private DoctorDAO doctorDAO;
	
	@Override
	public Doctor login(String username, String password) {
		// TODO Auto-generated method stub
		return doctorDAO.login(username, password);
	}

	@Override
	public List<Hospital> getHospitals() {
		// TODO Auto-generated method stub
		return doctorDAO.getHospitalsList();
	}

	@Override
	public DoctorGroup getDefaultGroup() {
		// TODO Auto-generated method stub
		return doctorDAO.getDefaultDoctorGroup();
	}

	@Override
	public Hospital getHospitalById(int hospital_id) {
		// TODO Auto-generated method stub
		return doctorDAO.getHospitalById(hospital_id);
	}

	@Override
	public boolean register(Doctor doctor) {
		// TODO Auto-generated method stub
		if (doctorDAO.isExist(doctor.getUsername(), doctor.getIdNumber())) {
			System.out.println("Exist!");
			return false;
		}
		return doctorDAO.register(doctor);
	}

	@Override
	public Doctor getDoctorById(Integer doctor_id) {
		// TODO Auto-generated method stub
		return doctorDAO.getDoctorById(doctor_id);
	}

	@Override
	public boolean updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorDAO.updateDoctor(doctor);
	}

	@Override
	public Patient getPatientByName(String username) {
		// TODO Auto-generated method stub
		return doctorDAO.getPatientByName(username);
	}

	
	public boolean isHasPermission(DoctorGroup doctorGroup, PatientGroup patientGroup,int permission_id) {
		// TODO Auto-generated method stub
		return doctorDAO.isHasPermission(doctorGroup,patientGroup,permission_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isHasPermission(Doctor doctor, Patient patient,int permission_id) {
		// TODO Auto-generated method stub
		Set<DoctorGroup> doctorGroups = doctor.getDoctorGroups();
		Set<PatientGroup> patientGroups = patient.getPatientGroups();
		System.out.println(doctorGroups+"  "+patientGroups);
		for (DoctorGroup doctorGroup : doctorGroups) {
			for (PatientGroup patientGroup : patientGroups) {
				if(this.isHasPermission(doctorGroup,patientGroup,permission_id)){
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean hasPatien(Doctor doctor, Patient patient) {
		// TODO Auto-generated method stub
		int doctor_id = doctor.getId();
		int patient_id = patient.getId();
		return doctorDAO.hasPatien(doctor_id,patient_id);
	}

	@Override
	public Patient getPatientByID(String id) {
		System.out.println(id);
		Integer patient_id = Integer.parseInt(id);
		return doctorDAO.getPatientById(patient_id);
	}

	@Override
	public Patient getPatientByIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		return doctorDAO.getPatientByIdNumber(idNumber);
	}

	@Override
	public List<Patient> getPatientByDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorDAO.getPatients(doctor);
	}

	@Override
	public boolean updatePatient(Patient patient) {
		return doctorDAO.updatePatient(patient);
	}

	@Override
	public List<MedicineUnit> getmedicineUnitList() {
		return doctorDAO.getmedicineUnitList();
	}

	@Override
	public List<MealTime> getMealTimeList() {
		return doctorDAO.getMealTimeList();
	}

	@Override
	public List<Medicine> getMedicineList() {
		return doctorDAO.getMedicineList();
	}

	@Override
	public Emr getEmrById(String emr_id) {
		return doctorDAO.getEmrById(emr_id);
	}

	@Override
	public boolean addEmr(Emr emr) {
		return doctorDAO.addEmr(emr);
	}

	@Override
	public Boolean isExistName(String username) {
		return doctorDAO.isExist(username, "");
	}

	@Override
	public Boolean isExistIdNumber(String idNumber) {
		return doctorDAO.isExist("", idNumber);
	}


}
