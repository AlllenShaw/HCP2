package com.hcp.dao.imp;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcp.dao.DoctorDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Emr;
import com.hcp.domain.GluPatientInfo;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientInfo;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Hospital;
import com.hcp.domain.HplPatientInfo;
import com.hcp.domain.HplPatientMedicineRecord;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientInfo;
import com.hcp.domain.HtnPatientMedicineRecord;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.MealTime;
import com.hcp.domain.Medicine;
import com.hcp.domain.MedicineUnit;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.PatientHasDoctor;
import com.hcp.domain.PatientHasDoctorId;
import com.hcp.domain.UserGroupPermission;
import com.hcp.util.MyHibernateCallback;

@Repository
public class DoctorDAOImp extends HibernateDaoSupport implements DoctorDAO {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public Doctor getDoctorById(Integer doctor_id) {
		Doctor doctor = null;
		try {
			doctor = this.getHibernateTemplate().load(Doctor.class, doctor_id);
			return doctor;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Doctor getDoctorByName(String username) {
		try {
			List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.username = ?",
					new Object[] { username });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DoctorGroup> getDoctorGroup(Doctor doctor) {
		// TODO Auto-generated method stub
		try {
			int doctor_id = doctor.getId();
			List<DoctorGroup> list = this.getHibernateTemplate().find("from DoctorGroup as dg where dg.doctor.id = ?",
					new Object[] { doctor_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isExist(String username, String idNumber) {
		try {
			List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.username = ? or d.idNumber = ?",
					new Object[] { username, idNumber });
			// System.out.println("isExist?"+!list.isEmpty());
			return !list.isEmpty();
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Doctor login(String username, String password) {
		try {
			List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.username = ? and d.password=?",
					new Object[] { username, password });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean register(Doctor doctor) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(doctor);
			this.getHibernateTemplate().flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean changePassword(Doctor doctor) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(doctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addPatient(PatientHasDoctor patientHasDoctor) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().saveOrUpdate(patientHasDoctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatients(Doctor doctor) {
		try {
			final int doctor_id = doctor.getId();
			List<Patient> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<Patient>>() {
				@Override
				public List<Patient> doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("select phd.id.patient from PatientHasDoctor as phd where phd.id.doctor.id=:doctor_id");
					query.setInteger("doctor_id", doctor_id);
					return query.list();
				}
			});
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient getPatientById(Integer patient_id) {
		try {
			List<Patient> list = this.getHibernateTemplate()
					.find("from Patient as p where p.id = ?", new Object[] { patient_id });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient getPatientByName(String patient_username) {
		// TODO Auto-generated method stub
		try {
			List<Patient> list = this.getHibernateTemplate().find("from Patient as p where p.username = ?",
					new Object[] { patient_username });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatientByRealName(Doctor doctor, String patient_realname) {
		try {
			final int doctor_id = doctor.getId();
			final String realname = patient_realname;
			List<Patient> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<Patient>>() {
				@Override
				public List<Patient> doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("select phd.id.patient from PatientHasDoctor as phd where phd.id.doctor.id=:doctor_id and phd.id.patient.realname like :realname");
					query.setInteger("doctor_id", doctor_id);
					query.setString("realname", "%" + realname + "%");
					return query.list();
				}
			});
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deletePatient(Patient patient, Doctor doctor) {
		try {
			final int patient_id = patient.getId();
			final int doctor_id = doctor.getId();
			Integer updateCount = this.getHibernateTemplate().execute(new HibernateCallback<Integer>() {
				@Override
				public Integer doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("delete from PatientHasDoctor as phd where phd.id.patient.id=:patient_id and phd.id.doctor.id=:doctor_id");
					query.setInteger("patient_id", patient_id);
					query.setInteger("doctor_id", doctor_id);
					return query.executeUpdate();
				}
			});
			if (updateCount > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Hospital getHosptial(Integer doctor_id) {
		try {
			return this.getDoctorById(doctor_id).getHospital();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> getHospitalsList() {
		try {
			List<Hospital> list = this.getSession().createQuery("from Hospital").list();
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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

	@Override
	public boolean newPatientEmr(Emr emr) {
		try {
			this.getHibernateTemplate().save(emr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkPremission(int doctor_id, int premission_id) {
		try {
			List<DoctorGroup> doctorGroups = this.getHibernateTemplate().find("from DoctorGroup as dg where dg.doctor.id = ?",
					new Object[] { doctor_id });
			for (DoctorGroup dg : doctorGroups) {
				int groupId = dg.getUserGroup().getId();
				List<UserGroupPermission> list = this.getHibernateTemplate().find(
						"from UserGroupPermission as ugp where ugp.userGroupByUserGroup1Id = ? and ugp.permission.id = ?",
						new Object[] { groupId, premission_id });
				if (!list.isEmpty()) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean setHtnPatientInfo(HtnPatientInfo htnPatientInfo) {
		try {
			System.out.println("_________________Htn_____________DAO Update");
			this.getHibernateTemplate().update(htnPatientInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean setHplPatientInfo(HplPatientInfo hplPatientInfo) {
		try {
			System.out.println("______________________Hpl________DAO Update");
			this.getHibernateTemplate().update(hplPatientInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean setGluPatientInfo(GluPatientInfo gluPatientInfo) {
		try {
			System.out.println("__________________________GLu__DAO Update");
			this.getHibernateTemplate().update(gluPatientInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean setHdPatientInfo(HdPatientInfo hdPatientInfo) {
		try {
			this.getHibernateTemplate().update(hdPatientInfo);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public GluPatientInfo getGluPatientInfo(Integer patient_id) {
		try {
			List<GluPatientInfo> list = this.getHibernateTemplate().find("from GluPatientInfo as glu where glu.patient.id=?",
					new Object[] { patient_id });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public HtnPatientInfo getHtnPatientInfo(Integer patient_id) {
		try {
			List<HtnPatientInfo> list = this.getHibernateTemplate().find("from HtnPatientInfo as htn where htn.patient.id=?",
					new Object[] { patient_id });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public HplPatientInfo getHplPatientInfo(Integer patient_id) {
		try {
			List<HplPatientInfo> list = this.getHibernateTemplate().find("from HplPatientInfo as hpl where hpl.patient.id=?",
					new Object[] { patient_id });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public HdPatientInfo getHdPatientInfo(Integer patient_id) {
		try {
			List<HdPatientInfo> list = this.getHibernateTemplate().find("from HdPatientInfo as hd where hd.patient.id=?",
					new Object[] { patient_id });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
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
	public boolean updateDoctor(Doctor doctor) {
		try {
			this.getHibernateTemplate().update(doctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> getMediciensList() {
		try {
			return this.getHibernateTemplate().find("from Medicine");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Medicine getMedicineById(Integer medicine_id) {
		try {
			List<Medicine> list = this.getHibernateTemplate().find("from Medicine as m where m.id = ?",
					new Object[] { medicine_id });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> getMedicineByName(String medicine_name) {
		try {
			List<Medicine> list = this.getHibernateTemplate().find("from Medicine as m where m.name like ?",
					"%" + medicine_name + "%");
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public DoctorGroup getDefaultDoctorGroup() {
		try {
			return this.getHibernateTemplate().load(DoctorGroup.class, 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Hospital getHospitalById(int hospital_id) {
		try {
			return this.getHibernateTemplate().load(Hospital.class, hospital_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings({ "unchecked", "finally" })
	@Override
	public boolean isHasPermission(DoctorGroup doctorGroup, PatientGroup patientGroup, int permission_id) {
		int doctorGroupId = doctorGroup.getUserGroup().getId();
		int patientGroupId = patientGroup.getUserGroup().getId();
		Boolean flag = false;
		try {
			List<UserGroupPermission> list = this
					.getHibernateTemplate()
					.find("from UserGroupPermission as p where p.userGroupByUserGroup1Id.id = ? and p.userGroupByUserGroup2Id.id = ? and p.permission.id = ?",
							new Object[] { doctorGroupId, patientGroupId, permission_id });
			if (!list.isEmpty()) {
				flag = true;
			}
			System.out.println("flag="+flag);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("flag="+flag);
			flag = false;
		} finally {
			return flag;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean hasPatien(int doctor_id, int patient_id) {
		try {
			List<PatientHasDoctor> list = this.getHibernateTemplate().find(
					"from PatientHasDoctor as phd where phd.id.patient.id = ? and phd.id.doctor.id = ?",
					new Object[] { patient_id, doctor_id });
			if(list.isEmpty()){
				return false;
			}else{
				for (PatientHasDoctor patientHasDoctor : list) {
					System.out.println("&&&&&&&&&&&&&&&&&&&"+patientHasDoctor);
				}
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient getPatientByIdNumber(String idNumber) {
		try {
			List<Patient> list = this.getHibernateTemplate().find("from Patient as p where p.idNumber = ?",
					new Object[] { idNumber });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updatePatient(Patient patient) {
		try {
			System.out.println(patient.getHtnPatientInfos());
			this.getHibernateTemplate().saveOrUpdate(patient);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MedicineUnit> getmedicineUnitList() {
		try {
			return this.getHibernateTemplate().find("from MedicineUnit");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MealTime> getMealTimeList() {
		try {
			return this.getHibernateTemplate().find("from MealTime");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medicine> getMedicineList() {
		try {
			return this.getHibernateTemplate().find("from Medicine");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Emr getEmrById(String emr_id) {
		try {
			Integer id = Integer.parseInt(emr_id);
			return this.getHibernateTemplate().load(Emr.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addEmr(Emr emr) {
		try {
			this.getHibernateTemplate().save(emr);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
