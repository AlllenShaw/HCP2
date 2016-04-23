package com.bean.domain;

import java.util.Date;
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
	private String nickname;
	private String password;
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
	private String certificate;
	private Date registerTime;
	private Set examinationEmrs = new HashSet(0);
	private Set patientHasDoctors = new HashSet(0);
	private Set emrs = new HashSet(0);
	private Set doctorOperPremissions = new HashSet(0);
	private Set medicineEmrs = new HashSet(0);

	// Constructors

	/** default constructor */
	public Doctor() {
	}

	/** minimal constructor */
	public Doctor(Hospital hospital, String username, String password,
			String certificate, Date registerTime) {
		this.hospital = hospital;
		this.username = username;
		this.password = password;
		this.certificate = certificate;
		this.registerTime = registerTime;
	}

	/** full constructor */
	public Doctor(Hospital hospital, String username, String realname,
			String nickname, String password, String mail, String tele,
			String gender, String age, String address, String height,
			String weight, String nation, String profession, String company,
			String certificate, Date registerTime, Set examinationEmrs,
			Set patientHasDoctors, Set emrs, Set doctorOperPremissions,
			Set medicineEmrs) {
		this.hospital = hospital;
		this.username = username;
		this.realname = realname;
		this.nickname = nickname;
		this.password = password;
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
		this.certificate = certificate;
		this.registerTime = registerTime;
		this.examinationEmrs = examinationEmrs;
		this.patientHasDoctors = patientHasDoctors;
		this.emrs = emrs;
		this.doctorOperPremissions = doctorOperPremissions;
		this.medicineEmrs = medicineEmrs;
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

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getCertificate() {
		return this.certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
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

	public Set getDoctorOperPremissions() {
		return this.doctorOperPremissions;
	}

	public void setDoctorOperPremissions(Set doctorOperPremissions) {
		this.doctorOperPremissions = doctorOperPremissions;
	}

	public Set getMedicineEmrs() {
		return this.medicineEmrs;
	}

	public void setMedicineEmrs(Set medicineEmrs) {
		this.medicineEmrs = medicineEmrs;
	}

	public void updatePaitent(Doctor doctor) {
		// TODO Auto-generated method stub
		
	}

}