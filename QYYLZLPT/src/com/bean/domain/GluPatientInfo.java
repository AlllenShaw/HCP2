package com.bean.domain;

import java.util.Date;

/**
 * GluPatientInfo entity. @author MyEclipse Persistence Tools
 */

public class GluPatientInfo implements java.io.Serializable {

	// Fields

	private Integer patientId;
	private Patient patient;
	private Float bloodGlucoseMax;
	private Float bloodGlucoseMin;
	private Date upgradeTime;

	// Constructors

	/** default constructor */
	public GluPatientInfo() {
	}

	/** full constructor */
	public GluPatientInfo(Integer patientId, Patient patient,
			Float bloodGlucoseMax, Float bloodGlucoseMin, Date upgradeTime) {
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

	public Date getUpgradeTime() {
		return this.upgradeTime;
	}

	public void setUpgradeTime(Date upgradeTime) {
		this.upgradeTime = upgradeTime;
	}

	@Override
	public String toString() {
		return "GluPatientInfo [patientId=" + patientId + ", patient="
				+ patient + ", bloodGlucoseMax=" + bloodGlucoseMax
				+ ", bloodGlucoseMin=" + bloodGlucoseMin + ", upgradeTime="
				+ upgradeTime + "]";
	}

}