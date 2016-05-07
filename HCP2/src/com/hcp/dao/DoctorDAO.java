package com.hcp.dao;

import java.util.List;

import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Emr;
import com.hcp.domain.GluPatientInfo;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientInfo;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Hospital;
import com.hcp.domain.Doctor;
import com.hcp.domain.HplPatientInfo;
import com.hcp.domain.HplPatientMedicineRecord;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientInfo;
import com.hcp.domain.HtnPatientMedicineRecord;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.PatientHasDoctor;

public interface DoctorDAO {

	public abstract Doctor getDoctorById(Integer doctor_id);

	public abstract Doctor getDoctorByName(String username);

	// 获取医生所在用户组
	public abstract List<DoctorGroup> getDoctorGroup(Doctor doctor);

	public abstract boolean isExist(String username,String idNumber);

	public abstract Doctor login(String username, String password);

	public abstract boolean register(Doctor doctor);

	public abstract boolean changePassword(Doctor doctor);

	public abstract boolean addPatient(PatientHasDoctor patientHasDoctor);

	// 获取该医生治疗的所有病人
	public abstract List<Patient> getPatients(Doctor doctor);

	public abstract Patient getPatientById(Integer patient_id);

	public abstract Patient getPatientByName(String patient_username);

	public List<Patient> getPatientByRealName(Doctor doctor, String patient_realname);

	public abstract boolean deletePatient(Patient patient,Doctor doctor);

	public abstract Hospital getHosptial(Integer doctor_id);

	public abstract List<Hospital> getHospitalsList();

	public abstract List<Emr> getPatientEmrsList(Integer patient_id, String startTime, String endTime);

	public abstract Emr getLastEmr(Integer patient_id);

	public abstract boolean newPatientEmr(Emr emr);

	// 检查医生是否有权利进行操作
	public abstract boolean checkPremission(int doctor_id, int premission_id);
	
	public abstract boolean setHtnPatientInfo(HtnPatientInfo htnPatientInfo);

	public abstract boolean setHplPatientInfo(HplPatientInfo hplPatientInfo);

	public abstract boolean setGluPatientInfo(GluPatientInfo gluPatientInfo);
	
	public abstract boolean setHdPatientInfo(HdPatientInfo hdPatientInfo);

	public abstract GluPatientInfo getGluPatientInfo(Integer patient_id);

	public abstract HtnPatientInfo getHtnPatientInfo(Integer patient_id);

	public abstract HplPatientInfo getHplPatientInfo(Integer patient_id);
	
	public abstract HdPatientInfo getHdPatientInfo(Integer patient_id);

	public abstract List<GluPatientMedicineRecord> getGluPatientMedicineRecord(Integer patient_id);

	public abstract List<HtnPatientMedicineRecord> getHtnPatientMedicineRecord(Integer patient_id);

	public abstract List<HplPatientMedicineRecord> getHplPatientMedicineRecord(Integer patient_id);

	public abstract List<HdPatientMedicineRecord> getHdPatientMedicineRecord(Integer patient_id);

	public abstract List<GluPatientRecord> getGluPatientRecords(Integer patient_id, Integer count);

	public abstract List<HtnPatientRecord> getHtnPatientRecords(Integer patient_id, Integer count);

	public abstract List<HplPatientRecord> getHplPatientRecords(Integer patient_id, Integer count);

	public abstract List<HdPatientRecord> getHdPatientRecords(Integer patient_id, Integer count);

	public abstract boolean updateDoctor(Doctor doctor);

	public abstract List<Medicine> getMediciensList();

	public abstract Medicine getMedicineById(Integer medicine_id);

	public abstract List<Medicine> getMedicineByName(String medicine_name);

	public abstract DoctorGroup getDefaultDoctorGroup();

	public abstract Hospital getHospitalById(int hospital_id);

	public abstract boolean isHasPermission(DoctorGroup doctorGroup, PatientGroup patientGroup, int permission_id);

	public abstract boolean hasPatien(int doctor_id, int patient_id);

	public abstract Patient getPatientByIdNumber(String idNumber);

	public abstract boolean updatePatient(Patient patient);

}
