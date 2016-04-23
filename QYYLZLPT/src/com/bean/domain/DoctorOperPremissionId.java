package com.bean.domain;

/**
 * DoctorOperPremissionId entity. @author MyEclipse Persistence Tools
 */

public class DoctorOperPremissionId implements java.io.Serializable {

	// Fields

	private Doctor doctor;
	private DoctorPremission doctorPremission;
	private Boolean operation;

	// Constructors

	/** default constructor */
	public DoctorOperPremissionId() {
	}

	/** full constructor */
	public DoctorOperPremissionId(Doctor doctor,
			DoctorPremission doctorPremission, Boolean operation) {
		this.doctor = doctor;
		this.doctorPremission = doctorPremission;
		this.operation = operation;
	}

	// Property accessors

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public DoctorPremission getDoctorPremission() {
		return this.doctorPremission;
	}

	public void setDoctorPremission(DoctorPremission doctorPremission) {
		this.doctorPremission = doctorPremission;
	}

	public Boolean getOperation() {
		return this.operation;
	}

	public void setOperation(Boolean operation) {
		this.operation = operation;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DoctorOperPremissionId))
			return false;
		DoctorOperPremissionId castOther = (DoctorOperPremissionId) other;

		return ((this.getDoctor() == castOther.getDoctor()) || (this
				.getDoctor() != null && castOther.getDoctor() != null && this
				.getDoctor().equals(castOther.getDoctor())))
				&& ((this.getDoctorPremission() == castOther
						.getDoctorPremission()) || (this.getDoctorPremission() != null
						&& castOther.getDoctorPremission() != null && this
						.getDoctorPremission().equals(
								castOther.getDoctorPremission())))
				&& ((this.getOperation() == castOther.getOperation()) || (this
						.getOperation() != null
						&& castOther.getOperation() != null && this
						.getOperation().equals(castOther.getOperation())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDoctor() == null ? 0 : this.getDoctor().hashCode());
		result = 37
				* result
				+ (getDoctorPremission() == null ? 0 : this
						.getDoctorPremission().hashCode());
		result = 37 * result
				+ (getOperation() == null ? 0 : this.getOperation().hashCode());
		return result;
	}

}