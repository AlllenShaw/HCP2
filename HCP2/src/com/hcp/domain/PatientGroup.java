package com.hcp.domain;

/**
 * PatientGroup entity. @author MyEclipse Persistence Tools
 */

public class PatientGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserGroup userGroup;
	private Patient patient;

	// Constructors

	/** default constructor */
	public PatientGroup() {
	}

	/** full constructor */
	public PatientGroup(UserGroup userGroup, Patient patient) {
		this.userGroup = userGroup;
		this.patient = patient;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}