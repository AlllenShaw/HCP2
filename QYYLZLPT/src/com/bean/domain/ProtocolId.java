package com.bean.domain;

/**
 * ProtocolId entity. @author MyEclipse Persistence Tools
 */

public class ProtocolId implements java.io.Serializable {

	// Fields

	private Hospital hospital;
	private Hospital hospital_1;

	// Constructors

	/** default constructor */
	public ProtocolId() {
	}

	/** full constructor */
	public ProtocolId(Hospital hospital, Hospital hospital_1) {
		this.hospital = hospital;
		this.hospital_1 = hospital_1;
	}

	// Property accessors

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Hospital getHospital_1() {
		return this.hospital_1;
	}

	public void setHospital_1(Hospital hospital_1) {
		this.hospital_1 = hospital_1;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProtocolId))
			return false;
		ProtocolId castOther = (ProtocolId) other;

		return ((this.getHospital() == castOther.getHospital()) || (this
				.getHospital() != null && castOther.getHospital() != null && this
				.getHospital().equals(castOther.getHospital())))
				&& ((this.getHospital_1() == castOther.getHospital_1()) || (this
						.getHospital_1() != null
						&& castOther.getHospital_1() != null && this
						.getHospital_1().equals(castOther.getHospital_1())));
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getHospital() == null ? 0 : this.getHospital().hashCode());
		result = 37
				* result
				+ (getHospital_1() == null ? 0 : this.getHospital_1()
						.hashCode());
		return result;
	}

}