package com.bean.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * MedicineUnit entity. @author MyEclipse Persistence Tools
 */

public class MedicineUnit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String medicineUnit;
	private Set medicineEmrs = new HashSet(0);
	private Set htnPatientMedicineRecords = new HashSet(0);
	private Set gluPatientMedicineRecords = new HashSet(0);
	private Set hplPatientMedicineRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public MedicineUnit() {
	}

	/** minimal constructor */
	public MedicineUnit(String medicineUnit) {
		this.medicineUnit = medicineUnit;
	}

	/** full constructor */
	public MedicineUnit(String medicineUnit, Set medicineEmrs,
			Set htnPatientMedicineRecords, Set gluPatientMedicineRecords,
			Set hplPatientMedicineRecords) {
		this.medicineUnit = medicineUnit;
		this.medicineEmrs = medicineEmrs;
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
		this.gluPatientMedicineRecords = gluPatientMedicineRecords;
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
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

	public Set getMedicineEmrs() {
		return this.medicineEmrs;
	}

	public void setMedicineEmrs(Set medicineEmrs) {
		this.medicineEmrs = medicineEmrs;
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

	public Set getHplPatientMedicineRecords() {
		return this.hplPatientMedicineRecords;
	}

	public void setHplPatientMedicineRecords(Set hplPatientMedicineRecords) {
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
	}

}