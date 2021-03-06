package com.hcp.dao;

import java.util.List;

import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.HospitalHasHospital;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
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

	public abstract boolean addDoctor(Doctor doctor);

	public abstract Doctor getDoctorByID(Integer doctor_id);

	public abstract Doctor getDoctorByName(String doctor_username);

	public List<Doctor> getDoctorByRealName(String realname, HospitalAdministrator hospitalAdministrator);

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

	// 删除医生组
	public abstract boolean deleteDoctorGroup(String doctor_id, String group_id);

	// 删除病人组
	public abstract boolean deletePatientGroup(String patient_id, String group_id);

	// 获取用户组的用户
	public abstract List<Doctor> getNumberByGroupId(String group_id);

	public abstract UserGroupPermission getGroupPermissionn(String group_id1, String group_id2, String permission_id);

	public abstract boolean addUserGroup(UserGroup userGroup);

	public abstract UserGroup getUserGroupById(int id);

	public abstract boolean addDoctorGroup(DoctorGroup doctorGroup);

	public abstract Patient getPatientById(int id);

	public abstract boolean addPatientGroup(PatientGroup patientGroup);

	public abstract Permission getPermissionById(int id);

	public abstract boolean deleteUserGroupPermission(UserGroupPermission userGroupPermission);

	public abstract Hospital getHospitalById(int id);

	public abstract List<DoctorGroup> getDoctorGroupByHospital(Integer hospital_id);

	public abstract List<PatientGroup> getPatientGroupByHospital(Integer hospital_id);

	public abstract List<UserGroup> getUserGroupByHospital(Integer hospital_id);

	public abstract List<UserGroup> getPatientUserGroupByHospital(Integer hospital_id);

	public abstract List<UserGroup> getDoctorUserGroupByHospital(Integer hospital_id);

	public abstract boolean deleteUserGroup(UserGroup userGroup);

	public abstract List<Doctor> getDoctorByHospital(Integer id);

	public abstract List<Patient> getPatientByHospital(Integer id);

	public abstract List<Hospital> getCopHospital(Integer hospital_id);

	public abstract List<Hospital> getAllHospital();

	public abstract boolean addCoHospital(HospitalHasHospital hospitalHasHospital);

	public abstract HospitalHasHospital getCopHospital(Hospital hospital);

	public abstract boolean deleteCoHospital(HospitalHasHospital hospitalHasHospitals);

	public abstract Patient getPatientByIdNumber(String idNumber);

	public abstract Patient getPatientByName(String username);

	public abstract boolean setGluTime(String patient_id, String bg_remain_time);

	public abstract boolean setHtnTime(String patient_id, String bp_remain_time);

	public abstract boolean setBoTime(String patient_id, String spo_remain_time);
}
