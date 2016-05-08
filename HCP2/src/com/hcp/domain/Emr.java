package com.hcp.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Emr entity. @author MyEclipse Persistence Tools
 */

public class Emr implements java.io.Serializable {

	// Fields

	private Integer id;
	private Doctor doctor;
	private Patient patient;
	private String illnessStateDesc;
	private Timestamp createTime;
	private String diagnosisSuggestion;
	private Set examinationEmrs = new HashSet(0);
	private Set prescriptions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Emr() {
	}

	/** minimal constructor */
	public Emr(Doctor doctor, Patient patient, String illnessStateDesc, Timestamp createTime) {
		this.doctor = doctor;
		this.patient = patient;
		this.illnessStateDesc = illnessStateDesc;
		this.createTime = createTime;
	}

	/** full constructor */
	public Emr(Doctor doctor, Patient patient, String illnessStateDesc, Timestamp createTime, String diagnosisSuggestion,
			Set examinationEmrs, Set prescriptions) {
		this.doctor = doctor;
		this.patient = patient;
		this.illnessStateDesc = illnessStateDesc;
		this.createTime = createTime;
		this.diagnosisSuggestion = diagnosisSuggestion;
		this.examinationEmrs = examinationEmrs;
		this.prescriptions = prescriptions;
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

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getDiagnosisSuggestion() {
		return this.diagnosisSuggestion;
	}

	public void setDiagnosisSuggestion(String diagnosisSuggestion) {
		this.diagnosisSuggestion = diagnosisSuggestion;
	}

	public Set getExaminationEmrs() {
		return this.examinationEmrs;
	}

	public void setExaminationEmrs(Set examinationEmrs) {
		this.examinationEmrs = examinationEmrs;
	}

	public Set getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(Set prescriptions) {
		this.prescriptions = prescriptions;
	}

}