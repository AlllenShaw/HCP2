package com.web.util;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

@SuppressWarnings("unchecked")
public class MyHibernateCallback implements HibernateCallback {

	private String hql;
	private int pageIndex;
	private int pageSize;
	private int id;
	private String startTime;
	private String endTime;

	/**
	 * @param hql
	 * @param pageIndex
	 * @param pageSize
	 * @param id
	 * @param startTime
	 * @param endTime
	 */
	public MyHibernateCallback(String hql, int pageIndex, int pageSize, int id) {
		super();
		this.hql = hql;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.id = id;

	}

	@Override
	public List doInHibernate(Session session) throws HibernateException,
			SQLException {
		Query query = session.createQuery(hql);
		query.setFirstResult(pageIndex * pageSize);
		query.setMaxResults(pageSize);
		query.setInteger(0, id);

		return query.list();
	}

}
