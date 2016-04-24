package com.web.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bean.domain.Doctor;
import com.bean.domain.DoctorOperPremission;
import com.bean.domain.DoctorOperPremissionId;
import com.bean.domain.Hospital;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.Protocol;

public interface HospatialAdminDao {
	public abstract HospitalAdministrator adminLogin(String username,
			String password);

	public abstract boolean changePassword(String name, String password);

	public abstract boolean addHosptial(Protocol protocol);

	public abstract List<Hospital> getHospitals(Integer my_hospital_id);

	public abstract List<Hospital> getAllHospital(Integer my_hospital_id);

	public abstract List<Hospital> getNoCollabHospital(Integer my_hospital_id);

	public abstract Hospital getMyHospital(Integer my_admin_id);

	public abstract boolean deleteDoctor(Doctor doctor);

	public abstract List<Doctor> getDoctors(Integer my_hospital_id);

	public abstract boolean editPremission(Map<String, Boolean> premissions,
			Integer my_hospital_id, Integer other_hospital_id);

	public abstract boolean addPremission(Map<String, Boolean> premissions,
			Integer my_hospital_id, Integer other_hospital_id);

	public abstract Map<String, Boolean> queryPremissions(
			Integer my_hospital_id, Integer other_hospital_id);

	public abstract Map<String, Boolean> getPremissionByName(
			Integer my_hospital_id, Integer other_hospital_id,
			String premissionName);

	public abstract boolean removePremission(Integer my_hospital_id,
			Integer other_hospital_id, Set<String> premissionNames);

	public abstract List<DoctorOperPremissionId> getDoctorPremission(
			Integer doctor_id);

	public abstract boolean editDoctorPremission(
			List<DoctorOperPremission> premissions);

	public abstract boolean updatePaitent(
			HospitalAdministrator hospitalAdministrator);

	public abstract boolean hospatialAdminRegister(HospitalAdministrator hospitalAdministrator);
	
	
	
	
	
	
}
