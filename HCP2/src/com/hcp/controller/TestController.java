package com.hcp.controller;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

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
		return "/test/result";
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
		return "/test/result";
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
		return "/test/result";
	}

	@RequestMapping("/list")
	public String list() {
		List<SuperAdministrator> lists = tdao.list();
		Iterator<SuperAdministrator> it = lists.iterator();
		while (it.hasNext()) {
			SuperAdministrator sa = it.next();
			System.out.println(sa.getId() + " " + sa.getUsername() + " " + sa.getPassword());
		}
		return "/test/result";
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
		return "/test/result";
	}

	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(HttpServletRequest request, ModelAndView modelAndView){
		return "/test/login";
	}
	
//	
//	@RequestMapping(value="/login",method=RequestMethod.POST)
//	public String login(HttpServletRequest request, ModelAndView modelAndView,String username,String password){
//		System.out.println("-------------------------------------");
//		System.out.println(username+" "+password);
//		modelAndView.setViewName("");
//		return "redirect:/test/welcome.do";
//	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, Model model,String username,String password){
		System.out.println("-------------------------------------");
		System.out.println(username+" "+password);
		model.addAttribute("username", username);
		model.addAttribute("password",password);
		return "/test/welcome";
//		return "redirect:/test/welcome.do";
	}
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcome(HttpServletRequest request, Model model){
		System.out.println("------------WELCOME-------------------");
		return "/test/welcome";
	}
}
