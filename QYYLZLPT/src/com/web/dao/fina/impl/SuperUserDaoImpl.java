package com.web.dao.fina.impl;

import java.util.Iterator;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.domain.Hospital;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.SuperAdministrator;
import com.web.dao.SuperUserDao;

@Repository
public class SuperUserDaoImpl implements SuperUserDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	@Override
	public SuperAdministrator superUserLogin(String username, String password) {
		List<SuperAdministrator> administrators = hibernateTemplate
				.find("from SuperAdministrator as superadmin where superadmin.username=? and superadmin.password=?",
						new Object[] { username, password });
		return administrators.isEmpty() ? null : administrators.get(0);
	}

	@Transactional(rollbackFor = Throwable.class)
	@Override
	public boolean addHosptial(Hospital hospital) {
		try {
			hibernateTemplate.save(hospital);
			Iterator<HospitalAdministrator> hIterable = hospital
					.getHospitalAdministrators().iterator();
			while (hIterable.hasNext()) {
				HospitalAdministrator administrator = hIterable.next();
				administrator.setHospital(hospital);

				hibernateTemplate.save(administrator);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional(rollbackFor = Throwable.class)
	@Override
	public boolean deleteHospital(Hospital hospital) {

		// return true;
		try {
			hibernateTemplate.delete(hospital);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Hospital> getAllHospital() {

		return hibernateTemplate.find("from Hospital");
	}

	@Override
	public Hospital getHospitalInfo(Integer hospital_id) {
		List<Hospital> list = hibernateTemplate.find(
				"from Hospital as hospital where hospital.id=? ",
				new Object[] { hospital_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<HospitalAdministrator> getHospitalAdministrators(
			Integer hospital_id) {

		return hibernateTemplate.find(
				"from HospitalAdministrator as ha where ha.hospital.id=? ",
				new Object[] { hospital_id });

	}

	@Override
	public HospitalAdministrator getHospitalAdministratorInfo(Integer admin_id) {
		List<HospitalAdministrator> list = hibernateTemplate.find(
				"from HospitalAdministrator as admin where admin.id=?",
				new Object[] { admin_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Transactional(rollbackFor = Throwable.class)
	@Override
	public boolean deleteHospitalAdministrator(
			final HospitalAdministrator hospitalAdministrator) {

		// hibernateTemplate.execute(new HibernateCallback() {
		//
		// @Override
		// public Object doInHibernate(Session session)
		// throws HibernateException, SQLException {
		// Query query = session
		// .createQuery("delete from HospitalAdministrator as hd where hd.id=?");
		// query.setInteger(0, hospitalAdministrator.getId());
		// query.executeUpdate();
		// return null;
		// }
		// });
		try {
			hibernateTemplate.delete(hospitalAdministrator);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional(rollbackFor = Throwable.class)
	@Override
	public boolean addospitalAdministrator(
			HospitalAdministrator hospitalAdministrator) {

		try {
			hibernateTemplate.save(hospitalAdministrator);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
