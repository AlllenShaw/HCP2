package com.hcp.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.HospitalAdminDAO;
import com.hcp.domain.HospitalAdministrator;
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

}
