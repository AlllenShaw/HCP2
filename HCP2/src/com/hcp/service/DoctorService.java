package com.hcp.service;

import com.hcp.domain.Doctor;
import com.hcp.domain.GluPatientInfo;
import com.hcp.domain.HdPatientInfo;
import com.hcp.domain.HplPatientInfo;
import com.hcp.domain.HtnPatientInfo;

public interface DoctorService {
	
	
	public abstract Doctor login(String username, String password);

	
	
}
