package com.web.service;

import java.util.List;

import com.bean.domain.Doctor;
import com.bean.domain.EkgPatientInfo;
import com.bean.domain.Emr;
import com.bean.domain.GluPatientInfo;
import com.bean.domain.HdPatientInfo;
import com.bean.domain.Hospital;
import com.bean.domain.HplPatientInfo;
import com.bean.domain.HtnPatientInfo;
import com.bean.domain.Medicine;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface DoctorService {
	// 添加病人
	public abstract boolean addPatient(int doctor_id, int patient_id);

	// 获取病人列表
	public abstract JSONArray getPatientList(int doctor_id);

	// 删除病人
	public abstract boolean deletePatient(int doctor_id, int patient_id);

	// 获取医院列表
	public abstract JSONObject getHosptial(int doctor_id);

	public abstract List<Hospital> getHospitals();

	// 获取所属医院
	public abstract Hospital getHospitalByDoctorId(int doctor_id);

	// 获取医院列表
	public abstract JSONArray queryHosptial(int hospital_id);

	// 获取病人电子病历
	public abstract JSONObject queryEmr(int doctor_id, int other_hospital_id,
			int patient_id, String projectPath);

	// 删除病人电子病历
	public abstract boolean deleteEmr(int doctor_id, int patient_id);

	// 修改电子病历
	public abstract boolean editEmr(Emr emr);

	// 医生注册
	public abstract boolean doctorRegister(Doctor doctor);

	// 设置病人血压信息
	public abstract boolean setHtnPatientInfo(HtnPatientInfo htnPatientInfo);

	// 设置病人血脂信息
	public abstract boolean setHplPatientInfo(HplPatientInfo hplPatientInfo);

	// 设置病人血糖信息
	public abstract boolean setGluPatientInfo(GluPatientInfo gluPatientInfo);
	
	// 设置病人心电信息
	public abstract boolean setHdPatientInfo(HdPatientInfo hdPatientInfo);

	// 医生登录
	public abstract Doctor doctorLogin(String username, String password);

	// 获取血糖病人用药信息
	public abstract JSONArray getGluPatientMedicineRecord(int patient_id);

	// 根据医院id获取病人列表
	public abstract JSONArray searchPatient(int hospital_id, String key);

	// 根据医生id获取病人列表
	public abstract JSONArray searchPatientByDoctor(int doctor_id, String key);

	// 查询权限
	public abstract boolean checkPremission(int doctor_id, String url);

	// 获取病人慢病信息
	public abstract JSONObject getPatientManBingDetails(Integer patient_id);

	// 预测血压信息
	public abstract JSONArray predictHtn(Integer patient_id);

	// 预测血糖信息
	public abstract JSONArray predictGlu(Integer patient_id);

	// 预测血脂信息
	public abstract JSONArray predictHpl(Integer patient_id);
	
	// 预测心电信息
	public abstract JSONArray predictHd(Integer patient_id);

	// 更新医生信息
	public abstract boolean updateDoctor(Doctor doctor);
	
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

	
	JSONObject getCompare(Integer type, Integer druga, Integer drugb);

}
