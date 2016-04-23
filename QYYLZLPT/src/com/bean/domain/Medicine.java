package com.bean.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Medicine entity. @author MyEclipse Persistence Tools
 */

public class Medicine implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer type;
	private String constituent;
	private String effect;
	private String taboo;
	private String direction;
	private String unit;
	private Float dosage;
	private String takingType;
	private String takingTime;
	private Set medicineEmrs = new HashSet(0);
	private Set htnPatientMedicineRecords = new HashSet(0);
	private Set hplPatientMedicineRecords = new HashSet(0);
	private Set gluPatientMedicineRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Medicine() {
	}

	/** minimal constructor */
	public Medicine(String name) {
		this.name = name;
	}

	/** full constructor */

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public Medicine(Integer id, String name, Integer type, String constituent,
			String effect, String taboo, String direction, String unit,
			Float dosage, String takingType, String takingTime,
			Set medicineEmrs, Set htnPatientMedicineRecords,
			Set hplPatientMedicineRecords, Set gluPatientMedicineRecords) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.constituent = constituent;
		this.effect = effect;
		this.taboo = taboo;
		this.direction = direction;
		this.unit = unit;
		this.dosage = dosage;
		this.takingType = takingType;
		this.takingTime = takingTime;
		this.medicineEmrs = medicineEmrs;
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
		this.gluPatientMedicineRecords = gluPatientMedicineRecords;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConstituent() {
		return this.constituent;
	}

	public void setConstituent(String constituent) {
		this.constituent = constituent;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getTaboo() {
		return this.taboo;
	}

	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
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

	public Set getHplPatientMedicineRecords() {
		return this.hplPatientMedicineRecords;
	}

	public void setHplPatientMedicineRecords(Set hplPatientMedicineRecords) {
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
	}

	public Set getGluPatientMedicineRecords() {
		return this.gluPatientMedicineRecords;
	}

	public void setGluPatientMedicineRecords(Set gluPatientMedicineRecords) {
		this.gluPatientMedicineRecords = gluPatientMedicineRecords;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Float getDosage() {
		return dosage;
	}

	public void setDosage(Float dosage) {
		this.dosage = dosage;
	}

	public String getTakingType() {
		return takingType;
	}

	public void setTakingType(String takingType) {
		this.takingType = takingType;
	}

	public String getTakingTime() {
		return takingTime;
	}

	public void setTakingTime(String takingTime) {
		this.takingTime = takingTime;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", type=" + type
				+ ", constituent=" + constituent + ", effect=" + effect
				+ ", taboo=" + taboo + ", direction=" + direction
				+ ", medicineEmrs=" + medicineEmrs
				+ ", htnPatientMedicineRecords=" + htnPatientMedicineRecords
				+ ", hplPatientMedicineRecords=" + hplPatientMedicineRecords
				+ ", gluPatientMedicineRecords=" + gluPatientMedicineRecords
				+ "]";
	}
}