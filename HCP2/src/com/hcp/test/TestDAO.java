package com.hcp.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcp.domain.SuperAdministrator;
import com.hcp.util.Pager;

@Repository
public class TestDAO  {

	@Resource
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public void add(SuperAdministrator sa) {
		System.out.println(hibernateTemplate);
		hibernateTemplate.save(sa);
//		hibernateTemplate.flush();
		System.out.println("save success!");
	}

	public void update(SuperAdministrator sa) {
		hibernateTemplate.update(sa);
		;
	}

	public void delete(SuperAdministrator sa) {
		hibernateTemplate.delete(sa);
	}

	public SuperAdministrator load(int id) {
		List<SuperAdministrator> list = hibernateTemplate.find("select * from SuperAdministrator as sa where sa.id=?",
				new Object[] { id });
		System.out.println("---------------------"+list.get(0).getRealname());
		return (list.isEmpty() ? null : list.get(0));
	}

	public List<SuperAdministrator> list() {
		List<SuperAdministrator> list = hibernateTemplate.find("select * from SuperAdministrator");
		return list.isEmpty() ? null : list;
	}

	// @SuppressWarnings("unchecked")
	// public Pager<SuperAdministrator> find() {
	// int offset = 1;
	// int size = 10;
	// Query query = this.getSession().createQuery("from SuperAdministrator");
	// query.setFirstResult(offset).setMaxResults(size);
	// List<SuperAdministrator> datas = query.list();
	// Pager<SuperAdministrator> hp = new Pager<SuperAdministrator>();
	// hp.setDatas(datas);
	// hp.setOffset(offset);
	// hp.setSize(size);
	// long total = (Long) this.getSession().createQuery("select count(*) from SuperAdministrator").uniqueResult();
	// hp.setTotal(total);
	// return hp;
	// }

}
