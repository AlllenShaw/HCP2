package com.hcp.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Doctor entity. @author MyEclipse Persistence Tools
 */

public class Doctor implements java.io.Serializable {

	// Fields

	private Integer id;
	private Hospital hospital;
	private String username;
	private String realname;
	private String idNumber;
	private String password;
	private String doctorLicense;
	private String mail;
	private String tele;
	private String gender;
	private String age;
	private String address;
	private String height;
	private String weight;
	private String nation;
	private String profession;
	private String company;
	private Timestamp registerTime;
	private Set doctorGroups = new HashSet(0);
	private Set examinationEmrs = new HashSet(0);
	private Set patientHasDoctors = new HashSet(0);
	private Set emrs = new HashSet(0);
	private Set prescriptions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Doctor() {
	}

	/** minimal constructor */
	public Doctor(Hospital hospital, String username, String realname, String idNumber, String password, String doctorLicense,
			Timestamp registerTime) {
		this.hospital = hospital;
		this.username = username;
		this.realname = realname;
		this.idNumber = idNumber;
		this.password = password;
		this.doctorLicense = doctorLicense;
		this.registerTime = registerTime;
	}

	/** full constructor */
	public Doctor(Hospital hospital, String username, String realname, String idNumber, String password, String doctorLicense,
			String mail, String tele, String gender, String age, String address, String height, String weight, String nation,
			String profession, String company, Timestamp registerTime, Set doctorGroups, Set examinationEmrs,
			Set patientHasDoctors, Set emrs, Set prescriptions) {
		this.hospital = hospital;
		this.username = username;
		this.realname = realname;
		this.idNumber = idNumber;
		this.password = password;
		this.doctorLicense = doctorLicense;
		this.mail = mail;
		this.tele = tele;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.height = height;
		this.weight = weight;
		this.nation = nation;
		this.profession = profession;
		this.company = company;
		this.registerTime = registerTime;
		this.doctorGroups = doctorGroups;
		this.examinationEmrs = examinationEmrs;
		this.patientHasDoctors = patientHasDoctors;
		this.emrs = emrs;
		this.prescriptions = prescriptions;
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

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDoctorLicense() {
		return this.doctorLicense;
	}

	public void setDoctorLicense(String doctorLicense) {
		this.doctorLicense = doctorLicense;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTele() {
		return this.tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHeight() {
		return this.height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Set getDoctorGroups() {
		return this.doctorGroups;
	}

	public void setDoctorGroups(Set doctorGroups) {
		this.doctorGroups = doctorGroups;
	}

	public Set getExaminationEmrs() {
		return this.examinationEmrs;
	}

	public void setExaminationEmrs(Set examinationEmrs) {
		this.examinationEmrs = examinationEmrs;
	}

	public Set getPatientHasDoctors() {
		return this.patientHasDoctors;
	}

	public void setPatientHasDoctors(Set patientHasDoctors) {
		this.patientHasDoctors = patientHasDoctors;
	}

	public Set getEmrs() {
		return this.emrs;
	}

	public void setEmrs(Set emrs) {
		this.emrs = emrs;
	}

	public Set getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(Set prescriptions) {
		this.prescriptions = prescriptions;
	}

}