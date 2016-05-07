package com.hcp.domain;

import java.sql.Timestamp;

/**
 * Prescription entity. @author MyEclipse Persistence Tools
 */

public class Prescription implements java.io.Serializable {

	// Fields

	private Integer id;
	private Emr emr;
	private Medicine medicine;
	private Doctor doctor;
	private TakingMedicineWay takingMedicineWay;
	private MedicineUnit medicineUnit;
	private Double takingMedicineNumberEachtime;
	private Integer takingMedicineTimesEachday;
	private String note;
	private MealTime mealTime;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Prescription() {
	}

	/** minimal constructor */
	public Prescription(Emr emr, Medicine medicine, Doctor doctor, TakingMedicineWay takingMedicineWay,
			MedicineUnit medicineUnit, Double takingMedicineNumberEachtime, Integer takingMedicineTimesEachday,
			Timestamp createTime) {
		this.emr = emr;
		this.medicine = medicine;
		this.doctor = doctor;
		this.takingMedicineWay = takingMedicineWay;
		this.medicineUnit = medicineUnit;
		this.takingMedicineNumberEachtime = takingMedicineNumberEachtime;
		this.takingMedicineTimesEachday = takingMedicineTimesEachday;
		this.createTime = createTime;
	}

	/** full constructor */
	public Prescription(Emr emr, Medicine medicine, Doctor doctor, TakingMedicineWay takingMedicineWay,
			MedicineUnit medicineUnit, Double takingMedicineNumberEachtime, Integer takingMedicineTimesEachday, String note,
			MealTime mealTime, Timestamp createTime) {
		this.emr = emr;
		this.medicine = medicine;
		this.doctor = doctor;
		this.takingMedicineWay = takingMedicineWay;
		this.medicineUnit = medicineUnit;
		this.takingMedicineNumberEachtime = takingMedicineNumberEachtime;
		this.takingMedicineTimesEachday = takingMedicineTimesEachday;
		this.note = note;
		this.mealTime = mealTime;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Emr getEmr() {
		return this.emr;
	}

	public void setEmr(Emr emr) {
		this.emr = emr;
	}

	public Medicine getMedicine() {
		return this.medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Doctor getDoctor() {
		return this.doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
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

	public Double getTakingMedicineNumberEachtime() {
		return this.takingMedicineNumberEachtime;
	}

	public void setTakingMedicineNumberEachtime(Double takingMedicineNumberEachtime) {
		this.takingMedicineNumberEachtime = takingMedicineNumberEachtime;
	}

	public Integer getTakingMedicineTimesEachday() {
		return this.takingMedicineTimesEachday;
	}

	public void setTakingMedicineTimesEachday(Integer takingMedicineTimesEachday) {
		this.takingMedicineTimesEachday = takingMedicineTimesEachday;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public MealTime getMealTime() {
		return this.mealTime;
	}

	public void setMealTime(MealTime mealTime) {
		this.mealTime = mealTime;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}