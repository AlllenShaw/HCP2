package com.hcp.test;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcp.domain.SuperAdministrator;

@Repository
public class TestDAO2 extends HibernateDaoSupport {

	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		this.setSessionFactory(sessionFactory);
	}
	
	public void add(SuperAdministrator sa) {
		this.getHibernateTemplate().save(sa);
		System.out.println("save success!");
	}
}
