package com.hcp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import com.hcp.util.TimeUtil;

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
		// return "/test/TestJSTL";
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
		System.out.println(flag + "-=-=-=-=-=-=-=-=-=-=-");
		if (flag) {
			return "/registered/success";
		} else {
			return "/registered/failed";
		}
	}

	// @RequestMapping("/getDoctorInfo")
	// public String getDoctorInfo(HttpServletRequest request, Model model, Integer doctor_id) {
	// Doctor doctor = doctorService.getDoctorById(doctor_id);
	// model.addAttribute("doctor", doctor);
	// if (doctor != null) {
	// return "/index_doctor/doctor_info";
	// } else {
	// return "/error/doctor/withoutThisDoctor";
	// }
	// }

	@RequestMapping("/getDoctorInfo")
	public String getDoctorInfo(HttpServletRequest request, Model model) {
		System.out.println("getdoctorinfo");
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		System.out.println("----------------" + doctor.getUsername() + " " + doctor.getRealname());
		model.addAttribute("doctor", doctor);
		if (doctor != null) {
			return "/index_doctor/doctor_info";
		} else {
			return "/error/doctor/withoutThisDoctor";
		}
	}

	@RequestMapping(value = "/updateDoctorInfo", method = RequestMethod.GET)
	public String updateDoctorInfo(HttpServletRequest request, Model model) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		System.out.println("----------------" + doctor.getUsername() + " " + doctor.getRealname() + " " + doctor.getAddress());
		List<Hospital> hospitals = doctorService.getHospitals();
		model.addAttribute("hospitals", hospitals);
		System.out.println("----------------" + doctor.getUsername() + " " + doctor.getRealname() + " " + doctor.getAddress());
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
		return "/registered/success";
	}

	@RequestMapping(value = "/seo", method = RequestMethod.GET)
	public String seo(HttpServletRequest request, Model model) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		System.out.println("----------------" + doctor.getUsername() + " " + doctor.getRealname() + " " + doctor.getAddress());
		model.addAttribute("doctor", doctor);
		return "/seo/seo";
	}

	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/seo", method = RequestMethod.POST)
	public String seo(HttpServletRequest request, Model model, String selector1, String selector2, String text1,String type) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		// System.out.println("----------------"+doctor.getUsername()+" "+doctor.getRealname()+" "+doctor.getAddress());
		System.out.println("seo:====" + selector1 + " " + selector2 + " " + text1);
		boolean flag = false;
		Patient patient = null;
		if (selector2.equals("1")) {
			// byUsername
			patient = doctorService.getPatientByName(text1);
		} else if (selector2.equals("2")) {
			// byID
			patient = doctorService.getPatientByID(text1);
		} else if (selector2.equals("3")) {
			// by身份证
			patient = doctorService.getPatientByIdNumber(text1);
		} else if (selector2.equals("4")) {
			return this.seoAll(doctor, selector1, model,type);
		} else {
			return "redirect:/doctor/seo.do";
		}
		System.out.println("patient==" + patient);
		if (patient == null) {
			return "/error/withoutPatient";
		}
		model.addAttribute("name", patient.getRealname());
		// 判断该医生是不是该病人的主治医生
		if (doctorService.hasPatien(doctor, patient)) {
			flag = true;
		}
		System.out.println("flag= " + flag);

		if (selector1.equals("1") || selector1.equals("5")) {
			// 血糖
			// 判断医生是否有权限查看该病人的血糖
			if (doctorService.isHasPermission(doctor, patient, 1)) {
				flag = true;
			}
			if (flag) {
				// 返回该病人的血糖信息,加入model
				Set<GluPatientRecord> gluPatientRecordsSet = patient.getGluPatientRecords();
				List<GluPatientRecord> gluPatientRecords = new ArrayList<GluPatientRecord>();
				gluPatientRecords.addAll(gluPatientRecordsSet);
				Collections.sort(gluPatientRecords, new Comparator<GluPatientRecord>() {
					@Override
					public int compare(GluPatientRecord o1, GluPatientRecord o2) {
						return o2.getId() - o1.getId();
					}
				});
				ArrayList<GluPatientInfo> tempList = new ArrayList<GluPatientInfo>();
				tempList.addAll(patient.getGluPatientInfos());
				model.addAttribute("gluPatientInfo", tempList.get(0));
				model.addAttribute("gluPatientRecords", gluPatientRecords);

				// 返回血糖显示页面
				if (selector1.equals("1")) {
					return "/index_patient/bg_patient";
				} else if (selector1.equals("5")) {
					return "/chart/bg_ichart";
				}
			} else {
				return "/error/withoutPermission";
			}
		} else if (selector1.equals("2") || selector1.equals("6")) {
			// 血压
			if (doctorService.isHasPermission(doctor, patient, 2)) {
				flag = true;
			}
			if (flag) {
				Set<HtnPatientRecord> htnPatientRecordsSet = patient.getHtnPatientRecords();
				List<HtnPatientRecord> htnPatientRecords = new ArrayList<HtnPatientRecord>();
				htnPatientRecords.addAll(htnPatientRecordsSet);
				Collections.sort(htnPatientRecords, new Comparator<HtnPatientRecord>() {
					@Override
					public int compare(HtnPatientRecord o1, HtnPatientRecord o2) {
						return o2.getId() - o1.getId();
					}
				});
				ArrayList<HtnPatientInfo> tempList = new ArrayList<HtnPatientInfo>();
				tempList.addAll(patient.getHtnPatientInfos());
				HtnPatientInfo htnPatientInfo = tempList.get(0);
				model.addAttribute("htnPatientInfo", htnPatientInfo);
				model.addAttribute("htnPatientRecords", htnPatientRecords);
				model.addAttribute("remainDay", TimeUtil.remainDays(htnPatientInfo.getRemainTime()));
				if (selector1.equals("2")) {
					return "/index_patient/bp_patient";
				} else if (selector1.equals("6")) {
					return "/chart/bp_ichart";
				}
			} else {
				return "/error/withoutPermission";
			}
		} else if (selector1.equals("3") || selector1.equals("7")) {
			// 血氧
			if (doctorService.isHasPermission(doctor, patient, 3)) {
				flag = true;
			}
			if (flag) {
				Set<BoPatientRecord> boPatientRecordsSet = patient.getBoPatientRecords();
				List<BoPatientRecord> boPatientRecords = new ArrayList<BoPatientRecord>();
				boPatientRecords.addAll(boPatientRecordsSet);
				Collections.sort(boPatientRecords, new Comparator<BoPatientRecord>() {
					@Override
					public int compare(BoPatientRecord o1, BoPatientRecord o2) {
						return o2.getId() - o1.getId();
					}
				});
				ArrayList<BoPatientInfo> tempList = new ArrayList<BoPatientInfo>();
				tempList.addAll(patient.getBoPatientInfos());
				BoPatientInfo boPatientInfo = tempList.get(0);
				model.addAttribute("boPatientInfo", boPatientInfo);
				model.addAttribute("remainDay", TimeUtil.remainDays(boPatientInfo.getRemainTime()));
				model.addAttribute("boPatientRecords", boPatientRecords);
				if (selector1.equals("3")) {
					return "/index_patient/spo_patient";
				} else if (selector1.equals("7")) {
					return "/chart/spo_ichart";
				}
			} else {
				return "/error/withoutPermission";
			}
		} else if (selector1.equals("4")) {
			// 血脂
			if (doctorService.isHasPermission(doctor, patient, 4)) {
				flag = true;
			}
			if (flag) {
				Set<HplPatientRecord> hplPatientRecordsSet = patient.getHplPatientRecords();
				List<HplPatientRecord> hplPatientRecords = new ArrayList<HplPatientRecord>();
				hplPatientRecords.addAll(hplPatientRecordsSet);
				Collections.sort(hplPatientRecords, new Comparator<HplPatientRecord>() {
					@Override
					public int compare(HplPatientRecord o1, HplPatientRecord o2) {
						return o2.getId() - o1.getId();
					}
				});
				ArrayList<HplPatientInfo> tempList = new ArrayList<HplPatientInfo>();
				HplPatientInfo hplPatientInfo = tempList.get(0);
				model.addAttribute("hplPatientInfo", tempList.get(0));
				model.addAttribute("remainDay", TimeUtil.remainDays(hplPatientInfo.getRemainTime()));
				model.addAttribute("hplPatientRecords", hplPatientRecords);
				if (selector1.equals("4")) {
					return "/index_patient/tg_patient";
				} else if (selector1.equals("?")) {
					return "/chart/tg_ichart";
				}
			} else {
				return "/error/withoutPermission";
			}
		} else if (selector1.equals("8")) {
			// 心电
			if (doctorService.isHasPermission(doctor, patient, 5)) {
				flag = true;
			}
			if (flag) {
				Set<HdPatientRecord> hdPatientRecordsSet = patient.getHdPatientRecords();
				List<HdPatientRecord> hdPatientRecords = new ArrayList<HdPatientRecord>();
				hdPatientRecords.addAll(hdPatientRecordsSet);
				Collections.sort(hdPatientRecords, new Comparator<HdPatientRecord>() {
					@Override
					public int compare(HdPatientRecord o1, HdPatientRecord o2) {
						return o2.getId() - o1.getId();
					}
				});
				ArrayList<HdPatientInfo> tempList = new ArrayList<HdPatientInfo>();
				HdPatientInfo hdPatientInfo = tempList.get(0);
				model.addAttribute("hdPatientInfo", hdPatientInfo);
				model.addAttribute("remainDay", TimeUtil.remainDays(hdPatientInfo.getRemainTime()));
				model.addAttribute("hdPatientRecords", hdPatientRecords);
				return "/index_patient/hd_patient";
			} else {
				return "/error/withoutPermission";
			}
		} else if (selector1.equals("9")) {
			// 用药记录
			if (doctorService.isHasPermission(doctor, patient, 6)) {
				flag = true;
			}
			if (flag) {
				Set<GluPatientMedicineRecord> gluPatientMedicineRecords = patient.getGluPatientMedicineRecords();
				Set<HdPatientMedicineRecord> hdPatientMedicineRecords = patient.getHdPatientMedicineRecords();
				Set<BoPatientMedicineRecord> boPatientMedicineRecords = patient.getBoPatientMedicineRecords();
				Set<HtnPatientMedicineRecord> htnPatientMedicineRecords = patient.getHtnPatientMedicineRecords();
				Set<HplPatientMedicineRecord> hplPatientMedicineRecords = patient.getHplPatientMedicineRecords();
				model.addAttribute("gluPatientMedicineRecords", gluPatientMedicineRecords);
				model.addAttribute("hdPatientMedicineRecords", hdPatientMedicineRecords);
				model.addAttribute("boPatientMedicineRecords", boPatientMedicineRecords);
				model.addAttribute("htnPatientMedicineRecords", htnPatientMedicineRecords);
				model.addAttribute("hplPatientMedicineRecords", hplPatientMedicineRecords);
				return "/index_patient/med_record";
			} else {
				return "/error/withoutPermission";
			}
		} else if (selector1.equals("10")) {
			// 病历
			if (doctorService.isHasPermission(doctor, patient, 7)) {
				flag = true;
			}
			if (flag) {
				Set<Emr> emrs = patient.getEmrs();
				model.addAttribute("patient", patient);
				model.addAttribute("emrs", emrs);
				return "/index_patient/case_history";
			} else {
				return "/error/withoutPermission";
			}
		} else if (selector1.equals("11")) {
			// 处方
			if (doctorService.isHasPermission(doctor, patient, 8)) {
				flag = true;
			}
			List<Prescription> list = new ArrayList<Prescription>();
			if (flag) {
				Set<Emr> emrsSet = patient.getEmrs();
				List<Emr> emrs = new ArrayList<Emr>();
				emrs.addAll(emrsSet);
				Collections.sort(emrs, new Comparator<Emr>() {
					@Override
					public int compare(Emr o1, Emr o2) {
						return o2.getId() - o1.getId();
					}
				});
				Set<Prescription> set = emrs.get(0).getPrescriptions();
				for (Prescription prescription : set) {
					System.out.println(prescription.getMedicine().getName());
					System.out.println(prescription.getTakingMedicineNumberEachtime());
				}
				model.addAttribute("name", patient.getRealname());
				model.addAttribute("id", patient.getId());
				model.addAttribute("emrs", emrs);
				model.addAttribute("set", set);
				return "/medical_manage/patient_iform";
			} else {
				return "/error/withoutPermission";
			}

		} else {
			return "redirect: seo.do";
		}
		return "redirect: seo.do";

	}

	@RequestMapping(value = "setWarning", method = RequestMethod.POST)
	public String setWarning(HttpServletRequest request, Model model, String patient_id, String bloodGlucoseMin,
			String bloodGlucoseMax, String pulseRateMin, String pulseRateMax, String spo2maxMin, String spo2maxMax,
			String systolicPressureMax, String systolicPressureMin, String diastolicPressureMax, String diastolicPressureMin,
			String heartRateMax, String heartRateMin) {
		Patient patient = doctorService.getPatientByID(patient_id);
		System.out.println(patient);
		Set<BoPatientInfo> boPatientInfos = patient.getBoPatientInfos();
		Set<GluPatientInfo> gluPatientInfos = patient.getGluPatientInfos();
		Set<HtnPatientInfo> htnPatientInfos = patient.getHtnPatientInfos();
		// 血氧
		if (boPatientInfos.isEmpty()) {
			System.out.println("血氧--无");
			BoPatientInfo boPatientInfo = new BoPatientInfo(patient, Float.parseFloat(pulseRateMax),
					Float.parseFloat(pulseRateMin), Float.parseFloat(spo2maxMax), Float.parseFloat(spo2maxMin), new Timestamp(
							new Date().getTime()));
			boPatientInfos.add(boPatientInfo);
		} else {
			System.out.println("血氧--有");
			for (BoPatientInfo boPatientInfo : boPatientInfos) {
				boPatientInfo.setPulseRateMax(Float.parseFloat(pulseRateMax));
				boPatientInfo.setPulseRateMin(Float.parseFloat(pulseRateMin));
				boPatientInfo.setSpo2maxMax(Float.parseFloat(spo2maxMax));
				boPatientInfo.setSpo2maxMin(Float.parseFloat(spo2maxMin));
				boPatientInfo.setUpgradeTime(new Timestamp(new Date().getTime()));
			}
		}
		// 血糖
		if (gluPatientInfos.isEmpty()) {
			GluPatientInfo gluPatientInfo = new GluPatientInfo(patient, Float.parseFloat(bloodGlucoseMax),
					Float.parseFloat(bloodGlucoseMin), new Timestamp(new Date().getTime()));
			gluPatientInfos.add(gluPatientInfo);
		} else {
			for (GluPatientInfo gluPatientInfo : gluPatientInfos) {
				gluPatientInfo.setBloodGlucoseMax(Float.parseFloat(bloodGlucoseMax));
				gluPatientInfo.setBloodGlucoseMin(Float.parseFloat(bloodGlucoseMin));
				gluPatientInfo.setUpgradeTime(new Timestamp(new Date().getTime()));
			}
		}
		// 血压
		if (htnPatientInfos.isEmpty()) {
			HtnPatientInfo htnPatientInfo = new HtnPatientInfo(patient, Float.parseFloat(diastolicPressureMax),
					Float.parseFloat(diastolicPressureMin), Float.parseFloat(systolicPressureMax),
					Float.parseFloat(systolicPressureMin), Float.parseFloat(heartRateMax), Float.parseFloat(heartRateMin),
					new Timestamp(new Date().getTime()));
			htnPatientInfos.add(htnPatientInfo);
		} else {
			for (HtnPatientInfo htnPatientInfo : htnPatientInfos) {
				htnPatientInfo.setDiastolicPressureMax(Float.parseFloat(diastolicPressureMax));
				htnPatientInfo.setDiastolicPressureMin(Float.parseFloat(diastolicPressureMin));
				htnPatientInfo.setHeartRateMax(Float.parseFloat(heartRateMax));
				htnPatientInfo.setHeartRateMin(Float.parseFloat(heartRateMin));
				htnPatientInfo.setSystolicPressureMax(Float.parseFloat(systolicPressureMax));
				htnPatientInfo.setSystolicPressureMin(Float.parseFloat(systolicPressureMin));
				htnPatientInfo.setUpgradeTime(new Timestamp(new Date().getTime()));
			}
		}
		if (doctorService.updatePatient(patient)) {
			return "/index_doctor/index";
		} else {
			return "/error/setPatientInfoError";
		}

	}

	@SuppressWarnings("unchecked")
	private String seoAll(Doctor doctor, String selecter, Model model, String type) {
		List<Patient> patients = doctorService.getPatientByDoctor(doctor);
		switch (selecter) {
		// 血糖
		case "1":
			List<GluPatientRecord> gluPatientRecords = new ArrayList<>();
			List<GluPatientInfo> gluPatientInfos = new ArrayList<GluPatientInfo>();
			for (Patient patient : patients) {
				List<GluPatientRecord> list = new ArrayList<GluPatientRecord>();
				Set<GluPatientRecord> gluPatientRecordsSet = patient.getGluPatientRecords();
				list.addAll(gluPatientRecordsSet);
				Collections.sort(list, new Comparator<GluPatientRecord>() {
					@Override
					public int compare(GluPatientRecord o1, GluPatientRecord o2) {
						return o2.getId() - o1.getId();
					}
				});
				gluPatientInfos.add(new ArrayList<GluPatientInfo>(patient.getGluPatientInfos()).get(0));
				System.out.println(gluPatientInfos);
				gluPatientRecords.add(list.get(0));
			}
			model.addAttribute("gluPatientInfos", gluPatientInfos);
			model.addAttribute("gluPatientRecords", gluPatientRecords);
			// 返回血糖显示页面
			if (type.equals("0")) {
				return "/all_form/bg_form";
			} else {
				return "/warning_setting/bg_monitor";
			}
			// 血压
		case "2":
			List<HtnPatientRecord> htnPatientRecords = new ArrayList<>();
			List<HtnPatientInfo> htnPatientInfos = new ArrayList<HtnPatientInfo>();
			for (Patient patient : patients) {
				List<HtnPatientRecord> list = new ArrayList<HtnPatientRecord>();
				Set<HtnPatientRecord> htnPatientRecordsSet = patient.getHtnPatientRecords();
				list.addAll(htnPatientRecordsSet);
				Collections.sort(list, new Comparator<HtnPatientRecord>() {
					@Override
					public int compare(HtnPatientRecord o1, HtnPatientRecord o2) {
						return o2.getId() - o1.getId();
					}
				});
				htnPatientInfos.add(new ArrayList<HtnPatientInfo>(patient.getHtnPatientInfos()).get(0));
				htnPatientRecords.add(list.get(0));
			}
			model.addAttribute("htnPatientInfos", htnPatientInfos);
			model.addAttribute("htnPatientRecords", htnPatientRecords);
			// 返回血糖显示页面
			if (type.equals("0")) {
				return "/all_form/bp_form";
			} else {
				return "/warning_setting/bp_monitor";
			}
			// 血氧
		case "3":
			List<BoPatientRecord> boPatientRecords = new ArrayList<BoPatientRecord>();
			List<BoPatientInfo> boPatientInfos = new ArrayList<BoPatientInfo>();
			for (Patient patient : patients) {
				List<BoPatientRecord> list = new ArrayList<BoPatientRecord>();
				Set<BoPatientRecord> boPatientRecordsSet = patient.getBoPatientRecords();
				list.addAll(boPatientRecordsSet);
				Collections.sort(list, new Comparator<BoPatientRecord>() {
					@Override
					public int compare(BoPatientRecord o1, BoPatientRecord o2) {
						return o2.getId() - o1.getId();
					}
				});
				System.out.println(list.get(0));
				boPatientInfos.add(new ArrayList<BoPatientInfo>(patient.getBoPatientInfos()).get(0));
				boPatientRecords.add(list.get(0));
			}
			model.addAttribute("boPatientInfos", boPatientInfos);
			model.addAttribute("boPatientRecords", boPatientRecords);
			if (type.equals("0")) {
				return "/all_form/spo_form";
			} else {
				return "/warning_setting/spo_monitor";
			}
			// 心电
		case "8":

			// 用药记录
		case "9":

			// 病历
		case "10":

			// 处方
		case "11":

		default:
			break;
		}
		return "redirect: seo.do";
	}

	@RequestMapping(value = "/getPatient", method = RequestMethod.POST)
	public String getPatient(HttpServletRequest request, Model model, String type, String text) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		Patient patient = null;
		Boolean flag = false;
		switch (type) {
		case "1":
			// 姓名
			patient = doctorService.getPatientByName(text);
			break;
		case "2":
			// ID
			patient = doctorService.getPatientByID(text);
			break;
		case "3":
			// 身份证
			patient = doctorService.getPatientByIdNumber(text);
			break;
		default:
			break;
		}
		if (patient == null) {
			return "/error/noThisPatient";
		}
		if (doctorService.hasPatien(doctor, patient)) {
			flag = true;
		}
		if (flag) {
			model.addAttribute("patient", patient);
			return "/warning_setting/warning_setting";
		}
		return "/warning_setting/warning_search";
	}

	@RequestMapping(value = "/addEmr.do", method = RequestMethod.GET)
	public String addEmr(HttpServletRequest request, Model model, String id) {
		Patient patient = doctorService.getPatientByID(id);
		SessionUtil sessionUtil = new SessionUtil(request);
		Doctor doctor = (Doctor) sessionUtil.getAttribute("USERMODEL");
		model.addAttribute("doctor", doctor);
		model.addAttribute("patient", patient);
		List<MedicineUnit> medicineUnits = doctorService.getmedicineUnitList();
		List<MealTime> mealTimes = doctorService.getMealTimeList();
		List<Medicine> medicines = doctorService.getMedicineList();
		model.addAttribute("medicineUnits", medicineUnits);
		model.addAttribute("mealTimes", mealTimes);
		model.addAttribute("medicines", medicines);
		return "/medical_manage/doctor_mmed";
	}

	@RequestMapping(value = "/addEmr.do", method = RequestMethod.POST)
	public String addEmr(HttpServletRequest request, Model model) {
		Emr emr = new Emr();
		// TODO
		return "redirect:addEmr.do";
	}

	@RequestMapping(value = "/getPrescriptionByEmr.do", method = RequestMethod.GET)
	public String getPrescriptionByEmr(HttpServletRequest request, Model model,String emr_id){
		Emr emr = doctorService.getEmrById(emr_id);
		model.addAttribute("emr", emr);
		return "/medical_manage/patient_mmed";
	}
	
	
}
