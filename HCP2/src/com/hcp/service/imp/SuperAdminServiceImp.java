package com.hcp.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.SuperAdminDAO;
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

}
