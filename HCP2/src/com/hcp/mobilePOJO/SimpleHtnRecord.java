package com.hcp.mobilePOJO;

import java.sql.Timestamp;

import com.hcp.domain.Patient;

public class SimpleHtnRecord {

	private Integer id;
	private Float diastolicPressure;
	private Float systolicPressure;
	private Float heartRate;
	private String measureTime;
	private Integer heartRateState;

	public SimpleHtnRecord() {
	}

	public SimpleHtnRecord(Integer id, Float diastolicPressure, Float systolicPressure, Float heartRate, Integer heartRateState,
			String measureTime) {
		super();
		this.id = id;
		this.diastolicPressure = diastolicPressure;		//舒张压---低压
		this.systolicPressure = systolicPressure;	//收缩压---高压
		this.heartRate = heartRate;
		this.measureTime = measureTime;
		this.heartRateState = heartRateState;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getDiastolicPressure() {
		return diastolicPressure;
	}

	public void setDiastolicPressure(Float diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	public Float getSystolicPressure() {
		return systolicPressure;
	}

	public void setSystolicPressure(Float systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	public Float getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(Float heartRate) {
		this.heartRate = heartRate;
	}

	public String getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(String measureTime) {
		this.measureTime = measureTime;
	}

	public Integer getHeartRateState() {
		return heartRateState;
	}

	public void setHeartRateState(Integer heartRateState) {
		this.heartRateState = heartRateState;
	}

}
