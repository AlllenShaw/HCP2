package com.hcp.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.hcp.domain.AppVersion;
import com.hcp.domain.Hospital;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.SuperAdministrator;
import com.hcp.service.HospitalAdminService;
import com.hcp.service.SuperAdminService;
import com.hcp.util.SessionUtil;
import com.mysql.fabric.xmlrpc.base.Data;

/**
 * 
 * @author Allen 添加删除医院(返回List<Hospital>)、添加删除查看医院管理员（输入：医院名称 返回List<HospitalAdmin>）
 */
@Controller
@RequestMapping("/superAdmin")
public class SuperAdminController {

	@Resource(name = "superAdminService")
	private SuperAdminService superAdminService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		SessionUtil sessionUtil = new SessionUtil(request);
		SuperAdministrator superAdministrator = (SuperAdministrator) sessionUtil.getAttribute("USERMODEL");
		model.addAttribute("superAdministrator", superAdministrator);
		return "/index_smanager/index_smanager";
	}

	@RequestMapping(value = "/hospitalManage", method = RequestMethod.GET)
	public String getAllHospital(HttpServletRequest request, Model model) {
		List<Hospital> hospitals = superAdminService.getAllHospital();
		model.addAttribute("hospitals", hospitals);
		return "/index_smanager/hospital_management";
	}

	@RequestMapping(value = "/addHospital", method = RequestMethod.POST)
	public String addHospital(HttpServletRequest request, Model model, String name, String address, String level,
			String introduction) {
		Hospital hospital = new Hospital(name, address, level, new Timestamp(new Date().getTime()));
		hospital.setIntroduction(introduction);
		Boolean flag = superAdminService.addHospital(hospital);
		System.out.println(flag);
		return "/index_doctor/index";
	}

	@RequestMapping(value = "/removeHospital", method = RequestMethod.POST)
	public String removeHospital(HttpServletRequest request, Model model, String hospital_id) {
		superAdminService.removeHospital(hospital_id);
		return "redirect:getAllHospital.do";
	}

	public String getAllHospitalAdmin(HttpServletRequest request, Model model) {
		List<HospitalAdministrator> list = superAdminService.getAllHospitalAdmin();
		model.addAttribute("list", list);
		return "index_smanager/hmanager_management";
	}

	@RequestMapping(value = "/HospitalAdminManage", method = RequestMethod.GET)
	public String HospitalAdminManage(HttpServletRequest request, Model model) {
		List<Hospital> hospitals = superAdminService.getAllHospital();
		model.addAttribute("hospitals", hospitals);
		return "index_smanager/hmanager_management";
	}

	@RequestMapping(value = "getHospitalAdminByHospital")
	public String getHospitalAdminByHospital(HttpServletRequest request, Model model, String hospital_id) {
		List<HospitalAdministrator> hospitalAdministrators = superAdminService.getHospitalAdminByHospital(hospital_id);
		model.addAttribute("hospitalAdministrators", hospitalAdministrators);
		model.addAttribute("hospitals", superAdminService.getAllHospital());
		return "/index_smanager/hmanager_form";
	}

	@RequestMapping(value = "/addHospitalAdmin", method = RequestMethod.GET)
	public String addHospitalAdmin(HttpServletRequest request, Model model) {
		List<Hospital> hospitals = superAdminService.getAllHospital();
		model.addAttribute("hospitals", hospitals);
		return "/registered/registered_hmanager";
	}

	@RequestMapping(value = "/addHospitalAdmin", method = RequestMethod.POST)
	public String addHospitalAdmin(HttpServletRequest request, Model model, String hospital_id, String username, String realname,
			String idNumber, String password, String mail, String tele) {
		Hospital hospital = superAdminService.getHospitalById(hospital_id);
		HospitalAdministrator hospitalAdministrator = new HospitalAdministrator(hospital, username, realname, idNumber, password);
		hospitalAdministrator.setMail(mail);
		hospitalAdministrator.setTele(tele);
		superAdminService.addHospitalAdmin(hospitalAdministrator);
		return "/registered/resetsuccess";
	}

	@RequestMapping("/removeHospitalAdmin")
	public String removeHospitalAdmin(HttpServletRequest request, Model model, String hospitalAdmin_id) {
		HospitalAdministrator hospitalAdministrator = superAdminService.getAllHospitalAdminById(hospitalAdmin_id);
		superAdminService.deleteHospitalAdmin(hospitalAdministrator);
		return "/index_doctor/index";
	}

	@RequestMapping(value = "/uploadApp", method = RequestMethod.POST)
	public String uploadApp(HttpServletRequest request, String version, String updateInfo, MultipartFile app) throws IOException {
		if(app.isEmpty()){
			return "/tips/operation_failed";
		}
		System.out.println(app.getName() + "," + app.getOriginalFilename() + "," + app.getContentType());
		String realpath = request.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realpath);
		File f = new File(realpath + "/" + app.getOriginalFilename());
		FileUtils.copyInputStreamToFile(app.getInputStream(), f);
		AppVersion appVersion = new AppVersion(version, updateInfo, new Timestamp(new Date().getTime()));
		superAdminService.addAppVersion(appVersion);
		return "/tips/operation_success";
	}

}
