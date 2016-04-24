package com.hcp.dao.imp;

import java.util.List;

import com.hcp.dao.SuperAdminDAO;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.SuperAdministrator;

public class SuperAdminDAOImp implements SuperAdminDAO {

	@Override
	public SuperAdministrator getSuperAdminiByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperAdministrator getSuperAdminiByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperAdministrator login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addHosptial(Hospital hospital) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Hospital> getHospitalsList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hospital getHospitalById(Integer hospital_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hospital getHospitalByName(String hospital_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HospitalAdministrator> getHospitalAdministrators(Integer hospital_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HospitalAdministrator getHospitalAdministratorByID(Integer admin_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HospitalAdministrator getHospitalAdministratorByName(String admin_username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addospitalAdministrator(HospitalAdministrator hospitalAdministrator) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHospitalAdministrator(HospitalAdministrator hospitalAdministrator) {
		// TODO Auto-generated method stub
		return false;
	}

}
