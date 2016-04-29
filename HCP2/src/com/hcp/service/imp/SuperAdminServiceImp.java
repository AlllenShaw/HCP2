package com.hcp.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.SuperAdminDAO;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.SuperAdministrator;
import com.hcp.service.SuperAdminService;

@Service("superAdminService")
public class SuperAdminServiceImp implements SuperAdminService {

	@Resource
	private SuperAdminDAO superAdminDAO;
	
	@Override
	public SuperAdministrator login(String username, String password) {
		// TODO Auto-generated method stub
		return superAdminDAO.login(username, password);
	}

	@Override
	public List<Hospital> getAllHospital() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeHospital(String hospital_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HospitalAdministrator> getAllHospitalAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hospital getHospitalById(String hospital_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addHospitalAdmin(HospitalAdministrator hospitalAdministrator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HospitalAdministrator getAllHospitalAdminById(String hospitalAdmin_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteHospitalAdmin(HospitalAdministrator hospitalAdministrator) {
		// TODO Auto-generated method stub
		
	}

}
