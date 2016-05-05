package com.hcp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcp.domain.Doctor;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.Patient;
import com.hcp.domain.SuperAdministrator;
import com.hcp.service.DoctorService;
import com.hcp.service.HospitalAdminService;
import com.hcp.service.PatientService;
import com.hcp.service.SuperAdminService;
import com.hcp.util.SessionUtil;

/**
 * 
 * @author Allen 登陆、登出
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private PatientService patientService;

	@Resource
	private DoctorService doctorService;

	@Resource
	private HospitalAdminService hospitalAdminService;

	@Resource
	private SuperAdminService superAdminService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		return "/main/main";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, Model model, String usertype, String username, String password) {
		System.out.println("user login");
		SessionUtil sessionUtil = new SessionUtil(request);

		System.out.println("type  " + usertype + "  username : " + username + " pass " + password);
		System.out.println("session is = " + sessionUtil.getJsessionid());
		
		// 1医生，2患者，3医院管理员，4系统管理员
		switch (usertype) {
		case "1":
			Doctor doctor = doctorService.login(username, password);
			if (doctor == null) {
				return "redirect:/user/login.do";
			}
			sessionUtil.setAttribute("USERMODEL", doctor);
			System.out.println("doctor name : " + doctor.getUsername());
			// model.addAttribute("username", doctor.getUsername());
			// model.addAttribute("userid", doctor.getId());
			model.addAttribute("doctor", doctor);
			return "redirect:/doctor/index.do";
		case "2":
			Patient patient = patientService.login(username, password);
			if (patient == null) {
				return "redirect:/user/login.do";
			}
			sessionUtil.setAttribute("USERMODEL", patient);
			System.out.println("patient name : " + patient.getUsername());
			// model.addAttribute("username", patient.getUsername());
			// model.addAttribute("userid", patient.getId());
			model.addAttribute("patient", patient);
			return "redirect:/patient/index.do";
		case "3":
			HospitalAdministrator hospitalAdministrator = hospitalAdminService.login(username, password);
			if (hospitalAdministrator == null) {
				return "redirect:/user/login.do";
			}
			sessionUtil.setAttribute("USERMODEL", hospitalAdministrator);
			System.out.println("hospitalAdministrator name : " + hospitalAdministrator.getUsername());
			// model.addAttribute("username", hospitalAdministrator.getUsername());
			// model.addAttribute("userid", hospitalAdministrator.getId());
			model.addAttribute("hospitalAdministrator", hospitalAdministrator);
			return "redirect:/hospitalAdministrator/index.do";
		case "4":
			SuperAdministrator superAdministrator = superAdminService.login(username, password);
			if (superAdministrator == null) {
				return "redirect:/user/login.do";
			}
			sessionUtil.setAttribute("USERMODEL", superAdministrator);
			System.out.println("superAdministrator name : " + superAdministrator.getUsername());
			// model.addAttribute("username", superAdministrator.getUsername());
			// model.addAttribute("userid", superAdministrator.getId());
			model.addAttribute("superAdministrator", superAdministrator);
			return "redirect:/superAdministrator/index.do";
		default:
			break;
		}
		return "redirect:/user/login.do";
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		SessionUtil sessionUtil = new SessionUtil(request);
		sessionUtil.removeAttrtube("USERMODEL");
		return "redirect:/user/login.do";
	}

}
