package com.web.service;

import com.bean.domain.Doctor;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.Medicine;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface HosptialAdminService {

	// 医院管理员注册
	public abstract boolean hosptialAdminRegister(HospitalAdministrator hospitalAdministrator);

	// 医院管理员登录
	public abstract HospitalAdministrator hosptialAdminLogin(String username, String password);

	// 修改权限
	public abstract boolean editPremission(String list, Integer my_hospital_id, Integer other_hospital_id);

	// 查询权限
	public abstract JSONObject queryPremission(Integer my_hospital_id, Integer other_hospital_id);

	// 添加合作医院
	public abstract boolean addHosptial(Integer my_hospital_id, Integer other_hospital_id);

	// 获取医院列表
	public abstract JSONArray getHosptials(Integer my_hospital_id);

	// 获取所在医院
	public abstract JSONObject getMyHospital(Integer my_admin_id);

	// 获取没有合作的医院
	public abstract JSONArray getNoCollabHospital(Integer my_hospital_id);

	// 获取本院医生列表
	public abstract JSONArray getMyHospitalDoctorList(Integer my_hospital_id);

	// 从本平台删除医生
	public abstract boolean deleteDoctor(Integer doctor_id);

	// 获取本院医生的权限信息
	public abstract JSONObject getMyHospitalDoctorPremission(Integer doctor_id);

	// 保存修改后的医生权限信息
	public abstract boolean saveDoctorPremission(Integer doctor_id, String list);

	// 更新个人资料
	public abstract boolean updatePaitent(HospitalAdministrator hospitalAdministrator);

	// 添加药品
	public boolean addMedicine(Medicine medicine);

	// 获取药品
	public JSONArray getMedicine();

	// 删除药品
	public Integer deleteMedicine(Integer medicine_id);

	// 通过id获取药品
	public JSONObject getMedicineById(Integer medicine_id);

	// 通过类型获取药品
	public JSONArray getMedicine(Integer type);

}
