package com.test;

public class TestLikeQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// SessionFactory sfFactory = new Configuration().configure()
		// .buildSessionFactory();
		// HibernateTemplate hibernateTemplate = new
		// HibernateTemplate(sfFactory);
		// DoctorDaoImpl impl = new DoctorDaoImpl();
		// impl.setHibernateTemplate(template);
		// List<Patient> patients = impl.searchPatients(1, "ingaf");
		// for (Patient patient : patients) {
		// System.out.println("patient id = " + patient.getId());
		// }

		String s = "http://localhost:8080/QYYLZLPT/doctor/bingRenLieBiao.do";
		String[] strings = s.split("/");
		System.out.println(strings[strings.length - 1]);

		// HosptialAdminDaoImpl hosptialAdminDaoImpl = new
		// HosptialAdminDaoImpl();
		// hosptialAdminDaoImpl.setHibernateTemplate(hibernateTemplate);
		// List<DoctorOperPremissionId> list = hosptialAdminDaoImpl
		// .getDoctorPremission(2);
		//
		// for (DoctorOperPremissionId doctorOperPremissionId : list) {
		// System.out.println(doctorOperPremissionId.getOperation());
		// System.out.println(doctorOperPremissionId.getDoctorPremission()
		// .getId());
		// }

	}

}
