package com.hcp.service;

import com.hcp.domain.Patient;


public interface PatientService {

	public abstract Patient login(String username, String password);
}
