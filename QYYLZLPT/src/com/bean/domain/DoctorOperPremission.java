package com.bean.domain;

/**
 * DoctorOperPremission entity. @author MyEclipse Persistence Tools
 */

public class DoctorOperPremission implements java.io.Serializable {

	// Fields

	private DoctorOperPremissionId id;
	private Doctor doctor;
	private DoctorPremission doctorPremission;

	// Constructors

	/** default constructor */
	public DoctorOperPremission() {
	}

	/** full constructor */
	public DoctorOperPremission(DoctorOperPremissionId id, Doctor doctor,
			DoctorPremission doctorPremission) {
		this.id = id;
		this.doctor = doctor;
		this.doctorPremission = doctorPremission;
	}

	// Property accessors

	public DoctorOperPremissionId getId() {
		return this.id;
	}

	public void setId(DoctorOperPremissionId id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public DoctorPremission getDoctorPremission() {
		return this.doctorPremission;
	}

	public void setDoctorPremission(DoctorPremission doctorPremission) {
		this.doctorPremission = doctorPremission;
	}

}