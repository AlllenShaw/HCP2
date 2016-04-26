package com.hcp.service.imp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcp.dao.PatientDAO;
import com.hcp.domain.Patient;
import com.hcp.service.PatientService;

@Service("patientService")
public class PatientServiceImp implements PatientService {

	@Resource
	private PatientDAO patientDAO;
	
	@Override
	public Patient login(String username, String password) {
		// TODO Auto-generated method stub
		return patientDAO.login(username, password);
	}

}
