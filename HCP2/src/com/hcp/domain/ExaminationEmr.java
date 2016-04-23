package com.hcp.domain;

import java.sql.Timestamp;

/**
 * ExaminationEmr entity. @author MyEclipse Persistence Tools
 */

public class ExaminationEmr implements java.io.Serializable {

	// Fields

	private Integer id;
	private Emr emr;
	private Doctor doctor;
	private ExaminationType examinationType;
	private String accessory;
	private String result;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public ExaminationEmr() {
	}

	/** full constructor */
	public ExaminationEmr(Emr emr, Doctor doctor, ExaminationType examinationType, String accessory, String result,
			Timestamp createTime) {
		this.emr = emr;
		this.doctor = doctor;
		this.examinationType = examinationType;
		this.accessory = accessory;
		this.result = result;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Emr getEmr() {
		return this.emr;
	}

	public void setEmr(Emr emr) {
		this.emr = emr;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public ExaminationType getExaminationType() {
		return this.examinationType;
	}

	public void setExaminationType(ExaminationType examinationType) {
		this.examinationType = examinationType;
	}

	public String getAccessory() {
		return this.accessory;
	}

	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}