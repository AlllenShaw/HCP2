package com.hcp.domain;

import java.sql.Timestamp;

/**
 * HtnPatientInfo entity. @author MyEclipse Persistence Tools
 */

public class HtnPatientInfo implements java.io.Serializable {

	// Fields

	private Integer patientId;
	private Patient patient;
	private Float diastolicPressureMax;
	private Float diastolicPressureMin;
	private Float systolicPressureMax;
	private Float systolicPressureMin;
	private Float heartRateMax;
	private Float heartRateMin;
	private Timestamp upgradeTime;

	// Constructors

	/** default constructor */
	public HtnPatientInfo() {
	}

	/** minimal constructor */
	public HtnPatientInfo(Patient patient) {
		this.patient = patient;
	}

	/** full constructor */
	public HtnPatientInfo(Patient patient, Float diastolicPressureMax, Float diastolicPressureMin, Float systolicPressureMax,
			Float systolicPressureMin, Float heartRateMax, Float heartRateMin, Timestamp upgradeTime) {
		this.patient = patient;
		this.diastolicPressureMax = diastolicPressureMax;
		this.diastolicPressureMin = diastolicPressureMin;
		this.systolicPressureMax = systolicPressureMax;
		this.systolicPressureMin = systolicPressureMin;
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

	public Float getDiastolicPressureMax() {
		return this.diastolicPressureMax;
	}

	public void setDiastolicPressureMax(Float diastolicPressureMax) {
		this.diastolicPressureMax = diastolicPressureMax;
	}

	public Float getDiastolicPressureMin() {
		return this.diastolicPressureMin;
	}

	public void setDiastolicPressureMin(Float diastolicPressureMin) {
		this.diastolicPressureMin = diastolicPressureMin;
	}

	public Float getSystolicPressureMax() {
		return this.systolicPressureMax;
	}

	public void setSystolicPressureMax(Float systolicPressureMax) {
		this.systolicPressureMax = systolicPressureMax;
	}

	public Float getSystolicPressureMin() {
		return this.systolicPressureMin;
	}

	public void setSystolicPressureMin(Float systolicPressureMin) {
		this.systolicPressureMin = systolicPressureMin;
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