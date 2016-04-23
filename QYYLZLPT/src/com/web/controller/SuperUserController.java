package com.web.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.domain.Authority;
import com.bean.domain.Hospital;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.SuperAdministrator;
import com.web.service.SuperUserService;
import com.web.util.SessionUtil;

@Controller
@RequestMapping("/admin")
public class SuperUserController {
	@Resource
	private SuperUserService superUserService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			ModelAndView modelAndView) {
		modelAndView.setViewName("login/login_supadmin");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
			ModelAndView modelAndView, String username, String password) {
		SuperAdministrator superAdministrator = superUserService
				.superUserLogin(username, password);

		if (superAdministrator == null) {
			modelAndView.setViewName("login/login_supadmin");
			return modelAndView;
		}
		SessionUtil sessionUtil = new SessionUtil(request);
		sessionUtil.setAttribute("USERMODEL", superAdministrator);
		modelAndView.addObject("username", superAdministrator.getUsername());
		modelAndView.addObject("userid", superAdministrator.getId());
		modelAndView.setViewName("redirect:/admin/index.do");
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		sessionUtil.removeAttrtube("USERMODEL");
		modelAndView.setViewName("redirect:/admin/login.do");
		return modelAndView;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request,
			ModelAndView modelAndView, String username, String password) {

		SessionUtil sessionUtil = new SessionUtil(request);
		SuperAdministrator superAdministrator = (SuperAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", superAdministrator.getUsername());
		modelAndView.addObject("userid", superAdministrator.getId());
		modelAndView.setViewName("/supadmin/supadmin");
		return modelAndView;
	}

	@RequestMapping(value = "/addHospital", method = RequestMethod.GET)
	public ModelAndView addHopsitalEntity(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		SuperAdministrator superAdministrator = (SuperAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", superAdministrator.getUsername());
		modelAndView.addObject("userid", superAdministrator.getId());
		modelAndView.setViewName("/supadmin/addrealhospital");
		return modelAndView;

	}

	@RequestMapping(value = "/addHospital", method = RequestMethod.POST)
	public ModelAndView addHopsitalEntity(HttpServletRequest request,
			ModelAndView modelAndView, Hospital hospital,
			HospitalAdministrator hospitalAdministrator) {

		SessionUtil sessionUtil = new SessionUtil(request);
		SuperAdministrator superAdministrator = (SuperAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", superAdministrator.getUsername());
		modelAndView.addObject("userid", superAdministrator.getId());

		System.out.println(hospital);
		System.out.println(hospitalAdministrator);

		Authority authority = new Authority();
		authority.setId(1);
		hospitalAdministrator.setAuthority(authority);

		hospitalAdministrator.setCreateTime(new Date());
		hospital.setRegisterTime(new Date());

		Set<HospitalAdministrator> hospitalAdministrators = new HashSet<HospitalAdministrator>();
		hospitalAdministrators.add(hospitalAdministrator);
		hospital.setHospitalAdministrators(hospitalAdministrators);

		superUserService.addHospital(hospital);
		modelAndView.setViewName("redirect:/admin/index.do");
		return modelAndView;
	}

	@RequestMapping(value = "/adminManage", method = RequestMethod.GET)
	public ModelAndView adminManage(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		SuperAdministrator superAdministrator = (SuperAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", superAdministrator.getUsername());
		modelAndView.addObject("userid", superAdministrator.getId());
		modelAndView.setViewName("/supadmin/renyuanguanli");
		return modelAndView;

	}

	@RequestMapping(value = "/pingtaizhicheng", method = RequestMethod.GET)
	public ModelAndView name(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		SuperAdministrator administrator = (SuperAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", administrator.getUsername());
		modelAndView.addObject("userid", administrator.getId());
		modelAndView.setViewName("pingtaizhicheng/pingtaizhicheng_supadmin");
		return modelAndView;

	}

	@RequestMapping(value = "/getAllHospital", method = RequestMethod.POST)
	@ResponseBody
	public String getAllHospital(HttpServletRequest request) {
		JSONArray array = superUserService.getAllHospital();

		JSONObject result = new JSONObject();
		result.put("result", 1);
		result.put("list", array);
		System.out.println("all hospital : " + result.toString());
		return result.toString();

	}

	@RequestMapping(value = "/addHosAdmin", method = RequestMethod.POST)
	public ModelAndView addHosAdmin(HttpServletRequest request,
			ModelAndView modelAndView,
			HospitalAdministrator hospitalAdministrator, Integer hospital_id) {

		SessionUtil sessionUtil = new SessionUtil(request);
		SuperAdministrator superAdministrator = (SuperAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", superAdministrator.getUsername());
		modelAndView.addObject("userid", superAdministrator.getId());

		Hospital hospital = new Hospital();
		hospital.setId(hospital_id);

		Authority authority = new Authority();
		authority.setId(1);

		hospitalAdministrator.setHospital(hospital);
		hospitalAdministrator.setAuthority(authority);
		hospitalAdministrator.setCreateTime(new Date());

		if (!superUserService.addHospitalAdministrator(hospitalAdministrator)) {
			modelAndView.setViewName("/supadmin/renyuanguanli");
		}

		modelAndView.setViewName("/supadmin/renyuanguanli");
		return modelAndView;

	}

	@RequestMapping(value = "/getHospitalInfo", method = RequestMethod.POST)
	@ResponseBody
	public String getHospitalInfo(HttpServletRequest request,
			Integer hospital_id) {
		JSONObject result = superUserService.getHospitalInfo(hospital_id);
		if (result == null) {
			result = new JSONObject();
			result.put("result", 0);
			System.out.println("all hospital : " + result.toString());
			return result.toString();
		}
		JSONArray array = superUserService
				.getHospitalAdministrators(hospital_id);
		result.put("result", 1);
		result.put("list", array);
		System.out.println("all hospital : " + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/getHosAdminInfo", method = RequestMethod.POST)
	@ResponseBody
	public String getHosAdminInfo(HttpServletRequest request, Integer admin_id) {
		JSONObject result = superUserService
				.getHospitalAdministratorInfo(admin_id);
		if (result == null) {
			result = new JSONObject();
			result.put("result", 0);
			System.out.println(" hospital admininfo : " + result.toString());
			return result.toString();
		}
		result.put("result", 1);
		System.out.println("  hospital  admininfo : " + result.toString());
		return result.toString();
	}

	/*
	 * @RequestMapping(value = "/getHosAdminList", method = RequestMethod.POST)
	 * public String getHosAdminList(HttpServletRequest request, Integer
	 * hospital_id) { JSONArray array = superUserService
	 * .getHospitalAdministrators(hospital_id);
	 * 
	 * JSONObject result = new JSONObject(); result.put("result", 1);
	 * result.put("list", array); System.out.println("all hospital : " +
	 * result.toString()); return result.toString(); }
	 */
	@RequestMapping(value = "/deleteHosAdmin", method = RequestMethod.POST)
	@ResponseBody
	public String deleteHosAdmin(HttpServletRequest request, Integer admin_id,
			Integer hospital_id) {

		JSONObject result = new JSONObject();
		if (superUserService.deleteHospitalAdministrator(admin_id, hospital_id)) {
			result.put("result", 1);
			System.out.println("delete hospital admin : " + result.toString());
			return result.toString();
		}
		result = new JSONObject();
		result.put("result", 0);
		System.out.println("all hospital : " + result.toString());
		return result.toString();

	}
}
