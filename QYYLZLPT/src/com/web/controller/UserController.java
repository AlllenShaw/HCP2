package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.bean.domain.Doctor;
import com.bean.domain.HealthHistory;
import com.bean.domain.Hospital;
import com.bean.domain.HospitalAdministrator;
import com.bean.domain.Patient;
import com.web.service.DoctorService;
import com.web.service.HosptialAdminService;
import com.web.service.PatientService;
import com.web.util.SessionUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name = "patientWebService")
	private PatientService patientService;

	@Resource
	private DoctorService doctorService;

	@Resource
	private HosptialAdminService hosptialAdminService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, ModelAndView modelAndView) {

		Patient patient = new Patient();
		patient.setNickname("hello");
		modelAndView.addObject("patient", patient);
		modelAndView.setViewName("login/login"); // name的值是登录login.jsp页面
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, ModelAndView modelAndView, Integer usertype, String username,
			String password) throws JSONException {

		SessionUtil sessionUtil = new SessionUtil(request);

		System.out.println("type  " + usertype + "  username : " + username + " pass " + password);
		System.out.println("session is = " + sessionUtil.getJsessionid());

		switch (usertype) {
		case 1:
			Doctor doctor = doctorService.doctorLogin(username, password);
			if (doctor == null) {
				modelAndView.setViewName("redirect:/user/login.do");
				return modelAndView;
			}
			sessionUtil.setAttribute("USERMODEL", doctor);
			System.out.println("doctor name : " + doctor.getUsername());
			modelAndView.addObject("username", doctor.getUsername());
			modelAndView.addObject("userid", doctor.getId());
			modelAndView.setViewName("redirect:/doctor/index.do");
			return modelAndView;

		case 2:
			Patient patient = patientService.login(username, password);
			if (patient == null) {
				modelAndView.setViewName("redirect:/user/login.do");
				return modelAndView;
			}
			sessionUtil.setAttribute("USERMODEL", patient);
			modelAndView.addObject("username", patient.getUsername());
			modelAndView.addObject("userid", patient.getId());
			modelAndView.setViewName("redirect:/patient/index.do");
			return modelAndView;

		case 3:
			HospitalAdministrator administrator = hosptialAdminService.hosptialAdminLogin(username, password);
			if (administrator == null) {
				modelAndView.setViewName("redirect:/user/login.do");
				return modelAndView;
			}
			sessionUtil.setAttribute("USERMODEL", administrator);
			modelAndView.addObject("username", administrator.getUsername());
			modelAndView.addObject("userid", administrator.getId());
			modelAndView.setViewName("redirect:/hosadmin/index.do");
			return modelAndView;
		default:
			break;
		}
		modelAndView.setViewName("redirect:/user/login.do");
		return modelAndView;
	}

	// ----------------处理手机登陆----------------------------------------------------------------
	@RequestMapping(value = "/m/login", method = RequestMethod.POST)
	@ResponseBody
	public String mlogin(HttpServletRequest request, String username, String password)
			throws JSONException {

		ModelAndView modelAndView = new ModelAndView();
		SessionUtil sessionUtil = new SessionUtil(request);

		System.out.println(" username : " + username + " pass " + password);
		System.out.println("session is = " + sessionUtil.getJsessionid());

		Patient patient = patientService.login(username, password);
		if (patient == null) {
			//TODO 登陆失败返回 {"state":"0"（失败）;"cookie":null;exception:"异常原因"} 
			modelAndView.setViewName("redirect:/m/user/login.do");
		}
		sessionUtil.setAttribute("USERMODEL", patient);
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());
		// TODO 登陆成功，返回JSON{"state":"1"（成功）;"cookie":cookie;exception:null} 
		modelAndView.setViewName("redirect:/m/patient/index.do");
		JSONObject jo = JSONObject.fromObject(modelAndView);
		String joS = jo.toString();
		System.out.println(joS);
		return joS;
	}

	// -------------------------------------------------------------------------------------

	@RequestMapping(value = "/patient/register", method = RequestMethod.GET)
	public ModelAndView patientRgister(HttpServletRequest request, ModelAndView modelAndView) {
		modelAndView.addObject("hospital", patientService.getHospitalList());
		modelAndView.setViewName("register/register_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/patient/getDoctors", method = RequestMethod.POST)
	@ResponseBody
	public String getDoctors(HttpServletRequest request, Integer hospital_id) {
		JSONArray list = patientService.getDoctors(hospital_id);
		JSONObject result = new JSONObject();
		result.put("result", 1);
		result.put("list", list);
		System.out.println("get doctors" + result.toString());
		return result.toString();

	}

	@RequestMapping(value = "/patient/register", method = RequestMethod.POST)
	public ModelAndView patientRegister(HttpServletRequest request, ModelAndView modelAndView, Patient patient,
			Integer doctor_id, HealthHistory healthHistory) throws JSONException {

		System.out.println("patient  " + patient);
		patient.setRegisterTime(new Date());
		Set<HealthHistory> healthHistories = new HashSet<HealthHistory>();
		healthHistories.add(healthHistory);
		patient.setHealthHistories(healthHistories);

		System.out.println("query" + patient);
		System.out.println(healthHistory);

		if (patientService.patientRegister(patient, doctor_id)) {
			modelAndView.setViewName("redirect:/user/login.do");
		} else {
			modelAndView.setViewName("redirect:/user/patient/register.do");
		}
		return modelAndView;
	}

	// -----------------------------处理手机注册------------------------------------------------
	@RequestMapping(value = "/m/patient/register", method = RequestMethod.POST)
	@ResponseBody
	// 注册 String用户名、String密码、String姓名、int性别（女0，男1）、String出生年月日(YYYY-MM-DD)、String手机号、密保问题
	// 返回{"state":"0(失败)","exception":"异常信息"}  {"state":"1(成功)","exception":null}
	public String mpatientRegister(HttpServletRequest request, ModelAndView modelAndView, Patient patient, Integer doctor_id, HealthHistory healthHistory) {
		System.out.println("patient  " + patient);
		patient.setRegisterTime(new Date());
		Set<HealthHistory> healthHistories = new HashSet<HealthHistory>();
		healthHistories.add(healthHistory);
		patient.setHealthHistories(healthHistories);
		System.out.println("query" + patient);
		System.out.println(healthHistory);

		if (patientService.patientRegister(patient, doctor_id)) {
			//TODO
			modelAndView.setViewName("redirect:/user/login.do");
		} else {
			//TODO
			modelAndView.setViewName("redirect:/user/patient/register.do");
		}
		
		JSONObject jo = JSONObject.fromObject(modelAndView);
		String joS = jo.toString();
		System.out.println(joS);
		return joS;

	}

	// -----------------------------------------------------------------------------------------

	@RequestMapping(value = "/doctor/register", method = RequestMethod.GET)
	public ModelAndView doctorRegister(HttpServletRequest request, ModelAndView modelAndView) {
		modelAndView.addObject("hospital", doctorService.getHospitals());
		modelAndView.setViewName("register/register_doctor");
		return modelAndView;
	}

	@RequestMapping(value = "/doctor/register", method = RequestMethod.POST)
	public ModelAndView doctorRegister(HttpServletRequest request, ModelAndView modelAndView, Doctor doctor, Integer hospital_id)
			throws JSONException {
		Hospital hospital = new Hospital();
		hospital.setId(hospital_id);
		doctor.setHospital(hospital);
		doctor.setRegisterTime(new Date());
		System.out.println("hospital id : = " + hospital_id + "  doctor entity : " + doctor.toString());

		if (doctorService.doctorRegister(doctor)) {
			modelAndView.addObject("result", 1);
			modelAndView.setViewName("redirect:/user/login.do");
		} else {
			modelAndView.addObject("result", 0);
			modelAndView.setViewName("redirect:user/doctor/register.do");
		}
		return modelAndView;
	}

	// 病人查看资料
	@RequestMapping(value = "/patient/persorInfo", method = RequestMethod.GET)
	public ModelAndView getPatientInfo(HttpServletRequest request, ModelAndView modelAndView, Patient patient) {
		
		return modelAndView;
	}

	// 病人修改资料
	@RequestMapping(value = "/patient/persorInfo", method = RequestMethod.POST)
	public ModelAndView updatePatientInfo(HttpServletRequest request, ModelAndView modelAndView, Patient patient) {
		if (patientService.updatePaitent(patient)) {
			modelAndView.addObject("result", 1);
			modelAndView.setViewName("redirect:/patient/index.do");
		} else {
			modelAndView.addObject("result", 0);
			modelAndView.setViewName("redirect:user/doctor/register.do");
		}
		return modelAndView;
	}
	
	//--------------手机端查看个人信息-------------------------------------------------------------------------------------
	// TODO
	// Para:cookie username 
	// 成功-->{state,return JSON (包含用户所有信息),exception} 
	// 失败-->
	// value = "/m/patient/persorInfo" GET
	//-----------------------------------------------------------------------------------------------------------------------------

	//----------------修改密码------------------------------------------------------------------------------------------------------------
	// TODO
	// Para: username, answer1、answer2、answer3,oldpassword、newpassword、type(0忘记密码,1修改密码)
	// 成功：（state:0,exception:null）
	// 失败：（state:1,exception）
	// value = "/m/patient/changePassword"
	//-----------------------------------------------------------------------------------------------------------------------------
	
	//

	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		sessionUtil.removeAttrtube("USERMODEL");
		modelAndView.setViewName("redirect:login.do"); // name的值是登录login.jsp页面
		return modelAndView;
	}

}
