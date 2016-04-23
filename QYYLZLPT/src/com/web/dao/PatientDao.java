package com.web.dao;

import java.util.List;

import com.bean.domain.Doctor;
import com.bean.domain.Emr;
import com.bean.domain.Hospital;
import com.bean.domain.Patient;
import com.bean.domain.PatientHasDoctor;

public interface PatientDao {

	/**
	 * check if user name exist
	 * 
	 * @param name
	 * @return exit or not
	 */
	public abstract boolean exisitName(String name);

	/**
	 * login
	 * 
	 * @param name
	 * @param password
	 * @return Patient model
	 */
	public abstract Patient patientLogin(String name, String password);

	public abstract List<Hospital> getHospitalList();

	public abstract List<Doctor> getDoctors(Integer hospital_id);

	/**
	 * register
	 * 
	 * @param Doctors
	 *            model
	 * @return successful or not
	 */
	public abstract boolean patientRegister(Patient patients,
			PatientHasDoctor patientHasDoctor);

	/**
	 * get patient emr
	 * 
	 * @param patient_id
	 *            integer
	 * @return Emr list
	 */
	public abstract List<Emr> queryEmr(int patient_id, String startTime,
			String endTime, int pageIndex, int pageSize);

	public boolean updateInfo(Patient patient);

	Patient getPatinetById(int patient_id);

}
