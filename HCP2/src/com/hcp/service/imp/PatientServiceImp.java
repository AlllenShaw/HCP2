package com.hcp.service.imp;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.PatientDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Hospital;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.PatientHasDoctor;
import com.hcp.domain.Prescription;
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
		return patientDAO.getHospitals();
	}

	@Override
	public Hospital getHospitalByID(String hospital_id) {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(hospital_id);
		return patientDAO.getHospitalByID(id);
	}

	@Override
	public PatientGroup getDefaultGroup() {
		// TODO Auto-generated method stub
		return patientDAO.getDefaultGroup();
	}

	@Override
	public Doctor getDoctorById(String doctor_id) {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(doctor_id);
		return patientDAO.getDoctorById(id);
	}

	@Override
	public boolean register(Patient patient) {
		// TODO Auto-generated method stub
		System.out.println("patientService register");
		if (patientDAO.isExist(patient.getUsername(), patient.getIdNumber(), patient.getMail(), patient.getTele())) {
			return false;
		}
		return patientDAO.register(patient);
	}

	@Override
	public Patient getPatientByName(String username) {
		// TODO Auto-generated method stub
		return patientDAO.getPatientByName(username);
	}

	@Override
	public boolean updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientDAO.updatePatient(patient);
	}

	@Override
	public Patient getPatientById(Integer patient_id) {
		// TODO Auto-generated method stub
		return patientDAO.getPatientById(patient_id);
	}

	@Override
	public Doctor getDoctorById(Integer doctor_id) {
		// TODO Auto-generated method stub
		return patientDAO.getDoctorById(doctor_id);
	}

	@Override
	public List<Doctor> getDoctorList() {
		// TODO Auto-generated method stub
		return patientDAO.getDoctorsList();
	}

	@Override
	public Medicine getMedicineById(Integer medicine_id) {
		// TODO Auto-generated method stub
		return patientDAO.getMedicineById(medicine_id);
	}

	@Override
	public List<Prescription> getPrescriptionByName(String username) {
		// TODO Auto-generated method stub
		return patientDAO.getPrescriptionByName(username);
	}

	@Override
	public List<Doctor> getDoctorListbyName(String username) {
		// TODO Auto-generated method stub
		int id = patientDAO.getPatientByName(username).getId();
		return patientDAO.getDoctorListByPatientId(id);
	}

	@Override
	public boolean uploadHdRecord(HdPatientRecord hdPatientRecord) {
		// TODO Auto-generated method stub
		return patientDAO.saveHdPatientRecord(hdPatientRecord);
	}

	@Override
	public boolean uploadGluRecord(GluPatientRecord gluPatientRecord) {
		// TODO Auto-generated method stub
		return patientDAO.saveGluPatientRecords(gluPatientRecord);
	}

	@Override
	public boolean uploadHplRecord(HplPatientRecord hplPatientRecord) {
		// TODO Auto-generated method stub
		return patientDAO.saveHplPatientRecord(hplPatientRecord);
	}

	@Override
	public boolean uploadHtnRecord(HtnPatientRecord htnPatientRecord) {
		// TODO Auto-generated method stub
		return patientDAO.saveHtnPatientRecord(htnPatientRecord);
	}

	@Override
	public List<Timestamp> getAllHdRecordTime(String username) {
		// TODO Auto-generated method stub
		return patientDAO.getAllHdRecordTime(username);
	}

	@Override
	public List<HdPatientRecord> getHdPatientRecords(String username, String startTime, String endTime) {
		// TODO Auto-generated method stub
		Timestamp sTime = Timestamp.valueOf(startTime);
		Timestamp eTime = Timestamp.valueOf(endTime);
		return patientDAO.getHdPatientRecordsByTime(username, sTime, eTime);
	}

}
