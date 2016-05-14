package com.hcp.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcp.domain.AppVersion;
import com.hcp.domain.BoPatientInfo;
import com.hcp.domain.BoPatientRecord;
import com.hcp.domain.Doctor;
import com.hcp.domain.Emr;
import com.hcp.domain.GluPatientInfo;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientInfo;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.HplPatientInfo;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientInfo;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
import com.hcp.domain.Prescription;
import com.hcp.mobilePOJO.DoctorInfo;
import com.hcp.mobilePOJO.MedicineDetail;
import com.hcp.mobilePOJO.MedicineInfo;
import com.hcp.mobilePOJO.SimpleDoctor;
import com.hcp.mobilePOJO.SimpleHdRecord;
import com.hcp.mobilePOJO.SimplePatient;
import com.hcp.service.DoctorService;
import com.hcp.service.PatientService;
import com.hcp.util.TimeUtil;

@Controller
@RequestMapping("/mobile")
public class MobileController {

	@Resource
	private PatientService patientService;

	@Resource
	private DoctorService doctorService;

	@RequestMapping("/login")
	@ResponseBody
	public String login(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		System.out.println(username + " " + password);
		Patient patient = patientService.login(username, password);
		if (patient == null) {
			state = 0;
			error = "1";
		}
		System.out.println("------------------------" + patient);
		System.out.println("state: " + state + " error: " + error);
		JSONObject jo = new JSONObject();
		jo.put("state", state);
		jo.put("error", error);
		jo.put("cookie", username);
		// map.put("state", state);
		// map.put("patient", patient);
		// map.put("error", error);
		// JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/register")
	@ResponseBody
	public String register(String account, String password, String name, int sex, String age, String idNumber, String phone,
			String answer1, String answer2, String answer3) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		String gender = "male";
		Patient patient = new Patient(account, idNumber, password);
		if (sex == 0) {
			gender = "female";
		}
		patient.setRealname(name);
		patient.setGender(gender);
		patient.setTele(phone);
		patient.setAge(age);
		patient.setAnswer1(answer1);
		patient.setAnswer2(answer2);
		patient.setAnswer3(answer3);
		if (patientService.register(patient)) {
		} else {
			state = 0;
			error = "2";
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getGluPatinentInfo")
	@ResponseBody
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
	@ResponseBody
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
	@ResponseBody
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
	@ResponseBody
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
	@ResponseBody
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

	@RequestMapping("/getAllHdRecordTime")
	@ResponseBody
	public String getAllHdRecordTime(String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> list = new ArrayList<String>();
		int state = 1;
		String error = "0";
		List<Timestamp> timestamps = patientService.getAllHdRecordTime(username);
		if (timestamps == null) {
			state = 0;
			error = "该用户没有心电数据";
		}
		for (Timestamp timestamp : timestamps) {
			System.out.println(timestamp.toString());
			list.add(timestamp.toString());
		}
		map.put("state", state);
		map.put("list", list);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/getHdPatientRecords")
	@ResponseBody
	public String getHdPatientRecords(String username, String startTime, String endTime) {
		System.out.println("===========================================");
		System.out.println(username + " " + startTime + " " + endTime);
		System.out.println("===========================================");
		Map<String, Object> map = new HashMap<String, Object>();
		List<SimpleHdRecord> list = new ArrayList<SimpleHdRecord>();
		int state = 1;
		String error = "0";
		List<HdPatientRecord> records = patientService.getHdPatientRecords(username, startTime, endTime);
		if (records == null) {
			state = 0;
			error = "该用户没有心电数据记录";
		} else {
			for (HdPatientRecord record : records) {
				SimpleHdRecord sRecord = new SimpleHdRecord(record.getId(), record.getHeartRate(), record.getEcg(), record
						.getMeasureTime().toString(), record.getAnalysis());
				list.add(sRecord);
			}
		}
		map.put("state", state);
		map.put("list", list);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		System.out.println(jo.toString());
		return jo.toString();
	}

	// // /////////////////////////////////////////////////////////////////////////
	// @SuppressWarnings("unchecked")
	// @RequestMapping("/getHdPatientRecord")
	// @ResponseBody
	// public String getHdPatientRecord(Integer patient_id) {
	// Map<String, Object> map = new HashMap<String, Object>();
	// int state = 1;
	// int error = 0;
	// Set<HdPatientRecord> set = null;
	// Patient patient = patientService.getPatientById(patient_id);
	// if (patient != null) {
	// set = patient.getHdPatientRecords();
	// } else {
	// state = 0;
	// error = 5;
	// }
	// map.put("state", state);
	// map.put("set", set);
	// map.put("error", error);
	// JSONObject jo = JSONObject.fromObject(map);
	// return jo.toString();
	// }
	//
	// // //////////////////////////////////////////////////////////////////////////////////////

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

	public String getDoctorList() {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		List<SimpleDoctor> list = new ArrayList<SimpleDoctor>();
		List<Doctor> doctors = patientService.getDoctorList();
		if (doctors != null) {
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

	@RequestMapping("/getDoctorList")
	@ResponseBody
	public String getDoctor(String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		List<SimpleDoctor> list = new ArrayList<SimpleDoctor>();
		List<Doctor> doctors = patientService.getDoctorListbyName(username);
		if (doctors != null) {
			for (Doctor doctor : doctors) {
				SimpleDoctor simpleDoctor = new SimpleDoctor(doctor.getId(), doctor.getRealname(), doctor.getProfession(), doctor
						.getHospital().getName());
				list.add(simpleDoctor);
			}
		} else {
			state = 0;
			error = "该用户暂时没有医生";
		}
		map.put("state", state);
		map.put("list", list);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/getPatientInfo")
	@ResponseBody
	public String getPatientInfo(String username) throws UnsupportedEncodingException {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		SimplePatient simplePatient = null;
		Patient patient = patientService.getPatientByName(username);
		if (patient != null) {
			int sex = 0;
			if (patient.getGender().equals("male")) {
				sex = 1;
			}
			simplePatient = new SimplePatient(patient.getUsername(), patient.getRealname(), patient.getIdNumber(), sex,
					patient.getAge(), patient.getTele());
		} else {
			state = 0;
			error = "7";
		}
		System.out.println("中文名----------------" + simplePatient.getName());
		map.put("state", state);
		map.put("simplePatient", simplePatient);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
		// return URLDecoder.decode(jo.toString(), "utf-8");
	}

	@RequestMapping("/updatePatientInfo")
	@ResponseBody
	public String updatePatientInfo(String username, String name, int sex, String age, String idNumber, String phone) {
		System.out.println("=======================updatePatientInfo=================");
		System.out.println("username: " + username + " realname= " + name + " sex= " + sex + " idNumber= " + idNumber
				+ " phone= " + phone);
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		String gender = "male";
		if (sex == 0) {
			gender = "female";
		}
		Patient patient = patientService.getPatientByName(username);
		if (patient == null) {
			state = 0;
			error = "不存在该用户";
		} else {
			patient.setRealname(name);
			patient.setGender(gender);
			patient.setIdNumber(idNumber);
			patient.setAge(age);
			patient.setTele(phone);
			patientService.updatePatient(patient);
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/changePassword")
	@ResponseBody
	public String changePassword(String username, String answer1, String answer2, String answer3, String oldPassword,
			String newPassword) {
		int type = 1;
		if (oldPassword == null) {
			type = 0;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		boolean flag = false;
		Patient patient = patientService.getPatientByName(username);
		if (type == 1) {
			// 1是用旧密码
			if (patient.getPassword().equals(oldPassword)) {
				flag = true;
			} else {
				state = 0;
				error = 1;
			}
		} else {
			// 0用是密保问题改
			if ((patient.getAnswer1().equals(answer1)) && (patient.getAnswer2().equals(answer2))
					&& (patient.getAnswer3().equals(answer3))) {
				flag = true;
			} else {
				state = 0;
				error = 8;
			}
		}
		if (flag) {
			patient.setPassword(newPassword);
			patientService.updatePatient(patient);
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/getDoctorInfo")
	@ResponseBody
	public String getDoctorInfo(Integer doctor_id) {
		System.out.println("=============================================");
		System.out.println("=======getDoctorInfo=================");
		System.out.println("=============================================");
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		int sex = 1;
		String info = "";
		DoctorInfo doctorInfo = null;
		Doctor doctor = patientService.getDoctorById(doctor_id);
		if (doctor != null) {
			if (doctor.getGender() != null) {
				if (doctor.getGender().equals("female")) {
					sex = 0;
				}
			}
			System.out.println(doctor.getRealname() + " " + doctor.getProfession() + " " + doctor.getHospital().getName() + " "
					+ sex + " " + Integer.parseInt(doctor.getAge()) + " " + doctor.getAddress() + " " + doctor.getNation() + " "
					+ info + " " + doctor.getTele() + " " + doctor.getMail());
			doctorInfo = new DoctorInfo(doctor.getRealname(), doctor.getProfession(), doctor.getHospital().getName(), sex,
					Integer.parseInt(doctor.getAge()), doctor.getAddress(), doctor.getNation(), info, doctor.getTele(),
					doctor.getMail());
		} else {
			state = 0;
			error = 9;
		}
		map.put("state", state);
		map.put("doctor", doctorInfo);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/getMedicineById")
	@ResponseBody
	public String getMedicineById(Integer medicineId) {
		System.out.println("=============================================");
		System.out.println("=======getMedicineById=================");
		System.out.println("=============================================");
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		Medicine medicine = null;
		medicine = patientService.getMedicineById(medicineId);
		if (medicine == null) {
			state = 0;
			error = 10;
		}
		MedicineDetail medicineDetail = new MedicineDetail(medicine.getName(), medicine.getConstituent(),
				medicine.getAdaptationDisease(), medicine.getAdverseReaction(), medicine.getTaboo(), medicine.getAttentions(),
				medicine.getDirection());
		map.put("state", state);
		map.put("medicineDetail", medicineDetail);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/getPrescription")
	public String getPrescription(String username) {
		System.out.println("=============================================");
		System.out.println("=======getPrescription=================");
		System.out.println("=============================================");
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		int error = 0;
		List<MedicineInfo> medicineInfos = new ArrayList<MedicineInfo>();
		Patient patient = patientService.getPatientByName(username);
		Set<Emr> emrs = patient.getEmrs();
		List<Emr> list = new ArrayList<Emr>();
		list.addAll(emrs);
		Emr lastEmr = list.get(list.size() - 1);
		Set<Prescription> prescriptions = lastEmr.getPrescriptions();
		if (prescriptions == null) {
			state = 1;
			error = 11;
		}
		if (prescriptions != null) {
			for (Prescription prescription : prescriptions) {
				Medicine medicine = prescription.getMedicine();
				MedicineInfo medicineInfo = new MedicineInfo(medicine.getId().toString(), medicine.getName(), prescription
						.getTakingMedicineWay().getTakingMedicineWay(), prescription.getTakingMedicineNumberEachtime(),
						prescription.getMedicineUnit().getMedicineUnit(),
						prescription.getTakingMedicineTimesEachday().toString(), prescription.getMealTime().getMealTime(),
						prescription.getCreateTime().toString());
				medicineInfos.add(medicineInfo);
			}
		}
		map.put("state", state);
		map.put("medicineInfos", medicineInfos);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/uploadRecord")
	@ResponseBody
	public String uploadRecord(String username, Integer type, String data) {
		switch (type) {
		case 0:
			// 心电数据
			return this.uploadHdRecord(username, data);
		case 1:
			// 血糖数据
			return this.uploadGluRecord(username, data);
		case 2:
			return null;
		case 3:
			return null;
		default:
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/uploadGluRecord")
	@ResponseBody
	public String uploadGluRecord(String username, String data) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx上传血糖数据*************");
		System.out.println("=========================" + username);
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		JSONObject json = JSONObject.fromObject(data);
		System.out.println("json------" + json);
		String time = json.getString("time");
		// 等待数据 TODO
		Float bloodGlucose = Float.parseFloat(json.getString("bloodGlucose"));
		Timestamp measureTime = Timestamp.valueOf(time);
		Timestamp uploadTime = new Timestamp(new Date().getTime());
		Patient patient = patientService.getPatientByName(username);
		System.out.println(patient);
		GluPatientRecord gluPatientRecord = new GluPatientRecord(patient, bloodGlucose, measureTime, uploadTime);
		Boolean f = patientService.uploadGluRecord(gluPatientRecord);
		if (!f) {
			state = 0;
			error = "储存用户血糖数据失败";
		} else {
			Set<GluPatientInfo> gluPatientInfos = patient.getGluPatientInfos();
			for (GluPatientInfo gluPatientInfo : gluPatientInfos) {
				gluPatientInfo.setRemainTime(gluPatientInfo.getRemainTime() - 1);
				if (gluPatientInfo.getRemainTime() < 3) {
					state = 1;
					error = "血糖测试次数剩余3次，请注意";
					if (gluPatientInfo.getRemainTime() < 0) {
						state = 1;
						error = "血糖测试次数已用完";
					}
				}
			}
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@RequestMapping("/uploadHdRecord")
	@ResponseBody
	public String uploadHdRecord(String username, String data) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx上传心电数据*************");
		System.out.println("=========================" + username);
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		JSONObject json = JSONObject.fromObject(data);
		System.out.println("json------" + json);
		String time = json.getString("time");
		float heartRate = (float) json.getInt("nAverageHR");
		Integer analysis = json.getInt("nAnalysis");
		String ecg = json.getString("ecgData");
		Timestamp measureTime = Timestamp.valueOf(time);
		Timestamp uploadTime = new Timestamp(new Date().getTime());
		System.out.println("====" + time + " " + heartRate + " " + measureTime + " " + ecg);
		Patient patient = patientService.getPatientByName(username);
		System.out.println(patient);
		HdPatientRecord hdPatientRecord = new HdPatientRecord(patient, heartRate, ecg, measureTime, uploadTime, analysis);
		Boolean f = patientService.uploadHdRecord(hdPatientRecord);
		if (!f) {
			state = 0;
			error = "储存用户心电数据失败";
		} else {
			Set<HdPatientInfo> hdPatientInfos = patient.getHdPatientInfos();
			for (HdPatientInfo hdPatientInfo : hdPatientInfos) {
				Timestamp endTime = hdPatientInfo.getRemainTime();
				System.out.println(endTime);
				if (TimeUtil.remainDays(endTime) < 3) {
					state = 1;
					error = "心电测试天数数剩余不足3天，请注意";
					if (TimeUtil.remainDays(endTime) < 0) {
						state = 1;
						error = "心电测试天数已到";
					}
				}
			}
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@RequestMapping("/uploadHplRecord")
	public String uploadHplRecord(String username, String data) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx上传血脂数据*************");
		System.out.println("=========================" + username);
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		JSONObject json = JSONObject.fromObject(data);
		System.out.println("json------" + json);
		String time = json.getString("time");
		// 等待数据 TODO
		Float tc = Float.parseFloat(json.getString("tc"));
		Float tg = Float.parseFloat(json.getString("tg"));
		Float hdl = Float.parseFloat(json.getString("hdl"));
		Float ldl = Float.parseFloat(json.getString("ldl"));
		Timestamp measureTime = Timestamp.valueOf(time);
		Timestamp uploadTime = new Timestamp(new Date().getTime());
		Patient patient = patientService.getPatientByName(username);
		System.out.println(patient);
		HplPatientRecord hplPatientRecord = new HplPatientRecord(patient, tc, tg, hdl, ldl, measureTime, uploadTime);
		Boolean f = patientService.uploadHplRecord(hplPatientRecord);
		if (!f) {
			state = 0;
			error = "储存用户血脂数据失败";
		} else {
			Set<HplPatientInfo> hplPatientInfos = patient.getHplPatientInfos();
			for (HplPatientInfo hplPatientInfo : hplPatientInfos) {
				Timestamp endTime = hplPatientInfo.getRemainTime();
				System.out.println(endTime);
				if (TimeUtil.remainDays(endTime) < 3) {
					state = 1;
					error = "血脂测试天数数剩余不足3天，请注意";
					if (TimeUtil.remainDays(endTime) < 0) {
						state = 1;
						error = "血脂测试天数已到";
					}
				}
			}
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@RequestMapping("/uploadHtnRecord")
	public String uploadHtnRecord(String username, String data) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx上传血压数据*************");
		System.out.println("=========================" + username);
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		JSONObject json = JSONObject.fromObject(data);
		System.out.println("json------" + json);
		String time = json.getString("time");
		// 等待数据 TODO
		Float diastolicPressure = Float.parseFloat(json.getString("diastolicPressure"));
		Float systolicPressure = Float.parseFloat(json.getString("systolicPressure"));
		Float heartRate = Float.parseFloat(json.getString("heartRate"));
		Timestamp measureTime = Timestamp.valueOf(time);
		Timestamp uploadTime = new Timestamp(new Date().getTime());
		Patient patient = patientService.getPatientByName(username);
		System.out.println(patient);
		HtnPatientRecord htnPatientRecord = new HtnPatientRecord(patient, diastolicPressure, systolicPressure, heartRate,
				measureTime, uploadTime);
		Boolean f = patientService.uploadHtnRecord(htnPatientRecord);
		if (!f) {
			state = 0;
			error = "储存用户血压数据失败";
		} else {
			Set<HtnPatientInfo> htnPatientInfos = patient.getHtnPatientInfos();
			for (HtnPatientInfo htnPatientInfo : htnPatientInfos) {
				Timestamp endTime = htnPatientInfo.getRemainTime();
				System.out.println(endTime);
				if (TimeUtil.remainDays(endTime) < 3) {
					state = 1;
					error = "血压测试天数数剩余不足3天，请注意";
					if (TimeUtil.remainDays(endTime) < 0) {
						state = 1;
						error = "血压测试天数已到";
					}
				}
			}
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@RequestMapping("/uploadBoRecord")
	public String uploadBoRecord(String username, String data) {
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx上传血氧数据*************");
		System.out.println("=========================" + username);
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		JSONObject json = JSONObject.fromObject(data);
		System.out.println("json------" + json);
		String time = json.getString("time");
		// 等待数据 TODO
		Float pulseRate = Float.parseFloat(json.getString("pulseRate"));
		Float spo2 = Float.parseFloat(json.getString("spo2"));
		Float pi = Float.parseFloat(json.getString("pi"));
		Timestamp measureTime = Timestamp.valueOf(time);
		Timestamp uploadTime = new Timestamp(new Date().getTime());
		Patient patient = patientService.getPatientByName(username);
		System.out.println(patient);
		BoPatientRecord boPatientRecord = new BoPatientRecord(patient, pulseRate, spo2, pi, measureTime, uploadTime);
		Boolean f = patientService.uploadBoRecord(boPatientRecord);
		if (!f) {
			state = 0;
			error = "储存用户血氧数据失败";
		} else {
			Set<BoPatientInfo> boPatientInfos = patient.getBoPatientInfos();
			for (BoPatientInfo boPatientInfo : boPatientInfos) {
				Timestamp endTime = boPatientInfo.getRemainTime();
				System.out.println(endTime);
				if (TimeUtil.remainDays(endTime) < 3) {
					state = 1;
					error = "血氧测试天数数剩余不足3天，请注意";
					if (TimeUtil.remainDays(endTime) < 0) {
						state = 1;
						error = "血氧测试天数已到";
					}
				}
			}
		}
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

	@RequestMapping("/getAppVersion")
	@ResponseBody
	public String getAppVersion() {
		Map<String, Object> map = new HashMap<String, Object>();
		int state = 1;
		String error = "0";
		AppVersion version = patientService.getAppVersion();
		if (version == null) {
			state = 0;
			error = "获取最新版本号错误";
		}
		map.put("version", version);
		map.put("state", state);
		map.put("error", error);
		JSONObject jo = JSONObject.fromObject(map);
		return jo.toString();
	}

}
