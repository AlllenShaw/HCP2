package com.hcp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * MedicineUnit entity. @author MyEclipse Persistence Tools
 */

public class MedicineUnit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String medicineUnit;
	private Set hplPatientMedicineRecords = new HashSet(0);
	private Set hdPatientMedicineRecords = new HashSet(0);
	private Set prescriptions = new HashSet(0);
	private Set htnPatientMedicineRecords = new HashSet(0);
	private Set gluPatientMedicineRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public MedicineUnit() {
	}

	/** minimal constructor */
	public MedicineUnit(String medicineUnit) {
		this.medicineUnit = medicineUnit;
	}

	/** full constructor */
	public MedicineUnit(String medicineUnit, Set hplPatientMedicineRecords, Set hdPatientMedicineRecords, Set prescriptions,
			Set htnPatientMedicineRecords, Set gluPatientMedicineRecords) {
		this.medicineUnit = medicineUnit;
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
		this.prescriptions = prescriptions;
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

	public String getMedicineUnit() {
		return this.medicineUnit;
	}

	public void setMedicineUnit(String medicineUnit) {
		this.medicineUnit = medicineUnit;
	}

	public Set getHplPatientMedicineRecords() {
		return this.hplPatientMedicineRecords;
	}

	public void setHplPatientMedicineRecords(Set hplPatientMedicineRecords) {
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
	}

	public Set getHdPatientMedicineRecords() {
		return this.hdPatientMedicineRecords;
	}

	public void setHdPatientMedicineRecords(Set hdPatientMedicineRecords) {
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
	}

	public Set getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(Set prescriptions) {
		this.prescriptions = prescriptions;
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