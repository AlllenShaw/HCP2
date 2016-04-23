package com.hcp.domain;

import java.sql.Timestamp;

/**
 * PatientHasDoctor entity. @author MyEclipse Persistence Tools
 */

public class PatientHasDoctor implements java.io.Serializable {

	// Fields

	private PatientHasDoctorId id;
	private Timestamp lastTreat;

	// Constructors

	/** default constructor */
	public PatientHasDoctor() {
	}

	/** minimal constructor */
	public PatientHasDoctor(PatientHasDoctorId id) {
		this.id = id;
	}

	/** full constructor */
	public PatientHasDoctor(PatientHasDoctorId id, Timestamp lastTreat) {
		this.id = id;
		this.lastTreat = lastTreat;
	}

	// Property accessors

	public PatientHasDoctorId getId() {
		return this.id;
	}

	public void setId(PatientHasDoctorId id) {
		this.id = id;
	}

	public Timestamp getLastTreat() {
		return this.lastTreat;
	}

	public void setLastTreat(Timestamp lastTreat) {
		this.lastTreat = lastTreat;
	}

}