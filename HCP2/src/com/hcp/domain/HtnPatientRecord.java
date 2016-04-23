package com.hcp.domain;

import java.sql.Timestamp;

/**
 * HtnPatientRecord entity. @author MyEclipse Persistence Tools
 */

public class HtnPatientRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Patient patient;
	private Float diastolicPressure;
	private Float systolicPressure;
	private Float heartRate;
	private Timestamp measureTime;
	private Timestamp uploadTime;

	// Constructors

	/** default constructor */
	public HtnPatientRecord() {
	}

	/** full constructor */
	public HtnPatientRecord(Patient patient, Float diastolicPressure, Float systolicPressure, Float heartRate,
			Timestamp measureTime, Timestamp uploadTime) {
		this.patient = patient;
		this.diastolicPressure = diastolicPressure;
		this.systolicPressure = systolicPressure;
		this.heartRate = heartRate;
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

	public Float getDiastolicPressure() {
		return this.diastolicPressure;
	}

	public void setDiastolicPressure(Float diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public Float getSystolicPressure() {
		return this.systolicPressure;
	}

	public void setSystolicPressure(Float systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	public Float getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Float heartRate) {
		this.heartRate = heartRate;
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