package com.hcp.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.HospitalAdminDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
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
		return null;
	}

	@Override
	public Medicine getMedicineByName(String medicine_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserGroup getUserGroupById(String group_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor getDoctorById(String doctor_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDoctorGroup(DoctorGroup doctorGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Patient getPatientById(String patient_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPatientGroup(PatientGroup patientGroup) {
		// TODO Auto-generated method stub
		return false;
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
		return null;
	}

	@Override
	public void addUserGroupPermission(UserGroupPermission userGroupPermission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserGroupPermission getGroupPermission(String group_id1, String group_id2, String permission_id) {
		// TODO Auto-generated method stub
		return hospitalAdminDAO.getGroupPermissionn(group_id1,group_id2,permission_id);
	}

	@Override
	public void deleteUserGroupPermission(UserGroupPermission userGroupPermission) {
		// TODO Auto-generated method stub
		
	}

}
