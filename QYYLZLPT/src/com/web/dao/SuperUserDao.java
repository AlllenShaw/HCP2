package com.web.dao;

import java.util.List;
import com.bean.domain.Hospital;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.SuperAdministrator;

public interface SuperUserDao {
	public abstract SuperAdministrator superUserLogin(String username,
			String password);

	public abstract boolean deleteHospital(Hospital hospital);

	public abstract boolean addHosptial(Hospital hospital);

	public abstract List<Hospital> getAllHospital();

	public abstract Hospital getHospitalInfo(Integer hospital_id);

	public abstract List<HospitalAdministrator> getHospitalAdministrators(
			Integer hospital_id);

	public abstract HospitalAdministrator getHospitalAdministratorInfo(
			Integer admin_id);

	public abstract boolean addospitalAdministrator(
			HospitalAdministrator hospitalAdministrator);

	public abstract boolean deleteHospitalAdministrator(
			HospitalAdministrator hospitalAdministrator);
}
