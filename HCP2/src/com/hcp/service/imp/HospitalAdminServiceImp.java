package com.hcp.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.HospitalAdminDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.Permission;
import com.hcp.domain.UserGroup;
import com.hcp.domain.UserGroupPermission;
import com.hcp.service.HospitalAdminService;

@Service("hospitalAdminService")
public class HospitalAdminServiceImp implements HospitalAdminService {

	@Resource
	private HospitalAdminDAO hospitalAdminDAO;
	
	@Override
	public HospitalAdministrator login(String username, String password) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.login(username, password);
	}

	@Override
	public Medicine getMedicineById(String medicine_id) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(medicine_id);
		return hospitalAdminDAO.getMedicineById(id);
	}

	@Override
	public Medicine getMedicineByName(String medicine_name) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.getMedicineByName(medicine_name);
	}

	@Override
	public boolean addMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.addMedicine(medicine);
	}

	@Override
	public boolean updateMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.updateMedicine(medicine);
	}

	@Override
	public boolean addUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.addUserGroup(userGroup);
	}

	@Override
	public UserGroup getUserGroupById(String group_id) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(group_id);
		return hospitalAdminDAO.getUserGroupById(id);
	}

	@Override
	public Doctor getDoctorById(String doctor_id) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(doctor_id);
		return hospitalAdminDAO.getDoctorByID(id);
	}

	@Override
	public boolean addDoctorGroup(DoctorGroup doctorGroup) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.addDoctorGroup(doctorGroup);
	}

	@Override
	public Patient getPatientById(String patient_id) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(patient_id);
		return hospitalAdminDAO.getPatientById(id);
	}

	@Override
	public boolean addPatientGroup(PatientGroup patientGroup) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.addPatientGroup(patientGroup);
	}

	@Override
	public void deleteDoctorGroup(String doctor_id, String group_id) {
		// TODO Auto-generated method stub
		hospitalAdminDAO.deleteDoctorGroup(doctor_id, group_id);
	}

	@Override
	public void deletePatientGroup(String patient_id, String group_id) {
		// TODO Auto-generated method stub
		hospitalAdminDAO.deletePatientGroup(patient_id, group_id);
	}

	@Override
	public List<Doctor> getNumberByGroupId(String group_id) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.getNumberByGroupId(group_id);
	}

	@Override
	public Permission getPermissionById(String permission_id) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(permission_id);
		return hospitalAdminDAO.getPermissionById(id);
	}

	@Override
	public boolean addUserGroupPermission(UserGroupPermission userGroupPermission) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.setGroupPermission(userGroupPermission);
	}

	@Override
	public UserGroupPermission getGroupPermission(String group_id1, String group_id2, String permission_id) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.getGroupPermissionn(group_id1,group_id2,permission_id);
	}

	@Override
	public boolean deleteUserGroupPermission(UserGroupPermission userGroupPermission) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.deleteUserGroupPermission(userGroupPermission);
	}

	@Override
	public Hospital getHospitalById(String hospital_id) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(hospital_id);
		return hospitalAdminDAO.getHospitalById(id);
	}

	@Override
	public List<DoctorGroup> getDoctorGroupByHospital(Integer hospital_id) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.getDoctorGroupByHospital(hospital_id);
	}

	@Override
	public List<PatientGroup> getPatientGroupByHospital(Integer hospital_id) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.getPatientGroupByHospital(hospital_id);
	}

	@Override
	public List<UserGroup> getUserGroupByHospital(Integer hospital_id) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.getUserGroupByHospital(hospital_id);
	}

	@Override
	public boolean deleteUserGroup(String group_id) {
		UserGroup userGroup = this.getUserGroupById(group_id);
		return hospitalAdminDAO.deleteUserGroup(userGroup);
	}

}
