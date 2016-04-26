package com.hcp.service;

import com.hcp.domain.HospitalAdministrator;


public interface HospitalAdminService {

	public abstract HospitalAdministrator login(String username, String password);
}
