package com.hcp.domain;

import java.sql.Timestamp;

/**
 * HplPatientInfo entity. @author MyEclipse Persistence Tools
 */

public class HplPatientInfo implements java.io.Serializable {

	// Fields

	private Integer patientId;
	private Patient patient;
	private Float tcMax;
	private Float tcMin;
	private Float tgMax;
	private Float tgMin;
	private Float hdlMax;
	private Float hdlMin;
	private Float ldlMax;
	private Float ldlMin;
	private Timestamp upgradeTime;

	// Constructors

	/** default constructor */
	public HplPatientInfo() {
	}

	/** minimal constructor */
	public HplPatientInfo(Patient patient) {
		this.patient = patient;
	}

	/** full constructor */
	public HplPatientInfo(Patient patient, Float tcMax, Float tcMin, Float tgMax, Float tgMin, Float hdlMax, Float hdlMin,
			Float ldlMax, Float ldlMin, Timestamp upgradeTime) {
		this.patient = patient;
		this.tcMax = tcMax;
		this.tcMin = tcMin;
		this.tgMax = tgMax;
		this.tgMin = tgMin;
		this.hdlMax = hdlMax;
		this.hdlMin = hdlMin;
		this.ldlMax = ldlMax;
		this.ldlMin = ldlMin;
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

	public Float getTcMax() {
		return this.tcMax;
	}

	public void setTcMax(Float tcMax) {
		this.tcMax = tcMax;
	}

	public Float getTcMin() {
		return this.tcMin;
	}

	public void setTcMin(Float tcMin) {
		this.tcMin = tcMin;
	}

	public Float getTgMax() {
		return this.tgMax;
	}

	public void setTgMax(Float tgMax) {
		this.tgMax = tgMax;
	}

	public Float getTgMin() {
		return this.tgMin;
	}

	public void setTgMin(Float tgMin) {
		this.tgMin = tgMin;
	}

	public Float getHdlMax() {
		return this.hdlMax;
	}

	public void setHdlMax(Float hdlMax) {
		this.hdlMax = hdlMax;
	}

	public Float getHdlMin() {
		return this.hdlMin;
	}

	public void setHdlMin(Float hdlMin) {
		this.hdlMin = hdlMin;
	}

	public Float getLdlMax() {
		return this.ldlMax;
	}

	public void setLdlMax(Float ldlMax) {
		this.ldlMax = ldlMax;
	}

	public Float getLdlMin() {
		return this.ldlMin;
	}

	public void setLdlMin(Float ldlMin) {
		this.ldlMin = ldlMin;
	}

	public Timestamp getUpgradeTime() {
		return this.upgradeTime;
	}

	public void setUpgradeTime(Timestamp upgradeTime) {
		this.upgradeTime = upgradeTime;
	}

}