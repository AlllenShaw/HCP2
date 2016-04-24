package com.hcp.dao.imp;

import java.util.List;

import com.hcp.dao.HospitalAdminDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.Medicine;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.Permission;
import com.hcp.domain.UserGroup;
import com.hcp.domain.UserGroupPermission;

public class HospitalAdminDAOImp implements HospitalAdminDAO {

	@Override
	public HospitalAdministrator getHospitalAdminById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HospitalAdministrator getHospitalAdminByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNameExist(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HospitalAdministrator login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hospital getHospital(HospitalAdministrator hospitalAdministrator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hospital> getHospitalsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doctor> getDoctors(Integer hospital_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor getDoctorByID(Integer doctor_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Doctor getDoctorByName(String doctor_username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHospitalAdministrator(HospitalAdministrator hospitalAdministrator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Medicine> getMediciensList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medicine getMedicineById(Integer medicine_id) {
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
	public boolean deleteMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean newGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addDoctor2Group(DoctorGroup doctorGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPatient2Group(PatientGroup patientGroup) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean setGroupPermission(UserGroupPermission userGroupPermission) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Permission> getPermissionsList() {
		// TODO Auto-generated method stub
		return null;
	}

}
