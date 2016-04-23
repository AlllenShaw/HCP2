package com.web.dao.fina.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.domain.Doctor;
import com.bean.domain.Emr;
import com.bean.domain.GluPatientInfo;
import com.bean.domain.HealthHistory;
import com.bean.domain.Hospital;
import com.bean.domain.HplPatientInfo;
import com.bean.domain.HtnPatientInfo;
import com.bean.domain.Patient;
import com.bean.domain.PatientHasDoctor;
import com.web.dao.PatientDao;
import com.web.util.MyHibernateCallback;

@Repository("patientDao")
public class PatientDaoImpl implements PatientDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	// public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	// this.hibernateTemplate = hibernateTemplate;
	// }

	@Override
	public boolean exisitName(String name) {
		List<Patient> list = hibernateTemplate.find(
				"from Patient as patient where patient.username = ?",
				new Object[] { name });
		return list.isEmpty();
	}

	@Override
	public Patient patientLogin(String name, String password) {
		List<Patient> list = hibernateTemplate
				.find("from Patient as patient where patient.username = ? and patient.password=?",
						new Object[] { name, password });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<Doctor> getDoctors(Integer hospital_id) {
		return hibernateTemplate.find(
				"from Doctor as doctor where doctor.hospital.id=?",
				new Object[] { hospital_id });
	}

	@Override
	public List<Hospital> getHospitalList() {
		return hibernateTemplate.find("from Hospital");
	}

	@Override
	public boolean patientRegister(Patient patient,
			PatientHasDoctor patientHasDoctor) {
		try {
			hibernateTemplate.save(patient);

			HealthHistory healthHistory = (HealthHistory) patient
					.getHealthHistories().iterator().next();

			healthHistory.setPatient(patient);
			healthHistory.setPatientId(patient.getId());

			hibernateTemplate.save(healthHistory);

			hibernateTemplate.save(patientHasDoctor);

			HtnPatientInfo htnPatientInfo = new HtnPatientInfo();
			htnPatientInfo.setPatient(patient);
			htnPatientInfo.setPatientId(patient.getId());
			hibernateTemplate.save(htnPatientInfo);

			GluPatientInfo gluPatientInfo = new GluPatientInfo();
			gluPatientInfo.setPatient(patient);
			gluPatientInfo.setPatientId(patient.getId());
			hibernateTemplate.save(gluPatientInfo);

			HplPatientInfo hplPatientInfo = new HplPatientInfo();
			hplPatientInfo.setPatient(patient);
			hplPatientInfo.setPatientId(patient.getId());
			hibernateTemplate.save(hplPatientInfo);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Emr> queryEmr(int patient_id, String startTime, String endTime,
			int pageIndex, int pageSize) {
		String hql = "from Emr as emr where emr.patients.id=? and emr.timestamp > ? and emr.timestamp < ?";
		List<Emr> result = hibernateTemplate
				.executeFind(new MyHibernateCallback(hql, pageIndex, pageSize,
						patient_id));
		return result;
	}

	@Override
	public Patient getPatinetById(int patient_id) {
		List<Patient> list = hibernateTemplate.find(
				"from Patient as p where p.id=?", new Object[] { patient_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Transactional(rollbackFor = Throwable.class)
	@Override
	public boolean updateInfo(final Patient patient) {
		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session
						.createQuery("update Patient p set p.password=?,p.address=?,p.tele=?,p.gluState=?,p.hplState=?,p.htnState=? where p.id=?");
				query.setString(0, patient.getPassword());
				query.setString(1, patient.getAddress());
				query.setString(2, patient.getTele());
				query.setBoolean(3, patient.getGluState());
				query.setBoolean(4, patient.getHplState());
				query.setBoolean(5, patient.getHtnState());
				query.setInteger(6, patient.getId());
				query.executeUpdate();
				return true;
			}
		});
	}
}
