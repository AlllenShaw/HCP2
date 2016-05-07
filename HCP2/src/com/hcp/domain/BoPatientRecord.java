package com.hcp.domain;

import java.sql.Timestamp;

/**
 * BoPatientRecord entity. @author MyEclipse Persistence Tools
 */

public class BoPatientRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Patient patient;
	private Float pulseRate;
	private Float spo2;
	private Float pi;
	private Timestamp measureTime;
	private Timestamp uploadTime;

	// Constructors

	/** default constructor */
	public BoPatientRecord() {
	}

	/** full constructor */
	public BoPatientRecord(Patient patient, Float pulseRate, Float spo2, Float pi, Timestamp measureTime, Timestamp uploadTime) {
		this.patient = patient;
		this.pulseRate = pulseRate;
		this.spo2 = spo2;
		this.pi = pi;
		this.measureTime = measureTime;
		this.uploadTime = uploadTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Float getPulseRate() {
		return this.pulseRate;
	}

	public void setPulseRate(Float pulseRate) {
		this.pulseRate = pulseRate;
	}

	public Float getSpo2() {
		return this.spo2;
	}

	public void setSpo2(Float spo2) {
		this.spo2 = spo2;
	}

	public Float getPi() {
		return this.pi;
	}

	public void setPi(Float pi) {
		this.pi = pi;
	}

	public Timestamp getMeasureTime() {
		return this.measureTime;
	}

	public void setMeasureTime(Timestamp measureTime) {
		this.measureTime = measureTime;
	}

	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

}