package com.hcp.dao;

import java.util.List;

import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.Medicine;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.Permission;
import com.hcp.domain.UserGroup;
import com.hcp.domain.UserGroupPermission;

public interface HospitalAdminDAO {

	public abstract HospitalAdministrator getHospitalAdminById(Integer id);

	public abstract HospitalAdministrator getHospitalAdminByName(String username);

	public abstract boolean isNameExist(String username);

	public abstract HospitalAdministrator login(String username, String password);

	// 得到当前医院的信息
	public abstract Hospital getHospital(HospitalAdministrator hospitalAdministrator);

	public abstract List<Hospital> getHospitalsList();

	public abstract List<Doctor> getDoctors(Integer hospital_id);

	public abstract Doctor addDoctor(Doctor doctor);
	
	public abstract Doctor getDoctorByID(Integer doctor_id);

	public abstract Doctor getDoctorByName(String doctor_username);

	public abstract boolean deleteDoctor(Doctor doctor);

	public abstract boolean updateHospitalAdministrator(HospitalAdministrator hospitalAdministrator);

	// 药品管理
	public abstract List<Medicine> getMediciensList();

	public abstract Medicine getMedicineById(Integer medicine_id);

	public abstract Medicine getMedicineByName(String medicine_name);

	public abstract boolean addMedicine(Medicine medicine);

	public abstract boolean deleteMedicine(Medicine medicine);

	public abstract boolean updateMedicine(Medicine medicine);

	// 创建一个新用户组
	public abstract boolean newGroup(UserGroup userGroup);

	// 将医生添加到某个医生组中
	public abstract boolean addDoctor2Group(DoctorGroup doctorGroup);
	
	// 将患者添加到某个患者组中
	public abstract boolean addPatient2Group(PatientGroup patientGroup);
	
	// 设置医生用户组对患者用户组的权限
	public abstract boolean setGroupPermission(UserGroupPermission userGroupPermission);
	
	// 获取权限信息
	public abstract List<Permission> getPermissionsList(); 
}
