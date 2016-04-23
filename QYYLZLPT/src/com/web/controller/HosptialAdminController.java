package com.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.domain.HospitalAdministrator;
import com.web.service.HosptialAdminService;
import com.web.util.SessionUtil;

@Controller
@RequestMapping("/hosadmin")
public class HosptialAdminController {

	@Resource
	private HosptialAdminService hosptialAdminService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator administrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", administrator.getUsername());
		modelAndView.addObject("userid", administrator.getId());
		modelAndView.setViewName("index/index_hosadmin");
		return modelAndView;
	}

	@RequestMapping(value = "/xietongzhenzhiziyuan", method = RequestMethod.GET)
	public ModelAndView xietongzhenzhiziyuan(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator administrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", administrator.getUsername());
		modelAndView.addObject("userid", administrator.getId());
		modelAndView.setViewName("xietongzhenzhiziyuan/xietongzhenzhiziyuan");
		return modelAndView;
	}

	@RequestMapping(value = "/gongxiangqudao", method = RequestMethod.GET)
	public ModelAndView gongxiangqudao(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator administrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", administrator.getUsername());
		modelAndView.addObject("userid", administrator.getId());
		modelAndView.setViewName("xietongzhenzhiziyuan/gongxiangqudao");
		return modelAndView;
	}

	@RequestMapping(value = "/quanxiangongxiang", method = RequestMethod.GET)
	public ModelAndView quanxiangongxiang(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator administrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", administrator.getUsername());
		modelAndView.addObject("userid", administrator.getId());
		modelAndView.setViewName("xietongzhenzhiziyuan/quanxiangongxiang");
		return modelAndView;
	}

	@RequestMapping(value = "/xietongzhenzhianquan", method = RequestMethod.GET)
	public ModelAndView xietongzhenzhianquan(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator administrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", administrator.getUsername());
		modelAndView.addObject("userid", administrator.getId());
		modelAndView.setViewName("xietongzhenzhianquan/xietongzhenzhianquan");
		return modelAndView;
	}

	@RequestMapping(value = "/yonghuguanli", method = RequestMethod.GET)
	public ModelAndView yonghuguanli(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator administrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", administrator.getUsername());
		modelAndView.addObject("userid", administrator.getId());
		modelAndView.setViewName("xietongzhenzhianquan/yonghuguanli");
		return modelAndView;
	}

	@RequestMapping(value = "/quanxianguanli", method = RequestMethod.GET)
	public ModelAndView quanxianguanli(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator administrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", administrator.getUsername());
		modelAndView.addObject("userid", administrator.getId());
		modelAndView.setViewName("xietongzhenzhianquan/quanxianguanli");
		return modelAndView;
	}
