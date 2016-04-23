package com.hcp.domain;

import java.sql.Timestamp;

/**
 * GluPatientRecord entity. @author MyEclipse Persistence Tools
 */

public class GluPatientRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Patient patient;
	private Float bloodGlucose;
	private Timestamp measureTime;
	private Timestamp uploadTime;

	// Constructors

	/** default constructor */
	public GluPatientRecord() {
	}

	/** full constructor */
	public GluPatientRecord(Patient patient, Float bloodGlucose, Timestamp measureTime, Timestamp uploadTime) {
		this.patient = patient;
		this.bloodGlucose = bloodGlucose;
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

	public Float getBloodGlucose() {
		return this.bloodGlucose;
	}

	public void setBloodGlucose(Float bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
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