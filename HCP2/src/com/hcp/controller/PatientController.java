package com.hcp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.hcp.domain.BoPatientMedicineRecord;
import com.hcp.domain.BoPatientRecord;
import com.hcp.domain.Doctor;
import com.hcp.domain.Emr;
import com.hcp.domain.Family;
import com.hcp.domain.GluPatientMedicineRecord;
import com.hcp.domain.GluPatientRecord;
import com.hcp.domain.HdPatientMedicineRecord;
import com.hcp.domain.HdPatientRecord;
import com.hcp.domain.Hospital;
import com.hcp.domain.HplPatientMedicineRecord;
import com.hcp.domain.HplPatientRecord;
import com.hcp.domain.HtnPatientMedicineRecord;
import com.hcp.domain.HtnPatientRecord;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.PatientHasDoctor;
import com.hcp.domain.PatientHasDoctorId;
import com.hcp.domain.Prescription;
import com.hcp.service.PatientService;
import com.hcp.util.SessionUtil;

/**
 * 
 * 注册、查看个人信息、找回密码、修改信息 （输入patient_id, 返回值：GluRecord、HdRecord、HplRecord、HtnRecord、Emr、MedicineRecord）
 * 
 */

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Resource(name = "patientService")
	private PatientService patientService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		model.addAttribute("patient", patient);
		return "/index_patient/index_patient";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(HttpServletRequest request, Model model) {
		List<Hospital> hospitals = patientService.getHospitals();
		List<Doctor> doctors = patientService.getDoctorList();
		model.addAttribute("hospitals", hospitals);
		model.addAttribute("doctors", doctors);
		return "/registered/registered_patient";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, Model model, String username, String password, String realname,
			String gender, String nation, String age, String marriage, String profession, String id2, String hin,
			String education, String address, String naddress, String company, String tele, String email, String hospital_id,
			String doctor_id, String fname1, String relationship1, String tele1, String faddress1, String femail1, String fname2,
			String relationship2, String tele2, String faddress2, String femail2, boolean htnstate, boolean glustate,
			boolean hplstate, String illnesshistory, String allergichistory, String familymedicalhistory, String security1,
			String security2, String security3) {
		System.out.println("=====================================================Register");
		System.out.println("=====================================================Register");
		System.out.println("=====================================================Register");
		Patient patient = new Patient();
		patient.setAddress(naddress);
		patient.setAge(age);
		patient.setAllergicHis(allergichistory);
		patient.setAnswer1(security1);
		patient.setAnswer2(security2);
		patient.setAnswer3(security3);
		patient.setBirAddress(address);
		patient.setCompany(company);
		patient.setEducation(education);
		Family family1 = new Family(fname1, relationship1, tele1, faddress1, femail1, null, null);
		Family family2 = new Family(fname2, relationship2, tele2, faddress2, femail2, null, null);
		patient.setFamilyByFamlily1(family1);
		patient.setFamilyByFamlily2(family2);
		patient.setFamilyHis(familymedicalhistory);
		patient.setGender(gender);
		patient.setGluState(glustate);
		patient.setHplState(hplstate);
		patient.setHtnState(htnstate);
		patient.setHin(hin);
		Hospital hospital = patientService.getHospitalByID(hospital_id);
		patient.setHospital(hospital);
		patient.setIdNumber(id2);
		patient.setIllnessHis(illnesshistory);
		patient.setMail(email);
		boolean marriaged = false;
		if (marriage != "0") {
			marriaged = true;
		}
		patient.setMarriage(marriaged);
		patient.setNation(nation);
		patient.setPassword(password);
		Set<PatientGroup> patientGroups = new HashSet<PatientGroup>();
		PatientGroup defaultGroup = patientService.getDefaultGroup();
		patientGroups.add(defaultGroup);
		patient.setPatientGroups(patientGroups);
		Doctor doctor = patientService.getDoctorById(Integer.parseInt(doctor_id));
		PatientHasDoctorId patientHasDoctorId = new PatientHasDoctorId(patient, doctor);
		PatientHasDoctor patientHasDoctor = new PatientHasDoctor(patientHasDoctorId, new Timestamp(new Date().getTime()));
		Set<PatientHasDoctor> patientHasDoctors = new HashSet<PatientHasDoctor>();
		patientHasDoctors.add(patientHasDoctor);
		patient.setPatientHasDoctors(patientHasDoctors);
		patient.setProfession(profession);
		patient.setRealname(realname);
		patient.setTele(tele);
		patient.setUsername(username);
		patient.setRegisterTime(new Timestamp(new Date().getTime()));
		Boolean flag = patientService.register(patient, family1, family2, patientHasDoctor);
		System.out.println(flag);
		if (flag) {
			System.out.println("return main");
			return "/main/main";
		} else {
			System.out.println("return register.do");
			return "redirect:register.do";
		}
	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public String forgetPassword(HttpServletRequest request, Model model, String username, String password, String security1,
			String security2, String security3) {
		Patient patient = patientService.getPatientByName(username);
		if ((patient.getAnswer1().equals(security1)) && (patient.getAnswer2().equals(security2))
				&& (patient.getAnswer3().equals(security3))) {
			patient.setPassword(password);
			patientService.updatePatient(patient);
			return "/main/main";
		} else {
			return "/error/securityAnswerError";
		}
	}

	@RequestMapping("/getPatientInfo")
	public String getPatientInfo(HttpServletRequest request, Model model, Integer patient_id) {
		Patient patient = patientService.getPatientById(patient_id);
		model.addAttribute("patient", patient);
		return "/registered/resetinfo_patient";
	}

	@RequestMapping(value = "/updatePatientInfo", method = RequestMethod.GET)
	public String updatePatientInfo(HttpServletRequest request, Model model, Integer patient_id) {
		Patient patient = patientService.getPatientById(patient_id);
		model.addAttribute("doctor", patient);
		return "/registered/resetinfo_patient";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updatePatientInfo", method = RequestMethod.POST)
	public String updatePatientInfo(HttpServletRequest request, Model model, Integer patient_id, String age, String marriage,
			String profession, String education, String naddress, String company, String tele, String email, String hospital_id,
			String doctor_id, String fname1, String relationship1, String tele1, String faddress1, String femail1, String fname2,
			String relationship2, String tele2, String faddress2, String femail2, boolean htnstate, boolean glustate,
			boolean hplstate, String illnesshistory, String allergichistory, String familymedicalhistory) {
		Patient patient = patientService.getPatientById(patient_id);
		Doctor doctor = patientService.getDoctorById(Integer.parseInt(doctor_id));
		Hospital hospital = patientService.getHospitalByID(hospital_id);
		patient.setAge(age);
		boolean marriaged = false;
		if (marriage != "0") {
			marriaged = true;
		}
		patient.setMarriage(marriaged);
		patient.setProfession(profession);
		patient.setEducation(education);
		patient.setAddress(naddress);
		patient.setCompany(company);
		patient.setTele(tele);
		patient.setMail(email);
		patient.setHospital(hospital);
		PatientHasDoctorId patientHasDoctorId = new PatientHasDoctorId(patient, doctor);
		PatientHasDoctor patientHasDoctor = new PatientHasDoctor(patientHasDoctorId, new Timestamp(new Date().getTime()));
		Set<PatientHasDoctor> patientHasDoctors = patient.getPatientHasDoctors();
		patientHasDoctors.add(patientHasDoctor);
		patient.setPatientHasDoctors(patientHasDoctors);
		patient.setGluState(glustate);
		patient.setHplState(hplstate);
		patient.setHtnState(htnstate);
		if (patientService.updatePatient(patient)) {
			return "/patient/getPatientInfo.do";
		} else {
			return "error/updateFail";
		}
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getGluRecord")
	public String getGluRecord(HttpServletRequest request, Model model, Integer patient_id) {
		Patient patient = patientService.getPatientById(patient_id);
		Set<GluPatientRecord> gluPatientRecords = patient.getGluPatientRecords();
		model.addAttribute("gluPatientRecords", gluPatientRecords);
		return "/index_patient/bg_patient";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getHtnRecord")
	public String getHtnRecord(HttpServletRequest request, Model model, Integer patient_id) {
		Patient patient = patientService.getPatientById(patient_id);
		Set<HtnPatientRecord> htnPatientRecords = patient.getHtnPatientRecords();
		model.addAttribute("htnPatientRecords", htnPatientRecords);
		return "/index_patient/bg_patient";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getHplRecord")
	public String getHplRecord(HttpServletRequest request, Model model, Integer patient_id) {
		Patient patient = patientService.getPatientById(patient_id);
		Set<HplPatientRecord> hplPatientRecords = patient.getHplPatientRecords();
		model.addAttribute("hplPatientRecords", hplPatientRecords);
		return "/index_patient/bg_patient";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getHdRecord")
	public String getHdRecord(HttpServletRequest request, Model model, Integer patient_id) {
		Patient patient = patientService.getPatientById(patient_id);
		Set<HdPatientRecord> hdPatientRecords = patient.getHdPatientRecords();
		model.addAttribute("hdPatientRecords", hdPatientRecords);
		return "/index_patient/hd_patient";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getEmr")
	public String getEmr(HttpServletRequest request, Model model, Integer patient_id) {
		Patient patient = patientService.getPatientById(patient_id);
		Set<Emr> emrs = patient.getEmrs();
		model.addAttribute("emrs", emrs);
		return "/index_patient/case_history";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/getMedicineRecord")
	public String getMedicineRecord(HttpServletRequest request, Model model, Integer patient_id) {
		Patient patient = patientService.getPatientById(patient_id);
		Set<GluPatientMedicineRecord> gluPatientMedicineRecords = patient.getGluPatientMedicineRecords();
		Set<HdPatientMedicineRecord> hdPatientMedicineRecords = patient.getHdPatientMedicineRecords();
		Set<HtnPatientMedicineRecord> htnPatientMedicineRecords = patient.getHtnPatientMedicineRecords();
		Set<HplPatientMedicineRecord> hplPatientMedicineRecords = patient.getHplPatientMedicineRecords();
		model.addAttribute("gluPatientMedicineRecords", gluPatientMedicineRecords);
		model.addAttribute("hdPatientMedicineRecords", hdPatientMedicineRecords);
		model.addAttribute("htnPatientMedicineRecords", htnPatientMedicineRecords);
		model.addAttribute("hplPatientMedicineRecords", hplPatientMedicineRecords);
		return "/index_patient/med_record";
	}

	@SuppressWarnings({ "unchecked" })
	@RequestMapping(value = "/seo", method = RequestMethod.GET)
	public String seo(HttpServletRequest request, Model model, String selector1) {
		SessionUtil sessionUtil = new SessionUtil(request);
		Patient patient = (Patient) sessionUtil.getAttribute("USERMODEL");
		// System.out.println("----------------"+doctor.getUsername()+" "+doctor.getRealname()+" "+doctor.getAddress());
		System.out.println("seo:====" + selector1);
		System.out.println("patient==" + patient);
		if (patient == null) {
			return "/error/withoutPatient";
		}
		model.addAttribute("name", patient.getRealname());

		if (selector1.equals("1") || selector1.equals("5")) {
			// 血糖
			Set<GluPatientRecord> gluPatientRecordsSet = patient.getGluPatientRecords();
			List<GluPatientRecord> gluPatientRecords = new ArrayList<GluPatientRecord>();
			gluPatientRecords.addAll(gluPatientRecordsSet);
			Collections.sort(gluPatientRecords, new Comparator<GluPatientRecord>() {
				@Override
				public int compare(GluPatientRecord o1, GluPatientRecord o2) {
					return o2.getId() - o1.getId();
				}
			});
			model.addAttribute("gluPatientRecords", gluPatientRecords);
			// 返回血糖显示页面
			if (selector1.equals("1")) {
				return "/index_patient/bg_patient";
			} else if (selector1.equals("5")) {
				return "/chart/bg_ichart";
			}
		} else if (selector1.equals("2") || selector1.equals("6")) {
			// 血压

			Set<HtnPatientRecord> htnPatientRecordsSet = patient.getHtnPatientRecords();
			List<HtnPatientRecord> htnPatientRecords = new ArrayList<HtnPatientRecord>();
			htnPatientRecords.addAll(htnPatientRecordsSet);
			Collections.sort(htnPatientRecords, new Comparator<HtnPatientRecord>() {
				@Override
				public int compare(HtnPatientRecord o1, HtnPatientRecord o2) {
					return o2.getId() - o1.getId();
				}
			});
			model.addAttribute("htnPatientRecords", htnPatientRecords);
			if (selector1.equals("2")) {
				return "/index_patient/bp_patient";
			} else if (selector1.equals("6")) {
				return "/chart/bp_ichart";
			}

		} else if (selector1.equals("3") || selector1.equals("7")) {
			// 血氧

			Set<BoPatientRecord> boPatientRecordsSet = patient.getBoPatientRecords();
			List<BoPatientRecord> boPatientRecords = new ArrayList<BoPatientRecord>();
			boPatientRecords.addAll(boPatientRecordsSet);
			Collections.sort(boPatientRecords, new Comparator<BoPatientRecord>() {
				@Override
				public int compare(BoPatientRecord o1, BoPatientRecord o2) {
					return o2.getId() - o1.getId();
				}
			});
			model.addAttribute("boPatientRecords", boPatientRecords);
			if (selector1.equals("3")) {
				return "/index_patient/spo_patient";
			} else if (selector1.equals("7")) {
				return "/chart/sop_ichart";
			}

		} else if (selector1.equals("4")) {
			// 血脂

			Set<HplPatientRecord> hplPatientRecordsSet = patient.getHplPatientRecords();
			List<HplPatientRecord> hplPatientRecords = new ArrayList<HplPatientRecord>();
			hplPatientRecords.addAll(hplPatientRecordsSet);
			Collections.sort(hplPatientRecords, new Comparator<HplPatientRecord>() {
				@Override
				public int compare(HplPatientRecord o1, HplPatientRecord o2) {
					return o2.getId() - o1.getId();
				}
			});
			model.addAttribute("hplPatientRecords", hplPatientRecords);
			if (selector1.equals("4")) {
				return "/index_patient/tg_patient";
			} else if (selector1.equals("?")) {
				return "/chart/tg_ichart";
			}

		} else if (selector1.equals("8")) {
			// 心电

			Set<HdPatientRecord> hdPatientRecordsSet = patient.getHdPatientRecords();
			List<HdPatientRecord> hdPatientRecords = new ArrayList<HdPatientRecord>();
			hdPatientRecords.addAll(hdPatientRecordsSet);
			Collections.sort(hdPatientRecords, new Comparator<HdPatientRecord>() {
				@Override
				public int compare(HdPatientRecord o1, HdPatientRecord o2) {
					return o2.getId() - o1.getId();
				}
			});
			model.addAttribute("hdPatientRecords", hdPatientRecords);
			return "/index_patient/hd_patient";

		} else if (selector1.equals("9")) {
			// 用药记录

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

		} else if (selector1.equals("10")) {
			// 病历

			Set<Emr> emrs = patient.getEmrs();
			model.addAttribute("patient", patient);
			model.addAttribute("emrs", emrs);
			return "/index_patient/case_history";

		} else if (selector1.equals("11")) {
			// 处方

			List<Prescription> list = new ArrayList<Prescription>();

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
			return "/medical_manage/patient_mmed";

		} else {
			return "redirect: seo.do";
		}
		return "redirect: seo.do";

	}

}
