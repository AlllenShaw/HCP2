package com.hcp.domain;

import java.sql.Timestamp;

/**
 * HdPatientInfo entity. @author MyEclipse Persistence Tools
 */

public class HdPatientInfo implements java.io.Serializable {

	// Fields

	private Integer patientId;
	private Patient patient;
	private Float heartRateMax;
	private Float heartRateMin;
	private Timestamp upgradeTime;

	// Constructors

	/** default constructor */
	public HdPatientInfo() {
	}

	/** minimal constructor */
	public HdPatientInfo(Patient patient) {
		this.patient = patient;
	}

	/** full constructor */
	public HdPatientInfo(Patient patient, Float heartRateMax, Float heartRateMin, Timestamp upgradeTime) {
		this.patient = patient;
		this.heartRateMax = heartRateMax;
		this.heartRateMin = heartRateMin;
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

	public Float getHeartRateMax() {
		return this.heartRateMax;
	}

	public void setHeartRateMax(Float heartRateMax) {
		this.heartRateMax = heartRateMax;
	}

	public Float getHeartRateMin() {
		return this.heartRateMin;
	}

	public void setHeartRateMin(Float heartRateMin) {
		this.heartRateMin = heartRateMin;
	}

	public Timestamp getUpgradeTime() {
		return this.upgradeTime;
	}

	public void setUpgradeTime(Timestamp upgradeTime) {
		this.upgradeTime = upgradeTime;
	}

}