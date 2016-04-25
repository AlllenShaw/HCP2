package com.hcp.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcp.dao.SuperAdminDAO;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.SuperAdministrator;

@Repository
public class SuperAdminDAOImp extends HibernateDaoSupport implements SuperAdminDAO {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
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
