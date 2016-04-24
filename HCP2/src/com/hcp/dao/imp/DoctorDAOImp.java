package com.hcp.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcp.dao.DoctorDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Emr;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Hospital;
import com.hcp.domain.HplPatientMedicineRecord;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientMedicineRecord;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;

@Repository
public class DoctorDAOImp extends HibernateDaoSupport implements DoctorDAO {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public Doctor getDoctorById(Integer doctor_id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(Doctor.class, doctor_id);
	}

	@Override
	public Doctor getDoctorByName(String username) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<DoctorGroup> getDoctorGroup(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNameExist(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Doctor login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean register(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Patient> getPatients(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

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
	public boolean deletePatient(Patient patient) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Hospital getHosptial(Integer doctor_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hospital> getHospitalsList() {
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

	@Override
	public Emr newPatientEmr(Emr emr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkPremission(int doctor_id, int premission_id) {
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
	public boolean updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Medicine> getMediciensList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicine getMedicineById(Integer medicine_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicine getMedicineByName(String medicine_name) {
		// TODO Auto-generated method stub
		return null;
	}

}
