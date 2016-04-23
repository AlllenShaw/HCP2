package com.hcp.controller;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcp.domain.SuperAdministrator;
import com.hcp.test.TestDAO;
import com.hcp.test.TestDAO2;

@Controller
@RequestMapping("/test")
public class TestController {

	@Resource
	private TestDAO2 tdao;
	
	@RequestMapping("/add")
	public String add(String username, String password){
		SuperAdministrator sa = new SuperAdministrator();
		sa.setUsername("kobe");
		sa.setRealname("xiaoxin");
		sa.setIdNumber("43902771234");
		sa.setPassword("123");
		sa.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		System.out.println(tdao);
		System.out.println(sa);
		
		tdao.add(sa);
//		tdao.load(1);
		return "/result";
	}
}
