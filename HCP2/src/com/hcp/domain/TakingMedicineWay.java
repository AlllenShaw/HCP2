package com.hcp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * TakingMedicineWay entity. @author MyEclipse Persistence Tools
 */

public class TakingMedicineWay implements java.io.Serializable {

	// Fields

	private Integer id;
	private String takingMedicineWay;
	private Set hplPatientMedicineRecords = new HashSet(0);
	private Set prescriptions = new HashSet(0);
	private Set hdPatientMedicineRecords = new HashSet(0);
	private Set htnPatientMedicineRecords = new HashSet(0);
	private Set gluPatientMedicineRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public TakingMedicineWay() {
	}

	/** minimal constructor */
	public TakingMedicineWay(String takingMedicineWay) {
		this.takingMedicineWay = takingMedicineWay;
	}

	/** full constructor */
	public TakingMedicineWay(String takingMedicineWay, Set hplPatientMedicineRecords, Set prescriptions,
			Set hdPatientMedicineRecords, Set htnPatientMedicineRecords, Set gluPatientMedicineRecords) {
		this.takingMedicineWay = takingMedicineWay;
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
		this.prescriptions = prescriptions;
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
		this.gluPatientMedicineRecords = gluPatientMedicineRecords;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTakingMedicineWay() {
		return this.takingMedicineWay;
	}

	public void setTakingMedicineWay(String takingMedicineWay) {
		this.takingMedicineWay = takingMedicineWay;
	}

	public Set getHplPatientMedicineRecords() {
		return this.hplPatientMedicineRecords;
	}

	public void setHplPatientMedicineRecords(Set hplPatientMedicineRecords) {
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
	}

	public Set getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(Set prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Set getHdPatientMedicineRecords() {
		return this.hdPatientMedicineRecords;
	}

	public void setHdPatientMedicineRecords(Set hdPatientMedicineRecords) {
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
	}

	public Set getHtnPatientMedicineRecords() {
		return this.htnPatientMedicineRecords;
	}

	public void setHtnPatientMedicineRecords(Set htnPatientMedicineRecords) {
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
	}

	public Set getGluPatientMedicineRecords() {
		return this.gluPatientMedicineRecords;
	}

	public void setGluPatientMedicineRecords(Set gluPatientMedicineRecords) {
		this.gluPatientMedicineRecords = gluPatientMedicineRecords;
	}

}