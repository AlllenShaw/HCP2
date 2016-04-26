package com.hcp.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.DoctorDAO;
import com.hcp.domain.Doctor;
import com.hcp.service.DoctorService;

@Service("doctorService")
public class DoctorServiceImp implements DoctorService {

	@Resource
	private DoctorDAO doctorDAO;
	
	@Override
	public Doctor login(String username, String password) {
		// TODO Auto-generated method stub
		return doctorDAO.login(username, password);
	}

}
