package com.hcp.service;

import java.util.List;

import com.hcp.domain.Hospital;
import com.hcp.domain.Patient;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.Medicine;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.Permission;
import com.hcp.domain.UserGroup;
import com.hcp.domain.UserGroupPermission;

public interface HospitalAdminService {

	public abstract HospitalAdministrator login(String username, String password);

	public abstract Medicine getMedicineById(String medicine_id);

	public abstract Medicine getMedicineByName(String medicine_name);

	public abstract boolean addMedicine(Medicine medicine);

	public abstract boolean updateMedicine(Medicine medicine);

	public abstract boolean addUserGroup(UserGroup userGroup);

	public abstract UserGroup getUserGroupById(String group_id);

	public abstract Doctor getDoctorById(String doctor_id);

	public abstract boolean addDoctorGroup(DoctorGroup doctorGroup);

	public abstract Patient getPatientById(String patient_id);

	public abstract boolean addPatientGroup(PatientGroup patientGroup);

	public abstract void deleteDoctorGroup(String doctor_id, String group_id);

	public abstract void deletePatientGroup(String patient_id, String group_id);

	public abstract List<Doctor> getNumberByGroupId(String group_id);

	public abstract Permission getPermissionById(String permission_id);

	public abstract boolean addUserGroupPermission(UserGroupPermission userGroupPermission);

	public abstract UserGroupPermission getGroupPermission(String group_id1, String group_id2, String permission_id);

	public abstract boolean deleteUserGroupPermission(UserGroupPermission userGroupPermission);

	public abstract Hospital getHospitalById(String hospital_id);

	public abstract List<DoctorGroup> getDoctorGroupByHospital(Integer hospital_id);

	public abstract List<PatientGroup> getPatientGroupByHospital(Integer hospital_id);

	public abstract List<UserGroup> getUserGroupByHospital(Integer hospital_id);

	public abstract boolean deleteUserGroup(String group_id);

	public abstract List<Doctor> getDoctorByHospital(Integer id);

	public abstract List<Patient> getPatientByHospital(Integer id);

	public abstract List<Hospital> getCopHospital(Integer hospital_id);

	public abstract List<Hospital> getAllHospital();

	public abstract boolean addCoHospital(String hospital_id, Hospital hospital);

	public abstract boolean deleteCoHospital(String hospital_id, Hospital hospital);

	public abstract Patient getPatientByIdNumber(String patientInfo);

	public abstract Patient getPatientByName(String patientInfo);

	public abstract boolean setGluTime(String patient_id, String bg_remain_time);

	public abstract boolean setHtnTime(String patient_id, String bp_remain_time);

	public abstract boolean setBoTime(String patient_id, String spo_remain_time);
}
