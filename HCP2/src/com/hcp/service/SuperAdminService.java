package com.hcp.service;

import com.hcp.domain.SuperAdministrator;

public interface SuperAdminService {
	
	public abstract SuperAdministrator login(String username, String password);
}
