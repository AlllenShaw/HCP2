package com.web.dao.fina.impl;

import java.sql.SQLException;
import java.util.Date;
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
import com.bean.domain.DoctorOperPremission;
import com.bean.domain.DoctorOperPremissionId;
import com.bean.domain.DoctorPremission;
import com.bean.domain.Emr;
import com.bean.domain.GluPatientInfo;
import com.bean.domain.GluPatientMedicineRecord;
import com.bean.domain.GluPatientRecord;
import com.bean.domain.HealthHistory;
import com.bean.domain.Hospital;
import com.bean.domain.HplPatientInfo;
import com.bean.domain.HplPatientMedicineRecord;
import com.bean.domain.HplPatientRecord;
import com.bean.domain.HtnPatientInfo;
import com.bean.domain.HtnPatientMedicineRecord;
import com.bean.domain.HtnPatientRecord;
import com.bean.domain.Medicine;
import com.bean.domain.Patient;
import com.bean.domain.PatientHasDoctor;
import com.web.dao.DoctorDao;
import com.web.util.MyHibernateCallback;

@Repository
public class DoctorDaoImpl implements DoctorDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public boolean deleteEmr(Emr emr) {
		try {
			hibernateTemplate.delete(emr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean changePassword(String name, String password) {
		// TODO change password
		return false;
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public boolean deletePatient(PatientHasDoctor patientHasDoctor) {
		try {
			hibernateTemplate.delete(patientHasDoctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public String getPremissionByUrl(String url) {
		List<String> list = hibernateTemplate.find("select dp.id from DoctorPremission as dp where dp.url=?",
				new Object[] { url });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean checkPremission(int doctor_id, String premission_id) {
		List<Boolean> list = hibernateTemplate
				.find("select dop.id.operation from DoctorOperPremission as dop where dop.id.doctorPremission.id=? and dop.id.doctor.id=?",
						new Object[] { premission_id, doctor_id });

		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Doctor doctorLogin(String username, String password) {
		List<Doctor> doctor = hibernateTemplate.find("from Doctor as doctor where doctor.username=? and doctor.password=?",
				new Object[] { username, password });
		return doctor.isEmpty() ? null : doctor.get(0);
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public boolean doctorRegister(Doctor doctor) {
		try {
			hibernateTemplate.save(doctor);
			List<DoctorPremission> list = hibernateTemplate.find(" from DoctorPremission");

			DoctorOperPremission doctorOperPremission = new DoctorOperPremission();

			for (DoctorPremission doctorPremission : list) {
				DoctorOperPremissionId premissionId = new DoctorOperPremissionId();
				premissionId.setDoctor(doctor);
				premissionId.setDoctorPremission(doctorPremission);
				premissionId.setOperation(false);
				doctorOperPremission.setId(premissionId);
				doctorOperPremission.setDoctor(doctor);
				doctorOperPremission.setDoctorPremission(doctorPremission);
				hibernateTemplate.save(doctorOperPremission);
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public boolean editEmr(Emr emr) {
		try {
			hibernateTemplate.save(emr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean exisitName(String name) {
		List<Doctor> doctors = hibernateTemplate.find("from Doctors as doctors where doctors.name=?", new Object[] { name });
		return doctors.isEmpty();
	}

	@Override
	public Hospital getHosptial(int doctorId) {
		List<Hospital> list = hibernateTemplate.find("select hospital from Doctor as doctor where doctor.id=?",
				new Object[] { doctorId });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<Hospital> getHospitalsList() {
		// TODO Auto-generated method stub
		return hibernateTemplate.find("from Hospital");
	}

	@Override
	public Emr queryEmr(int hosptialId, int patientsId) {
		List<Emr> emrs = hibernateTemplate.find("from Emr as emr where emr.hosptials.id=? and emr.patients.id=?", new Object[] {
				hosptialId, patientsId });
		return emrs.isEmpty() ? null : emrs.get(0);
	}

	@Override
	public List<Hospital> queryHosptial(int hospitalId) {
		return hibernateTemplate.find("select pro.id.hospital_1 from Protocol as pro where pro.id.hospital.id=?",
				new Object[] { hospitalId });
	}

	@Override
	public List<Patient> queryPatient(int doctorId) {
		return hibernateTemplate.find("select phd.id.patient from PatientHasDoctor as phd  where phd.id.doctor.id=?",
				new Object[] { doctorId });
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> searchPatients(final int hospital_id, final String key) {
		return hibernateTemplate.executeFind(new HibernateCallback<List<Patient>>() {

			@Override
			public List<Patient> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("select doctor.id from Doctor as doctor where doctor.hospital.id=? ");
				query.setInteger(0, hospital_id);
				List<Integer> doctorids = query.list();

				for (Integer integer : doctorids) {
					System.out.println("doctor's id = " + integer);
				}

				Query query2 = session
						.createQuery("select phd.id.patient from PatientHasDoctor as phd where phd.id.patient.realname like :key and phd.id.doctor.id in (:doctorids) ");
				query2.setString("key", "%" + key + "%");
				query2.setParameterList("doctorids", doctorids);
				return query2.list();
			}
		});
	}

	@Override
	public List<Patient> searchPatientByDoctor(final int doctor_id, final String key) {
		List<Patient> list = hibernateTemplate.executeFind(new HibernateCallback<List<Patient>>() {

			@Override
			public List<Patient> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session
						.createQuery("select phd.id.patient from PatientHasDoctor as phd where phd.id.doctor.id=:doctor_id and phd.id.patient.realname like :key");

				query.setInteger("doctor_id", doctor_id);
				query.setString("key", "%" + key + "%");
				return query.list();
			}
		});

		return list.isEmpty() ? null : list;
	}

	@Override
	public Patient getPatientById(int patient_id) {
		List<Patient> list = hibernateTemplate.find("from Patient as patient where patient.id=?", new Object[] { patient_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public HealthHistory getPatinetHealthHistoryById(int patient_id) {
		List<HealthHistory> list = hibernateTemplate.find("from HealthHistory as history where history.patient.id=?",
				new Object[] { patient_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public boolean setHtnPatientInfo(final HtnPatientInfo htnPatientInfo) {
		try {
			return hibernateTemplate.execute(new HibernateCallback<Boolean>() {
				@Override
				public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("update HtnPatientInfo h set h.diastolicPressureMax=?,h.diastolicPressureMin=?,h.systolicPressureMax=?,h.systolicPressureMax=?,h.heartRateMax=?,h.heartRateMin=?,h.upgradeTime=? where h.patientId=? ");
					query.setFloat(0, htnPatientInfo.getDiastolicPressureMax());
					query.setFloat(1, htnPatientInfo.getDiastolicPressureMin());
					query.setFloat(2, htnPatientInfo.getSystolicPressureMax());
					query.setFloat(3, htnPatientInfo.getSystolicPressureMin());
					query.setFloat(4, htnPatientInfo.getHeartRateMax());
					query.setFloat(5, htnPatientInfo.getHeartRateMin());
					query.setDate(6, htnPatientInfo.getUpgradeTime());
					query.setInteger(7, htnPatientInfo.getPatientId());
					query.executeUpdate();
					return true;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public boolean setHplPatientInfo(final HplPatientInfo hplPatientInfo) {
		try {
			// hibernateTemplate.saveOrUpdate(hplPatientInfo);
			hibernateTemplate.execute(new HibernateCallback<Boolean>() {

				@Override
				public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("update HplPatientInfo h set h.tcMax=?,h.tcMin=?,h.tgMax=?,h.tgMin=?,h.hdlMax=?,h.hdlMin=?,h.ldlMax=?,h.ldlMin=?,h.upgradeTime=? where h.patientId=?");

					query.setFloat(0, hplPatientInfo.getTcMax());
					query.setFloat(1, hplPatientInfo.getTcMin());
					query.setFloat(2, hplPatientInfo.getTgMax());
					query.setFloat(3, hplPatientInfo.getTgMin());
					query.setFloat(4, hplPatientInfo.getHdlMax());
					query.setFloat(5, hplPatientInfo.getHdlMin());
					query.setFloat(6, hplPatientInfo.getLdlMax());
					query.setFloat(7, hplPatientInfo.getLdlMin());
					query.setDate(8, hplPatientInfo.getUpgradeTime());
					query.setFloat(9, hplPatientInfo.getPatientId());
					query.executeUpdate();
					return true;
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public boolean setGluPatientInfo(final GluPatientInfo gluPatientInfo) {
		try {
			hibernateTemplate.execute(new HibernateCallback<Boolean>() {

				@Override
				public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("update GluPatientInfo g set g.bloodGlucoseMax=?,g.bloodGlucoseMin=?,g.upgradeTime=? where g.patientId=?");
					query.setFloat(0, gluPatientInfo.getBloodGlucoseMax());
					query.setFloat(1, gluPatientInfo.getBloodGlucoseMin());
					query.setDate(2, gluPatientInfo.getUpgradeTime());
					query.setInteger(3, gluPatientInfo.getPatientId());
					query.executeUpdate();
					return true;
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public boolean addPatient(PatientHasDoctor patientHasDoctor) {
		try {
			hibernateTemplate.saveOrUpdate(patientHasDoctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public GluPatientInfo getGluPatientInfo(Integer patient_id) {

		List<GluPatientInfo> list = hibernateTemplate.find("from GluPatientInfo as glu where glu.patient.id=?",
				new Object[] { patient_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public HtnPatientInfo getHtnPatientInfo(Integer patient_id) {
		List<HtnPatientInfo> list = hibernateTemplate.find("from HtnPatientInfo as htn where htn.patient.id=?",
				new Object[] { patient_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public HplPatientInfo getHplPatientInfo(Integer patient_id) {
		List<HplPatientInfo> list = hibernateTemplate.find("from HplPatientInfo as hpl where hpl.patient.id=?",
				new Object[] { patient_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public List<GluPatientMedicineRecord> getGluPatientMedicineRecord(Integer patient_id) {
		List<GluPatientMedicineRecord> list = hibernateTemplate.find(
				"from GluPatientMedicineRecord as glu where glu.patient.id=?", new Object[] { patient_id });
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<HtnPatientMedicineRecord> getHtnPatientMedicineRecord(Integer patient_id) {
		List<HtnPatientMedicineRecord> list = hibernateTemplate.find(
				"from HtnPatientMedicineRecord as htn where htn.patient.id=?", new Object[] { patient_id });
		return list.isEmpty() ? null : list;

	}

	@Override
	public List<HplPatientMedicineRecord> getHplPatientMedicineRecord(Integer patient_id) {
		List<HplPatientMedicineRecord> list = hibernateTemplate.find(
				"from HplPatientMedicineRecord as hpl where hpl.patient.id=?", new Object[] { patient_id });
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<GluPatientRecord> getGluPatientRecords(Integer patient_id, Integer count) {
		String hql = "from GluPatientRecord as glu where glu.patient.id=? order by id desc ";
		List<GluPatientRecord> list = hibernateTemplate.executeFind(new MyHibernateCallback(hql, 0, count, patient_id));
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<HtnPatientRecord> getHtnPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		String hql = "from HtnPatientRecord as htn where htn.patient.id=? order by id desc";
		List<HtnPatientRecord> list = hibernateTemplate.executeFind(new MyHibernateCallback(hql, 0, count, patient_id));
		return list.isEmpty() ? null : list;
	}

	@Override
	public List<HplPatientRecord> getHplPatientRecords(Integer patient_id, Integer count) {
		// TODO Auto-generated method stub
		String hql = "from HplPatientRecord as hpl where hpl.patient.id=? order by id desc ";
		List<HplPatientRecord> list = hibernateTemplate.executeFind(new MyHibernateCallback(hql, 0, count, patient_id));
		return list.isEmpty() ? null : list;
	}

	@Override
	public boolean updateDoctor(final Doctor doctor) {

		return hibernateTemplate.execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("update Doctor p set p.password=?,p.address=?,p.tele=? where p.id=?");
				query.setString(0, doctor.getPassword());
				query.setString(1, doctor.getAddress());
				query.setString(2, doctor.getTele());
				query.setInteger(3, doctor.getId());
				query.executeUpdate();
				return true;
			}
		});
	}

	@Override
	public boolean addMedicine(Medicine medicine) {
		try {
			hibernateTemplate.save(medicine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Medicine> getMedicine() {
		return hibernateTemplate.find("from Medicine");
	}

	@Override
	public Medicine getMedicineById(Integer medicine_id) {
		List<Medicine> list = hibernateTemplate.find("from Medicine where id=?", new Object[] { medicine_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public int deleteMedicine(final Integer medicine_id) {
		return hibernateTemplate.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("delete from Medicine where id=?");
				query.setInteger(0, medicine_id);

				return query.executeUpdate();
			}
		});

	}

	@Override
	public List<Medicine> getMedicine(Integer type) {
		List<Medicine> list = hibernateTemplate.find("from Medicine as m where m.type=?", new Object[] { type });
		return list.isEmpty() ? null : list;

	}

	@Override
	public List<Integer> getPatientByMedicineId(Integer medicine_id, String type) {
		List<Integer> list = hibernateTemplate.find("select type.patient.id from " + type + " as type where type.medicine.id=?",
				new Object[] { medicine_id });
		return list.isEmpty() ? null : list;

	}
}
