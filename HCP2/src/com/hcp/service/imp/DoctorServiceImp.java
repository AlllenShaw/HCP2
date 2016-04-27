package com.hcp.service.imp;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.DoctorDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Hospital;
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
		return null;
	}

	@Override
	public DoctorGroup getDefaultGroup() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hospital getHospitalById(int hospital_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean register(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Doctor getDoctorById(Integer doctor_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient getPatientByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHasPermission(DoctorGroup doctorGroup, PatientGroup patientGroup,int permission_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isHasPermission(Doctor doctor, Patient patient,int permission_id) {
		// TODO Auto-generated method stub
		Set<DoctorGroup> doctorGroups = doctor.getDoctorGroups();
		Set<PatientGroup> patientGroups = patient.getPatientGroups();
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
		return false;
	}

	@Override
	public Patient getPatientByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatientByIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Patient> getPatientByDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

}
