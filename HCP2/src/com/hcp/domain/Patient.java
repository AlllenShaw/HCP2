package com.hcp.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Patient entity. @author MyEclipse Persistence Tools
 */

public class Patient implements java.io.Serializable {

	// Fields

	private Integer id;
	private Security securityBySecurity3;
	private Family familyByFamlily1;
	private Family familyByFamlily2;
	private Security securityBySecurity2;
	private Security securityBySecurity1;
	private Hospital hospital;
	private String username;
	private String realname;
	private String idNumber;
	private String password;
	private String token;
	private String mail;
	private String hin;
	private String tele;
	private String gender;
	private String age;
	private String height;
	private String weight;
	private String education;
	private String address;
	private String birAddress;
	private String nation;
	private String profession;
	private String company;
	private Boolean marriage;
	private Timestamp registerTime;
	private Boolean gluState;
	private Boolean hplState;
	private Boolean htnState;
	private Boolean hdState;
	private String illnessHis;
	private String allergicHis;
	private String familyHis;
	private String answer1;
	private String answer2;
	private String answer3;
	private String picture;
	private Set htnPatientRecords = new HashSet(0);
	private Set emrs = new HashSet(0);
	private Set hplPatientInfos = new HashSet(0);
	private Set patientGroups = new HashSet(0);
	private Set hdPatientInfos = new HashSet(0);
	private Set boPatientInfos = new HashSet(0);
	private Set htnPatientMedicineRecords = new HashSet(0);
	private Set hdPatientRecords = new HashSet(0);
	private Set gluPatientRecords = new HashSet(0);
	private Set gluPatientInfos = new HashSet(0);
	private Set boPatientMedicineRecords = new HashSet(0);
	private Set boPatientRecords = new HashSet(0);
	private Set patientHasDoctors = new HashSet(0);
	private Set hplPatientMedicineRecords = new HashSet(0);
	private Set gluPatientMedicineRecords = new HashSet(0);
	private Set hdPatientMedicineRecords = new HashSet(0);
	private Set hplPatientRecords = new HashSet(0);
	private Set htnPatientInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Patient() {
	}

	/** minimal constructor */
	public Patient(String username, String idNumber, String password) {
		this.username = username;
		this.idNumber = idNumber;
		this.password = password;
	}

