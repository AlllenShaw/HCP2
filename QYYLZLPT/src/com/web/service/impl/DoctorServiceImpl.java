package com.web.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.bean.domain.Doctor;
import com.bean.domain.EkgPatientInfo;
import com.bean.domain.Emr;
import com.bean.domain.GluPatientInfo;
import com.bean.domain.GluPatientMedicineRecord;
import com.bean.domain.GluPatientRecord;
import com.bean.domain.HdPatientInfo;
import com.bean.domain.HealthHistory;
import com.bean.domain.Hospital;
import com.bean.domain.HplPatientInfo;
import com.bean.domain.HplPatientRecord;
import com.bean.domain.HtnPatientInfo;
import com.bean.domain.HtnPatientRecord;
import com.bean.domain.Medicine;
import com.bean.domain.Patient;
import com.bean.domain.PatientHasDoctor;
import com.bean.domain.PatientHasDoctorId;
import com.web.dao.DoctorDao;
import com.web.prediction.BPAlgorithm;
import com.web.service.DoctorService;
import com.web.util.JsonDateValueProcessor;
import com.web.util.JsonFloatValueProcessor;
import com.web.util.JsonUtil;
import com.web.util.PremissionForHospitalUtil;
import com.web.util.Translate;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {

	@Resource
	private DoctorDao doctorDao;

	@Override
	public Doctor doctorLogin(String username, String password) {
		return doctorDao.doctorLogin(username, password);
	}

	@Override
	public boolean doctorRegister(Doctor doctor) {
		return doctorDao.doctorRegister(doctor);
	}

	@Override
	public JSONArray getPatientList(int doctor_id) {
		List<Patient> list = doctorDao.queryPatient(doctor_id);

		JSONArray patientArray = new JSONArray();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "healthHistories",
				"gluPatientRecords", "htnPatientRecords", "hplPatientInfos",
				"gluPatientMedicineRecords", "hplPatientRecords",
				"hplPatientMedicineRecords", "patientHasDoctors",
				"htnPatientMedicineRecords", "gluPatientInfos",
				"htnPatientInfos", "emrs" });
		for (Patient patient : list) {
			patientArray.add(JSONObject.fromObject(patient, config));
		}
		return patientArray;
	}

	@Override
	public JSONArray searchPatient(int hospital_id, String key) {
		List<Patient> list = doctorDao.searchPatients(hospital_id, key);

		System.out.println(list == null);

		JSONArray patientArray = new JSONArray();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "healthHistories",
				"gluPatientRecords", "htnPatientRecords", "hplPatientInfos",
				"gluPatientMedicineRecords", "hplPatientRecords",
				"hplPatientMedicineRecords", "patientHasDoctors",
				"htnPatientMedicineRecords", "gluPatientInfos",
				"htnPatientInfos", "emrs" });
		for (Patient patient : list) {
			patientArray.add(JSONObject.fromObject(patient, config));
		}
		return patientArray;
	}

	@Override
	public JSONArray searchPatientByDoctor(int doctor_id, String key) {
		List<Patient> list = doctorDao.searchPatientByDoctor(doctor_id, key);

		if (list == null) {
			return null;
		}

		JSONArray patientArray = new JSONArray();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "healthHistories",
				"gluPatientRecords", "htnPatientRecords", "hplPatientInfos",
				"gluPatientMedicineRecords", "hplPatientRecords",
				"hplPatientMedicineRecords", "patientHasDoctors",
				"htnPatientMedicineRecords", "gluPatientInfos",
				"htnPatientInfos", "emrs" });
		for (Patient patient : list) {
			patientArray.add(JSONObject.fromObject(patient, config));
		}
		return patientArray;
	}

	@Override
	public boolean deletePatient(int doctor_id, int patient_id) {
		Patient patient = new Patient();
		patient.setId(patient_id);
		Doctor doctor = new Doctor();
		doctor.setId(doctor_id);

		PatientHasDoctorId patientHasDoctorId = new PatientHasDoctorId();
		patientHasDoctorId.setPatient(patient);
		patientHasDoctorId.setDoctor(doctor);

		PatientHasDoctor patientHasDoctor = new PatientHasDoctor();
		patientHasDoctor.setId(patientHasDoctorId);

		return doctorDao.deletePatient(patientHasDoctor);
	}

	@Override
	public JSONObject getHosptial(int doctor_id) {

		Hospital hospital = doctorDao.getHosptial(doctor_id);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "tranformFieldsTables", "doctors",
				"protocolsForOtherHospitalId", "protocolsForMyHospitalId",
				"hospitalAdministrators" });
		return JSONObject.fromObject(hospital, config);
	}

	@Override
	public List<Hospital> getHospitals() {
		return doctorDao.getHospitalsList();
	}

	@Override
	public Hospital getHospitalByDoctorId(int doctor_id) {
		return doctorDao.getHosptial(doctor_id);
	}

	@Override
	public JSONArray queryHosptial(int hospital_id) {

		List<Hospital> list = doctorDao.queryHosptial(hospital_id);

		JSONArray hospitalaArray = new JSONArray();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "tranformFieldsTables", "doctors",
				"protocolsForOtherHospitalId", "protocolsForMyHospitalId",
				"hospitalAdministrators" });
		for (Hospital hospital : list) {
			hospitalaArray.add(hospital, config);
		}
		return hospitalaArray;
	}

	// @Override
	// public JSONObject getPaitentById(int patient_id) {
	// Patient patient = doctorDao.getPatientById(patient_id);
	// JsonConfig config = new JsonConfig();
	// config.setExcludes(new String[] { "healthHistories",
	// "gluPatientRecords", "htnPatientRecords", "hplPatientInfos",
	// "gluPatientMedicineRecords", "hplPatientRecords",
	// "hplPatientMedicineRecords", "patientHasDoctors",
	// "htnPatientMedicineRecords", "gluPatientInfos",
	// "htnPatientInfos", "emrs" });
	// return JSONObject.fromObject(patient, config);
	// }

	@Override
	public JSONObject queryEmr(int doctor_id, int other_hospital_id,
			int patient_id, String projectPath) {
		// Emr emr = doctorDao.queryEmr(doctor_id, patient_id);

		String basepath = projectPath + "/clinical_data/";
		Patient patient = doctorDao.getPatientById(patient_id);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "healthHistories", "token",
				"password", "gluPatientRecords", "htnPatientRecords",
				"hplPatientInfos", "gluPatientMedicineRecords",
				"hplPatientRecords", "hplPatientMedicineRecords",
				"patientHasDoctors", "htnPatientMedicineRecords",
				"gluPatientInfos", "htnPatientInfos", "emrs" });
		config.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());

		JSONObject object = JSONObject.fromObject(patient, config);

		Hospital myhospital = getHospitalByDoctorId(doctor_id);
		Map<String, Boolean> premissions = PremissionForHospitalUtil
				.iteratorPremissions(myhospital.getId(), other_hospital_id);

		Map<String, String> returnList = new HashMap<String, String>();

		Set<String> set = premissions.keySet();
		for (String string : set) {
			if ("电子病历".equals(string)) {
				if (premissions.get(string)) {
					returnList.put("电子病历", "1");
				} else {
					returnList.put("电子病历", "0");
				}
				continue;
			}
			if (premissions.get(string)) {
				returnList.put(string, basepath + Translate.translate(string)
						+ "/" + String.valueOf(other_hospital_id) + "_"
						+ String.valueOf(patient_id) + ".jpg");
			} else {
				returnList.put(string, "0");
			}
		}

		JSONArray array = JsonUtil.map2JsonObject(returnList);
		object.put("list", array);

		// JSONObject jsonObject = JSONObject.fromObject(patient, config);
		if (premissions.get("电子病历")) {
			HealthHistory history = doctorDao
					.getPatinetHealthHistoryById(patient_id);

			if (history != null) {
				object.put("illnessHistory", history.getIllnessHistory());
				object.put("allergicHistory", history.getAllergicHistory());
				object.put("familyMedicalHistory",
						history.getFamilyMedicalHistory());
			} else {
				object.put("illnessHistory", "无");
				object.put("allergicHistory", "无");
				object.put("familyMedicalHistory", "无");
			}
		} else {
			object.put("illnessHistory", "0");
			object.put("allergicHistory", "0");
			object.put("familyMedicalHistory", "0");
		}
		// object.put("电子病历", object);
		return object;
	}

	@Override
	public boolean setHtnPatientInfo(HtnPatientInfo htnPatientInfo) {
		return doctorDao.setHtnPatientInfo(htnPatientInfo);
	}

	@Override
	public boolean setHplPatientInfo(HplPatientInfo hplPatientInfo) {
		return doctorDao.setHplPatientInfo(hplPatientInfo);
	}

	@Override
	public boolean setGluPatientInfo(GluPatientInfo gluPatientInfo) {
		return doctorDao.setGluPatientInfo(gluPatientInfo);
	}

	@Override
	public boolean deleteEmr(int doctor_id, int patient_id) {
		return false;
	}

	@Override
	public boolean editEmr(Emr emr) {
		return false;
	}

	@Override
	public boolean addPatient(int doctor_id, int patient_id) {
		Patient patient = new Patient();
		patient.setId(patient_id);

		Doctor doctor = new Doctor();
		doctor.setId(doctor_id);

		PatientHasDoctorId patientHasDoctorId = new PatientHasDoctorId();
		patientHasDoctorId.setPatient(patient);
		patientHasDoctorId.setDoctor(doctor);

		PatientHasDoctor patientHasDoctor = new PatientHasDoctor();
		patientHasDoctor.setId(patientHasDoctorId);

		return doctorDao.addPatient(patientHasDoctor);
	}

	@Override
	public boolean checkPremission(int doctor_id, String url) {
		String premission_id = doctorDao.getPremissionByUrl(url);
		System.out.println("premission id : " + premission_id);
		if (premission_id == null) {
			return false;
		}
		return doctorDao.checkPremission(doctor_id, premission_id);
	}

	@Override
	public JSONArray getGluPatientMedicineRecord(int patient_id) {
		List<GluPatientMedicineRecord> list = doctorDao
				.getGluPatientMedicineRecord(patient_id);
		if (list == null) {
			return null;
		}
		JSONArray array = new JSONArray();
		for (GluPatientMedicineRecord gluPatientMedicineRecord : list) {

			JSONObject object = new JSONObject();
			object.put("id", gluPatientMedicineRecord.getMedicine().getId());
			object.put("name", gluPatientMedicineRecord.getMedicine().getName());
			object.put("time", new SimpleDateFormat("yy-MM-dd HH:mm:ss")
					.format(gluPatientMedicineRecord.getTakingMedicineTime()));
			object.put("way", gluPatientMedicineRecord.getTakingMedicineWay()
					.getTakingMedicineWay());
			object.put("dose",
					gluPatientMedicineRecord.getTakingMedicineNumberEachtime()
							+ gluPatientMedicineRecord.getMedicineUnit()
									.getMedicineUnit());
			array.add(object);
		}
		return array;
	}

	@Override
	public JSONObject getPatientManBingDetails(Integer patient_id) {

		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "patient" });
		config.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		config.registerJsonValueProcessor(Float.class,
				new JsonFloatValueProcessor());

		GluPatientInfo gluPatientInfo = doctorDao.getGluPatientInfo(patient_id);
		if (gluPatientInfo == null) {
			return null;
		}
		JSONObject gluJsonObject = JSONObject
				.fromObject(gluPatientInfo, config);
		if (gluPatientInfo.getPatient().getGluState()) {
			gluJsonObject.put("has", 1);
		} else {
			gluJsonObject.put("has", 0);
		}

		HtnPatientInfo htnPatientInfo = doctorDao.getHtnPatientInfo(patient_id);
		if (htnPatientInfo == null) {
			return null;
		}
		JSONObject htnJsonObject = JSONObject
				.fromObject(htnPatientInfo, config);

		if (htnPatientInfo.getPatient().getHtnState()) {
			htnJsonObject.put("has", 1);
		} else {
			htnJsonObject.put("has", 0);
		}

		HplPatientInfo hplPatientInfo = doctorDao.getHplPatientInfo(patient_id);
		if (hplPatientInfo == null) {
			return null;
		}
		JSONObject hplJsonObject = JSONObject
				.fromObject(hplPatientInfo, config);
		if (hplPatientInfo.getPatient().getHplState()) {
			hplJsonObject.put("has", 1);
		} else {
			hplJsonObject.put("has", 0);
		}

		
		// TODO	 add hdPatientInfo
		
		
		JSONObject object = new JSONObject();
		object.put("glu", gluJsonObject);
		object.put("htn", htnJsonObject);
		object.put("hpl", hplJsonObject);

		return object;
	}

	@Override
	public JSONArray predictHtn(Integer patient_id) {
		JSONArray array = new JSONArray();
		List<HtnPatientRecord> list = doctorDao.getHtnPatientRecords(
				patient_id, 15);
		if (list == null || list.size() < 15) {
			return null;
		}
		double[] diastolicPressure = new double[15];
		double[] heartRate = new double[15];
		double[] systolicPressure = new double[15];
		for (int i = 0; i < list.size(); i++) {
			diastolicPressure[i] = list.get(i).getDiastolicPressure();
			heartRate[i] = list.get(i).getHeartRate();
			systolicPressure[i] = list.get(i).getSystolicPressure();
		}
		double[] pridectDiastolicPressure = BPAlgorithm
				.htnDiastolicPressure(diastolicPressure);
		double[] pridectHeartRate = BPAlgorithm.htnHeartRate(heartRate);
		double[] predictSystolicPressure = BPAlgorithm
				.htnSystolicPressure(systolicPressure);

		JSONObject spJsonObject = new JSONObject();

		spJsonObject.put("value", predictSystolicPressure);
		spJsonObject.put("title", "收缩压");
		array.add(spJsonObject);

		spJsonObject.clear();
		spJsonObject.put("value", pridectDiastolicPressure);
		spJsonObject.put("title", "舒缩压");
		array.add(spJsonObject);

		spJsonObject.clear();
		spJsonObject.put("value", pridectHeartRate);
		spJsonObject.put("title", "心率");
		array.add(spJsonObject);

		return array;
	}

	@Override
	public JSONArray predictGlu(Integer patient_id) {
		JSONArray array = new JSONArray();
		List<GluPatientRecord> list = doctorDao.getGluPatientRecords(
				patient_id, 15);

		if (list == null || list.size() < 15) {
			return null;
		}

		double[] bloodGlucose = new double[15];
		for (int i = 0; i < bloodGlucose.length; i++) {
			bloodGlucose[i] = list.get(i).getBloodGlucose();
		}
		double[] predict = BPAlgorithm.gluBloodGlucose(bloodGlucose);
		JSONObject object = new JSONObject();
		object.put("title", "血糖");
		object.put("value", predict);
		array.add(object);
		return array;
	}

	@Override
	public JSONArray predictHpl(Integer patient_id) {
		JSONArray array = new JSONArray();
		List<HplPatientRecord> list = doctorDao.getHplPatientRecords(
				patient_id, 15);

		if (list == null || list.size() < 15) {
			return null;
		}

		double[] tc = new double[15];
		double[] tg = new double[15];
		double[] hdl = new double[15];
		double[] ldl = new double[15];
		for (int i = 0; i < list.size(); i++) {
			tc[i] = list.get(i).getTc();
			tg[i] = list.get(i).getTg();
			hdl[i] = list.get(i).getHdl();
			ldl[i] = list.get(i).getLdl();
		}

		double[] ptc = BPAlgorithm.hplTC(tc);
		double[] ptg = BPAlgorithm.hplTG(tg);
		double[] phdl = BPAlgorithm.hplHDL(hdl);
		double[] pldl = BPAlgorithm.hplLDL(ldl);

		JSONObject spJsonObject = new JSONObject();

		spJsonObject.put("value", ptc);
		spJsonObject.put("title", "总胆固醇值");
		array.add(spJsonObject);

		spJsonObject.clear();
		spJsonObject.put("value", ptg);
		spJsonObject.put("title", "甘油三酯值");
		array.add(spJsonObject);

		spJsonObject.clear();
		spJsonObject.put("value", phdl);
		spJsonObject.put("title", "高密度脂蛋白胆固醇值");
		array.add(spJsonObject);

		spJsonObject.clear();
		spJsonObject.put("value", pldl);
		spJsonObject.put("title", "低密度脂蛋白胆固醇值");
		array.add(spJsonObject);

		return array;
	}

	
	@Override
	public boolean setHdPatientInfo(HdPatientInfo hdPatientInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JSONArray predictHd(Integer patient_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean updateDoctor(Doctor doctor) {
		return doctorDao.updateDoctor(doctor);
	}

	@Override
	public boolean addMedicine(Medicine medicine) {
		return doctorDao.addMedicine(medicine);
	}

	@Override
	public JSONArray getMedicine() {
		List<Medicine> list = doctorDao.getMedicine();
		if (list == null) {
			return null;
		}
		JSONArray array = new JSONArray();
		for (Medicine medicine : list) {
			JSONObject object = new JSONObject();
			object.put("id", medicine.getId());
			object.put("name", medicine.getName());
			object.put("type", medicine.getType());
			array.add(object);
		}
		return array;
	}

	@Override
	public Integer deleteMedicine(Integer medicine_id) {
		return doctorDao.deleteMedicine(medicine_id);
	}

	@Override
	public JSONObject getMedicineById(Integer medicine_id) {
		Medicine medicine = doctorDao.getMedicineById(medicine_id);
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "medicineEmrs",
				"htnPatientMedicineRecords", "hplPatientMedicineRecords",
				"gluPatientMedicineRecords" });
		return JSONObject.fromObject(medicine, config);

	}

	@Override
	public JSONArray getMedicine(Integer type) {
		List<Medicine> list = doctorDao.getMedicine(type);
		if (list == null) {
			return null;
		}
		JSONArray array = new JSONArray();
		for (Medicine medicine : list) {
			JSONObject object = new JSONObject();
			object.put("id", medicine.getId());
			object.put("name", medicine.getName());
			array.add(object);
		}
		return array;
	}

	@Override
	public JSONObject getCompare(Integer type, Integer druga, Integer drugb) {
		JSONObject object = new JSONObject();
		List<Integer> lista = null;
		List<Integer> listb = null;
		Integer patient1 = 0;
		Integer patient2 = 0;
		Random random = new Random();
		switch (type) {
		case 1:
			lista = doctorDao.getPatientByMedicineId(druga,
					"HtnPatientMedicineRecord");
			listb = doctorDao.getPatientByMedicineId(drugb,
					"HtnPatientMedicineRecord");

			if (lista == null || listb == null) {
				return null;
			}
			patient1 = lista.get(random.nextInt(lista.size()));
			patient2 = listb.get(random.nextInt(listb.size()));

			List<HtnPatientRecord> record1 = doctorDao.getHtnPatientRecords(
					patient1, 8);
			List<HtnPatientRecord> record2 = doctorDao.getHtnPatientRecords(
					patient1, 8);

			JSONArray systolicPressure = new JSONArray();
			JSONArray diastolicPressure = new JSONArray();
			JSONArray heartRate = new JSONArray();

			JSONArray list1 = new JSONArray();

			for (HtnPatientRecord htnPatientRecord : record1) {
				systolicPressure.add(htnPatientRecord.getSystolicPressure());
				diastolicPressure.add(htnPatientRecord.getDiastolicPressure());
				heartRate.add(htnPatientRecord.getHeartRate());
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("title", "收缩压");
			jsonObject.put("value", diastolicPressure);
			list1.add(jsonObject);

			jsonObject.clear();
			jsonObject.put("title", "舒张压");
			jsonObject.put("value", systolicPressure);
			list1.add(jsonObject);

			jsonObject.clear();
			jsonObject.put("title", "心率");
			jsonObject.put("value", heartRate);
			list1.add(jsonObject);

			object.put("list1", list1);

			JSONArray list2 = new JSONArray();
			JSONArray systolicPressure2 = new JSONArray();
			JSONArray diastolicPressure2 = new JSONArray();
			JSONArray heartRate2 = new JSONArray();

			for (HtnPatientRecord htnPatientRecord : record2) {
				systolicPressure2.add(htnPatientRecord.getSystolicPressure());
				diastolicPressure2.add(htnPatientRecord.getDiastolicPressure());
				heartRate2.add(htnPatientRecord.getHeartRate());
			}

			JSONObject jsonObject2 = new JSONObject();
			jsonObject2.put("title", "收缩压");
			jsonObject2.put("value", diastolicPressure2);
			list2.add(jsonObject);

			jsonObject2.clear();
			jsonObject2.put("title", "舒张压");
			jsonObject2.put("value", systolicPressure2);
			list2.add(jsonObject);

			jsonObject2.clear();
			jsonObject2.put("title", "心率");
			jsonObject2.put("value", heartRate2);
			list2.add(jsonObject);
			object.put("list2", list2);

			return object;
		case 2:
			lista = doctorDao.getPatientByMedicineId(druga,
					"GluPatientMedicineRecord");
			listb = doctorDao.getPatientByMedicineId(drugb,
					"GluPatientMedicineRecord");
			if (lista == null || listb == null) {
				return null;
			}
			patient1 = lista.get(random.nextInt(lista.size()));
			patient2 = listb.get(random.nextInt(listb.size()));

			List<GluPatientRecord> glurecord1 = doctorDao.getGluPatientRecords(
					patient1, 8);
			List<GluPatientRecord> glurecord2 = doctorDao.getGluPatientRecords(
					patient2, 8);

			JSONArray bloodGlucose1 = new JSONArray();
			JSONArray bloodGlucose2 = new JSONArray();
			for (GluPatientRecord gluPatientRecord : glurecord1) {
				bloodGlucose1.add(gluPatientRecord.getBloodGlucose());
			}
			for (GluPatientRecord gluPatientRecord : glurecord2) {
				bloodGlucose2.add(gluPatientRecord.getBloodGlucose());
			}

			JSONArray glulist1 = new JSONArray();
			JSONArray glulist2 = new JSONArray();
			JSONObject jsonObject3 = new JSONObject();
			jsonObject3.put("title", "血糖值");
			jsonObject3.put("value", bloodGlucose1);
			glulist1.add(jsonObject3);
			object.put("list1", glulist1);

			jsonObject3.clear();
			jsonObject3.put("title", "血糖值");
			jsonObject3.put("value", bloodGlucose1);
			glulist2.add(jsonObject3);
			object.put("list2", glulist2);

			return object;
		case 3:
			lista = doctorDao.getPatientByMedicineId(druga,
					"HplPatientMedicineRecord");
			listb = doctorDao.getPatientByMedicineId(drugb,
					"HplPatientMedicineRecord");
			if (lista == null || listb == null) {
				return null;
			}
			patient1 = lista.get(random.nextInt(lista.size()));
			patient2 = listb.get(random.nextInt(listb.size()));

			List<HplPatientRecord> hplrecord1 = doctorDao.getHplPatientRecords(
					patient1, 8);
			List<HplPatientRecord> hplrecord2 = doctorDao.getHplPatientRecords(
					patient2, 8);

			JSONArray tc1 = new JSONArray();
			JSONArray tg1 = new JSONArray();
			JSONArray hdl1 = new JSONArray();
			JSONArray ldl1 = new JSONArray();
			JSONArray tc2 = new JSONArray();
			JSONArray tg2 = new JSONArray();
			JSONArray hdl2 = new JSONArray();
			JSONArray ldl2 = new JSONArray();

			for (HplPatientRecord hplPatientRecord : hplrecord1) {
				tc1.add(hplPatientRecord.getTc());
				tg1.add(hplPatientRecord.getTg());
				hdl1.add(hplPatientRecord.getHdl());
				ldl1.add(hplPatientRecord.getLdl());
			}
			for (HplPatientRecord hplPatientRecord : hplrecord2) {
				tc2.add(hplPatientRecord.getTc());
				tg2.add(hplPatientRecord.getTg());
				hdl2.add(hplPatientRecord.getHdl());
				ldl2.add(hplPatientRecord.getLdl());
			}

			JSONArray hpllist1 = new JSONArray();
			JSONArray hpllist2 = new JSONArray();

			JSONObject jsonObject4 = new JSONObject();
			jsonObject4.put("title", "总胆固醇值");
			jsonObject4.put("value", tc1);
			hpllist1.add(jsonObject4);

			jsonObject4.clear();
			jsonObject4.put("title", "甘油三酯值");
			jsonObject4.put("value", tg1);
			hpllist1.add(jsonObject4);

			jsonObject4.clear();
			jsonObject4.put("title", "高密度脂蛋白胆固醇值");
			jsonObject4.put("value", hdl1);
			hpllist1.add(jsonObject4);

			jsonObject4.clear();
			jsonObject4.put("title", "低密度脂蛋白胆固醇值");
			jsonObject4.put("value", ldl1);
			hpllist1.add(jsonObject4);

			jsonObject4.clear();
			jsonObject4.put("title", "总胆固醇值");
			jsonObject4.put("value", tc2);
			hpllist2.add(jsonObject4);

			jsonObject4.clear();
			jsonObject4.put("title", "甘油三酯值");
			jsonObject4.put("value", tg2);
			hpllist2.add(jsonObject4);

			jsonObject4.clear();
			jsonObject4.put("title", "高密度脂蛋白胆固醇值");
			jsonObject4.put("value", hdl2);
			hpllist2.add(jsonObject4);

			jsonObject4.clear();
			jsonObject4.put("title", "低密度脂蛋白胆固醇值");
			jsonObject4.put("value", ldl2);
			hpllist2.add(jsonObject4);

			object.put("list1", hpllist1);
			object.put("list2", hpllist2);

			return object;
		}

		return null;

	}

	
}
