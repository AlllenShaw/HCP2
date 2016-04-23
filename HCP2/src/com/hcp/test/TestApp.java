package com.hcp.test;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hcp.domain.SuperAdministrator;



public class TestApp {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService1 ts1 = (TestService1) ac.getBean("testService1");
		System.out.println(ts1.getName());
		
		SuperAdministrator sa = new SuperAdministrator();
		sa.setUsername("allen");
		sa.setRealname("xiaoxin");
		sa.setIdNumber("43902771234");
		sa.setPassword("123");
		sa.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		
		System.out.println(sa);
		
		TestDAO tdao = new TestDAO();
		
		tdao.add(sa);
		
	}

}
