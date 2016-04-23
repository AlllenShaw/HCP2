package com.bean.domain;

import java.util.Date;

/**
 * ExaminationEmr entity. @author MyEclipse Persistence Tools
 */

public class ExaminationEmr implements java.io.Serializable {

	// Fields

	private Integer id;
	private Emr emr;
	private Doctor doctor;
	private ExaminationType examinationType;
	private String value;
	private Date createTime;

	// Constructors

	/** default constructor */
	public ExaminationEmr() {
	}

	/** full constructor */
	public ExaminationEmr(Emr emr, Doctor doctor,
			ExaminationType examinationType, String value, Date createTime) {
		this.emr = emr;
		this.doctor = doctor;
		this.examinationType = examinationType;
		this.value = value;
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

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}