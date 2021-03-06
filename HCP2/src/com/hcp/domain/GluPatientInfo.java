package com.hcp.domain;

import java.sql.Timestamp;

/**
 * GluPatientInfo entity. @author MyEclipse Persistence Tools
 */

public class GluPatientInfo implements java.io.Serializable {

	// Fields

	private Integer patientId;
	private Patient patient;
	private Float bloodGlucoseMax;
	private Float bloodGlucoseMin;
	private Timestamp upgradeTime;
	private Integer remainTime;

	// Constructors

	/** default constructor */
	public GluPatientInfo() {
	}

	/** minimal constructor */
	public GluPatientInfo(Patient patient) {
		this.patient = patient;
	}

	/** full constructor */
	public GluPatientInfo(Integer patientId, Patient patient, Float bloodGlucoseMax, Float bloodGlucoseMin, Timestamp upgradeTime) {
		this.patientId = patientId;
		this.patient = patient;
		this.bloodGlucoseMax = bloodGlucoseMax;
		this.bloodGlucoseMin = bloodGlucoseMin;
		this.upgradeTime = upgradeTime;
	}

	// Property accessors

	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Float getBloodGlucoseMax() {
		return this.bloodGlucoseMax;
	}

	public void setBloodGlucoseMax(Float bloodGlucoseMax) {
		this.bloodGlucoseMax = bloodGlucoseMax;
	}

	public Float getBloodGlucoseMin() {
		return this.bloodGlucoseMin;
	}

	public void setBloodGlucoseMin(Float bloodGlucoseMin) {
		this.bloodGlucoseMin = bloodGlucoseMin;
	}

	public Timestamp getUpgradeTime() {
		return this.upgradeTime;
	}

	public void setUpgradeTime(Timestamp upgradeTime) {
		this.upgradeTime = upgradeTime;
	}

	public Integer getRemainTime() {
		return this.remainTime;
	}

	public void setRemainTime(Integer remainTime) {
		this.remainTime = remainTime;
	}

}