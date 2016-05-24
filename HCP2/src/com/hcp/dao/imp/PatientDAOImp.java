package com.hcp.dao.imp;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcp.dao.PatientDAO;
import com.hcp.domain.AppVersion;
import com.hcp.domain.BoPatientInfo;
import com.hcp.domain.BoPatientRecord;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Emr;
import com.hcp.domain.Family;
import com.hcp.domain.GluPatientInfo;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Hospital;
import com.hcp.domain.HplPatientMedicineRecord;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientInfo;
import com.hcp.domain.HtnPatientMedicineRecord;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.PatientHasDoctor;
import com.hcp.domain.PatientHasDoctorId;
import com.hcp.domain.Prescription;
import com.hcp.util.MyHibernateCallback;

@Repository
public class PatientDAOImp extends HibernateDaoSupport implements PatientDAO {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public Patient getPatientById(Integer patient_id) {
		try {
			return this.getHibernateTemplate().load(Patient.class, patient_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient getPatientByName(String patient_username) {
		try {
			List<Patient> list = this.getHibernateTemplate().find("from Patient as p where p.username = ?",
					new Object[] { patient_username });
			System.out.println("-----DAO-----" + list.isEmpty());
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExist(String username, String idNumber) {
		try {
			List<Patient> list = this.getHibernateTemplate().find("from Patient as p where p.username = ? or p.idNumber = ?",
					new Object[] { username, idNumber });
			return !list.isEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient login(String username, String password) {
		try {
			List<Patient> list = this.getHibernateTemplate().find("from Patient as p where p.username = ? and p.password = ?",
					new Object[] { username, password });
			System.out.println("list---------------------" + list);
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctors(Integer hospital_id) {
		try {
			List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.hospital.id = ?",
					new Object[] { hospital_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean register(Patient patients, PatientHasDoctor patientHasDoctor) {
		try {
			this.getHibernateTemplate().save(patients);
			this.getHibernateTemplate().save(patientHasDoctor);
			this.getHibernateTemplate().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean register(Patient patients) {
		try {
			this.getHibernateTemplate().save(patients);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatePatient(Patient patient) {
		try {
			this.getHibernateTemplate().update(patient);
			System.out.println("**********************update*************");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GluPatientMedicineRecord> getGluPatientMedicineRecord(Integer patient_id) {
		try {
			List<GluPatientMedicineRecord> list = this.getHibernateTemplate().find(
					"from GluPatientMedicineRecord as glu where glu.patient.id=?", new Object[] { patient_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HtnPatientMedicineRecord> getHtnPatientMedicineRecord(Integer patient_id) {
		try {
			List<HtnPatientMedicineRecord> list = this.getHibernateTemplate().find(
					"from HtnPatientMedicineRecord as htn where htn.patient.id=?", new Object[] { patient_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HplPatientMedicineRecord> getHplPatientMedicineRecord(Integer patient_id) {
		try {
			List<HplPatientMedicineRecord> list = this.getHibernateTemplate().find(
					"from HplPatientMedicineRecord as hpl where hpl.patient.id=?", new Object[] { patient_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HdPatientMedicineRecord> getHdPatientMedicineRecord(Integer patient_id) {
		try {
			List<HdPatientMedicineRecord> list = this.getHibernateTemplate().find(
					"from HdPatientMedicineRecord as hd where hd.patient.id=?", new Object[] { patient_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GluPatientRecord> getGluPatientRecords(Integer patient_id, Integer count) {
		try {
			String hql = "from GluPatientRecord as glu where glu.patient.id=? order by id desc ";
			List<GluPatientRecord> list = this.getHibernateTemplate().executeFind(
					new MyHibernateCallback(hql, 0, count, patient_id));
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HtnPatientRecord> getHtnPatientRecords(Integer patient_id, Integer count) {
		try {
			String hql = "from HtnPatientRecord as htn where htn.patient.id=? order by id desc ";
			List<HtnPatientRecord> list = this.getHibernateTemplate().executeFind(
					new MyHibernateCallback(hql, 0, count, patient_id));
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HplPatientRecord> getHplPatientRecords(Integer patient_id, Integer count) {
		try {
			String hql = "from HplPatientRecord as hpl where hpl.patient.id=? order by id desc ";
			List<HplPatientRecord> list = this.getHibernateTemplate().executeFind(
					new MyHibernateCallback(hql, 0, count, patient_id));
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HdPatientRecord> getHdPatientRecords(Integer patient_id, Integer count) {
		try {
			String hql = "from HdPatientRecord as hd where hd.patient.id=? order by id desc ";
			List<HdPatientRecord> list = this.getHibernateTemplate().executeFind(
					new MyHibernateCallback(hql, 0, count, patient_id));
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveGluPatientRecords(GluPatientRecord gluPatientRecord) {
		try {
			this.getHibernateTemplate().save(gluPatientRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveHtnPatientRecord(HtnPatientRecord htnPatientRecord) {
		try {
			this.getHibernateTemplate().save(htnPatientRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveHplPatientRecord(HplPatientRecord hplPatientRecord) {
		try {
			this.getHibernateTemplate().save(hplPatientRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveHdPatientRecord(HdPatientRecord hdPatientRecord) {
		try {
			this.getHibernateTemplate().save(hdPatientRecord);
			// this.getHibernateTemplate().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveBoPatientRecord(BoPatientRecord boPatientRecord) {
		try {
			this.getHibernateTemplate().save(boPatientRecord);
			// this.getHibernateTemplate().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emr> getPatientEmrsList(Integer patient_id, String startTime, String endTime) {
		try {
			List<Emr> list = this.getHibernateTemplate()
					.find("from Emr as e where e.patient.id = ?", new Object[] { patient_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Emr getLastEmr(Integer patient_id) {
		try {
			List<Emr> list = this.getHibernateTemplate()
					.find("from Emr as e where e.patient.id = ?", new Object[] { patient_id });
			return list.get(list.size() - 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> getHospitals() {
		try {
			List<Hospital> list = this.getSession().createQuery("from Hospital").list();
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Hospital getHospitalByID(Integer id) {
		try {
			return this.getHibernateTemplate().load(Hospital.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public PatientGroup getDefaultGroup() {
		try {
			return this.getHibernateTemplate().load(PatientGroup.class, 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Doctor getDoctorById(Integer id) {
		try {
			return this.getHibernateTemplate().load(Doctor.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorsList() {
		try {
			return this.getHibernateTemplate().find("from Doctor");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Medicine getMedicineById(Integer medicine_id) {
		try {
			return this.getHibernateTemplate().load(Medicine.class, medicine_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prescription> getPrescriptionByName(String username) {
		try {
			List<Prescription> list = this.getHibernateTemplate().find("from Prescription as p where p.emr.patient.username = ?",
					new Object[] { username });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorListByPatientId(int id) {
		// TODO Auto-generated method stub
		// List<PatientHasDoctor> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<PatientHasDoctor>>() {
		// @Override
		// public List<PatientHasDoctor> doInHibernate(Session session) throws HibernateException, SQLException {
		// Query query = session.createQuery("from PatientHasDoctor p where p.id.patient.id =:id");
		// query.setInteger("id", id);
		// return query.list();
		// }
		// });
		try {
			List<PatientHasDoctor> list = this.getHibernateTemplate().find("from PatientHasDoctor p where p.id.patient.id = ?",
					new Object[] { id });
			List<Doctor> doctors = new ArrayList<Doctor>();
			for (PatientHasDoctor p : list) {
				doctors.add(p.getId().getDoctor());
			}
			return doctors.isEmpty() ? null : doctors;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timestamp> getAllHdRecordTime(String username) {
		try {
			List<Timestamp> list = this.getHibernateTemplate().find(
					"select h.measureTime from HdPatientRecord as h where h.patient.username = ?", new Object[] { username });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timestamp> getAllBoRecordTime(String username) {
		try {
			List<Timestamp> list = this.getHibernateTemplate().find(
					"select b.measureTime from BoPatientRecord as b where b.patient.username = ?", new Object[] { username });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timestamp> getAllHtnRecordTime(String username) {
		try {
			List<Timestamp> list = this.getHibernateTemplate().find(
					"select b.measureTime from HtnPatientRecord as b where b.patient.username = ?", new Object[] { username });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Timestamp> getAllGluRecordTime(String username) {
		try {
			List<Timestamp> list = this.getHibernateTemplate().find(
					"select b.measureTime from GluPatientRecord as b where b.patient.username = ?", new Object[] { username });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HdPatientRecord> getHdPatientRecordsByTime(String username, Timestamp startTime, Timestamp endTime) {
		try {
			List<HdPatientRecord> list = this.getHibernateTemplate().find(
					"from HdPatientRecord as h where h.patient.username = ? and h.measureTime >= ? and h.measureTime <= ?",
					new Object[] { username, startTime, endTime });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BoPatientRecord> getBoPatientRecordsByTime(String username, Timestamp startTime, Timestamp endTime) {
		try {
			List<BoPatientRecord> list = this.getHibernateTemplate().find(
					"from BoPatientRecord as b where b.patient.username = ? and b.measureTime >= ? and b.measureTime <= ?",
					new Object[] { username, startTime, endTime });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HtnPatientRecord> getHtnPatientRecordsByTime(String username, Timestamp startTime, Timestamp endTime) {
		try {
			List<HtnPatientRecord> list = this.getHibernateTemplate().find(
					"from HtnPatientRecord as b where b.patient.username = ? and b.measureTime >= ? and b.measureTime <= ?",
					new Object[] { username, startTime, endTime });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GluPatientRecord> getGluPatientRecordsByTime(String username, Timestamp startTime, Timestamp endTime) {
		try {
			List<GluPatientRecord> list = this.getHibernateTemplate().find(
					"from GluPatientRecord as b where b.patient.username = ? and b.measureTime >= ? and b.measureTime <= ?",
					new Object[] { username, startTime, endTime });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean register(Patient patient, Family family1, Family family2, PatientHasDoctor patientHasDoctor) {
		try {
			this.getHibernateTemplate().save(family1);
			this.getHibernateTemplate().save(family2);
			this.getHibernateTemplate().save(patient);
			this.getHibernateTemplate().save(patientHasDoctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public AppVersion getAppVersion() {
		try {
			AppVersion appVersion = this.getHibernateTemplate().execute(new HibernateCallback<AppVersion>() {
				@Override
				public AppVersion doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery("from AppVersion order by id");
					query.setMaxResults(1);
					return (AppVersion) query.uniqueResult();
				}
			});
			return appVersion;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean saveBoPatientInfo(BoPatientInfo boPatientInfo) {
		System.out.println("****************************************");
		System.out.println("****************************************");
		System.out.println("****************************************");
		System.out.println("****************************************");
		this.getHibernateTemplate().save(boPatientInfo);
		return true;

	}

	@Override
	public boolean saveGluPatientInfo(GluPatientInfo gluPatientInfo) {
		try {
			this.getHibernateTemplate().save(gluPatientInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean saveHtnPatientInfo(HtnPatientInfo htnPatientInfo) {
		try {
			this.getHibernateTemplate().save(htnPatientInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorByHospital(String hospital_id) {
		Integer id = Integer.parseInt(hospital_id);
		try {
			List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.hospital.id = ?",
					new Object[] { id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
