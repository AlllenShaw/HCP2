package com.web.dao;

import java.util.List;

import com.bean.domain.Doctor;
import com.bean.domain.Emr;
import com.bean.domain.GluPatientInfo;
import com.bean.domain.GluPatientMedicineRecord;
import com.bean.domain.GluPatientRecord;
import com.bean.domain.HealthHistory;
import com.bean.domain.Hospital;
import com.bean.domain.HplPatientInfo;
import com.bean.domain.HplPatientMedicineRecord;
import com.bean.domain.HplPatientRecord;
import com.bean.domain.HtnPatientInfo;
import com.bean.domain.HtnPatientMedicineRecord;
import com.bean.domain.HtnPatientRecord;
import com.bean.domain.Medicine;
import com.bean.domain.Patient;
import com.bean.domain.PatientHasDoctor;

/**
 * @author Admin
 * 
 */
public interface DoctorDao {

	/**
	 * check if user name exist
	 * 
	 * @param name
	 * @return exit or not
	 */
	public abstract boolean exisitName(String name);

	public abstract boolean changePassword(String name, String password);

	/**
	 * login
	 * 
	 * @param name
	 * @param password
	 * @return Doctors model
	 */
	public abstract Doctor doctorLogin(String username, String password);

	/**
	 * register
	 * 
	 * @param Doctors
	 *            model
	 * @return successful or not
	 */
	public abstract boolean doctorRegister(Doctor doctor);

	public abstract boolean addPatient(PatientHasDoctor patientHasDoctor);

	/**
	 * get patient list which are belong to the doctor_id
	 * 
	 * @param doctor_id
	 *            int
	 * @return patient list
	 */
	public abstract List<Patient> queryPatient(int doctor_id);

	public abstract List<Patient> searchPatients(int hospital_id, String key);

	public abstract List<Patient> searchPatientByDoctor(int doctor_id,
			String key);

	public abstract Patient getPatientById(int patient_id);

	public abstract HealthHistory getPatinetHealthHistoryById(int patient_id);

	/**
	 * delete the patient
	 * 
	 * @param integer
	 *            doctor_id
	 * @param integer
	 *            patient_id
	 * @return successful or not
	 */
	public abstract boolean deletePatient(PatientHasDoctor patientHasDoctor);

	/**
	 * get hospital which the doctor are belonged to
	 * 
	 * @param doctor_id
	 *            int
	 * @return successful or not
	 */
	public abstract Hospital getHosptial(int doctor_id);

	public abstract List<Hospital> getHospitalsList();

	/**
	 * get hospital list which are collaboration with the hosptial_id
	 * 
	 * @param doctor_id
	 *            integer
	 * @return patient list
	 */
	public abstract List<Hospital> queryHosptial(int hospital_id);

	/**
	 * get patient emr
	 * 
	 * @param doctor_id
	 *            integer
	 * @param patient_id
	 *            integer
	 * @return Emr model
	 */
	public abstract Emr queryEmr(int doctor_id, int patients_id);

	/**
	 * delete emr
	 * 
	 * @param doctor_id
	 *            integer
	 * @param patient_id
	 *            integer
	 * @return successful or not
	 */
	public abstract boolean deleteEmr(Emr emr);

	/**
	 * edit emr
	 * 
	 * @param doctor_id
	 *            integer
	 * @param patient_id
	 *            integer
	 * @param Emr
	 *            model
	 * @return successful or not
	 */
	public abstract boolean editEmr(Emr emr);

	public abstract String getPremissionByUrl(String url);

	public abstract boolean checkPremission(int doctor_id, String premission_id);

	public abstract boolean setHtnPatientInfo(HtnPatientInfo htnPatientInfo);

	public abstract boolean setHplPatientInfo(HplPatientInfo hplPatientInfo);

	public abstract boolean setGluPatientInfo(GluPatientInfo gluPatientInfo);

	public abstract GluPatientInfo getGluPatientInfo(Integer patient_id);

	public abstract HtnPatientInfo getHtnPatientInfo(Integer patient_id);

	public abstract HplPatientInfo getHplPatientInfo(Integer patient_id);

	public abstract List<GluPatientMedicineRecord> getGluPatientMedicineRecord(
			Integer patient_id);

	public abstract List<HtnPatientMedicineRecord> getHtnPatientMedicineRecord(
			Integer patient_id);

	public abstract List<HplPatientMedicineRecord> getHplPatientMedicineRecord(
			Integer patient_id);

	public abstract List<GluPatientRecord> getGluPatientRecords(
			Integer patient_id, Integer count);

	public abstract List<HtnPatientRecord> getHtnPatientRecords(
			Integer patient_id, Integer count);

	public abstract List<HplPatientRecord> getHplPatientRecords(
			Integer patient_id, Integer count);

	public abstract boolean updateDoctor(Doctor doctor);

	boolean addMedicine(Medicine medicine);

	List<Medicine> getMedicine();

	int deleteMedicine(Integer medicine_id);

	Medicine getMedicineById(Integer medicine_id);

	List<Medicine> getMedicine(Integer type);

	List<Integer> getPatientByMedicineId(Integer medicine_id, String type);
}
