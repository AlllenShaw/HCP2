package com.web.service;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bean.domain.Hospital;
import com.bean.domain.Patient;

public interface PatientService {
	// 病人注册
	public abstract boolean patientRegister(Patient patient, Integer doctor_id);

	// 病人登录
	public abstract Patient login(String username, String password);

	public abstract List<Hospital> getHospitalList();

	public abstract JSONArray getDoctors(Integer hospital_id);

	// 查看电子病历
	public abstract JSONObject getEmr(Integer patient_id);

	// 获取慢病信息
	public abstract JSONObject getPatientManBingDetails(Integer patient_id);

	// 血压预测
	public abstract JSONArray predictHtn(Integer patient_id);

	// 血糖预测
	public abstract JSONArray predictGlu(Integer patient_id);

	// 血脂预测
	public abstract JSONArray predictHpl(Integer patient_id);

	// 心电数据预测
	public abstract JSONArray predictEkg(Integer patient_id);

	// 更新个人信息
	public abstract boolean updatePaitent(Patient patient);

	Patient getPatientById(int patient_id);
}
