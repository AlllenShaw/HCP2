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

import com.hcp.dao.HospitalAdminDAO;
import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
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
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(HospitalAdministrator.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public HospitalAdministrator getHospitalAdminByName(String username) {
		// TODO Auto-generated method stub
		List<HospitalAdministrator> list = this.getHibernateTemplate().find(
				"from HospitalAdministrator as ha where ha.username = ?", new Object[] { username });
		return list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean isNameExist(String username) {
		// TODO Auto-generated method stub
		List<HospitalAdministrator> list = this.getHibernateTemplate().find(
				"from HospitalAdministrator as ha where ha.username = ?", new Object[] { username });
		return list.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public HospitalAdministrator login(String username, String password) {
		// TODO Auto-generated method stub
		List<HospitalAdministrator> list = this.getHibernateTemplate().find(
				"from HospitalAdministrator as ha where ha.username = ? and ha.password=?", new Object[] { username, password });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public Hospital getHospital(HospitalAdministrator hospitalAdministrator) {
		// TODO Auto-generated method stub
		return hospitalAdministrator.getHospital();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hospital> getHospitalsList() {
		// TODO Auto-generated method stub
		List<Hospital> list = this.getSession().createQuery("from Hospital").list();
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctors(Integer hospital_id) {
		// TODO Auto-generated method stub
		List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.hospital.id = ?",
				new Object[] { hospital_id });
		return list.isEmpty() ? null : list;
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(Doctor.class, doctor_id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Doctor getDoctorByName(String doctor_username) {
		// TODO Auto-generated method stub
		List<Doctor> list = this.getHibernateTemplate().find("from Doctor as d where d.username = ?",
				new Object[] { doctor_username });
		return list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getDoctorByRealName(final String realname, HospitalAdministrator hospitalAdministrator) {
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
	}

	@Override
	public boolean deleteDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Medicine");
	}

	@SuppressWarnings("unchecked")
	@Override
	public Medicine getMedicineById(Integer medicine_id) {
		// TODO Auto-generated method stub
		List<Medicine> list = this.getHibernateTemplate().find("from Medicine as m where m.id = ?", new Object[] { medicine_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Medicine getMedicineByName(String medicine_name) {
		// TODO Auto-generated method stub
		List<Medicine> list = this.getHibernateTemplate().find("from Medicine as m where m.name =?",
				new Object[] { medicine_name });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean addMedicine(Medicine medicine) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		List<Permission> list = this.getHibernateTemplate().find("from Permission");
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteDoctorGroup(String doctor_id, String group_id) {
		// TODO Auto-generated method stub
		// 根据doctor_id和group_id找到doctorGroup
		List<DoctorGroup> list = this.getHibernateTemplate().find(
				"from DoctorGroup as dg where dg.doctor.id = ? and dg.userGroup.id = ? ", new Object[] { doctor_id, group_id });
		DoctorGroup doctorGroup = list.isEmpty() ? null : list.get(0);
		// 删除doctorGroup
		this.getHibernateTemplate().delete(doctorGroup);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deletePatientGroup(String patient_id, String group_id) {
		// TODO Auto-generated method stub
		// 根据patient_id和group_id找到patientGroup
		List<PatientGroup> list = this.getHibernateTemplate()
				.find("from PatientGroup as pg where pg.patient.id = ? and pg.userGroup.id = ? ",
						new Object[] { patient_id, group_id });
		PatientGroup patientGroup = list.isEmpty() ? null : list.get(0);
		// 删除doctorGroup
		this.getHibernateTemplate().delete(patientGroup);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> getNumberByGroupId(final String group_id) {
		// TODO Auto-generated method stub
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
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserGroupPermission getGroupPermissionn(String group_id1, String group_id2, String permission_id) {
		// TODO Auto-generated method stub
		List<UserGroupPermission> list = this
				.getHibernateTemplate()
				.find("from UserGroupPermission as p where p.userGroupByUserGroup1Id.id = ? and p.userGroupByUserGroup2Id.id = ? and p.permission.id = ?",
						new Object[] { group_id1, group_id2, permission_id });
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public boolean addUserGroup(UserGroup userGroup) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(UserGroup.class, id);
	}

	@Override
	public boolean addDoctorGroup(DoctorGroup doctorGroup) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(Patient.class, id);
	}

	@Override
	public boolean addPatientGroup(PatientGroup patientGroup) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(Permission.class, id);
	}

	@Override
	public boolean deleteUserGroupPermission(UserGroupPermission userGroupPermission) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().load(Hospital.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DoctorGroup> getDoctorGroupByHospital(Integer hospital_id) {
		// TODO Auto-generated method stub
		List<DoctorGroup> list = this.getHibernateTemplate().find("from DoctorGroup as dg where dg.userGroup.hospital.id = ?",
				new Object[] { hospital_id });
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PatientGroup> getPatientGroupByHospital(Integer hospital_id) {
		List<PatientGroup> list = this.getHibernateTemplate().find("from PatientGroup as pg where pg.userGroup.hospital.id = ?",
				new Object[] { hospital_id });
		return list.isEmpty() ? null : list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserGroup> getPatientUserGroupByHospital(final Integer hospital_id) {
//		List<UserGroup> list = this.getHibernateTemplate().find("select dg.userGroup from PatientGroup as pg where pg.userGroup.hospital.id = ?",
//				new Object[] { hospital_id });
		
		List<UserGroup> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<UserGroup>>() {
			@Override
			public List<UserGroup> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("select pg.userGroup form PatientGroup as pg where pg.userGroup.hospital.id =:hospital_id");
				query.setInteger("hospital_id", hospital_id);
				return query.list();
			}
		});
		return list.isEmpty() ? null : list;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserGroup> getDoctorUserGroupByHospital(final Integer hospital_id) {
//		List<UserGroup> list = this.getHibernateTemplate().find("select dg.userGroup from DoctorGroup as dg where dg.userGroup.hospital.id = ?",
//				new Object[] { hospital_id });
		List<UserGroup> list = this.getHibernateTemplate().executeFind(new HibernateCallback<List<UserGroup>>() {
			@Override
			public List<UserGroup> doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createQuery("select dg.userGroup form DoctorGroup as dg where dg.userGroup.hospital.id =:hospital_id");
				query.setInteger("hospital_id", hospital_id);
				return query.list();
			}
		});
		return list.isEmpty() ? null : list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserGroup> getUserGroupByHospital(Integer hospital_id) {
		List<UserGroup> list = this.getHibernateTemplate().find("from UserGroup as ug where ug.hospital.id = ?",
				new Object[] { hospital_id });
		return list.isEmpty() ? null : list;
	}
}
