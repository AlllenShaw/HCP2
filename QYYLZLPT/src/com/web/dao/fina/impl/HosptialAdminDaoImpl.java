package com.web.dao.fina.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.domain.Doctor;
import com.bean.domain.DoctorOperPremission;
import com.bean.domain.DoctorOperPremissionId;
import com.bean.domain.GluPatientInfo;
import com.bean.domain.HealthHistory;
import com.bean.domain.Hospital;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.HplPatientInfo;
import com.bean.domain.HtnPatientInfo;
import com.bean.domain.Patient;
import com.bean.domain.PatientHasDoctor;
import com.bean.domain.Protocol;
import com.web.dao.HospatialAdminDao;
import com.web.util.PremissionForHospitalUtil;

@Repository
public class HosptialAdminDaoImpl implements HospatialAdminDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	// public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	// this.hibernateTemplate = hibernateTemplate;
	// }

	@Override
	public HospitalAdministrator adminLogin(String username, String password) {
		List<HospitalAdministrator> administrators = hibernateTemplate.find(
				"from HospitalAdministrator as hadmin where hadmin.username=? and hadmin.password=?", new Object[] { username,
						password });
		return administrators.isEmpty() ? null : administrators.get(0);
	}

	@Override
	@Transactional
	public boolean addHosptial(Protocol protocol) {
		try {
			hibernateTemplate.save(protocol);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Hospital> getAllHospital(Integer my_hospital_id) {
		List<Hospital> list = hibernateTemplate.find(" from Hospital as hos");

		return list.isEmpty() ? null : list;
	}

	@Override
	public List<Hospital> getNoCollabHospital(Integer my_hospital_id) {
		List<Hospital> list = getHospitals(my_hospital_id);
		final List<Integer> coll_ids = new ArrayList<Integer>();
		for (Hospital hospital : list) {
			coll_ids.add(hospital.getId());
			System.out.print(hospital.getId());
		}

		List<Hospital> result = hibernateTemplate.executeFind(new HibernateCallback<List<Hospital>>() {

			@Override
			public List<Hospital> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session
						.createQuery("select protocol.id.hospital_1 from Protocol as protocol where protocol.id.hospital.id not in(:coll_ids)");
				query.setParameterList("coll_ids", coll_ids);
				return query.list();
			}
		});

		return result;
	}

	@Override
	public List<Hospital> getHospitals(Integer my_hospital_id) {
		List<Hospital> list = hibernateTemplate.find(
				"select protocol.id.hospital_1 from Protocol as protocol where protocol.id.hospital.id=? ",
				new Object[] { my_hospital_id });
		return list.isEmpty() ? null : list;
	}

	@Override
	public Hospital getMyHospital(Integer my_admin_id) {
		List<Hospital> list = hibernateTemplate.find(
				"select hosadmin.hospital from HospitalAdministrator as hosadmin where hosadmin.id=?",
				new Object[] { my_admin_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Transactional(rollbackFor = Throwable.class)
	@Override
	public boolean deleteDoctor(Doctor doctor) {
		try {
			hibernateTemplate.delete(doctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public List<Doctor> getDoctors(Integer my_hospital_id) {
		List<Doctor> list = hibernateTemplate.find("from Doctor as doctor where doctor.hospital.id=?",
				new Object[] { my_hospital_id });

		return list.isEmpty() ? null : list;
	}

	@Override
	public boolean editPremission(Map<String, Boolean> premissions, Integer my_hospital_id, Integer other_hospital_id) {
		return PremissionForHospitalUtil.editPremissions(my_hospital_id, other_hospital_id, premissions);
	}

	@Override
	public boolean addPremission(Map<String, Boolean> premissions, Integer my_hospital_id, Integer other_hospital_id) {
		return PremissionForHospitalUtil.addPremissions(my_hospital_id, other_hospital_id, premissions);
	}

	@Override
	public Map<String, Boolean> queryPremissions(Integer my_hospital_id, Integer other_hospital_id) {
		return PremissionForHospitalUtil.iteratorPremissions(my_hospital_id, other_hospital_id);
	}

	@Override
	public Map<String, Boolean> getPremissionByName(Integer my_hospital_id, Integer other_hospital_id, String premissionName) {
		return PremissionForHospitalUtil.getPremissionByName(my_hospital_id, other_hospital_id, premissionName);
	}

	@Override
	public boolean removePremission(Integer my_hospital_id, Integer other_hospital_id, Set<String> premissionNames) {
		return PremissionForHospitalUtil.removePremission(my_hospital_id, other_hospital_id, premissionNames);
	}

	@Override
	public List<DoctorOperPremissionId> getDoctorPremission(Integer doctor_id) {
		List<DoctorOperPremissionId> list = hibernateTemplate.find(
				"select dop.id from DoctorOperPremission as dop where dop.doctor.id=?", new Object[] { doctor_id });
		return list.isEmpty() ? null : list;
	}

	@Override
	public boolean editDoctorPremission(List<DoctorOperPremission> premissions) {
		try {
			for (final DoctorOperPremission doctorOperPremission : premissions) {
				hibernateTemplate.execute(new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session) throws HibernateException, SQLException {
						Query query = session
								.createQuery("update DoctorOperPremission dop set dop.id.operation=? where dop.id.doctor.id=? and dop.id.doctorPremission.id=? ");
						query.setBoolean(0, doctorOperPremission.getId().getOperation());
						query.setInteger(1, doctorOperPremission.getId().getDoctor().getId());
						query.setString(2, doctorOperPremission.getDoctorPremission().getId());
						query.executeUpdate();
						return null;
					}

				});
			}

			// hibernateTemplate.saveOrUpdateAll(premissions);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean changePassword(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePaitent(final HospitalAdministrator hospitalAdministrator) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("update HospitalAdministrator p set p.password=?,p.tele=? where p.id=?");
				query.setString(0, hospitalAdministrator.getPassword());
				query.setString(1, hospitalAdministrator.getTele());
				query.setInteger(2, hospitalAdministrator.getId());
				query.executeUpdate();
				return true;
			}
		});
	}

	@Override
	public boolean hospatialAdminRegister(HospitalAdministrator hospitalAdministrator) {
		try {
			hibernateTemplate.save(hospitalAdministrator);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
