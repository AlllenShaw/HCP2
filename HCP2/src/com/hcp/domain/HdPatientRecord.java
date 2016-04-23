package com.hcp.domain;

import java.sql.Timestamp;

/**
 * HdPatientRecord entity. @author MyEclipse Persistence Tools
 */

public class HdPatientRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Patient patient;
	private Float heartRate;
	private String ecg;
	private Timestamp measureTime;
	private Timestamp uploadTime;

	// Constructors

	/** default constructor */
	public HdPatientRecord() {
	}

	/** full constructor */
	public HdPatientRecord(Patient patient, Float heartRate, String ecg, Timestamp measureTime, Timestamp uploadTime) {
		this.patient = patient;
		this.heartRate = heartRate;
		this.ecg = ecg;
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

	public Float getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Float heartRate) {
		this.heartRate = heartRate;
	}

	public String getEcg() {
		return this.ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
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