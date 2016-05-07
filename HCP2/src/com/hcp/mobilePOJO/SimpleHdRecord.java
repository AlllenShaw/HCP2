package com.hcp.mobilePOJO;

import java.sql.Timestamp;

import com.hcp.domain.Patient;

public class SimpleHdRecord {

	private Integer id;
	private Float heartRate;
	private String ecg;
	private String measureTime;
	private Integer analysis;

	public SimpleHdRecord() {
	}

	public SimpleHdRecord(Integer id, Float heartRate, String ecg, String measureTime,Integer analysis) {
		super();
		this.id = id;
		this.heartRate = heartRate;
		this.ecg = ecg;
		this.measureTime = measureTime;
		this.analysis = analysis;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(Float heartRate) {
		this.heartRate = heartRate;
	}

	public String getEcg() {
		return ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	public String getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(String measureTime) {
		this.measureTime = measureTime;
	}

	public Integer getAnalysis() {
		return analysis;
	}

	public void setAnalysis(Integer analysis) {
		this.analysis = analysis;
	}

}
