package com.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.web.dao.fina.impl.DoctorDaoImpl;
import com.web.dao.fina.impl.PatientDaoImpl;

public class TestOne2Many {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sf);
		// Session session = sf.openSession();
		DoctorDaoImpl daoImp = new DoctorDaoImpl();

		PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
		// patientDaoImpl.setHibernateTemplate(hibernateTemplate);
		// Patient p = patientDaoImpl.patientLogin("1", "1");
		// System.out.println(p.getAddress());

		// daoImp.setHibernateTemplate(hibernateTemplate);

		System.out.println(daoImp.exisitName("12345"));

		// List<Patients> patients = daoImp.queryPatient(1);
		// for (Patients patient : patients) {
		// System.out.println("address id = " + patient.getAddress());
		// }

	}

}
