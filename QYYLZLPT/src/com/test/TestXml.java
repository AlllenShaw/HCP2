package com.test;

import org.dom4j.DocumentException;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestXml {
	public static void main(String[] args) throws DocumentException {

		Configuration configuration = new Configuration().configure();
		SchemaExport export = new SchemaExport(configuration);
		export.create(true, true);

		// Map<String, Boolean> map = new HashMap<String, Boolean>();
		// map.put("B-chao", false);
		// map.put("fangshe", true);
		// Set<String> set = new HashSet<String>();
		// set.add("B-chao");
		// set.add("fangshe");
		// System.out.println(PremissionForHospitalUtil.removePremission(1, 7,
		// set));
		//
		// System.out.println(PremissionForHospitalUtil.createPremissionFile(2,
		// 7));

		// SessionFactory sfFactory = new Configuration().configure()
		// .buildSessionFactory();
		// HibernateTemplate hibernateTemplate = new
		// HibernateTemplate(sfFactory);
		// HosptialAdminDaoImpl hosptialAdminDaoImpl = new
		// HosptialAdminDaoImpl();
		//
		// hosptialAdminDaoImpl.setHibernateTemplate(hibernateTemplate);
		// List<Hospital> list = hosptialAdminDaoImpl.getHospitals(2);
		// for (Hospital hospital : list) {
		// System.out.println(hospital.toString());
		// }
	}
}
