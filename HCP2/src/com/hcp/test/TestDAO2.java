package com.hcp.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcp.domain.SuperAdministrator;

@Repository
public class TestDAO2 extends HibernateDaoSupport {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	public void add(SuperAdministrator sa) {
		this.getHibernateTemplate().save(sa);
		this.getHibernateTemplate().flush();
		System.out.println("save success!");
	}

	public void update(SuperAdministrator sa) {
		this.getHibernateTemplate().update(sa);
		this.getHibernateTemplate().flush();
		System.out.println("update success!");
	}

	public void delete(int id) {
		SuperAdministrator sa = this.load(id);
		this.getHibernateTemplate().delete(sa);
		this.getHibernateTemplate().flush();
		System.out.println("delete success!");
	}

	public SuperAdministrator load(int id) {
		SuperAdministrator sa = this.getHibernateTemplate().load(SuperAdministrator.class, id);
		System.out.println("success load" + id);
		System.out.println(sa);
		return sa;
	}

	public List<SuperAdministrator> list() {
		List list = this.getSession().createQuery("from SuperAdministrator").list();
		System.out.println("list success!---"+list);
		return list;
	}

}
