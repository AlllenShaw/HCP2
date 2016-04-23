package com.hcp.domain;

/**
 * DoctorGroup entity. @author MyEclipse Persistence Tools
 */

public class DoctorGroup implements java.io.Serializable {

	// Fields

	private Integer id;
	private Doctor doctor;
	private UserGroup userGroup;

	// Constructors

	/** default constructor */
	public DoctorGroup() {
	}

	/** full constructor */
	public DoctorGroup(Doctor doctor, UserGroup userGroup) {
		this.doctor = doctor;
		this.userGroup = userGroup;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public UserGroup getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}