//
//	@RequestMapping(value = "/pingtaizhicheng", method = RequestMethod.GET)
//	public ModelAndView name(HttpServletRequest request,
//			ModelAndView modelAndView) {
//		SessionUtil sessionUtil = new SessionUtil(request);
//		HospitalAdministrator administrator = (HospitalAdministrator) sessionUtil
//				.getAttribute("USERMODEL");
//		modelAndView.addObject("username", administrator.getUsername());
//		modelAndView.addObject("userid", administrator.getId());
//		modelAndView.setViewName("pingtaizhicheng/pingtaizhicheng_hosadmin");
//		return modelAndView;
//
//	}

	@RequestMapping(value = "/getMyHospital", method = RequestMethod.POST)
	@ResponseBody
	public String getMyHospital(HttpServletRequest request,
			@RequestParam(value = "doctor_id") Integer my_admin_id) {

		System.out.println("doctor id : " + my_admin_id);
		JSONObject result = hosptialAdminService.getMyHospital(my_admin_id);
		if (result == null) {
			result = new JSONObject();
			result.put("result", 0);
			System.out.println("get my hospital" + result.toString());
			return result.toString();
		}
		result.put("result", 1);
		System.out.println("get my hospital" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/getMyHospitalDoctorList", method = RequestMethod.POST)
	@ResponseBody
	public String getMyHospitalDoctorList(HttpServletRequest request,
			@RequestParam(value = "hospital_id") Integer my_hospital_id) {

		System.out.println("doctor id : " + my_hospital_id);
		JSONArray list = hosptialAdminService
				.getMyHospitalDoctorList(my_hospital_id);
		JSONObject result = new JSONObject();
		if (list == null) {
			result.put("result", 0);
			System.out.println("get my hospital doctor list"
					+ result.toString());
			return result.toString();
		}
		result.put("result", 1);
		result.put("list", list);
		System.out.println("get my hospital doctor list" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/deleteDoctor", method = RequestMethod.POST)
	@ResponseBody
	public String deleteDocctor(HttpServletRequest request, int doctor_id) {
		JSONObject result = new JSONObject();
		if (hosptialAdminService.deleteDoctor(doctor_id)) {
			result.put("result", 1);
			System.out.println("delete doctor  " + result.toString());
			return result.toString();
		}
		result.put("result", 0);
		System.out.println("delete doctor  " + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/queryHospitalDoctorPremission")
	@ResponseBody
	public String queryHospitalDoctorPremission(HttpServletRequest request,
			Integer doctor_id) {
		JSONObject result = hosptialAdminService
				.getMyHospitalDoctorPremission(doctor_id);
		if (result == null) {
			result = new JSONObject();
			result.put("result", 0);
			System.out.println("get doctor premissions " + result.toString());
			return result.toString();
		}
		result.put("result", 1);
		System.out.println("get doctor premissions " + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/saveDoctorPremission")
	@ResponseBody
	public String saveDoctorPremission(HttpServletRequest request,
			Integer doctor_id, String list) {
		System.out.println("doctor premission list " + list);
		JSONObject result = new JSONObject();
		if (hosptialAdminService.saveDoctorPremission(doctor_id, list)) {
			result.put("result", 1);
			System.out.println("save doctor premissions " + result.toString());
			return result.toString();
		}
		result.put("result", 0);
		System.out.println("save doctor premissions " + result.toString());
		return result.toString();

	}

	@RequestMapping("/getNoCollabHospital")
	@ResponseBody
	public String getNoCollabHospital(HttpServletRequest request,
			@RequestParam(value = "hospital_id") Integer my_hospital_id) {

		System.out.println("hospital id = " + my_hospital_id);

		JSONArray hospitalArray = hosptialAdminService
				.getNoCollabHospital(my_hospital_id);
		JSONObject result = new JSONObject();
		result.put("result", 1);
		result.put("list", hospitalArray);
		System.out.println("get no coll hospital list : " + result.toString());
		return result.toString();
	}

	@RequestMapping("/addHospital")
	@ResponseBody
	public String addHosptial(HttpServletRequest request,
			@RequestParam(value = "hospital_id_1") Integer my_hospital_id,
			@RequestParam(value = "hospital_id_2") Integer other_hospital_id) {
		JSONObject result = new JSONObject();

		if (hosptialAdminService.addHosptial(my_hospital_id, other_hospital_id)) {
			result.put("result", 1);
			System.out.println("hosadmin add hospital : " + result.toString());
			return result.toString();
		}
		result.put("result", 0);
		System.out.println("hosadmin add hospital : " + result.toString());
		return result.toString();

	}

	@RequestMapping("/getCollabHospital")
	@ResponseBody
	public String getCollabHospital(HttpServletRequest request,
			@RequestParam(value = "hospital_id") Integer my_hospital_id) {
		JSONArray hospitalArray = hosptialAdminService
				.getHosptials(my_hospital_id);
		JSONObject result = new JSONObject();
		result.put("result", 1);
		result.put("list", hospitalArray);
		System.out.println("get coll hospital list : " + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/queryPremission", method = RequestMethod.POST)
	@ResponseBody
	public String queryPremission(HttpServletRequest request,
			@RequestParam(value = "hospital_id_1") Integer my_hospital_id,
			@RequestParam(value = "hospital_id_2") Integer other_hospital_id) {

		JSONObject result = hosptialAdminService.queryPremission(
				my_hospital_id, other_hospital_id);
		result.put("result", 1);
		System.out.println("return premission list" + result.toString());
		return result.toString();
	}

	@RequestMapping("/editPremission")
	@ResponseBody
	public String editPremission(HttpServletRequest request,
			@RequestParam(value = "hospital_id_1") Integer my_hospital_id,
			@RequestParam(value = "hospital_id_2") Integer other_hospital_id,
			String list) {

		System.out.println("list : " + list);

		JSONObject result = new JSONObject();

		if (hosptialAdminService.editPremission(list, my_hospital_id,
				other_hospital_id)) {
			result.put("result", 1);
			System.out.println("edit premission : " + result.toString());
			return result.toString();
		}
		result.put("result", 0);
		System.out.println("edit premission : " + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/pingtaizhicheng", method = RequestMethod.GET)
	public ModelAndView pingtaizhicheng(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator hospitalAdministrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", hospitalAdministrator.getUsername());
		modelAndView.addObject("userid", hospitalAdministrator.getId());
		modelAndView.setViewName("pingtaizhicheng/pingtaizhicheng_hosadmin");
		return modelAndView;
	}

	@RequestMapping(value = "/pingtaishezhi", method = RequestMethod.GET)
	public ModelAndView pingtaishezhi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator hospitalAdministrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", hospitalAdministrator.getUsername());
		modelAndView.addObject("userid", hospitalAdministrator.getId());
		modelAndView.setViewName("pingtaizhicheng/pingtaishezhi_hosadmin");
		return modelAndView;
	}

	@RequestMapping(value = "/pingtaibangzhu", method = RequestMethod.GET)
	public ModelAndView pingtaibangzhu(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator hospitalAdministrator = (HospitalAdministrator) sessionUtil
				.getAttribute("USERMODEL");
		modelAndView.addObject("username", hospitalAdministrator.getUsername());
		modelAndView.addObject("userid", hospitalAdministrator.getId());
		modelAndView.setViewName("pingtaizhicheng/pingtaibangzhu_hosadmin");
		return modelAndView;
	}

	@RequestMapping(value = "/setting", method = RequestMethod.POST)
	public ModelAndView setting(HttpServletRequest request,
			ModelAndView modelAndView,
			HospitalAdministrator hospitalAdministrator) {

		System.out.println(hospitalAdministrator);
		hosptialAdminService.updatePaitent(hospitalAdministrator);

		modelAndView.addObject("username", hospitalAdministrator.getUsername());
		modelAndView.addObject("userid", hospitalAdministrator.getId());
		modelAndView.setViewName("redirect:/hosadmin/pingtaishezhi.do");
		return modelAndView;
	}

}
