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

import com.hcp.dao.SuperAdminDAO;
import com.hcp.domain.AppVersion;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.Patient;
import com.hcp.domain.SuperAdministrator;

@Repository
public class SuperAdminDAOImp extends HibernateDaoSupport implements SuperAdminDAO {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	@Override
	public SuperAdministrator getSuperAdminiByID(Integer id) {
		try {
			return this.getHibernateTemplate().load(SuperAdministrator.class, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public SuperAdministrator getSuperAdminiByName(String username) {
		try {
			List<SuperAdministrator> list = this.getHibernateTemplate().find(
					"from SuperAdministrator as sa where sa.username = ?", new Object[] { username });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public SuperAdministrator login(String username, String password) {
		try {
			List<SuperAdministrator> list = this.getHibernateTemplate().find(
					"from SuperAdministrator as sa where sa.username = ? and sa.password=?", new Object[] { username, password });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean deleteHospital(Hospital hospital) {
		try {
			this.getHibernateTemplate().delete(hospital);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addHosptial(Hospital hospital) {
		try {
			this.getHibernateTemplate().save(hospital);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
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

	@Override
	public Hospital getHospitalById(Integer hospital_id) {
		try {
			return this.getHibernateTemplate().load(Hospital.class, hospital_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Hospital getHospitalByName(String hospital_name) {
		try {
			List<Hospital> list = this.getHibernateTemplate().find("from Hospital as h where h.name = ?",
					new Object[] { hospital_name });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HospitalAdministrator> getHospitalAdministrators(Integer hospital_id) {
		try {
			List<HospitalAdministrator> list = this.getHibernateTemplate().find(
					"form HospitalAdministrator as ha where ha.hospital.id = ?", new Object[] { hospital_id });
			return list.isEmpty() ? null : list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public HospitalAdministrator getHospitalAdministratorByID(Integer admin_id) {
		try {
			return this.getHibernateTemplate().load(HospitalAdministrator.class, admin_id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public HospitalAdministrator getHospitalAdministratorByName(String admin_username) {
		try {
			List<HospitalAdministrator> list = this.getHibernateTemplate().find(
					"form HospitalAdministrator as ha where ha.username = ?", new Object[] { admin_username });
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<HospitalAdministrator> getHospitalAdministratorByRealName(final String realname) {
		try {
			List<HospitalAdministrator> list = this.getHibernateTemplate().executeFind(
					new HibernateCallback<List<HospitalAdministrator>>() {
						@Override
						public List<HospitalAdministrator> doInHibernate(Session session) throws HibernateException, SQLException {
							// TODO Auto-generated method stub
							Query query = session
									.createQuery("select ha from HospitalAdministrator as ha where ha.realname like :realname");
							query.setString("realname", realname);
							return query.list();
						}
					});
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addospitalAdministrator(HospitalAdministrator hospitalAdministrator) {
		try {
			this.getHibernateTemplate().save(hospitalAdministrator);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteHospitalAdministrator(HospitalAdministrator hospitalAdministrator) {
		try {
			this.getHibernateTemplate().delete(hospitalAdministrator);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HospitalAdministrator> getHospitalAdministratorsList() {
		try {
			return this.getHibernateTemplate().find("from HospitalAdministrator");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HospitalAdministrator> getHospitalAdminByHospital(String hospital_id) {
		try {
			Integer id = Integer.parseInt(hospital_id);
			return this.getHibernateTemplate().find("from HospitalAdministrator as h where h.hospital.id = ?",
					new Object[] { id });
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addAppVersion(AppVersion appVersion) {
		try {
			this.getHibernateTemplate().save(appVersion);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
