package com.hcp.dao.imp;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcp.dao.HospitalAdminDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.HospitalHasHospital;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.Permission;
import com.hcp.domain.UserGroup;
import com.hcp.domain.UserGroupPermission;

@Repository
public class HospitalAdminDAOImp extends HibernateDaoSupport implements HospitalAdminDAO {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public HospitalAdministrator getHospitalAdminById(Integer id) {
		try {
			return this.getHibernateTemplate().load(HospitalAdministrator.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public HospitalAdministrator getHospitalAdminByName(String username) {
		try {
			List<HospitalAdministrator> list = this.getHibernateTemplate().find(
					"from HospitalAdministrator as ha where ha.username = ?", new Object[] { username });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isNameExist(String username) {
		try {
			List<HospitalAdministrator> list = this.getHibernateTemplate().find(
					"from HospitalAdministrator as ha where ha.username = ?", new Object[] { username });
			return list.isEmpty();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public HospitalAdministrator login(String username, String password) {
		try {
			List<HospitalAdministrator> list = this.getHibernateTemplate().find(
					"from HospitalAdministrator as ha where ha.username = ? and ha.password=?",
					new Object[] { username, password });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Hospital getHospital(HospitalAdministrator hospitalAdministrator) {
		try {
			return hospitalAdministrator.getHospital();
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

	@Override
	public boolean addDoctor(Doctor doctor) {
		try {
			this.getHibernateTemplate().save(doctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Doctor getDoctorByID(Integer doctor_id) {
		try {
			return this.getHibernateTemplate().load(Doctor.class, doctor_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Doctor getDoctorByName(String doctor_username) {
		try {
			List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.username = ?",
					new Object[] { doctor_username });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorByRealName(final String realname, HospitalAdministrator hospitalAdministrator) {
		try {
			final int hospital_id = hospitalAdministrator.getHospital().getId();
			List<Doctor> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<Doctor>>() {
				@Override
				public List<Doctor> doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("select d from Doctor as d where d.realname like:realname and d.hospital.id=:hospital_id");
					query.setString("realname", realname);
					query.setInteger("hospital_id", hospital_id);
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
	public boolean deleteDoctor(Doctor doctor) {
		try {
			this.getHibernateTemplate().delete(doctor);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateHospitalAdministrator(HospitalAdministrator hospitalAdministrator) {
		try {
			this.getHibernateTemplate().update(hospitalAdministrator);
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
	public Medicine getMedicineByName(String medicine_name) {
		try {
			List<Medicine> list = this.getHibernateTemplate().find("from Medicine as m where m.name =?",
					new Object[] { medicine_name });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addMedicine(Medicine medicine) {
		try {
			this.getHibernateTemplate().save(medicine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteMedicine(Medicine medicine) {
		try {
			this.getHibernateTemplate().delete(medicine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateMedicine(Medicine medicine) {
		try {
			this.getHibernateTemplate().update(medicine);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean newGroup(UserGroup userGroup) {
		try {
			this.getHibernateTemplate().save(userGroup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addDoctor2Group(DoctorGroup doctorGroup) {
		try {
			this.getHibernateTemplate().save(doctorGroup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addPatient2Group(PatientGroup patientGroup) {
		try {
			this.getHibernateTemplate().save(patientGroup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean setGroupPermission(UserGroupPermission userGroupPermission) {
		try {
			this.getHibernateTemplate().save(userGroupPermission);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Permission> getPermissionsList() {
		try {
			List<Permission> list = this.getHibernateTemplate().find("from Permission");
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteDoctorGroup(String doctor_id, String group_id) {
		try {
			// TODO Auto-generated method stub
			// 根据doctor_id和group_id找到doctorGroup
			Integer did = Integer.parseInt(doctor_id);
			Integer gid = Integer.parseInt(group_id);
			List<DoctorGroup> list = this.getHibernateTemplate().find(
					"from DoctorGroup as dg where dg.doctor.id = ? and dg.userGroup.id = ? ", new Object[] { did, gid });
			DoctorGroup doctorGroup = list.isEmpty() ? null : list.get(0);
			// 删除doctorGroup
			this.getHibernateTemplate().delete(doctorGroup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean deletePatientGroup(String patient_id, String group_id) {
		try {
			// 根据patient_id和group_id找到patientGroup
			List<PatientGroup> list = this.getHibernateTemplate().find(
					"from PatientGroup as pg where pg.patient.id = ? and pg.userGroup.id = ? ",
					new Object[] { patient_id, group_id });
			PatientGroup patientGroup = list.isEmpty() ? null : list.get(0);
			// 删除doctorGroup
			this.getHibernateTemplate().delete(patientGroup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getNumberByGroupId(final String group_id) {
		try {
			List<Doctor> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<Doctor>>() {
				int id = Integer.parseInt(group_id);

				@Override
				public List<Doctor> doInHibernate(Session session) throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					Query query = session.createQuery("select dg.doctor from DoctorGroup as dg.userGroup.id =:id");
					query.setInteger("id", id);
					return query.list();
				}
			});
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserGroupPermission getGroupPermissionn(String group_id1, String group_id2, String permission_id) {
		try {
			Integer id1 = Integer.parseInt(group_id1);
			Integer id2 = Integer.parseInt(group_id2);
			Integer pid = Integer.parseInt(permission_id);
			List<UserGroupPermission> list = this
					.getHibernateTemplate()
					.find("from UserGroupPermission as p where p.userGroupByUserGroup1Id.id = ? and p.userGroupByUserGroup2Id.id = ? and p.permission.id = ?",
							new Object[] { id1, id2, pid });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addUserGroup(UserGroup userGroup) {
		try {
			this.getHibernateTemplate().save(userGroup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public UserGroup getUserGroupById(int id) {
		try {
			return this.getHibernateTemplate().load(UserGroup.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addDoctorGroup(DoctorGroup doctorGroup) {
		try {
			this.getHibernateTemplate().save(doctorGroup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Patient getPatientById(int id) {
		try {
			return this.getHibernateTemplate().load(Patient.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addPatientGroup(PatientGroup patientGroup) {
		try {
			this.getHibernateTemplate().save(patientGroup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Permission getPermissionById(int id) {
		try {
			return this.getHibernateTemplate().load(Permission.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteUserGroupPermission(UserGroupPermission userGroupPermission) {
		try {
			this.getHibernateTemplate().delete(userGroupPermission);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Hospital getHospitalById(int id) {
		try {
			return this.getHibernateTemplate().load(Hospital.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DoctorGroup> getDoctorGroupByHospital(Integer hospital_id) {
		try {
			List<DoctorGroup> list = this.getHibernateTemplate().find(
					"from DoctorGroup as dg where dg.userGroup.hospital.id = ?", new Object[] { hospital_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PatientGroup> getPatientGroupByHospital(Integer hospital_id) {
		try {
			List<PatientGroup> list = this.getHibernateTemplate().find(
					"from PatientGroup as pg where pg.userGroup.hospital.id = ?", new Object[] { hospital_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserGroup> getPatientUserGroupByHospital(final Integer hospital_id) {
		// List<UserGroup> list =
		// this.getHibernateTemplate().find("select dg.userGroup from PatientGroup as pg where pg.userGroup.hospital.id = ?",
		// new Object[] { hospital_id });
		try {
			List<UserGroup> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<UserGroup>>() {
				@Override
				public List<UserGroup> doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("select pg.userGroup form PatientGroup as pg where pg.userGroup.hospital.id =:hospital_id");
					query.setInteger("hospital_id", hospital_id);
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
	public List<UserGroup> getDoctorUserGroupByHospital(final Integer hospital_id) {
		// List<UserGroup> list =
		// this.getHibernateTemplate().find("select dg.userGroup from DoctorGroup as dg where dg.userGroup.hospital.id = ?",
		// new Object[] { hospital_id });
		try {
			List<UserGroup> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<UserGroup>>() {
				@Override
				public List<UserGroup> doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("select dg.userGroup form DoctorGroup as dg where dg.userGroup.hospital.id =:hospital_id");
					query.setInteger("hospital_id", hospital_id);
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
	public List<UserGroup> getUserGroupByHospital(Integer hospital_id) {
		try {
			List<UserGroup> list = this.getHibernateTemplate().find("from UserGroup as ug where ug.hospital.id = ?",
					new Object[] { hospital_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteUserGroup(UserGroup userGroup) {
		try {
			this.getHibernateTemplate().delete(userGroup);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorByHospital(Integer id) {
		try {
			List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.hospital.id = ?", new Object[] { id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> getPatientByHospital(Integer id) {
		try {
			return this.getHibernateTemplate().find("from Patient as p where p.hospital.id = ?", new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> getCopHospital(Integer hospital_id) {
		try {
			List<HospitalHasHospital> list = this.getHibernateTemplate().find(
					"from HospitalHasHospital as h where h.hospitalByHospital1.id = ?", new Object[] { hospital_id });
			List<Hospital> hospitals = new ArrayList<Hospital>();
			for (HospitalHasHospital h : list) {
				hospitals.add(h.getHospitalByHospital2());
			}
			return hospitals.isEmpty() ? null : hospitals;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> getAllHospital() {
		try {
			List<Hospital> list = this.getSession().createQuery("from Hospital").list();
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addCoHospital(HospitalHasHospital hospitalHasHospital) {
		try {
			this.getHibernateTemplate().save(hospitalHasHospital);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public HospitalHasHospital getCopHospital(Hospital hospital) {
		try {
			List<HospitalHasHospital> list = this.getHibernateTemplate().find(
					"from HospitalHasHospital as h where h.hospitalByHospital1.id = ?", new Object[] { hospital.getId() });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public boolean deleteCoHospital(HospitalHasHospital hospitalHasHospitals) {
		try {
			this.getHibernateTemplate().delete(hospitalHasHospitals);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient getPatientByIdNumber(String idNumber) {
		List<Patient> list = null;
		try {
			list = this.getHibernateTemplate().find("from Patient as p where p.idNumber = ?", new Object[] { idNumber });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public Patient getPatientByName(String username) {
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		List<Patient> list = null;
		try {
			list = this.getHibernateTemplate().find("from Patient as p where p.username = ?", new Object[] { username });
			System.out.println(list + "   " + list.get(0));
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean setGluTime(String patient_id, String bg_remain_time) {
		final Integer remainTime = Integer.parseInt(bg_remain_time);
		final Integer id = Integer.parseInt(patient_id);
		try {
			this.getHibernateTemplate().execute(new HibernateCallback<Objects>() {
				@Override
				public Objects doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("update GluPatientInfo g set g.remainTime =:remainTime where g.patientId =:id");
					query.setInteger("remainTime", remainTime);
					query.setInteger("id", id);
					query.executeUpdate();
					return null;
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean setHtnTime(String patient_id, String bp_remain_time) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(bp_remain_time);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (date == null) {
			return false;
		}
		final Timestamp remainTime = new Timestamp(date.getTime());
		final Integer id = Integer.parseInt(patient_id);
		try {
			this.getHibernateTemplate().execute(new HibernateCallback<Objects>() {
				@Override
				public Objects doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("update HtnPatientInfo g set g.remainTime =:remainTime where g.patientId =:id");
					query.setTimestamp("remainTime", remainTime);
					query.setInteger("id", id);
					query.executeUpdate();
					return null;
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean setBoTime(String patient_id, String spo_remain_time) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse(spo_remain_time);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		if (date == null) {
			return false;
		}
		final Timestamp remainTime = new Timestamp(date.getTime());
		final Integer id = Integer.parseInt(patient_id);
		try {
			this.getHibernateTemplate().execute(new HibernateCallback<Objects>() {
				@Override
				public Objects doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session
							.createQuery("update BoPatientInfo g set g.remainTime =:remainTime where g.patientId =:id");
					query.setTimestamp("remainTime", remainTime);
					query.setInteger("id", id);
					query.executeUpdate();
					return null;
				}
			});
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
