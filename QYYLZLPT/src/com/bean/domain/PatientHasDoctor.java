package com.bean.domain;

/**
 * PatientHasDoctor entity. @author MyEclipse Persistence Tools
 */

public class PatientHasDoctor implements java.io.Serializable {

	// Fields

	private PatientHasDoctorId id;

	// Constructors

	/** default constructor */
	public PatientHasDoctor() {
	}

	/** full constructor */
	public PatientHasDoctor(PatientHasDoctorId id) {
		this.id = id;
	}

	// Property accessors

	public PatientHasDoctorId getId() {
		return this.id;
	}

	public void setId(PatientHasDoctorId id) {
		this.id = id;
	}

}