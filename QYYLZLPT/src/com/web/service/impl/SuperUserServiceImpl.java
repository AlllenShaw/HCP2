package com.web.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.stereotype.Service;

import com.bean.domain.Authority;
import com.bean.domain.Hospital;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.SuperAdministrator;
import com.web.dao.SuperUserDao;
import com.web.service.SuperUserService;
import com.web.util.JsonDateValueProcessor;

@Service
public class SuperUserServiceImpl implements SuperUserService {

	@Resource
	private SuperUserDao superUserDao;

	@Override
	public SuperAdministrator superUserLogin(String username, String password) {
		return superUserDao.superUserLogin(username, password);
	}

	@Override
	public boolean addHospital(Hospital hospital) {

		return superUserDao.addHosptial(hospital);
	}

	@Override
	public boolean deleteHospital(Integer hospital_id) {
		Hospital hospital = new Hospital();
		hospital.setId(hospital_id);
		return superUserDao.deleteHospital(hospital);
	}

	@Override
	public JSONArray getAllHospital() {

		List<Hospital> list = superUserDao.getAllHospital();
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
	public JSONObject getHospitalInfo(Integer hospital_id) {
		Hospital hospital = superUserDao.getHospitalInfo(hospital_id);

		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "tranformFieldsTables", "doctors",
				"protocolsForOtherHospitalId", "protocolsForMyHospitalId",
				"hospitalAdministrators" });
		config.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());
		return JSONObject.fromObject(hospital, config);
	}

	@Override
	public JSONArray getHospitalAdministrators(Integer hospital_id) {
		List<HospitalAdministrator> list = superUserDao
				.getHospitalAdministrators(hospital_id);

		JSONArray adminArray = new JSONArray();

		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "authority", "hospital" });
		config.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());

		for (HospitalAdministrator hospitalAdministrator : list) {
			adminArray.add(hospitalAdministrator, config);
		}

		return adminArray;
	}

	@Override
	public JSONObject getHospitalAdministratorInfo(Integer admin_id) {
		HospitalAdministrator hospitalAdministrator = superUserDao
				.getHospitalAdministratorInfo(admin_id);

		JsonConfig config = new JsonConfig();
		config.setExcludes(new String[] { "authority", "hospital" });
		config.registerJsonValueProcessor(Date.class,
				new JsonDateValueProcessor());

		return JSONObject.fromObject(hospitalAdministrator, config);
	}

	@Override
	public boolean addHospitalAdministrator(
			HospitalAdministrator hospitalAdministrator) {

		return superUserDao.addospitalAdministrator(hospitalAdministrator);
	}

	@Override
	public boolean deleteHospitalAdministrator(Integer admin_id,
			Integer hospital_id) {
		HospitalAdministrator hospitalAdministrator = new HospitalAdministrator();

		Authority authority = new Authority();
		authority.setId(1);

		Hospital hospital = new Hospital();
		hospital.setId(hospital_id);

		hospitalAdministrator.setId(admin_id);
		hospitalAdministrator.setAuthority(authority);
		hospitalAdministrator.setHospital(hospital);
	//	hospitalAdministrator.setUsername("google");
	//	hospitalAdministrator.setMail("123");
	//	hospitalAdministrator.setTele("134");
	//	hospitalAdministrator.setPassword("123123");

		return superUserDao.deleteHospitalAdministrator(hospitalAdministrator);
	}

}
