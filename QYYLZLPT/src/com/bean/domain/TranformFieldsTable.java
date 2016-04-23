package com.bean.domain;

/**
 * TranformFieldsTable entity. @author MyEclipse Persistence Tools
 */

public class TranformFieldsTable implements java.io.Serializable {

	// Fields

	private Integer id;
	private Hospital hospital;
	private String username;
	private String age;
	private String weight;
	private String height;
	private String illnessHistory;
	private String allergicHistory;
	private String familyMedicalHistory;
	private String clinicalData;
	private String ct;
	private String BUltrasonic;
	private String XRay;

	// Constructors

	/** default constructor */
	public TranformFieldsTable() {
	}

	/** minimal constructor */
	public TranformFieldsTable(Hospital hospital) {
		this.hospital = hospital;
	}

	/** full constructor */
	public TranformFieldsTable(Hospital hospital, String username, String age,
			String weight, String height, String illnessHistory,
			String allergicHistory, String familyMedicalHistory,
			String clinicalData, String ct, String BUltrasonic, String XRay) {
		this.hospital = hospital;
		this.username = username;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.illnessHistory = illnessHistory;
		this.allergicHistory = allergicHistory;
		this.familyMedicalHistory = familyMedicalHistory;
		this.clinicalData = clinicalData;
		this.ct = ct;
		this.BUltrasonic = BUltrasonic;
		this.XRay = XRay;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getIllnessHistory() {
		return this.illnessHistory;
	}

	public void setIllnessHistory(String illnessHistory) {
		this.illnessHistory = illnessHistory;
	}

	public String getAllergicHistory() {
		return this.allergicHistory;
	}

	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	public String getFamilyMedicalHistory() {
		return this.familyMedicalHistory;
	}

	public void setFamilyMedicalHistory(String familyMedicalHistory) {
		this.familyMedicalHistory = familyMedicalHistory;
	}

	public String getClinicalData() {
		return this.clinicalData;
	}

	public void setClinicalData(String clinicalData) {
		this.clinicalData = clinicalData;
	}

	public String getCt() {
		return this.ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	public String getBUltrasonic() {
		return this.BUltrasonic;
	}

	public void setBUltrasonic(String BUltrasonic) {
		this.BUltrasonic = BUltrasonic;
	}

	public String getXRay() {
		return this.XRay;
	}

	public void setXRay(String XRay) {
		this.XRay = XRay;
	}

}