package com.hcp.controller;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

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
	public String add(String username, String password) {
		SuperAdministrator sa = new SuperAdministrator();
		sa.setUsername("june");
		sa.setRealname("hong");
		sa.setIdNumber("439027712378");
		sa.setPassword("123");
		sa.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		System.out.println(tdao);
		System.out.println(sa);
		System.out.println(sa.getId() + " " + sa.getUsername() + " " + sa.getRealname());
		;

		tdao.add(sa);
		return "/result";
	}

	@RequestMapping("/update")
	public String update(Integer id, String password) {
		Integer id1 = 1;
		System.out.println("----------------------------------------------------");
		System.out.println(id1);
		System.out.println("----------------------------------------------------");
		SuperAdministrator sa = tdao.load(id1);
		sa.setPassword("new password");
		System.out.println(sa.getId() + " " + sa.getUsername() + " " + sa.getPassword());
		tdao.update(sa);
		return "/result";
	}

	@RequestMapping("/delete")
	public String delete(Integer id) {
		Integer id1 = 1;
		// System.out.println("----------------------------------------------------");
		// System.out.println(id1);
		// System.out.println("----------------------------------------------------");
		// SuperAdministrator sa = tdao.load(id1);
		// System.out.println(sa.getId()+" "+sa.getUsername()+" "+sa.getPassword());
		tdao.delete(id1);
		return "/result";
	}

	@RequestMapping("/list")
	public String list() {
		List<SuperAdministrator> lists = tdao.list();
		Iterator<SuperAdministrator> it = lists.iterator();
		while (it.hasNext()) {
			SuperAdministrator sa = it.next();
			System.out.println(sa.getId() + " " + sa.getUsername() + " " + sa.getPassword());
		}
		return "/result";
	}

	@RequestMapping("/get")
	public String getByName() {
		String username = "james";
		SuperAdministrator sa = tdao.getByName(username);
		if (sa != null) {
			System.out.println(sa.getId() + " " + sa.getUsername() + " " + sa.getPassword());
		} else {
			System.out.println(sa);
		}
		return "/result";
	}

}
