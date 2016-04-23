package com.bean.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * MealTime entity. @author MyEclipse Persistence Tools
 */

public class MealTime implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mealTime;
	private Set htnPatientMedicineRecords = new HashSet(0);
	private Set gluPatientRecords = new HashSet(0);
	private Set medicineEmrs = new HashSet(0);
	private Set gluPatientMedicineRecords = new HashSet(0);
	private Set hplPatientMedicineRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public MealTime() {
	}

	/** minimal constructor */
	public MealTime(String mealTime) {
		this.mealTime = mealTime;
	}

	/** full constructor */
	public MealTime(String mealTime, Set htnPatientMedicineRecords,
			Set gluPatientRecords, Set medicineEmrs,
			Set gluPatientMedicineRecords, Set hplPatientMedicineRecords) {
		this.mealTime = mealTime;
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
		this.gluPatientRecords = gluPatientRecords;
		this.medicineEmrs = medicineEmrs;
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

	public String getMealTime() {
		return this.mealTime;
	}

	public void setMealTime(String mealTime) {
		this.mealTime = mealTime;
	}

	public Set getHtnPatientMedicineRecords() {
		return this.htnPatientMedicineRecords;
	}

	public void setHtnPatientMedicineRecords(Set htnPatientMedicineRecords) {
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
	}

	public Set getGluPatientRecords() {
		return this.gluPatientRecords;
	}

	public void setGluPatientRecords(Set gluPatientRecords) {
		this.gluPatientRecords = gluPatientRecords;
	}

	public Set getMedicineEmrs() {
		return this.medicineEmrs;
	}

	public void setMedicineEmrs(Set medicineEmrs) {
		this.medicineEmrs = medicineEmrs;
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