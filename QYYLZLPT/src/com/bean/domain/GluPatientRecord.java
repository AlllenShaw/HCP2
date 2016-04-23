package com.bean.domain;

import java.util.Date;

/**
 * GluPatientRecord entity. @author MyEclipse Persistence Tools
 */

public class GluPatientRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private MealTime mealTime;
	private Patient patient;
	private Float bloodGlucose;
	private Date measureTime;
	private Date uploadTime;

	// Constructors

	/** default constructor */
	public GluPatientRecord() {
	}

	/** full constructor */
	public GluPatientRecord(MealTime mealTime, Patient patient,
			Float bloodGlucose, Date measureTime, Date uploadTime) {
		this.mealTime = mealTime;
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

	public MealTime getMealTime() {
		return this.mealTime;
	}

	public void setMealTime(MealTime mealTime) {
		this.mealTime = mealTime;
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

	@Override
	public String toString() {
		return "GluPatientRecord [id=" + id + ", bloodGlucose=" + bloodGlucose
				+ ", measureTime=" + measureTime + ", uploadTime=" + uploadTime
				+ "]";
	}
}