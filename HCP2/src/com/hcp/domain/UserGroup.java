package com.hcp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * UserGroup entity. @author MyEclipse Persistence Tools
 */

public class UserGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private Hospital hospital;
	private String name;
	private String description;
	private Set userGroupPermissionsForUserGroup1Id = new HashSet(0);
	private Set patientGroups = new HashSet(0);
	private Set doctorGroups = new HashSet(0);
	private Set userGroupPermissionsForUserGroup2Id = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserGroup() {
	}

	/** minimal constructor */
	public UserGroup(String name) {
		this.name = name;
	}

	/** full constructor */
	public UserGroup(Hospital hospital, String name, String description, Set userGroupPermissionsForUserGroup1Id,
			Set patientGroups, Set doctorGroups, Set userGroupPermissionsForUserGroup2Id) {
		this.hospital = hospital;
		this.name = name;
		this.description = description;
		this.userGroupPermissionsForUserGroup1Id = userGroupPermissionsForUserGroup1Id;
		this.patientGroups = patientGroups;
		this.doctorGroups = doctorGroups;
		this.userGroupPermissionsForUserGroup2Id = userGroupPermissionsForUserGroup2Id;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getUserGroupPermissionsForUserGroup1Id() {
		return this.userGroupPermissionsForUserGroup1Id;
	}

	public void setUserGroupPermissionsForUserGroup1Id(Set userGroupPermissionsForUserGroup1Id) {
		this.userGroupPermissionsForUserGroup1Id = userGroupPermissionsForUserGroup1Id;
	}

	public Set getPatientGroups() {
		return this.patientGroups;
	}

	public void setPatientGroups(Set patientGroups) {
		this.patientGroups = patientGroups;
	}

	public Set getDoctorGroups() {
		return this.doctorGroups;
	}

	public void setDoctorGroups(Set doctorGroups) {
		this.doctorGroups = doctorGroups;
	}

	public Set getUserGroupPermissionsForUserGroup2Id() {
		return this.userGroupPermissionsForUserGroup2Id;
	}

	public void setUserGroupPermissionsForUserGroup2Id(Set userGroupPermissionsForUserGroup2Id) {
		this.userGroupPermissionsForUserGroup2Id = userGroupPermissionsForUserGroup2Id;
	}

}