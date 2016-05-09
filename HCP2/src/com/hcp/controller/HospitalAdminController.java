package com.hcp.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.hcp.domain.Hospital;
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
	public String index(HttpServletRequest request, Model model) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator hospitalAdministrator = (HospitalAdministrator) sessionUtil.getAttribute("USERMODEL");
		model.addAttribute("hospitalAdministrator", hospitalAdministrator);
		return "/index_hmanager/index_hmanager";
	}

	@RequestMapping(value = "/getMedicine", method = RequestMethod.POST)
	public String getMedicine(HttpServletRequest request, Model model, String name) {
		String type = "1";
		if (type == "0") {
			// id
			Medicine medicine = hospitalAdminService.getMedicineById(name);
			model.addAttribute("medicine", medicine);
		} else {
			// name
			Medicine medicine = hospitalAdminService.getMedicineByName(name);
			model.addAttribute("medicine", medicine);
		}
		return "/index_hmanager/medinfo";
	}

	@RequestMapping(value = "/addMedicine", method = RequestMethod.POST)
	public String addMedicine(HttpServletRequest request, Model model, String type, String name, String adaptationDisease,
			String usage, String dosage, String adverseReaction, String taboo, String attentions) {
		Medicine medicine = new Medicine(name, adaptationDisease, usage, dosage, adverseReaction, taboo, attentions);
		// Medicine medicine = new Medicine(name);
		hospitalAdminService.addMedicine(medicine);
		return "/index_doctor/index";
	}

	@RequestMapping(value = "/showUserGroups", method = RequestMethod.GET)
	public String showUserGroups(HttpServletRequest request, Model model) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator hospitalAdministrator = (HospitalAdministrator) sessionUtil.getAttribute("USERMODEL");
		Hospital hospital = hospitalAdministrator.getHospital();
		List<UserGroup> userGroups = hospitalAdminService.getUserGroupByHospital(hospital.getId());
		model.addAttribute("userGroups", userGroups);
		model.addAttribute("hospital", hospital);
		return "/index_hmanager/group_search";
	}

	@RequestMapping(value = "/showGroupDetail", method = RequestMethod.GET)
	public String showGroupDetail(HttpServletRequest request, Model model, String group_id) {
		UserGroup group = hospitalAdminService.getUserGroupById(group_id);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxx+++  " + group);
		model.addAttribute("hospital", group.getHospital());
		model.addAttribute("group", group);
		model.addAttribute("patientGroups", group.getPatientGroups());
		model.addAttribute("doctorGroups", group.getDoctorGroups());
		return "/index_hmanager/group_info";
	}

	@RequestMapping(value = "/deleteUserGroup", method = RequestMethod.GET)
	public String deleteUserGroup(HttpServletRequest request, Model model, String group_id) {
		try {
			// TDOO
			
			hospitalAdminService.deleteUserGroup(group_id);
			return "redirect:showUserGroups.do";
		} catch (Exception e) {
			e.printStackTrace();
			return "/tips/operation_failed";
		}
	}

	@RequestMapping(value = "/addUserGroup", method = RequestMethod.GET)
	public String addUserGroup(HttpServletRequest request, Model model) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator hospitalAdministrator = (HospitalAdministrator) sessionUtil.getAttribute("USERMODEL");
		Hospital hospital = hospitalAdministrator.getHospital();
		model.addAttribute("hospital", hospital);
		return "index_hmanager/group_add";
	}

	@RequestMapping(value = "/addUserGroup", method = RequestMethod.POST)
	public String addUserGroup(HttpServletRequest request, Model model, String groupName, String description, String hospital_id) {
		try {
			UserGroup userGroup = new UserGroup(groupName);
			userGroup.setDescription(description);
			userGroup.setHospital(hospitalAdminService.getHospitalById(hospital_id));
			hospitalAdminService.addUserGroup(userGroup);
			model.addAttribute("userGroup", userGroup);
			return "/tips/operation_success";
		} catch (Exception e) {
			e.printStackTrace();
			return "/tips/operation_failed";
		}
	}

	@RequestMapping(value = "/addUser2Group", method = RequestMethod.GET)
	public String addUser2Group(HttpServletRequest request, Model model, String hospital_id) {
		Integer id = Integer.parseInt(hospital_id);
		List<UserGroup> userGroups = hospitalAdminService.getUserGroupByHospital(id);
		List<Doctor> doctors = hospitalAdminService.getDoctorByHospital(id);
		List<Patient> patients = hospitalAdminService.getPatientByHospital(id);
		model.addAttribute("userGroups", userGroups);
		model.addAttribute("doctors", doctors);
		model.addAttribute("patients", patients);
		return "index_hmanager/group_member_add";
	}

	@RequestMapping(value = "/addUser2Group", method = RequestMethod.POST)
	public String addUser2Group(HttpServletRequest request, Model model, String groupId, String type, String userId1,
			String userId2) {
		try {
			if (groupId.equals("-1")) {
				System.out.println("没有选择用户组");
				return "/tips/operation_failed";
			} else if (userId1.equals("-1") && userId2.equals("-1")) {
				System.out.println("没有选择用户");
				return "/tips/operation_failed";
			}
			if (type.equals("0")) {
				// 医生
				this.addDoctor2Group(userId1, groupId);
				System.out.println("添加医生成功");
			} else {
				// 患者
				this.addPatient2Group(userId2, groupId);
				System.out.println("添加患者成功");
			}
			return "/tips/operation_success";
		} catch (Exception e) {
			e.printStackTrace();
			return "/tips/operation_failed";
		}
	}

	@RequestMapping(value = "/addDoctor2Group", method = RequestMethod.POST)
	public String addDoctor2Group(String doctor_id, String group_id) {
		UserGroup userGroup = hospitalAdminService.getUserGroupById(group_id);
		Doctor doctor = hospitalAdminService.getDoctorById(doctor_id);
		DoctorGroup doctorGroup = new DoctorGroup(doctor, userGroup);
		hospitalAdminService.addDoctorGroup(doctorGroup);
		return "#";
	}

	@RequestMapping(value = "/addPatient2Group", method = RequestMethod.POST)
	public String addPatient2Group(String patient_id, String group_id) {
		UserGroup userGroup = hospitalAdminService.getUserGroupById(group_id);
		Patient patient = hospitalAdminService.getPatientById(patient_id);
		PatientGroup patientGroup = new PatientGroup(userGroup, patient);
		hospitalAdminService.addPatientGroup(patientGroup);
		return "#";
	}

	@RequestMapping(value = "/deleteDoctorFromGroup", method = RequestMethod.GET)
	public String deleteDoctorFromGroup(HttpServletRequest request, Model model, String doctor_id, String group_id) {
		try {
			hospitalAdminService.deleteDoctorGroup(doctor_id, group_id);
			return "/tips/operation_success";
		} catch (Exception e) {
			e.printStackTrace();
			return "/tips/operation_failed";
		}
	}

	@RequestMapping(value = "/deletePatientFromGroup", method = RequestMethod.GET)
	public String deletePatientFromGroup(HttpServletRequest request, Model model, String patient_id, String group_id) {
		try {
			hospitalAdminService.deletePatientGroup(patient_id, group_id);
			return "/tips/operation_success";
		} catch (Exception e) {
			e.printStackTrace();
			return "/tips/operation_failed";
		}

	}

	@RequestMapping(value = "/showDoctorGroupMember", method = RequestMethod.POST)
	public String showDoctorGroupMember(HttpServletRequest request, Model model, String group_id) {
		// TODO
		// 删除这个用户组的所有成员(doctorGroup和patientGroup)
		List<Doctor> doctors = hospitalAdminService.getNumberByGroupId(group_id);
		model.addAttribute("doctors", doctors);
		return "#";
	}

	@RequestMapping(value = "addGroupPermissions", method = RequestMethod.POST)
	public String addGroupPermissions(HttpServletRequest request, Model model, String group1_id, String group2_id, boolean bg,
			boolean bp, boolean bo, boolean tg, boolean hd, boolean medicineRecord, boolean emr, boolean prescription,
			boolean wEmr, boolean wPrescription) {
		try {
			if (bg == true) {
				this.addGroupPermission("1", group1_id, group2_id);
			} else {
				this.removeGroupPermission("1", group1_id, group2_id);
			}

			if (bp == true) {
				this.addGroupPermission("2", group1_id, group2_id);
			} else {
				this.removeGroupPermission("2", group1_id, group2_id);
			}

			if (bo == true) {
				this.addGroupPermission("3", group1_id, group2_id);
			} else {
				this.removeGroupPermission("3", group1_id, group2_id);
			}

			if (tg == true) {
				this.addGroupPermission("4", group1_id, group2_id);
			} else {
				this.removeGroupPermission("4", group1_id, group2_id);
			}

			if (hd == true) {
				this.addGroupPermission("5", group1_id, group2_id);
			} else {
				this.removeGroupPermission("5", group1_id, group2_id);
			}

			if (medicineRecord == true) {
				this.addGroupPermission("6", group1_id, group2_id);
			} else {
				this.removeGroupPermission("6", group1_id, group2_id);
			}

			if (emr == true) {
				this.addGroupPermission("7", group1_id, group2_id);
			} else {
				this.removeGroupPermission("7", group1_id, group2_id);
			}

			if (prescription == true) {
				this.addGroupPermission("8", group1_id, group2_id);
			} else {
				this.removeGroupPermission("8", group1_id, group2_id);
			}
			if (wEmr == true) {
				this.addGroupPermission("9", group1_id, group2_id);
			} else {
				this.removeGroupPermission("9", group1_id, group2_id);
			}

			if (wPrescription == true) {
				this.addGroupPermission("10", group1_id, group2_id);
			} else {
				this.removeGroupPermission("10", group1_id, group2_id);
			}
			return "/tips/operation_success";
		} catch (Exception e) {
			e.printStackTrace();
			return "/tips/operation_failed";
		}
	}

	private void addGroupPermission(String permission_id, String group_id1, String group_id2) {
		UserGroup userGroup1 = hospitalAdminService.getUserGroupById(group_id1);
		Permission permission = hospitalAdminService.getPermissionById(permission_id);
		UserGroup userGroup2 = hospitalAdminService.getUserGroupById(group_id2);
		UserGroupPermission userGroupPermission = new UserGroupPermission(userGroup1, permission, userGroup2);
		UserGroupPermission ugp = hospitalAdminService.getGroupPermission(group_id1, group_id2, permission_id);
		System.out.println("++++++++++++++++++++++++++++++++ugp" + ugp);
		if (ugp == null) {
			hospitalAdminService.addUserGroupPermission(userGroupPermission);
		}
	}

	private void removeGroupPermission(String permission_id, String group_id1, String group_id2) {
		UserGroupPermission userGroupPermission = hospitalAdminService.getGroupPermission(group_id1, group_id2, permission_id);
		if (userGroupPermission != null) {
			hospitalAdminService.deleteUserGroupPermission(userGroupPermission);
		}
	}

	@RequestMapping(value = "toGroupAuthority", method = RequestMethod.GET)
	public String toGroupAuthority(HttpServletRequest request, Model model) {
		SessionUtil sessionUtil = new SessionUtil(request);
		HospitalAdministrator hospitalAdministrator = (HospitalAdministrator) sessionUtil.getAttribute("USERMODEL");
		System.out.println("============================" + hospitalAdministrator.getUsername() + "===========================");
		Hospital hospital = hospitalAdministrator.getHospital();
		System.out.println(hospital.getName());
		model.addAttribute("hospital", hospital);
		List<DoctorGroup> dGroups = hospitalAdminService.getDoctorGroupByHospital(hospital.getId());
		List<PatientGroup> pGroups = hospitalAdminService.getPatientGroupByHospital(hospital.getId());
		Set<UserGroup> doctorGroups = new HashSet<UserGroup>();
		for (DoctorGroup dGroup : dGroups) {
			doctorGroups.add(dGroup.getUserGroup());
		}
		for (UserGroup userGroup : doctorGroups) {
			System.out.println(userGroup.getName());
		}
		Set<UserGroup> patientGroups = new HashSet<UserGroup>();
		for (PatientGroup pGroup : pGroups) {
			patientGroups.add(pGroup.getUserGroup());
		}
		for (UserGroup userGroup : patientGroups) {
			System.out.println(userGroup.getName());
		}
		// List<UserGroup> userGroups = hospitalAdminService.getUserGroupByHospital(hospital.getId());
		// model.addAttribute("userGroups", userGroups);
		model.addAttribute("doctorGroups", doctorGroups);
		model.addAttribute("paientGroups", patientGroups);
		return "/index_hmanager/group_authority";
	}

}
