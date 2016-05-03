package com.hcp.service;

import java.sql.Timestamp;
import java.util.List;

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

public interface PatientService {

	public abstract Patient login(String username, String password);

	public abstract List<Hospital> getHospitals();

	public abstract Hospital getHospitalByID(String hospital_id);

	public abstract PatientGroup getDefaultGroup();

	public abstract Doctor getDoctorById(Integer doctor_id);

	public abstract boolean register(Patient patient);

	public abstract Patient getPatientByName(String username);

	public abstract boolean updatePatient(Patient patient);

	public abstract Patient getPatientById(Integer patient_id);

	public abstract List<Doctor> getDoctorList();

	public abstract Medicine getMedicineById(Integer medicine_id);

	public abstract Doctor getDoctorById(String doctor_id);

	public abstract List<Prescription> getPrescriptionByName(String username);

	public abstract List<Doctor> getDoctorListbyName(String username);

	public abstract boolean uploadHdRecord(HdPatientRecord hdPatientRecord);

	public abstract boolean uploadGluRecord(GluPatientRecord gluPatientRecord);

	public abstract boolean uploadHplRecord(HplPatientRecord hplPatientRecord);

	public abstract boolean uploadHtnRecord(HtnPatientRecord htnPatientRecord);

	public abstract List<Timestamp> getAllHdRecordTime(String username);

	public abstract List<HdPatientRecord> getHdPatientRecords(String username, String startTime, String endTime);
}
