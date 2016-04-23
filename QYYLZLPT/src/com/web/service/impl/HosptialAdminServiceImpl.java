package com.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.bean.domain.Doctor;
import com.bean.domain.DoctorOperPremission;
import com.bean.domain.DoctorOperPremissionId;
import com.bean.domain.DoctorPremission;
import com.bean.domain.Hospital;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.Medicine;
import com.bean.domain.Protocol;
import com.bean.domain.ProtocolId;
import com.web.dao.HospatialAdminDao;
import com.web.service.HosptialAdminService;
import com.web.util.JsonDateValueProcessor;
import com.web.util.JsonUtil;
import com.web.util.PremissionForHospitalUtil;

@Service
public class HosptialAdminServiceImpl implements HosptialAdminService {
	@Resource
	private HospatialAdminDao hospatialAdminDao;
	private DoctorServiceImpl doctorServiceImpl;
	
	@Override
	public HospitalAdministrator hosptialAdminLogin(String username,
			String password) {
		return hospatialAdminDao.adminLogin(username, password);
	}

	@Override
	public boolean editPremission(String list, Integer my_hospital_id,
			Integer other_hospital_id) {
		return hospatialAdminDao.editPremission(
				JsonUtil.jsonObject2Map(JSONObject.fromObject(list)),
				my_hospital_id, other_hospital_id);
	}

	@Override
	public JSONObject queryPremission(Integer my_hospital_id,
			Integer other_hospital_id) {
		JSONObject object = new JSONObject();
		JSONArray array = JsonUtil.map2JsonObject(hospatialAdminDao
				.queryPremissions(my_hospital_id, other_hospital_id));
		object.put("list", array);
		return object;
	}

	@Override
	public boolean addHosptial(Integer my_hospital_id, Integer other_hospital_id) {
		Hospital h1 = new Hospital();
		h1.setId(my_hospital_id);
		Hospital h2 = new Hospital();
		h2.setId(other_hospital_id);

		ProtocolId protocolId = new ProtocolId();
		protocolId.setHospital(h1);
		protocolId.setHospital_1(h2);

		Protocol protocol = new Protocol();
		protocol.setId(protocolId);
		protocol.setFilepath("path");
		protocol.setCreateTime(new Date());

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("电子病历", false);
		map.put("X光", false);
		map.put("CT", false);
		map.put("MRI", false);
		map.put("B超", false);

		return hospatialAdminDao.addHosptial(protocol)
				&& PremissionForHospitalUtil.createPremissionFile(
						my_hospital_id, other_hospital_id)
				&& PremissionForHospitalUtil.addPremissions(my_hospital_id,
						other_hospital_id, map);

	}

	@Override
	public JSONArray getHosptials(Integer my_hospital_id) {
		List<Hospital> list = hospatialAdminDao.getHospitals(my_hospital_id);
		JSONArray hospitalArray = new JSONArray();

		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "tranformFieldsTables", "doctors",
				"protocolsForOtherHospitalId", "protocolsForMyHospitalId",
				"hospitalAdministrators" });
		for (Hospital hospital : list) {
			hospitalArray.add(hospital, config);
		}
		return hospitalArray;
	}

	@Override
	public JSONObject getMyHospital(Integer my_admin_id) {
		Hospital hospital = hospatialAdminDao.getMyHospital(my_admin_id);
		// JSONObject object = new JSONObject();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "tranformFieldsTables", "doctors",
				"protocolsForOtherHospitalId", "protocolsForMyHospitalId",
				"hospitalAdministrators" });
		config.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		return JSONObject.fromObject(hospital, config);
	}

	@Override
	public JSONArray getNoCollabHospital(Integer my_hospital_id) {
		// List<Hospital> list = hospatialAdminDao
		// .getNoCollabHospital(my_hospital_id);
		List<Hospital> list = hospatialAdminDao.getAllHospital(my_hospital_id);
		JSONArray hospitalArray = new JSONArray();

		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "tranformFieldsTables", "doctors",
				"protocolsForOtherHospitalId", "protocolsForMyHospitalId",
				"hospitalAdministrators" });
		config.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		for (Hospital hospital : list) {
			hospitalArray.add(hospital, config);
		}
		return hospitalArray;
	}

	@Override
	public JSONArray getMyHospitalDoctorList(Integer my_hospital_id) {
		List<Doctor> list = hospatialAdminDao.getDoctors(my_hospital_id);

		JSONArray doctorArray = new JSONArray();
		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "hospital", "examinationEmrs",
				"patientHasDoctors", "emrs", "medicineEmrs",
				"doctorOperPremissions" });
		config.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		for (Doctor doctor : list) {
			doctorArray.add(doctor, config);
		}
		return doctorArray;
	}

	@Override
	public boolean deleteDoctor(Integer doctor_id) {
		Doctor doctor = new Doctor();
		doctor.setId(doctor_id);

		return hospatialAdminDao.deleteDoctor(doctor);
	}

	@Override
	public JSONObject getMyHospitalDoctorPremission(Integer doctor_id) {
		List<DoctorOperPremissionId> list = hospatialAdminDao
				.getDoctorPremission(doctor_id);

		Map<String, Boolean> map = new HashMap<String, Boolean>();
		for (DoctorOperPremissionId doctorOperPremissionId : list) {
			map.put(doctorOperPremissionId.getDoctorPremission().getId(),
					doctorOperPremissionId.getOperation());
		}

		JSONObject object = new JSONObject();
		JSONArray array = JsonUtil.map2JsonObject(map);
		object.put("list", array);
		return object;

	}

	@Override
	public boolean saveDoctorPremission(Integer doctor_id, String list) {
		Map<String, Boolean> map = JsonUtil.jsonObject2Map(JSONObject
				.fromObject(list));
		Set<String> set = map.keySet();
		List<DoctorOperPremission> list2 = new ArrayList<DoctorOperPremission>();

		for (String key : set) {
			Doctor doctor = new Doctor();
			doctor.setId(doctor_id);

			DoctorPremission doctorPremission = new DoctorPremission();
			doctorPremission.setId(key);

			DoctorOperPremissionId id = new DoctorOperPremissionId();
			id.setDoctorPremission(doctorPremission);
			id.setOperation(map.get(key));
			id.setDoctor(doctor);

			DoctorOperPremission doctorOperPremission = new DoctorOperPremission();
			doctorOperPremission.setId(id);
			doctorOperPremission.setDoctorPremission(doctorPremission);
			doctorOperPremission.setDoctor(doctor);

			list2.add(doctorOperPremission);

		}

		return hospatialAdminDao.editDoctorPremission(list2);
	}

	@Override
	public boolean updatePaitent(HospitalAdministrator hospitalAdministrator) {
		return hospatialAdminDao.updatePaitent(hospitalAdministrator);
	}

	@Override
	public boolean hosptialAdminRegister(HospitalAdministrator hospitalAdministrator) {
		return hospatialAdminDao.hospatialAdminRegister(hospitalAdministrator);
	}

	@Override
	public boolean addMedicine(Medicine medicine) {
		return doctorServiceImpl.addMedicine(medicine);
	}

	@Override
	public JSONArray getMedicine() {
		return doctorServiceImpl.getMedicine();
	}

	@Override
	public Integer deleteMedicine(Integer medicine_id) {
		return doctorServiceImpl.deleteMedicine(medicine_id);
	}

	@Override
	public JSONObject getMedicineById(Integer medicine_id) {
		return doctorServiceImpl.getMedicineById(medicine_id);
	}

	@Override
	public JSONArray getMedicine(Integer type) {
		return doctorServiceImpl.getMedicine(type);
	}

}
