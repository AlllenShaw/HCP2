package com.hcp.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.hcp.domain.AppVersion;
import com.hcp.domain.BoPatientInfo;
import com.hcp.domain.BoPatientRecord;
import com.hcp.domain.Doctor;
import com.hcp.domain.Family;
import com.hcp.domain.GluPatientInfo;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Hospital;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientInfo;
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

	public abstract boolean uploadBoRecord(BoPatientRecord boPatientRecord);

	public abstract List<Timestamp> getAllHdRecordTime(String username);

	public abstract List<Timestamp> getAllBoRecordTime(String username);

	public abstract List<Timestamp> getAllHtnRecordTime(String username);

	public abstract List<Timestamp> getAllGluRecordTime(String username);

	public abstract List<HdPatientRecord> getHdPatientRecords(String username, String startTime, String endTime);

	public abstract List<BoPatientRecord> getBoPatientRecords(String username, String startTime, String endTime);

	public abstract List<HtnPatientRecord> getHtnPatientRecords(String username, String startTime, String endTime);

	public abstract List<GluPatientRecord> getGluPatientRecords(String username, String startTime, String endTime);

	public abstract boolean register(Patient patient, Family family1, Family family2, PatientHasDoctor patientHasDoctor);

	public abstract AppVersion getAppVersion();

	public abstract Boolean saveChronicInfo(BoPatientInfo boPatientInfo, HtnPatientInfo htnPatientInfo,
			GluPatientInfo gluPatientInfo);

	public abstract List<Doctor> getDoctorByHospital(String hospital_jd);

	public abstract Boolean isExistName(String username);

	public abstract Boolean isExistIdNumber(String idNumber);

}
