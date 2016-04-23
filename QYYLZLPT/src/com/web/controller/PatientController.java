package com.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bean.domain.Patient;
import com.web.service.DoctorService;
import com.web.service.PatientService;
import com.web.util.SessionUtil;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Resource
	private PatientService patientService;

	@Resource
	private DoctorService doctorService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());
		modelAndView.setViewName("index/index_patient");
		// modelAndView.setViewName("patientEmr/dianzidangan_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/xieTongZhenZhi", method = RequestMethod.GET)
	public ModelAndView xieTongZhenZhi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		System.out.println("patient user name : " + patient.getUsername());

		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());

		modelAndView.setViewName("patientEmr/xietongzhenzhi_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/sangaoyuce")
	public ModelAndView sangaoyuce(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());

		modelAndView.setViewName("patientPredict/fuzhuzhenzhi_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/xuetangyujing", method = RequestMethod.GET)
	public ModelAndView xuetangyujing(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());
		modelAndView.setViewName("patientPredict/xuetangyujing_patient");
		return modelAndView;

	}

	@RequestMapping(value = "/xueyayujing", method = RequestMethod.GET)
	public ModelAndView xueyayujing(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());

		modelAndView.setViewName("patientPredict/xueyayujing_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/xuezhiyujing", method = RequestMethod.GET)
	public ModelAndView xuezhiyujing(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());
		modelAndView.setViewName("patientPredict/xuezhiyujing_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/predictHtn", method = RequestMethod.POST)
	@ResponseBody
	public String predictHtn(HttpServletRequest request, Integer patient_id) {
		JSONArray list = doctorService.predictHtn(patient_id);
		JSONObject result = new JSONObject();

		if (list == null) {
			result.put("result", 0);
			System.out.println("predict htn" + result.toString());
			return result.toString();
		}
		result.put("result", 1);
		result.put("list", list);
		System.out.println("predict htn" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/predictGlu", method = RequestMethod.POST)
	@ResponseBody
	public String predictGlu(HttpServletRequest request, Integer patient_id) {
		JSONArray list = doctorService.predictGlu(patient_id);
		JSONObject result = new JSONObject();
		if (list == null) {
			result.put("result", 0);
			System.out.println("predict glu" + result.toString());
			return result.toString();
		}
		result.put("result", 1);
		result.put("list", list);
		System.out.println("predict glu" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/predictHpl", method = RequestMethod.POST)
	@ResponseBody
	public String predictHpl(HttpServletRequest request, Integer patient_id) {
		JSONArray list = doctorService.predictHpl(patient_id);
		JSONObject result = new JSONObject();
		if (list == null) {
			result.put("result", 0);
			System.out.println("predict hpl" + result.toString());
			return result.toString();
		}
		result.put("result", 1);
		result.put("list", list);
		System.out.println("predict hpl" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/dianzidangan", method = RequestMethod.GET)
	public ModelAndView queryEmr(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());

		System.out.println("patient : " + patient.getId()
				+ patient.getUsername());
		modelAndView.setViewName("patientEmr/dianzidangan_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/queryEmr", method = RequestMethod.POST)
	@ResponseBody
	public String queryEmr(HttpServletRequest request, Integer patient_id) {
		// Map<String, String> map = ProcessRequest.process(request);
		System.out.println("patient id " + patient_id);
		JSONObject result = patientService.getEmr(patient_id);
		result.put("result", 1);
		// result.put("list", patientArray);
		System.out.println("query  emr" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/pingtaizhicheng", method = RequestMethod.GET)
	public ModelAndView pingtaizhicheng(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());
		modelAndView.setViewName("pingtaizhicheng/pingtaizhicheng_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/pingtaishezhi", method = RequestMethod.GET)
	public ModelAndView pingtaishezhi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());
		modelAndView.addObject("patient", patient);
		modelAndView.setViewName("pingtaizhicheng/pingtaishezhi_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/pingtaibangzhu", method = RequestMethod.GET)
	public ModelAndView pingtaibangzhu(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());
		modelAndView.setViewName("pingtaizhicheng/pingtaibangzhu_patient");
		return modelAndView;
	}

	@RequestMapping(value = "/setting", method = RequestMethod.POST)
	public ModelAndView setting(HttpServletRequest request,
			ModelAndView modelAndView, Patient patient) {

		System.out.println(patient);
		patientService.updatePaitent(patient);

		modelAndView.addObject("username", patient.getUsername());
		modelAndView.addObject("userid", patient.getId());
		modelAndView.setViewName("redirect:/patient/pingtaishezhi.do");
		return modelAndView;
	}
	
	//----------------手机端查看医生列表--------------------------------------------------------------------
	// cookie、username
	// {state,list(doctorRealname,id,profession,hospital),exception}
	//	value= /m/patien/getDoctorList  GET 
	// -----------------------------------------------------------------------------------------------------
	
	//----------------手机端查看医生详细信息-----------------------------------------------------------
	//	cookie username doctorId
	//	{state,doctor(doctorRealname，hospital，tele，email，gender，age，address，nation、profession、info),excption}
	//  value= /m/patien/getDoctorInfo  GET
	//-----------------------------------------------------------------------------------------------
	
	//--------------------------查看慢病数据----------------------------------------------------------
	//	cookie username time1 timer2
	//	{state，ekg（字符串记录y轴，result），exception}
	//  value = /m/patien/getHdData
	//------------------------------------------------------------------------------------------------
	
	//------------------------查看主治医生----------------------------------------------------------
	// 待讨论
	//----------------------------------------------------------------------------------------------
	
	//----------------------------查药单----------------------------------------------------------
	// cookie username 
	// {state, prescription{int药品ID、药名、服用方式、float剂量、剂量的单位、服药次数,时间},exception}
	// value = /m/patient/getPrescription
	//----------------------------------------------------------------------------------------------
	
	//--------------------------详细药品-------------------------------------------------------
	// cookie username 药品id
	// { state,excption, 药品名称，成分，适应症、用法、用量、不良反应、用药禁忌、注意事项、药品说明 }
	// value = /m/patient/getMedicineInfo 
	//------------------------------------------------------------
}