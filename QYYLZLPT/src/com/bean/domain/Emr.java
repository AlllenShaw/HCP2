package com.bean.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Emr entity. @author MyEclipse Persistence Tools
 */

public class Emr implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Doctor doctor;
	private Patient patient;
	private String illnessStateDesc;
	private Date createTime;
	private Set medicineEmrs = new HashSet(0);
	private Set examinationEmrs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Emr() {
	}

	/** minimal constructor */
	public Emr(Doctor doctor, Patient patient, String illnessStateDesc,
			Date createTime) {
		this.doctor = doctor;
		this.patient = patient;
		this.illnessStateDesc = illnessStateDesc;
		this.createTime = createTime;
	}

	/** full constructor */
	public Emr(Doctor doctor, Patient patient, String illnessStateDesc,
			Date createTime, Set medicineEmrs, Set examinationEmrs) {
		this.doctor = doctor;
		this.patient = patient;
		this.illnessStateDesc = illnessStateDesc;
		this.createTime = createTime;
		this.medicineEmrs = medicineEmrs;
		this.examinationEmrs = examinationEmrs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getIllnessStateDesc() {
		return this.illnessStateDesc;
	}

	public void setIllnessStateDesc(String illnessStateDesc) {
		this.illnessStateDesc = illnessStateDesc;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Set getMedicineEmrs() {
		return this.medicineEmrs;
	}

	public void setMedicineEmrs(Set medicineEmrs) {
		this.medicineEmrs = medicineEmrs;
	}

	public Set getExaminationEmrs() {
		return this.examinationEmrs;
	}

	public void setExaminationEmrs(Set examinationEmrs) {
		this.examinationEmrs = examinationEmrs;
	}

}