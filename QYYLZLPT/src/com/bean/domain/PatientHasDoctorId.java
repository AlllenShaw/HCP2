package com.bean.domain;

/**
 * PatientHasDoctorId entity. @author MyEclipse Persistence Tools
 */

public class PatientHasDoctorId implements java.io.Serializable {

	// Fields

	private Patient patient;
	private Doctor doctor;

	// Constructors

	/** default constructor */
	public PatientHasDoctorId() {
	}

	/** full constructor */
	public PatientHasDoctorId(Patient patient, Doctor doctor) {
		this.patient = patient;
		this.doctor = doctor;
	}

	// Property accessors

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PatientHasDoctorId))
			return false;
		PatientHasDoctorId castOther = (PatientHasDoctorId) other;

		return ((this.getPatient() == castOther.getPatient()) || (this
				.getPatient() != null && castOther.getPatient() != null && this
				.getPatient().equals(castOther.getPatient())))
				&& ((this.getDoctor() == castOther.getDoctor()) || (this
						.getDoctor() != null && castOther.getDoctor() != null && this
						.getDoctor().equals(castOther.getDoctor())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPatient() == null ? 0 : this.getPatient().hashCode());
		result = 37 * result
				+ (getDoctor() == null ? 0 : this.getDoctor().hashCode());
		return result;
	}

}