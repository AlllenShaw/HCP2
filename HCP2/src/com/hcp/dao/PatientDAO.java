package com.hcp.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.hcp.domain.AppVersion;
import com.hcp.domain.BoPatientInfo;
import com.hcp.domain.BoPatientRecord;
import com.hcp.domain.Doctor;
import com.hcp.domain.Emr;
import com.hcp.domain.Family;
import com.hcp.domain.GluPatientInfo;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Hospital;
import com.hcp.domain.HplPatientMedicineRecord;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientInfo;
import com.hcp.domain.HtnPatientMedicineRecord;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.PatientHasDoctor;
import com.hcp.domain.Prescription;

public interface PatientDAO {

	public abstract Patient getPatientById(Integer patient_id);

	public abstract Patient getPatientByName(String patient_username);

	public abstract boolean isExist(String username, String idNumber);

	public abstract Patient login(String username, String password);

	public abstract List<Doctor> getDoctors(Integer hospital_id);

	public abstract boolean register(Patient patients);

	public abstract boolean updatePatient(Patient patient);

	public abstract List<GluPatientMedicineRecord> getGluPatientMedicineRecord(Integer patient_id);

	public abstract List<HtnPatientMedicineRecord> getHtnPatientMedicineRecord(Integer patient_id);

	public abstract List<HplPatientMedicineRecord> getHplPatientMedicineRecord(Integer patient_id);

	public abstract List<HdPatientMedicineRecord> getHdPatientMedicineRecord(Integer patient_id);

	public abstract List<GluPatientRecord> getGluPatientRecords(Integer patient_id, Integer count);

	public abstract List<HtnPatientRecord> getHtnPatientRecords(Integer patient_id, Integer count);

	public abstract List<HplPatientRecord> getHplPatientRecords(Integer patient_id, Integer count);

	public abstract List<HdPatientRecord> getHdPatientRecords(Integer patient_id, Integer count);

	public abstract boolean saveGluPatientRecords(GluPatientRecord gluPatientRecord);

	public abstract boolean saveHtnPatientRecord(HtnPatientRecord htnPatientRecord);

	public abstract boolean saveHplPatientRecord(HplPatientRecord hplPatientRecord);

	public abstract boolean saveHdPatientRecord(HdPatientRecord hdPatientRecord);

	public abstract boolean saveBoPatientRecord(BoPatientRecord boPatientRecord);

	public abstract List<Emr> getPatientEmrsList(Integer patient_id, String startTime, String endTime);

	public abstract Emr getLastEmr(Integer patient_id);

	public abstract List<Hospital> getHospitals();

	public abstract Hospital getHospitalByID(Integer id);

	public abstract PatientGroup getDefaultGroup();

	public abstract Doctor getDoctorById(Integer id);

	public abstract List<Doctor> getDoctorsList();

	public abstract Medicine getMedicineById(Integer medicine_id);

	public abstract List<Prescription> getPrescriptionByName(String username);

	public abstract List<Doctor> getDoctorListByPatientId(int id);

	public abstract List<Timestamp> getAllHdRecordTime(String username);

	public abstract List<Timestamp> getAllBoRecordTime(String username);

	public abstract List<Timestamp> getAllHtnRecordTime(String username);
	
	public abstract List<Timestamp> getAllGluRecordTime(String username);

	public abstract List<HdPatientRecord> getHdPatientRecordsByTime(String username, Timestamp startTime, Timestamp endTime);

	public abstract List<BoPatientRecord> getBoPatientRecordsByTime(String username, Timestamp sTime, Timestamp eTime);

	public abstract List<HtnPatientRecord> getHtnPatientRecordsByTime(String username, Timestamp sTime, Timestamp eTime);

	public abstract List<GluPatientRecord> getGluPatientRecordsByTime(String username, Timestamp sTime, Timestamp eTime);
	
	public abstract boolean register(Patient patient, Family family1, Family family2, PatientHasDoctor patientHasDoctor);

	public abstract AppVersion getAppVersion();

	public abstract boolean saveBoPatientInfo(BoPatientInfo boPatientInfo);

	public abstract boolean saveGluPatientInfo(GluPatientInfo gluPatientInfo);

	public abstract boolean saveHtnPatientInfo(HtnPatientInfo htnPatientInfo);

	public abstract List<Doctor> getDoctorByHospital(String hospital_jd);


	

}
