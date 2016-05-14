package com.hcp.domain;

import java.sql.Timestamp;

/**
 * BoPatientInfo entity. @author MyEclipse Persistence Tools
 */

public class BoPatientInfo implements java.io.Serializable {

	// Fields

	private Integer patientId;
	private Patient patient;
	private Float pulseRateMax;
	private Float pulseRateMin;
	private Float spo2maxMax;
	private Float spo2maxMin;
	private Timestamp upgradeTime;
	private Timestamp remainTime;

	// Constructors

	/** default constructor */
	public BoPatientInfo() {
	}

	/** minimal constructor */
	public BoPatientInfo(Patient patient) {
		this.patient = patient;
	}

	/** full constructor */
	public BoPatientInfo(Patient patient, Float pulseRateMax, Float pulseRateMin, Float spo2maxMax, Float spo2maxMin,
			Timestamp upgradeTime) {
		this.patient = patient;
		this.pulseRateMax = pulseRateMax;
		this.pulseRateMin = pulseRateMin;
		this.spo2maxMax = spo2maxMax;
		this.spo2maxMin = spo2maxMin;
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

	public Float getPulseRateMax() {
		return this.pulseRateMax;
	}

	public void setPulseRateMax(Float pulseRateMax) {
		this.pulseRateMax = pulseRateMax;
	}

	public Float getPulseRateMin() {
		return this.pulseRateMin;
	}

	public void setPulseRateMin(Float pulseRateMin) {
		this.pulseRateMin = pulseRateMin;
	}

	public Float getSpo2maxMax() {
		return this.spo2maxMax;
	}

	public void setSpo2maxMax(Float spo2maxMax) {
		this.spo2maxMax = spo2maxMax;
	}

	public Float getSpo2maxMin() {
		return this.spo2maxMin;
	}

	public void setSpo2maxMin(Float spo2maxMin) {
		this.spo2maxMin = spo2maxMin;
	}

	public Timestamp getUpgradeTime() {
		return this.upgradeTime;
	}

	public void setUpgradeTime(Timestamp upgradeTime) {
		this.upgradeTime = upgradeTime;
	}

	public Timestamp getRemainTime() {
		return this.remainTime;
	}

	public void setRemainTime(Timestamp remainTime) {
		this.remainTime = remainTime;
	}

}