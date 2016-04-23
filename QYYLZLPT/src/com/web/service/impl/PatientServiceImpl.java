package com.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.bean.domain.Doctor;
import com.bean.domain.HealthHistory;
import com.bean.domain.Hospital;
import com.bean.domain.HtnPatientInfo;
import com.bean.domain.Patient;
import com.bean.domain.PatientHasDoctor;
import com.bean.domain.PatientHasDoctorId;
import com.web.dao.DoctorDao;
import com.web.dao.PatientDao;
import com.web.service.PatientService;
import com.web.util.JsonDateValueProcessor;

@Service("patientWebService")
public class PatientServiceImpl implements PatientService {
	@Resource(name = "patientDao")
	private PatientDao patientDao;
	@Resource
	private DoctorDao doctorDao;
	private DoctorServiceImpl doctorServiceImpl;

	@Override
	public JSONObject getEmr(Integer patient_id) {
		Patient patient = doctorDao.getPatientById(patient_id);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "healthHistories", "token", "password", "gluPatientRecords", "htnPatientRecords",
				"hplPatientInfos", "gluPatientMedicineRecords", "hplPatientRecords", "hplPatientMedicineRecords",
				"patientHasDoctors", "htnPatientMedicineRecords", "gluPatientInfos", "htnPatientInfos", "emrs" });
		config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());

		JSONObject object = JSONObject.fromObject(patient, config);

		HealthHistory history = doctorDao.getPatinetHealthHistoryById(patient_id);

		if (history != null) {

			object.put("illnessHistory", history.getIllnessHistory());
			object.put("allergicHistory", history.getAllergicHistory());
			object.put("familyMedicalHistory", history.getFamilyMedicalHistory());
		} else {
			object = new JSONObject();
			object.put("illnessHistory", "无");
			object.put("allergicHistory", "无");
			object.put("familyMedicalHistory", "无");
		}
		return object;

	}

	@Override
	public JSONArray getDoctors(Integer hospital_id) {
		List<Doctor> list = patientDao.getDoctors(hospital_id);
		JSONArray doctorArray = new JSONArray();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "hospital", "examinationEmrs", "patientHasDoctors", "emrs", "medicineEmrs",
				"doctorOperPremissions" });
		config.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
		for (Doctor doctor : list) {
			doctorArray.add(doctor, config);
		}
		return doctorArray;
	}

	@Override
	public List<Hospital> getHospitalList() {
		return patientDao.getHospitalList();
	}

	@Override
	public Patient login(String username, String password) {
		return patientDao.patientLogin(username, password);
		// JSONObject patientJsonObject = JSONObject.fromObject(patients);
	}

	@Override
	public boolean patientRegister(Patient patient, Integer doctor_id) {
		Doctor doctor = new Doctor();
		doctor.setId(doctor_id);

		if (patient.getGluState() == null) {
			patient.setGluState(false);
		}
		if (patient.getHtnState() == null) {
			patient.setHtnState(false);
		}
		if (patient.getHplState() == null) {
			patient.setHplState(false);
		}
		PatientHasDoctorId patientHasDoctorId = new PatientHasDoctorId();
		patientHasDoctorId.setPatient(patient);
		patientHasDoctorId.setDoctor(doctor);

		PatientHasDoctor patientHasDoctor = new PatientHasDoctor();
		patientHasDoctor.setId(patientHasDoctorId);

		return patientDao.patientRegister(patient, patientHasDoctor);
	}

	@Override
	public boolean updatePaitent(Patient patient) {

		if (patient.getGluState() == null) {
			patient.setGluState(false);
		}
		if (patient.getHtnState() == null) {
			patient.setHtnState(false);
		}
		if (patient.getHplState() == null) {
			patient.setHplState(false);
		}

		return patientDao.updateInfo(patient);
	}

	@Override
	public Patient getPatientById(int patient_id) {
		return patientDao.getPatinetById(patient_id);
	}

	// 预测
	@Override
	public JSONArray predictHtn(Integer patient_id) {
		return doctorServiceImpl.predictHtn(patient_id);
	}

	@Override
	public JSONArray predictGlu(Integer patient_id) {

		return doctorServiceImpl.predictGlu(patient_id);
	}

	@Override
	public JSONArray predictHpl(Integer patient_id) {

		return doctorServiceImpl.predictHpl(patient_id);
	}

	@Override
	public JSONArray predictEkg(Integer patient_id) {

		return doctorServiceImpl.predictHd(patient_id);
	}

	// 获取慢病信息
	@Override
	public JSONObject getPatientManBingDetails(Integer patient_id) {
		return doctorServiceImpl.getPatientManBingDetails(patient_id);
	}
}