package com.hcp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcp.domain.Doctor;
import com.hcp.domain.GluPatientInfo;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientInfo;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Patient;
import com.hcp.mobilePOJO.SimpleDoctor;
import com.hcp.mobilePOJO.SimplePatient;
import com.hcp.service.PatientService;

@Controller
@RequestMapping("/mobile")
public class MobileController {

	@Resource
	private PatientService patientService;

	@RequestMapping("/login")
	public String login(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		System.out.println(username + " " + password);
		Patient patient = patientService.login(username, password);
		if (patient == null) {
			state = 0;
			error = 1;
		}
		map.put("state", state);
		// map.put("patient", patient);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/register")
	public String register(String account, String password, String name, int sex, String birthday, String idNumber, String phone,
			String answer1, String answer2, String answer3) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		String gender = "male";
		Patient patient = new Patient(account, idNumber, password);
		if (sex == 0) {
			gender = "female";
		}
		patient.setGender(gender);
		patient.setTele(phone);
		patient.setAnswer1(answer1);
		patient.setAnswer2(answer2);
		patient.setAnswer3(answer3);
		if (patientService.register(patient)) {
		} else {
			state = 0;
			error = 2;
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getGluPatinentInfo")
	public String getGluPatinentInfo(Integer patient_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		Set<GluPatientInfo> set = null;
		Patient patient = patientService.getPatientById(patient_id);
		if (patient != null) {
			set = patient.getGluPatientInfos();
		} else {
			state = 0;
			error = 3;
		}
		map.put("state", state);
		map.put("set", set);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getGluPatientMedicineRecord")
	public String getGluPatientMedicineRecord(Integer patient_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		Set<GluPatientMedicineRecord> set = null;
		Patient patient = patientService.getPatientById(patient_id);
		if (patient != null) {
			set = patient.getGluPatientMedicineRecords();
		} else {
			state = 0;
			error = 4;
		}
		map.put("state", state);
		map.put("set", set);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getGluPatientRecord")
	public String getGluPatientRecord(Integer patient_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		Set<GluPatientRecord> set = null;
		Patient patient = patientService.getPatientById(patient_id);
		if (patient != null) {
			set = patient.getGluPatientRecords();
		} else {
			state = 0;
			error = 5;
		}
		map.put("state", state);
		map.put("set", set);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getHdPatientInfo")
	public String getHdPatientInfo(Integer patient_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		Set<HdPatientInfo> set = null;
		Patient patient = patientService.getPatientById(patient_id);
		if (patient != null) {
			set = patient.getHdPatientInfos();
		} else {
			state = 0;
			error = 3;
		}
		map.put("state", state);
		map.put("set", set);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getHdPatientMedicineRecord")
	public String getHdPatientMedicineRecord(Integer patient_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		Set<HdPatientMedicineRecord> set = null;
		Patient patient = patientService.getPatientById(patient_id);
		if (patient != null) {
			set = patient.getGluPatientMedicineRecords();
		} else {
			state = 0;
			error = 4;
		}
		map.put("state", state);
		map.put("set", set);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getHdPatientRecord")
	public String getHdPatientRecord(Integer patient_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		Set<HdPatientRecord> set = null;
		Patient patient = patientService.getPatientById(patient_id);
		if (patient != null) {
			set = patient.getHdPatientRecords();
		} else {
			state = 0;
			error = 5;
		}
		map.put("state", state);
		map.put("set", set);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	// @RequestMapping("/getHplPatientInfo")
	// public String getHplPatientInfo(Integer patient_id) {
	// return null;
	// }
	//
	// public String getHplPatientMedicineRecord(Integer patient_id) {
	// return null;
	// }
	//
	// public String getHplPatientRecord(Integer patient_id) {
	// return null;
	// }
	//
	// public String getHtnPatientInfo(Integer patient_id) {
	// return null;
	// }
	//
	// public String getHtnPatientMedicineRecord(Integer patient_id) {
	// return null;
	// }
	//
	// public String getHtnPatientRecord(Integer patient_id) {
	// return null;
	// }

	@RequestMapping("/getDoctorList")
	public String getDoctorList() {
		// TODO
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		List<SimpleDoctor> list = new ArrayList<SimpleDoctor>();
		List<Doctor> doctors = patientService.getDoctorList();
		if (list != null) {
			for (Doctor doctor : doctors) {
				SimpleDoctor simpleDoctor = new SimpleDoctor(doctor.getId(), doctor.getRealname(), doctor.getProfession(), doctor
						.getHospital().getName());
				list.add(simpleDoctor);
			}
		} else {
			state = 0;
			error = 6;
		}
		map.put("state", state);
		map.put("list", list);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/getPatientInfo")
	public String getPatientInfo(Integer patient_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		SimplePatient simplePatient = null;
		Patient patient = patientService.getPatientById(patient_id);
		if (patient != null) {
			int sex = 0;
			if (patient.getGender().equals("male")) {
				sex = 1;
			}
			simplePatient = new SimplePatient(patient.getUsername(), patient.getRealname(), patient.getIdNumber(), sex,
					patient.getAge(), patient.getTele());
		} else {
			state = 0;
			error = 7;
		}
		map.put("state", state);
		map.put("simplePatient", simplePatient);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	// public String updatePatientInfo(Integer patient_id) {
	// return null;
	// }
	
	@RequestMapping("/changePassword")
	public String changePassword(int type, String username, String answer1, String answer2, String answer3, String oldPassword,
			String newPassword) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		boolean flag = false;
		Patient patient = patientService.getPatientByName(username);
		if (type == 1) {
			// 1是用旧密码
			if (patient.getPassword().equals(oldPassword)) {
				flag = true;
			}else{
				state = 0;
				error = 1;
			}
		} else {
			// 0用是密保问题改
			if ((patient.getAnswer1().equals(answer1)) && (patient.getAnswer2().equals(answer2))
					&& (patient.getAnswer3().equals(answer3))) {
				flag = true;
			}else{
				state = 0;
				error = 8;
			}
		}
		if(flag){
			patient.setPassword(newPassword);
			patientService.updatePatient(patient);
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	
	
	public String getDoctorInfo(Integer doctor_id) {
		return null;
	}

	public String getHospitals() {
		return null;
	}

	public String getMedicineById() {
		return null;
	}

	public String getPrescription() {
		return null;
	}

	public String uploadGluRecord() {
		return null;
	}

	public String uploadHdRecord() {
		return null;
	}

	public String uploadHplRecord() {
		return null;
	}

	public String uploadHtnRecord() {
		return null;
	}
}
