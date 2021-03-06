package com.hcp.domain;

import java.sql.Timestamp;

/**
 * HplPatientMedicineRecord entity. @author MyEclipse Persistence Tools
 */

public class HplPatientMedicineRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Medicine medicine;
	private TakingMedicineWay takingMedicineWay;
	private MedicineUnit medicineUnit;
	private Patient patient;
	private Double takingMedicineNumberEachtime;
	private Timestamp takingMedicineTime;
	private Timestamp uploadTime;

	// Constructors

	/** default constructor */
	public HplPatientMedicineRecord() {
	}

	/** full constructor */
	public HplPatientMedicineRecord(Medicine medicine, TakingMedicineWay takingMedicineWay, MedicineUnit medicineUnit,
			Patient patient, Double takingMedicineNumberEachtime, Timestamp takingMedicineTime, Timestamp uploadTime) {
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

	public Double getTakingMedicineNumberEachtime() {
		return this.takingMedicineNumberEachtime;
	}

	public void setTakingMedicineNumberEachtime(Double takingMedicineNumberEachtime) {
		this.takingMedicineNumberEachtime = takingMedicineNumberEachtime;
	}

	public Timestamp getTakingMedicineTime() {
		return this.takingMedicineTime;
	}

	public void setTakingMedicineTime(Timestamp takingMedicineTime) {
		this.takingMedicineTime = takingMedicineTime;
	}

	public Timestamp getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

}