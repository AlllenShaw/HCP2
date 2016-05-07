package com.hcp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcp.domain.*;
import com.hcp.service.DoctorService;
import com.hcp.util.SessionUtil;

/**
 * 
 * @author Allen 注册、查看个人信息、找回密码、修改信息 综合查询（输入patient_realname，patient_username,
 *         返回值：GluRecord、HdRecord、HplRecord、HtnRecord、Emr、MedicineRecord） 设置预警值
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Resource(name = "doctorService")
	private DoctorService doctorService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		model.addAttribute("doctor", doctor);
		return "/index_doctor/index_doctor";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request, Model model) {
		List<Hospital> hospitals = doctorService.getHospitals();
		model.addAttribute("hospitals", hospitals);
		return "/registered/registered_doctor";
//		 return "/test/TestJSTL";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, String username, String password, String realname,
			String gender, String nation, String age, String id2, String naddress, String profession, String tele, String mail,
			String hospital_id, String certificate, String belongdepart) {
		System.out.println("============注册====================");
		Doctor doctor = new Doctor();
		doctor.setAddress(naddress);
		doctor.setAge(age);
		DoctorGroup defaultGroup = doctorService.getDefaultGroup();
		HashSet<DoctorGroup> doctorGroups = new HashSet<DoctorGroup>();
		doctorGroups.add(defaultGroup);
		doctor.setDoctorGroups(doctorGroups);
		doctor.setDoctorLicense(certificate);
		doctor.setGender(gender);
		doctor.setHospital(doctorService.getHospitalById(Integer.parseInt(hospital_id)));
		doctor.setIdNumber(id2);
		doctor.setMail(mail);
		doctor.setNation(nation);
		doctor.setPassword(password);
		doctor.setProfession(profession);
		doctor.setRealname(realname);
		doctor.setTele(tele);
		doctor.setCompany(belongdepart);
		doctor.setUsername(username);
		doctor.setRegisterTime(new Timestamp(new Date().getTime()));
		Boolean flag = doctorService.register(doctor);
		System.out.println(flag+"-=-=-=-=-=-=-=-=-=-=-");
		if (flag) {
			return "/registered/success";
		} else {
			return "/registered/failed";
		}
	}

	@RequestMapping("/getDoctorInfo")
	public String getDoctorInfo(HttpServletRequest request, Model model, Integer doctor_id) {
		Doctor doctor = doctorService.getDoctorById(doctor_id);
		model.addAttribute("doctor", doctor);
		if (doctor != null) {
			return "/index_doctor/doctor_info";
		} else {
			return "/error/doctor/withoutThisDoctor";
		}
	}

	@RequestMapping(value = "/updateDoctorInfo", method = RequestMethod.GET)
	public String updateDoctorInfo(HttpServletRequest request, Model model, Integer doctor_id) {
		Doctor doctor = doctorService.getDoctorById(doctor_id);
		model.addAttribute("doctor", doctor);
		return "/registered/resetinfo_doctor";
	}

	@RequestMapping(value = "/updateDoctorInfo", method = RequestMethod.POST)
	public String updateDoctorInfo(HttpServletRequest request, Model model, Integer doctor_id, String age, String naddress,
			String profession, String tele, String mail, Integer hospital_id, String belongdepart) {
		Doctor doctor = doctorService.getDoctorById(doctor_id);
		Hospital hospital = doctorService.getHospitalById(hospital_id);
		doctor.setAddress(naddress);
		doctor.setAge(age);
		doctor.setProfession(profession);
		doctor.setTele(tele);
		doctor.setMail(mail);
		doctor.setHospital(hospital);
		doctor.setCompany(belongdepart);
		doctorService.updateDoctor(doctor);
		return "/doctor/getDoctorInfo.do";
	}

	@RequestMapping(value = "/seo", method = RequestMethod.GET)
	public String seo(HttpServletRequest request, Model model) {
		return "/seo/seo";
	}

	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/seo", method = RequestMethod.POST)
	public String seo(HttpServletRequest request, Model model, String selector1, String selector2, String text1, Integer doctor_id) {
		Doctor doctor = doctorService.getDoctorById(doctor_id);
		boolean flag = false;
		Patient patient = null;
		if (selector2 == "1") {
			// byUsername
			patient = doctorService.getPatientByName(text1);
		} else if (selector2 == "2") {
			// byID
			patient = doctorService.getPatientByID(text1);
		} else if (selector2 == "3") {
			// by身份证
			patient = doctorService.getPatientByIdNumber(text1);
		} else {
			return "/doctor/seo.do";
		}
		if (patient == null) {
			return "/error/withoutPatient";
		}
		// 判断该医生是不是该病人的主治医生
		if (doctorService.hasPatien(doctor, patient)) {
			flag = true;
		}

		switch (selector1) {
		// 血糖
		case "1":
			// 判断医生是否有权限查看该病人的血糖
			if (doctorService.isHasPermission(doctor, patient, 1)) {
				flag = true;
			}
			if (flag) {
				// 返回该病人的血糖信息,加入model
				Set<GluPatientRecord> gluPatientRecords = patient.getGluPatientRecords();
				model.addAttribute("gluPatientRecords", gluPatientRecords);
				// 返回血糖显示页面
				return "/index_patient/bg_patient";
			} else {
				return "/error/withoutPermission";
			}
			// 血压
		case "2":
			if (doctorService.isHasPermission(doctor, patient, 2)) {
				flag = true;
			}
			if (flag) {
				Set<HtnPatientRecord> htnPatientRecords = patient.getHtnPatientRecords();
				model.addAttribute("htnPatientRecords", htnPatientRecords);
				return "/index_patient/bp_patient";
			} else {
				return "/error/withoutPermission";
			}
			// 血氧
		case "3":
			if (doctorService.isHasPermission(doctor, patient, 3)) {
				flag = true;
			}
			if (flag) {
				Set<HplPatientRecord> hplPatientRecords = patient.getHplPatientRecords();
				model.addAttribute("hplPatientRecords", hplPatientRecords);
				return "/index_patient/spo_patient";
			} else {
				return "/error/withoutPermission";
			}
			// 心电
		case "8":
			if (doctorService.isHasPermission(doctor, patient, 4)) {
				flag = true;
			}
			if (flag) {
				Set<HdPatientRecord> hdPatientRecords = patient.getHdPatientRecords();
				model.addAttribute("hdPatientRecords", hdPatientRecords);
				return "/index_patient/hd_patient";
			} else {
				return "/error/withoutPermission";
			}
			// 用药记录
		case "9":
			if (doctorService.isHasPermission(doctor, patient, 5)) {
				flag = true;
			}
			if (flag) {
				Set<GluPatientMedicineRecord> gluPatientMedicineRecords = patient.getGluPatientMedicineRecords();
				Set<HdPatientMedicineRecord> hdPatientMedicineRecords = patient.getHdPatientMedicineRecords();
				Set<HtnPatientMedicineRecord> htnPatientMedicineRecords = patient.getHtnPatientMedicineRecords();
				Set<HplPatientMedicineRecord> hplPatientMedicineRecords = patient.getHplPatientMedicineRecords();
				model.addAttribute("gluPatientMedicineRecords", gluPatientMedicineRecords);
				model.addAttribute("hdPatientMedicineRecords", hdPatientMedicineRecords);
				model.addAttribute("htnPatientMedicineRecords", htnPatientMedicineRecords);
				model.addAttribute("hplPatientMedicineRecords", hplPatientMedicineRecords);
				return "/index_patient/med_record";
			} else {
				return "/error/withoutPermission";
			}
			// 病历
		case "10":
			if (doctorService.isHasPermission(doctor, patient, 6)) {
				flag = true;
			}
			if (flag) {
				Set<Emr> emrs = patient.getEmrs();
				model.addAttribute("emrs", emrs);
				return "/index_patient/case_history";
			} else {
				return "/error/withoutPermission";
			}
			// 处方
		case "11":
			if (doctorService.isHasPermission(doctor, patient, 7)) {
				flag = true;
			}
			List<Set<Prescription>> list = new ArrayList<Set<Prescription>>();
			if (flag) {
				Set<Emr> emrs = patient.getEmrs();
				for (Emr emr : emrs) {
					Set<Prescription> prescriptions = emr.getPrescriptions();
					list.add(prescriptions);
				}
				model.addAttribute("list", list);
				return "/medical_manage/patient_iform";
			} else {
				return "/error/withoutPermission";
			}

		default:
			break;
		}
		return "/doctor/seo.do";
	}

	@RequestMapping(value = "setWarning", method = RequestMethod.POST)
	public String setWarning() {
		// TODO
		return "/doctor/index.do";
	}

}
