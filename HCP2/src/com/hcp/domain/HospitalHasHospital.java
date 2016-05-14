package com.hcp.domain;

/**
 * HospitalHasHospital entity. @author MyEclipse Persistence Tools
 */

public class HospitalHasHospital implements java.io.Serializable {

	// Fields

	private Integer id;
	private Hospital hospitalByHospital1;
	private Hospital hospitalByHospital2;

	// Constructors

	/** default constructor */
	public HospitalHasHospital() {
	}

	/** full constructor */
	public HospitalHasHospital(Hospital hospitalByHospital1, Hospital hospitalByHospital2) {
		this.hospitalByHospital1 = hospitalByHospital1;
		this.hospitalByHospital2 = hospitalByHospital2;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Hospital getHospitalByHospital1() {
		return this.hospitalByHospital1;
	}

	public void setHospitalByHospital1(Hospital hospitalByHospital1) {
		this.hospitalByHospital1 = hospitalByHospital1;
	}

	public Hospital getHospitalByHospital2() {
		return this.hospitalByHospital2;
	}

	public void setHospitalByHospital2(Hospital hospitalByHospital2) {
		this.hospitalByHospital2 = hospitalByHospital2;
	}

}