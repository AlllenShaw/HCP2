package com.hcp.domain;

import java.sql.Timestamp;

/**
 * HplPatientRecord entity. @author MyEclipse Persistence Tools
 */

public class HplPatientRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Patient patient;
	private Float tc;
	private Float tg;
	private Float hdl;
	private Float ldl;
	private Timestamp measureTime;
	private Timestamp uploadTime;

	// Constructors

	/** default constructor */
	public HplPatientRecord() {
	}

	/** full constructor */
	public HplPatientRecord(Patient patient, Float tc, Float tg, Float hdl, Float ldl, Timestamp measureTime, Timestamp uploadTime) {
		this.patient = patient;
		this.tc = tc;
		this.tg = tg;
		this.hdl = hdl;
		this.ldl = ldl;
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

	public Float getTc() {
		return this.tc;
	}

	public void setTc(Float tc) {
		this.tc = tc;
	}

	public Float getTg() {
		return this.tg;
	}

	public void setTg(Float tg) {
		this.tg = tg;
	}

	public Float getHdl() {
		return this.hdl;
	}

	public void setHdl(Float hdl) {
		this.hdl = hdl;
	}

	public Float getLdl() {
		return this.ldl;
	}

	public void setLdl(Float ldl) {
		this.ldl = ldl;
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