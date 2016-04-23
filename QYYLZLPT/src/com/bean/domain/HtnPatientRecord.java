package com.bean.domain;

import java.util.Date;

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
	private Date measureTime;
	private Date uploadTime;

	// Constructors

	/** default constructor */
	public HtnPatientRecord() {
	}

	/** full constructor */
	public HtnPatientRecord(Patient patient, Float diastolicPressure,
			Float systolicPressure, Float heartRate, Date measureTime,
			Date uploadTime) {
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

	public Date getMeasureTime() {
		return this.measureTime;
	}

	public void setMeasureTime(Date measureTime) {
		this.measureTime = measureTime;
	}

	public Date getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}