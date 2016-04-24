package com.hcp.dao.imp;

import java.util.List;

import com.hcp.dao.PatientDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.Emr;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.HplPatientMedicineRecord;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientMedicineRecord;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientHasDoctor;

public class PatientDAOImp implements PatientDAO {

	@Override
	public Patient getPatientById(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient getPatientByName(String patient_username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNameExist(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getDoctors(Integer hospital_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean register(Patient patients, PatientHasDoctor patientHasDoctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<GluPatientMedicineRecord> getGluPatientMedicineRecord(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HtnPatientMedicineRecord> getHtnPatientMedicineRecord(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HplPatientMedicineRecord> getHplPatientMedicineRecord(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HdPatientMedicineRecord> getHdPatientMedicineRecord(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GluPatientRecord> getGluPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HtnPatientRecord> getHtnPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HplPatientRecord> getHplPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HdPatientRecord> getHdPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emr> getPatientEmrsList(Integer patient_id, String startTime, String endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Emr getLastEmr(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
