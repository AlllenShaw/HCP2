package com.hcp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpRecoverableException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcp.domain.Doctor;
import com.hcp.domain.DoctorGroup;
import com.hcp.domain.HospitalAdministrator;
import com.hcp.domain.Medicine;
import com.hcp.domain.Patient;
import com.hcp.domain.PatientGroup;
import com.hcp.domain.Permission;
import com.hcp.domain.UserGroup;
import com.hcp.domain.UserGroupPermission;
import com.hcp.service.HospitalAdminService;
import com.hcp.util.SessionUtil;

/**
 * 
 * @author Allen 1.查询药物（药物名称/id,返回药物对象） 2.添加药物 3.修改药物（id/名称、。。。。） 4.添加合作医院 5.添加用户组、修改用户组信息、添加用户组用户、修改用户组用户、添加用户组权限、移除权限
 */
@Controller
@RequestMapping("/hospitalAdmin")
public class HospitalAdminController {

	@Resource
	private HospitalAdminService hospitalAdminService;

	@RequestMapping("/index")
	public String index(HttpServletRequest request, Model model){
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator hospitalAdministrator = (HospitalAdministrator) sessionUtil.getAttribute("USERMODEL");
		model.addAttribute("hospitalAdministrator", hospitalAdministrator);
		return "/index_hmanager/index_hmanager";
	}
	
	
	@RequestMapping(value = "/getMedicine", method = RequestMethod.POST)
	public String getMedicine(HttpServletRequest request, Model model, String type, String text) {
		if (type == "0") {
			// id
			Medicine medicine = hospitalAdminService.getMedicineById(text);
			model.addAttribute("medicine", medicine);
		} else {
			// name
			Medicine medicine = hospitalAdminService.getMedicineByName(text);
			model.addAttribute("medicine", medicine);
		}
		return "/medical_manage/medicine_info";
	}

	@RequestMapping(value = "/addMedicine", method = RequestMethod.POST)
	public String addMedicine(HttpServletRequest request, Model model, String type, String medicine_id, String medicine_name,
			String number) {
		Medicine medicine = new Medicine(medicine_name);
		medicine.setAdaptationDisease(type);
		hospitalAdminService.addMedicine(medicine);
		return "/medical_manage/hmanager_mmed";
	}
	
	
	@RequestMapping(value = "/addUserGroup", method = RequestMethod.POST)
	public String addUserGroup(HttpServletRequest request, Model model,String groupName,String description){
		UserGroup userGroup = new UserGroup(groupName);
		userGroup.setDescription(description);
		hospitalAdminService.addUserGroup(userGroup);
		model.addAttribute("userGroup", userGroup);
		return "/hospitalAdmin/listUserGroup.do";
	}
	
	@RequestMapping(value="/addDoctor2Group",method = RequestMethod.POST)
	public String addDoctor2Group(HttpServletRequest request, Model model,String doctor_id, String group_id){
		UserGroup userGroup = hospitalAdminService.getUserGroupById(group_id);
		Doctor doctor = hospitalAdminService.getDoctorById(doctor_id);
		DoctorGroup doctorGroup = new DoctorGroup(doctor, userGroup);
		hospitalAdminService.addDoctorGroup(doctorGroup);
		return "#";
	}
	
	@RequestMapping(value="/addPatient2Group",method = RequestMethod.POST)
	public String addPatient2Group(HttpServletRequest request, Model model,String patient_id, String group_id){
		UserGroup userGroup = hospitalAdminService.getUserGroupById(group_id);
		Patient patient = hospitalAdminService.getPatientById(patient_id);
		PatientGroup patientGroup = new PatientGroup(userGroup, patient);
		hospitalAdminService.addPatientGroup(patientGroup);
		return "#";
	}
	
	@RequestMapping(value="/deleteDoctorFromGroup",method = RequestMethod.POST)
	public String deleteDoctorFromGroup(HttpServletRequest request, Model model,String doctor_id, String group_id){
		hospitalAdminService.deleteDoctorGroup(doctor_id,group_id);
		return "#";
	}
	
	@RequestMapping(value="/deletePatientFromGroup",method = RequestMethod.POST)
	public String deletePatientFromGroup(HttpServletRequest request, Model model,String patient_id, String group_id){
		hospitalAdminService.deletePatientGroup(patient_id,group_id);
		return "#";
	}
	
	@RequestMapping(value="/showDoctorGroupNumber",method = RequestMethod.POST)
	public String showDoctorGroupNumber(HttpServletRequest request, Model model,String group_id){
		//TODO 
		List<Doctor> doctors = hospitalAdminService.getNumberByGroupId(group_id);
		model.addAttribute("doctors", doctors);
		return "#";
	}
	
	public String addGroupPermission(HttpServletRequest request, Model model,String permission_id,String group_id1,String group_id2){
		
		UserGroup userGroup1 = hospitalAdminService.getUserGroupById(group_id1);
		Permission permission = hospitalAdminService.getPermissionById(permission_id);
		UserGroup userGroup2 = hospitalAdminService.getUserGroupById(group_id2);
		UserGroupPermission userGroupPermission = new UserGroupPermission(userGroup1, permission, userGroup2);
		hospitalAdminService.addUserGroupPermission(userGroupPermission);
		return "#";
	}
	
	public String removeGroupPermission(HttpServletRequest request, Model model,String permission_id,String group_id1,String group_id2){
		UserGroupPermission userGroupPermission = hospitalAdminService.getGroupPermission(group_id1,group_id2,permission_id);
		hospitalAdminService.deleteUserGroupPermission(userGroupPermission);
		return "#";
	}
}
