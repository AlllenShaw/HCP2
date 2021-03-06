package com.bean.domain;

import java.util.Date;

/**
 * GluPatientMedicineRecord entity. @author MyEclipse Persistence Tools
 */

public class GluPatientMedicineRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private MealTime mealTime;
	private Medicine medicine;
	private TakingMedicineWay takingMedicineWay;
	private MedicineUnit medicineUnit;
	private Patient patient;
	private Integer takingMedicineNumberEachtime;
	private Date takingMedicineTime;
	private Date uploadTime;

	// Constructors

	/** default constructor */
	public GluPatientMedicineRecord() {
	}

	/** full constructor */
	public GluPatientMedicineRecord(MealTime mealTime, Medicine medicine,
			TakingMedicineWay takingMedicineWay, MedicineUnit medicineUnit,
			Patient patient, Integer takingMedicineNumberEachtime,
			Date takingMedicineTime, Date uploadTime) {
		this.mealTime = mealTime;
		this.medicine = medicine;
		this.takingMedicineWay = takingMedicineWay;
		this.medicineUnit = medicineUnit;
		this.patient = patient;
		this.takingMedicineNumberEachtime = takingMedicineNumberEachtime;
		this.takingMedicineTime = takingMedicineTime;
		this.uploadTime = uploadTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MealTime getMealTime() {
		return this.mealTime;
	}

	public void setMealTime(MealTime mealTime) {
		this.mealTime = mealTime;
	}

	public Medicine getMedicine() {
		return this.medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public TakingMedicineWay getTakingMedicineWay() {
		return this.takingMedicineWay;
	}

	public void setTakingMedicineWay(TakingMedicineWay takingMedicineWay) {
		this.takingMedicineWay = takingMedicineWay;
	}

	public MedicineUnit getMedicineUnit() {
		return this.medicineUnit;
	}

	public void setMedicineUnit(MedicineUnit medicineUnit) {
		this.medicineUnit = medicineUnit;
	}

	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getTakingMedicineNumberEachtime() {
		return this.takingMedicineNumberEachtime;
	}

	public void setTakingMedicineNumberEachtime(
			Integer takingMedicineNumberEachtime) {
		this.takingMedicineNumberEachtime = takingMedicineNumberEachtime;
	}

	public Date getTakingMedicineTime() {
		return this.takingMedicineTime;
	}

	public void setTakingMedicineTime(Date takingMedicineTime) {
		this.takingMedicineTime = takingMedicineTime;
	}

	public Date getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

}