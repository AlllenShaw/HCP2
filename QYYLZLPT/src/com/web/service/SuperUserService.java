package com.web.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bean.domain.Hospital;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.SuperAdministrator;

public interface SuperUserService {
	// 管理员登录
	public abstract SuperAdministrator superUserLogin(String username,
			String password);

	// 添加医院
	public abstract boolean addHospital(Hospital hospital);

	// 删除医院
	public abstract boolean deleteHospital(Integer hospital_id);

	// 获取医院列表
	public abstract JSONArray getAllHospital();

	// 获取医院信息
	public abstract JSONObject getHospitalInfo(Integer hospital_id);

	// 获取医院管理员列表
	public abstract JSONArray getHospitalAdministrators(Integer hospital_id);

	// 获取医院管理员信息
	public abstract JSONObject getHospitalAdministratorInfo(Integer admin_id);

	// 添加医院管理员
	public abstract boolean addHospitalAdministrator(
			HospitalAdministrator hospitalAdministrator);

	// 删除医院管理员
	public abstract boolean deleteHospitalAdministrator(Integer admin_id,
			Integer hospital_id);
}
