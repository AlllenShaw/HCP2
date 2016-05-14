package com.hcp.dao;

import java.util.List;

import com.hcp.domain.AppVersion;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.SuperAdministrator;

public interface SuperAdminDAO {

	public abstract SuperAdministrator getSuperAdminiByID(Integer id);

	public abstract SuperAdministrator getSuperAdminiByName(String username);

	public abstract SuperAdministrator login(String username, String password);

	public abstract boolean deleteHospital(Hospital hospital);

	public abstract boolean addHosptial(Hospital hospital);

	public abstract List<Hospital> getHospitalsList();

	public abstract Hospital getHospitalById(Integer hospital_id);

	public abstract Hospital getHospitalByName(String hospital_name);

	public abstract List<HospitalAdministrator> getHospitalAdministrators(Integer hospital_id);

	public abstract HospitalAdministrator getHospitalAdministratorByID(Integer admin_id);
	
	public abstract HospitalAdministrator getHospitalAdministratorByName(String admin_username);

	public abstract boolean addospitalAdministrator(HospitalAdministrator hospitalAdministrator);

	public abstract boolean deleteHospitalAdministrator(HospitalAdministrator hospitalAdministrator);

	public abstract List<HospitalAdministrator> getHospitalAdministratorsList();

	public abstract List<HospitalAdministrator> getHospitalAdminByHospital(String hospital_id);

	public abstract boolean addAppVersion(AppVersion appVersion);

}
