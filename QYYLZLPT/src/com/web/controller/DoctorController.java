package com.web.controller;

import java.util.Date;

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

import com.bean.domain.Doctor;
import com.bean.domain.GluPatientInfo;
import com.bean.domain.Hospital;
import com.bean.domain.HplPatientInfo;
import com.bean.domain.HtnPatientInfo;
import com.bean.domain.Medicine;
import com.bean.domain.Patient;
import com.web.service.DoctorService;
import com.web.util.SessionUtil;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Resource(name = "doctorService")
	private DoctorService doctorService;

	@RequestMapping("/index")
	public ModelAndView doctorIndex(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("userid", doctor.getId());
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.setViewName("index/index_doctor");
		return modelAndView;
	}

	@RequestMapping(value = "/manBingZhenZhi", method = RequestMethod.GET)
	public ModelAndView manBingZhengZhi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		if (!doctorService.checkPremission(doctor.getId(),
				"doctor/manBingZhenZhi.do")) {
			modelAndView.setViewName("manbingzhenzhi/nopermission");
			return modelAndView;
		}
		modelAndView.setViewName("manbingzhenzhi/manbingzhenzhi");
		return modelAndView;
	}

	@RequestMapping(value = "/fuZhuZhenZhi", method = RequestMethod.GET)
	public ModelAndView fuZhuZhenZhi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		// if (!doctorService.checkPremission(doctor.getId(),
		// "doctor/fuZhuZhenZhi.do")) {
		// modelAndView.setViewName("fuzhuzhenzhi/nopermission");
		// return modelAndView;
		// }
		modelAndView.setViewName("fuzhuzhenzhi/fuzhuzhenzhi");
		return modelAndView;
	}

	@RequestMapping(value = "/dianzidangan", method = RequestMethod.GET)
	public ModelAndView dianzidangan(HttpServletRequest request,
			@RequestParam(value = "userid") Integer doctor_id,
			ModelAndView modelAndView) {

		System.out.println("userid =  " + doctor_id);
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());

		if (!doctorService.checkPremission(doctor.getId(),
				"doctor/dianzidangan.do")) {
			modelAndView.setViewName("xietongzhenzhi/nopermission");
			return modelAndView;
		}

		modelAndView.setViewName("xietongzhenzhi/dianzidangan");
		return modelAndView;
	}

	@RequestMapping(value = "/getHospitals", method = RequestMethod.POST)
	@ResponseBody
	public String getHospitals(HttpServletRequest request, Integer doctor_id) {
		// JSONObject cmd = ProcessRequest.getJsonObject(request);
		// int doctor_id = cmd.getInt("hospital_id");
		// String string = request.getParameter("doctor_id");
		// System.out.println("doctor_id : " + doctor_id);
		// int doctor_id = 1;

		Hospital hospital = doctorService.getHospitalByDoctorId(doctor_id);
		JSONArray hospitalArray = doctorService.queryHosptial(hospital.getId());
		JSONObject result = new JSONObject();
		result.put("result", 1);
		result.put("list", hospitalArray);
		System.out.println("return hospital list : " + result.toString());

		return result.toString();

	}

	@RequestMapping("/getPatients")
	@ResponseBody
	public String getPatients(HttpServletRequest request, Integer doctor_id) {

		JSONArray patientArray = doctorService.getPatientList(doctor_id);
		JSONObject result = new JSONObject();

		if (patientArray.isEmpty()) {
			result.put("result", 0);
			return result.toString();
		}

		result.put("result", 1);
		result.put("list", patientArray);
		System.out.println("return patient list : " + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/getEmr", method = RequestMethod.POST)
	@ResponseBody
	public String getEmr(HttpServletRequest request, Integer patient_id,
			@RequestParam(value = "hospital_id") Integer other_hospital_id,
			Integer doctor_id) {
		JSONObject object = new JSONObject();

		if (!doctorService.checkPremission(doctor_id, "doctor/getEmr.do")) {
			object.put("result", 0);
			System.out.println("return emr string : " + object.toString());
			return object.toString();
		}

		System.out.println("doctor id : " + doctor_id + " hosp id :  "
				+ other_hospital_id + " patient id : " + patient_id);

		String projectWebPath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath();

		JSONObject result = doctorService.queryEmr(doctor_id,
				other_hospital_id, patient_id, projectWebPath);
		result.put("result", 1);
		System.out.println("return emr string : " + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/getOtherEmr", method = RequestMethod.POST)
	@ResponseBody
	public String getOtherEmr(HttpServletRequest request) {
		return null;

	}

	@RequestMapping("/addPatient")
	@ResponseBody
	public String addPatient(HttpServletRequest request, Integer doctor_id,
			Integer patient_id) {
		// JSONObject cmd = ProcessRequest.getJsonObject(request);
		// int patient_id = cmd.getInt("patient_id");
		// int doctor_id = cmd.getInt("doctor_id");

		JSONObject object = new JSONObject();

		if (!doctorService.checkPremission(doctor_id, "doctor/addPatient.do")) {
			object.put("result", 0);
			System.out.println("return emr string : " + object.toString());
			return object.toString();
		}

		JSONObject result = new JSONObject();

		if (!doctorService.addPatient(doctor_id, patient_id)) {
			result.put("result", 0);
			System.out.println("return add patient : " + result.toString());
			return result.toString();
		}

		result.put("result", 1);
		System.out.println("return add patient : " + result.toString());
		return result.toString();

	}

	@RequestMapping("/searchPatient")
	@ResponseBody
	public String searchPatient(HttpServletRequest request,
			Integer hospital_id, String keyword) {

		JSONArray patientArray = doctorService.searchPatient(hospital_id,
				keyword);
		JSONObject result = new JSONObject();

		if (patientArray.isEmpty()) {
			result.put("result", 0);
			return result.toString();
		}

		result.put("result", 1);
		result.put("list", patientArray);
		System.out.println("return search patient list : " + result.toString());
		return result.toString();
	}

	@RequestMapping("/searchPatientByDoctor")
	@ResponseBody
	public String searchPatientByDoctor(HttpServletRequest request,
			Integer doctor_id, String keyword) {

		JSONArray patientArray = doctorService.searchPatientByDoctor(doctor_id,
				keyword);
		JSONObject result = new JSONObject();

		if (patientArray == null) {
			result.put("result", 0);
			return result.toString();
		}

		result.put("result", 1);
		result.put("list", patientArray);
		System.out.println("return search patient list : " + result.toString());
		return result.toString();
	}

	@RequestMapping("/deletePatient")
	@ResponseBody
	public String deletePatient(HttpServletRequest request, Integer patient_id,
			Integer doctor_id) {
		JSONObject object = new JSONObject();

		// if (!doctorService
		// .checkPremission(doctor_id, "doctor/deletePatient.do")) {
		// object.put("result", 0);
		// System.out.println("return emr string : " + object.toString());
		// return object.toString();
		// }
		JSONObject result = new JSONObject();
		if (doctorService.deletePatient(doctor_id, patient_id)) {
			result.put("result", 1);
		} else {
			result.put("result", 0);
		}
		System.out.println("return delete patient result : "
				+ result.toString());
		return result.toString();
	}

	/*
	 * 返回慢病诊治jsp视图，同时把相关属性注入jsp
	 */
	@RequestMapping(value = "/manbingzhenzhi", method = RequestMethod.GET)
	public ModelAndView manbingzhenzhi(HttpServletRequest request,
			ModelAndView modelAndView) {

		modelAndView.setViewName("");
		return modelAndView;
	}

	/*
	 * 返回患者信息jsp视图，同时把相关属性注入jsp
	 */

	@RequestMapping(value = "/huanzhexinxi", method = RequestMethod.GET)
	public ModelAndView huanzhexinxi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());

		if (!doctorService.checkPremission(doctor.getId(),
				"doctor/huanzhexinxi.do")) {
			modelAndView.setViewName("manbingzhenzhi/nopermission");
			return modelAndView;
		}

		modelAndView.setViewName("manbingzhenzhi/huanzhexinxi");
		return modelAndView;

	}

	/*
	 * 返回慢病信息jsp视图，同时把相关属性注入jsp
	 */

	@RequestMapping(value = "/manbingxinxi", method = RequestMethod.GET)
	public ModelAndView manbingxinxi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		//
		if (!doctorService.checkPremission(doctor.getId(),
				"doctor/manbingxinxi.do")) {
			modelAndView.setViewName("manbingzhenzhi/nopermission");
			return modelAndView;
		}

		modelAndView.setViewName("manbingzhenzhi/manbingxinxi");
		return modelAndView;

	}

	/*
	 * 返回慢病信息列表，json字符串
	 */
	@RequestMapping(value = "/getPatientManBingDetails", method = RequestMethod.POST)
	@ResponseBody
	public String getPatientManBingDetails(HttpServletRequest request,
			Integer doctor_id, Integer patient_id) {

		JSONObject object = new JSONObject();
		if (!doctorService.checkPremission(doctor_id,
				"doctor/getPatientManBingDetails.do")) {

			object.put("result", 0);
			System.out.println("return emr string : " + object.toString());
			return object.toString();
		}

		JSONObject result = doctorService.getPatientManBingDetails(patient_id);
		if (result == null) {
			result = new JSONObject();
			result.put("result", 0);
			System.out.println("get patient getPatientManBingDetails "
					+ result.toString());
			return result.toString();

		}
		result.put("result", 1);
		System.out.println("get patient getPatientManBingDetails "
				+ result.toString());
		return result.toString();

	}

	@RequestMapping(value = "/updateManBing", method = RequestMethod.POST)
	public ModelAndView updateManBing(HttpServletRequest request,
			ModelAndView modelAndView, HplPatientInfo hplPatientInfo,
			GluPatientInfo gluPatientInfo, HtnPatientInfo htnPatientInfo,
			@RequestParam(value = "patient_id") Integer patientId, Integer doctor_id) {

		if (!doctorService
				.checkPremission(doctor_id, "doctor/updateManBing.do")) {
			modelAndView.setViewName("manbingzhenzhi/nopermission");
			return modelAndView;
		}

		Patient patient = new Patient();
		patient.setId(patientId);

		hplPatientInfo.setPatient(patient);
		hplPatientInfo.setPatientId(patientId);
		hplPatientInfo.setUpgradeTime(new Date());

		htnPatientInfo.setPatient(patient);
		htnPatientInfo.setPatientId(patientId);
		htnPatientInfo.setUpgradeTime(new Date());

		gluPatientInfo.setPatient(patient);
		gluPatientInfo.setPatientId(patientId);
		gluPatientInfo.setUpgradeTime(new Date());

		System.out.println("hpl " + hplPatientInfo);
		System.out.println("glu" + gluPatientInfo);
		System.out.println("htn " + htnPatientInfo);

		boolean b = doctorService.setGluPatientInfo(gluPatientInfo)
				&& doctorService.setHplPatientInfo(hplPatientInfo)
				&& doctorService.setHtnPatientInfo(htnPatientInfo);
		System.out.println("update info " + b);
		modelAndView.setViewName("redirect:manbingxinxi.do");
		return modelAndView;

	}

	/*
	 * 返回患病用药jsp视图，同时把相关属性注入jsp
	 */

	@RequestMapping(value = "/huanzheyaowu", method = RequestMethod.GET)
	public ModelAndView huanzheyaowu(HttpServletRequest request,
			ModelAndView modelAndView) {

		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		//
		if (!doctorService.checkPremission(doctor.getId(),
				"doctor/huanzheyaowu.do")) {
			modelAndView.setViewName("manbingzhenzhi/nopermission");
			return modelAndView;
		}

		modelAndView.setViewName("manbingzhenzhi/huanzheyaowu");
		return modelAndView;

	}

	/*
	 * 返回患病用药信息列表，json字符串
	 */
	@RequestMapping(value = "/patientMedicine", method = RequestMethod.POST)
	@ResponseBody
	public String huanzheyaowu(HttpServletRequest request, int patient_id,
			int doctor_id) {
		JSONObject object = new JSONObject();
		if (!doctorService.checkPremission(doctor_id,
				"doctor/patientMedicine.do")) {

			object.put("result", 2);
			System.out.println("return emr string : " + object.toString());
			return object.toString();
		}

		JSONArray list = doctorService.getGluPatientMedicineRecord(patient_id);
		JSONObject result = new JSONObject();
		if (list == null) {
			result.put("result", 0);
			System.out.println("get medicine" + result.toString());
			return result.toString();
		}

		result.put("result", 1);
		result.put("list", list);
		System.out.println("get patient medicin " + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/addMedince", method = RequestMethod.GET)
	public ModelAndView addMedince(HttpServletRequest request,
			ModelAndView modelAndView) {

		modelAndView.setViewName("manbingzhenzhi/manbingyaowu");
		return modelAndView;
	}

	@RequestMapping(value = "/addMedicine", method = RequestMethod.POST)
	public ModelAndView addMedince(HttpServletRequest request,
			ModelAndView modelAndView, Medicine medicine) {
		System.out.println(medicine);
		doctorService.addMedicine(medicine);
		modelAndView.setViewName("redirect:manbingyaowu.do");
		return modelAndView;
	}

	@RequestMapping(value = "/manbingyaowu", method = RequestMethod.GET)
	public ModelAndView listMedicine(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());

		System.out.println("user id : " + doctor.getRealname());
		modelAndView.setViewName("manbingzhenzhi/manbingyaowu");
		return modelAndView;
	}

	@RequestMapping(value = "/getMedicine", method = RequestMethod.POST)
	@ResponseBody
	public String listMedicine(HttpServletRequest request) {
		JSONArray list = doctorService.getMedicine();
		JSONObject result = new JSONObject();

		if (list == null) {
			result.put("result", 0);
			System.out.println("get medicine" + result.toString());
			return result.toString();
		}

		result.put("result", 1);
		result.put("list", list);
		System.out.println("get medicine" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/getMedicineById", method = RequestMethod.POST)
	@ResponseBody
	public String getMedicineById(HttpServletRequest request,
			Integer medicine_id) {

		System.out.println("medicine id " + medicine_id);

		JSONObject result = doctorService.getMedicineById(medicine_id);
		if (result == null) {
			result = new JSONObject();
			result.put("result", 0);
			System.out.println("get medicine by id" + result.toString());
			return result.toString();
		}
		result.put("result", 1);
		System.out.println("get medicine by id" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/deleteMedicine", method = RequestMethod.POST)
	@ResponseBody
	public String deleteMedicine(HttpServletRequest request, Integer medicine_id) {
		doctorService.deleteMedicine(medicine_id);
		JSONObject result = new JSONObject();

		result.put("result", 1);
		System.out.println("delete medicine" + result.toString());
		return result.toString();
	}

	//
	// /*
	// * 返回慢病药物管理jsp视图，同时把相关属性注入jsp
	// */
	//
	// @RequestMapping(value = "/manbingyaowu", method = RequestMethod.GET)
	// public ModelAndView manbingyaowu(HttpServletRequest request,
	// ModelAndView modelAndView) {
	//
	// return modelAndView;
	//
	// }
	//
	// /*
	// * 返回慢病药物管理信息列表，json字符串
	// */
	// @RequestMapping(value = "/manbingyaowu", method = RequestMethod.POST)
	// @ResponseBody
	// public String manbingyaowu(HttpServletRequest request) {
	//
	// return "";
	//
	// }
	@RequestMapping(value = "/xieTongZhenZhi", method = RequestMethod.GET)
	public ModelAndView xieTongZhenZhi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		// if (!doctorService.checkPremission(doctor.getId(),
		// "doctor/xieTongZhenZhi.do")) {
		// modelAndView.setViewName("xietongzhenzhi/nopermission");
		// return modelAndView;
		// }
		modelAndView.setViewName("xietongzhenzhi/xietongzhenzhi");
		return modelAndView;
	}

	@RequestMapping(value = "/xuetangyujing", method = RequestMethod.GET)
	public ModelAndView xuetangyujing(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		//
		if (!doctorService.checkPremission(doctor.getId(),
				"doctor/xuetangyujing.do")) {
			modelAndView.setViewName("fuzhuzhenzhi/nopermission");
			return modelAndView;
		}

		modelAndView.setViewName("fuzhuzhenzhi/xuetangyujing");
		return modelAndView;
	}

	@RequestMapping(value = "/xueyayujing", method = RequestMethod.GET)
	public ModelAndView xueyayujing(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		if (!doctorService.checkPremission(doctor.getId(),
				"doctor/xueyayujing.do")) {
			modelAndView.setViewName("fuzhuzhenzhi/nopermission");
			return modelAndView;
		}

		modelAndView.setViewName("fuzhuzhenzhi/xueyayujing");
		return modelAndView;
	}

	@RequestMapping(value = "/xuezhiyujing", method = RequestMethod.GET)
	public ModelAndView xuezhiyujing(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		if (!doctorService.checkPremission(doctor.getId(),
				"doctor/xuezhiyujing.do")) {
			modelAndView.setViewName("fuzhuzhenzhi/nopermission");
			return modelAndView;
		}

		modelAndView.setViewName("fuzhuzhenzhi/xuezhiyujing");
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
			System.out.println("predict htn" + result.toString());
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
			System.out.println("predict htn" + result.toString());
			return result.toString();
		}
		result.put("result", 1);
		result.put("list", list);
		System.out.println("predict hpl" + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/pingTaiZhiCheng", method = RequestMethod.GET)
	public ModelAndView pingTaiZhiCheng(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());

		modelAndView.setViewName("pingtaizhicheng/pingtaizhicheng_doctor");
		return modelAndView;
	}

	@RequestMapping(value = "/yaowushiyanshi", method = RequestMethod.GET)
	public ModelAndView yaowushiyanshi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());

		if (!doctorService.checkPremission(doctor.getId(),
				"doctor/yaowushiyanshi.do")) {
			modelAndView.setViewName("fuzhuzhenzhi/nopermission");
			return modelAndView;
		}

		modelAndView.setViewName("fuzhuzhenzhi/yaowushiyanshi");
		return modelAndView;
	}

	@RequestMapping(value = "/getMedicineByType", method = RequestMethod.POST)
	@ResponseBody
	public String getMedicineByType(HttpServletRequest request, Integer type,
			Integer doctor_id) {
		JSONArray list = doctorService.getMedicine(type);
		JSONObject result = new JSONObject();

		if (list == null) {
			result.put("result", 0);
			System.out.println("get medicine by type" + result.toString());
			return result.toString();
		}

		result.put("result", 1);
		result.put("list", list);
		System.out.println("get medicine by type " + result.toString());
		return result.toString();
	}

	@RequestMapping(value = "/compare", method = RequestMethod.POST)
	@ResponseBody
	public String compare(HttpServletRequest request, Integer druga,
			Integer drugb, Integer type) {

		JSONObject result = doctorService.getCompare(type, druga, drugb);
		if (result == null) {
			result = new JSONObject();
			result.put("result", 0);
			System.out.println("get compare medicine  " + result.toString());
			return result.toString();
		}

		result.put("result", 1);
		System.out.println("get compare medicine " + result.toString());
		return result.toString();

	}

	@RequestMapping(value = "/pingtaibangzhu", method = RequestMethod.GET)
	public ModelAndView pingtaibangzhu(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		modelAndView.setViewName("pingtaizhicheng/pingtaibangzhu_doctor");
		return modelAndView;
	}

	@RequestMapping(value = "/pingtaishezhi", method = RequestMethod.GET)
	public ModelAndView pingtaishezhi(HttpServletRequest request,
			ModelAndView modelAndView) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		modelAndView.addObject("doctor", doctor);
		modelAndView.setViewName("pingtaizhicheng/pingtaishezhi_doctor");
		return modelAndView;
	}

	@RequestMapping(value = "/setting", method = RequestMethod.POST)
	public ModelAndView setting(HttpServletRequest request,
			ModelAndView modelAndView, Doctor doctor) {

		System.out.println(doctor);
		doctorService.updateDoctor(doctor);
		modelAndView.addObject("username", doctor.getUsername());
		modelAndView.addObject("userid", doctor.getId());
		modelAndView.setViewName("redirect:pingtaishezhi.do");
		return modelAndView;
	}
}