	/** full constructor */
	public Patient(Security securityBySecurity3, Family familyByFamlily1, Family familyByFamlily2, Security securityBySecurity2,
			Security securityBySecurity1, Hospital hospital, String username, String realname, String idNumber, String password,
			String token, String mail, String hin, String tele, String gender, String age, String height, String weight,
			String education, String address, String birAddress, String nation, String profession, String company,
			Boolean marriage, Timestamp registerTime, Boolean gluState, Boolean hplState, Boolean htnState, Boolean hdState,
			String illnessHis, String allergicHis, String familyHis, String answer1, String answer2, String answer3,
			String picture, Set htnPatientRecords, Set emrs, Set hplPatientInfos, Set patientGroups, Set hdPatientInfos,
			Set boPatientInfos, Set htnPatientMedicineRecords, Set hdPatientRecords, Set gluPatientRecords, Set gluPatientInfos,
			Set boPatientMedicineRecords, Set boPatientRecords, Set patientHasDoctors, Set hplPatientMedicineRecords,
			Set gluPatientMedicineRecords, Set hdPatientMedicineRecords, Set hplPatientRecords, Set htnPatientInfos) {
		this.securityBySecurity3 = securityBySecurity3;
		this.familyByFamlily1 = familyByFamlily1;
		this.familyByFamlily2 = familyByFamlily2;
		this.securityBySecurity2 = securityBySecurity2;
		this.securityBySecurity1 = securityBySecurity1;
		this.hospital = hospital;
		this.username = username;
		this.realname = realname;
		this.idNumber = idNumber;
		this.password = password;
		this.token = token;
		this.mail = mail;
		this.hin = hin;
		this.tele = tele;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.education = education;
		this.address = address;
		this.birAddress = birAddress;
		this.nation = nation;
		this.profession = profession;
		this.company = company;
		this.marriage = marriage;
		this.registerTime = registerTime;
		this.gluState = gluState;
		this.hplState = hplState;
		this.htnState = htnState;
		this.hdState = hdState;
		this.illnessHis = illnessHis;
		this.allergicHis = allergicHis;
		this.familyHis = familyHis;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.picture = picture;
		this.htnPatientRecords = htnPatientRecords;
		this.emrs = emrs;
		this.hplPatientInfos = hplPatientInfos;
		this.patientGroups = patientGroups;
		this.hdPatientInfos = hdPatientInfos;
		this.boPatientInfos = boPatientInfos;
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
		this.hdPatientRecords = hdPatientRecords;
		this.gluPatientRecords = gluPatientRecords;
		this.gluPatientInfos = gluPatientInfos;
		this.boPatientMedicineRecords = boPatientMedicineRecords;
		this.boPatientRecords = boPatientRecords;
		this.patientHasDoctors = patientHasDoctors;
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
		this.gluPatientMedicineRecords = gluPatientMedicineRecords;
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
		this.hplPatientRecords = hplPatientRecords;
		this.htnPatientInfos = htnPatientInfos;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Security getSecurityBySecurity3() {
		return this.securityBySecurity3;
	}

	public void setSecurityBySecurity3(Security securityBySecurity3) {
		this.securityBySecurity3 = securityBySecurity3;
	}

	public Family getFamilyByFamlily1() {
		return this.familyByFamlily1;
	}

	public void setFamilyByFamlily1(Family familyByFamlily1) {
		this.familyByFamlily1 = familyByFamlily1;
	}

	public Family getFamilyByFamlily2() {
		return this.familyByFamlily2;
	}

	public void setFamilyByFamlily2(Family familyByFamlily2) {
		this.familyByFamlily2 = familyByFamlily2;
	}

	public Security getSecurityBySecurity2() {
		return this.securityBySecurity2;
	}

	public void setSecurityBySecurity2(Security securityBySecurity2) {
		this.securityBySecurity2 = securityBySecurity2;
	}

	public Security getSecurityBySecurity1() {
		return this.securityBySecurity1;
	}

	public void setSecurityBySecurity1(Security securityBySecurity1) {
		this.securityBySecurity1 = securityBySecurity1;
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

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getHin() {
		return this.hin;
	}

	public void setHin(String hin) {
		this.hin = hin;
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

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirAddress() {
		return this.birAddress;
	}

	public void setBirAddress(String birAddress) {
		this.birAddress = birAddress;
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

	public Boolean getMarriage() {
		return this.marriage;
	}

	public void setMarriage(Boolean marriage) {
		this.marriage = marriage;
	}

	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Boolean getGluState() {
		return this.gluState;
	}

	public void setGluState(Boolean gluState) {
		this.gluState = gluState;
	}

	public Boolean getHplState() {
		return this.hplState;
	}

	public void setHplState(Boolean hplState) {
		this.hplState = hplState;
	}

	public Boolean getHtnState() {
		return this.htnState;
	}

	public void setHtnState(Boolean htnState) {
		this.htnState = htnState;
	}

	public Boolean getHdState() {
		return this.hdState;
	}

	public void setHdState(Boolean hdState) {
		this.hdState = hdState;
	}

	public String getIllnessHis() {
		return this.illnessHis;
	}

	public void setIllnessHis(String illnessHis) {
		this.illnessHis = illnessHis;
	}

	public String getAllergicHis() {
		return this.allergicHis;
	}

	public void setAllergicHis(String allergicHis) {
		this.allergicHis = allergicHis;
	}

	public String getFamilyHis() {
		return this.familyHis;
	}

	public void setFamilyHis(String familyHis) {
		this.familyHis = familyHis;
	}

	public String getAnswer1() {
		return this.answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return this.answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return this.answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Set getHtnPatientRecords() {
		return this.htnPatientRecords;
	}

	public void setHtnPatientRecords(Set htnPatientRecords) {
		this.htnPatientRecords = htnPatientRecords;
	}

	public Set getEmrs() {
		return this.emrs;
	}

	public void setEmrs(Set emrs) {
		this.emrs = emrs;
	}

	public Set getHplPatientInfos() {
		return this.hplPatientInfos;
	}

	public void setHplPatientInfos(Set hplPatientInfos) {
		this.hplPatientInfos = hplPatientInfos;
	}

	public Set getPatientGroups() {
		return this.patientGroups;
	}

	public void setPatientGroups(Set patientGroups) {
		this.patientGroups = patientGroups;
	}

	public Set getHdPatientInfos() {
		return this.hdPatientInfos;
	}

	public void setHdPatientInfos(Set hdPatientInfos) {
		this.hdPatientInfos = hdPatientInfos;
	}

	public Set getBoPatientInfos() {
		return this.boPatientInfos;
	}

	public void setBoPatientInfos(Set boPatientInfos) {
		this.boPatientInfos = boPatientInfos;
	}

	public Set getHtnPatientMedicineRecords() {
		return this.htnPatientMedicineRecords;
	}

	public void setHtnPatientMedicineRecords(Set htnPatientMedicineRecords) {
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
	}

	public Set getHdPatientRecords() {
		return this.hdPatientRecords;
	}

	public void setHdPatientRecords(Set hdPatientRecords) {
		this.hdPatientRecords = hdPatientRecords;
	}

	public Set getGluPatientRecords() {
		return this.gluPatientRecords;
	}

	public void setGluPatientRecords(Set gluPatientRecords) {
		this.gluPatientRecords = gluPatientRecords;
	}

	public Set getGluPatientInfos() {
		return this.gluPatientInfos;
	}

	public void setGluPatientInfos(Set gluPatientInfos) {
		this.gluPatientInfos = gluPatientInfos;
	}

	public Set getBoPatientMedicineRecords() {
		return this.boPatientMedicineRecords;
	}

	public void setBoPatientMedicineRecords(Set boPatientMedicineRecords) {
		this.boPatientMedicineRecords = boPatientMedicineRecords;
	}

	public Set getBoPatientRecords() {
		return this.boPatientRecords;
	}

	public void setBoPatientRecords(Set boPatientRecords) {
		this.boPatientRecords = boPatientRecords;
	}

	public Set getPatientHasDoctors() {
		return this.patientHasDoctors;
	}

	public void setPatientHasDoctors(Set patientHasDoctors) {
		this.patientHasDoctors = patientHasDoctors;
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

	public Set getHdPatientMedicineRecords() {
		return this.hdPatientMedicineRecords;
	}

	public void setHdPatientMedicineRecords(Set hdPatientMedicineRecords) {
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
	}

	public Set getHplPatientRecords() {
		return this.hplPatientRecords;
	}

	public void setHplPatientRecords(Set hplPatientRecords) {
		this.hplPatientRecords = hplPatientRecords;
	}

	public Set getHtnPatientInfos() {
		return this.htnPatientInfos;
	}

	public void setHtnPatientInfos(Set htnPatientInfos) {
		this.htnPatientInfos = htnPatientInfos;
	}

}