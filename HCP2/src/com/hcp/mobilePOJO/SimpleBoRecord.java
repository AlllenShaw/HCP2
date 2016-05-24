package com.hcp.mobilePOJO;

public class SimpleBoRecord {
	private Integer id;
	private Float bloodGlucose;
	private String measureTime;
	private Float heartRate;

	public SimpleBoRecord() {
	}

	public SimpleBoRecord(Integer id, Float bloodGlucose, String measureTime) {
		super();
		this.id = id;
		this.bloodGlucose = bloodGlucose;
		this.measureTime = measureTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getBloodGlucose() {
		return bloodGlucose;
	}

	public void setBloodGlucose(Float bloodGlucose) {
		this.bloodGlucose = bloodGlucose;
	}

	public String getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(String measureTime) {
		this.measureTime = measureTime;
	}

	public Float getHeartRate() {
		return heartRate;
	}

	public void setHeartRate(Float heartRate) {
		this.heartRate = heartRate;
	}

}
