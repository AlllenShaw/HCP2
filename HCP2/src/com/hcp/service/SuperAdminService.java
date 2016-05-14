package com.hcp.service;

import java.util.List;

import com.hcp.domain.AppVersion;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.SuperAdministrator;

public interface SuperAdminService {
	
	public abstract SuperAdministrator login(String username, String password);

	public abstract List<Hospital> getAllHospital();

	public abstract boolean addHospital(Hospital hospital);

	public abstract boolean removeHospital(String hospital_id);

	public abstract List<HospitalAdministrator> getAllHospitalAdmin();

	public abstract Hospital getHospitalById(String hospital_id);

	public abstract boolean addHospitalAdmin(HospitalAdministrator hospitalAdministrator);

	public abstract HospitalAdministrator getAllHospitalAdminById(String hospitalAdmin_id);

	public abstract boolean deleteHospitalAdmin(HospitalAdministrator hospitalAdministrator);

	public abstract List<HospitalAdministrator> getHospitalAdminByHospital(String hospital_id);

	public abstract boolean addAppVersion(AppVersion appVersion);
}
