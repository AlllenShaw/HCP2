package com.bean.domain;

/**
 * HealthHistory entity. @author MyEclipse Persistence Tools
 */

public class HealthHistory implements java.io.Serializable {

	// Fields

	private Integer patientId;
	private Patient patient;
	private String illnessHistory;
	private String allergicHistory;
	private String familyMedicalHistory;

	// Constructors

	/** default constructor */
	public HealthHistory() {
	}

	/** minimal constructor */
	public HealthHistory(Integer patientId, Patient patient) {
		this.patientId = patientId;
		this.patient = patient;
	}

	/** full constructor */
	public HealthHistory(Integer patientId, Patient patient,
			String illnessHistory, String allergicHistory,
			String familyMedicalHistory) {
		this.patientId = patientId;
		this.patient = patient;
		this.illnessHistory = illnessHistory;
		this.allergicHistory = allergicHistory;
		this.familyMedicalHistory = familyMedicalHistory;
	}

	// Property accessors

	public Integer getPatientId() {
		return this.patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getIllnessHistory() {
		return this.illnessHistory;
	}

	public void setIllnessHistory(String illnessHistory) {
		this.illnessHistory = illnessHistory;
	}

	public String getAllergicHistory() {
		return this.allergicHistory;
	}

	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	public String getFamilyMedicalHistory() {
		return this.familyMedicalHistory;
	}

	public void setFamilyMedicalHistory(String familyMedicalHistory) {
		this.familyMedicalHistory = familyMedicalHistory;
	}

	@Override
	public String toString() {
		return "HealthHistory [patientId=" + patientId + ", patient=" + patient
				+ ", illnessHistory=" + illnessHistory + ", allergicHistory="
				+ allergicHistory + ", familyMedicalHistory="
				+ familyMedicalHistory + "]";
	}

}