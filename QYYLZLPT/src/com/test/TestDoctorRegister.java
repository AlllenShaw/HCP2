package com.test;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.bean.domain.Doctor;
import com.bean.domain.Hospital;
import com.web.dao.fina.impl.DoctorDaoImpl;

public class TestDoctorRegister {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SessionFactory sFactory = new Configuration().configure()
				.buildSessionFactory();
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sFactory);

		Hospital hospital = new Hospital();
		hospital.setId(1);

		Doctor doctor = new Doctor();
		doctor.setHospital(hospital);
		doctor.setUsername("123");
		doctor.setPassword("123");
		doctor.setCertificate("cert11");
		doctor.setRegisterTime(new Date());

		DoctorDaoImpl daoImpl = new DoctorDaoImpl();
		daoImpl.setHibernateTemplate(hibernateTemplate);
		daoImpl.doctorRegister(doctor);

	}

}
