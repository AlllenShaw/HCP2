package com.bean.domain;

import java.io.Serializable;
import java.util.Date;

public class HdPatientRecord implements Serializable {
	// Fields

	private Integer id;
	private Patient patient;
	private MealTime mealTime;
	private Float heartRate;
	private String ecg;
	private Date measureTime;
	private Date uploadTime;

	// Constructors

	/** default constructor */
	public HdPatientRecord() {
	}

	/** full constructor */
	public HdPatientRecord(Patient patient, MealTime mealTime,Float heartRate, String ecg, Date measureTime, Date uploadTime) {
		this.patient = patient;
		this.mealTime = mealTime;
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
		return "GluPatientRecord [id=" + id + ", heartRate=" + heartRate + ", ecg=" + ecg + ", measureTime=" + measureTime
				+ ", uploadTime=" + uploadTime + "]";
	}

	public MealTime getMealTime() {
		return mealTime;
	}

	public void setMealTime(MealTime mealTime) {
		this.mealTime = mealTime;
	}

}
