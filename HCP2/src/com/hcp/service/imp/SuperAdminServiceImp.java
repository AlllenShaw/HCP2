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
		return superAdminDAO.getHospitalsList();
	}

	@Override
	public boolean addHospital(Hospital hospital) {
		// TODO Auto-generated method stub
		return superAdminDAO.addHosptial(hospital);
	}

	@Override
	public boolean removeHospital(String hospital_id) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(hospital_id);
		Hospital hospital = superAdminDAO.getHospitalById(id);
		return superAdminDAO.deleteHospital(hospital);
	}

	@Override
	public List<HospitalAdministrator> getAllHospitalAdmin() {
		// TODO Auto-generated method stub
		return superAdminDAO.getHospitalAdministratorsList();
	}

	@Override
	public Hospital getHospitalById(String hospital_id) {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(hospital_id);
		return superAdminDAO.getHospitalById(id);
	}

	@Override
	public boolean addHospitalAdmin(HospitalAdministrator hospitalAdministrator) {
		// TODO Auto-generated method stub
		return superAdminDAO.addospitalAdministrator(hospitalAdministrator);
	}

	@Override
	public HospitalAdministrator getAllHospitalAdminById(String hospitalAdmin_id) {
		Integer admin_id = Integer.parseInt(hospitalAdmin_id);
		return superAdminDAO.getHospitalAdministratorByID(admin_id);
	}

	@Override
	public boolean deleteHospitalAdmin(HospitalAdministrator hospitalAdministrator) {
		// TODO Auto-generated method stub
		return superAdminDAO.deleteHospitalAdministrator(hospitalAdministrator);
	}

	@Override
	public List<HospitalAdministrator> getHospitalAdminByHospital(String hospital_id) {
		// TODO Auto-generated method stub
		return superAdminDAO.getHospitalAdminByHospital(hospital_id);
	}

}
