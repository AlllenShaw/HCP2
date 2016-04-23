package com.bean.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AbstractPatient entity provides the base persistence definition of the Patient entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPatient implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String realname;
	private String nickname;
	private String password;
	private String token;
	private String mail;
	private String tele;
	private String tele1;
	private String tele2;
	private Boolean gluState;
	private Boolean hplState;
	private Boolean htnState;
	private Boolean hdState;
	private String gender;
	private String age;
	private String height;
	private String weight;
	private String address;
	private String nation;
	private String profession;
	private String company;
	private Date registerTime;
	private Boolean marriage;
	private Set htnPatientRecords = new HashSet(0);
	private Set emrs = new HashSet(0);
	private Set hplPatientInfos = new HashSet(0);
	private Set hdPatientInfos = new HashSet(0);
	private Set hdPatientRecords = new HashSet(0);
	private Set htnPatientMedicineRecords = new HashSet(0);
	private Set gluPatientRecords = new HashSet(0);
	private Set gluPatientInfos = new HashSet(0);
	private Set healthHistories = new HashSet(0);
	private Set patientHasDoctors = new HashSet(0);
	private Set hdPatientMedicineRecords = new HashSet(0);
	private Set hplPatientMedicineRecords = new HashSet(0);
	private Set gluPatientMedicineRecords = new HashSet(0);
	private Set hplPatientRecords = new HashSet(0);
	private Set htnPatientInfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractPatient() {
	}

	/** minimal constructor */
	public AbstractPatient(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public AbstractPatient(String username, String realname, String nickname, String password, String token, String mail,
			String tele, String tele1, String tele2, Boolean gluState, Boolean hplState, Boolean htnState, Boolean hdState,
			String gender, String age, String height, String weight, String address, String nation, String profession,
			String company, Timestamp registerTime, Boolean marriage, Set htnPatientRecords, Set emrs, Set hplPatientInfos,
			Set hdPatientInfos, Set hdPatientRecords, Set htnPatientMedicineRecords, Set gluPatientRecords, Set gluPatientInfos,
			Set healthHistories, Set patientHasDoctors, Set hdPatientMedicineRecords, Set hplPatientMedicineRecords,
			Set gluPatientMedicineRecords, Set hplPatientRecords, Set htnPatientInfos) {
		this.username = username;
		this.realname = realname;
		this.nickname = nickname;
		this.password = password;
		this.token = token;
		this.mail = mail;
		this.tele = tele;
		this.tele1 = tele1;
		this.tele2 = tele2;
		this.gluState = gluState;
		this.hplState = hplState;
		this.htnState = htnState;
		this.hdState = hdState;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.address = address;
		this.nation = nation;
		this.profession = profession;
		this.company = company;
		this.registerTime = registerTime;
		this.marriage = marriage;
		this.htnPatientRecords = htnPatientRecords;
		this.emrs = emrs;
		this.hplPatientInfos = hplPatientInfos;
		this.hdPatientInfos = hdPatientInfos;
		this.hdPatientRecords = hdPatientRecords;
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
		this.gluPatientRecords = gluPatientRecords;
		this.gluPatientInfos = gluPatientInfos;
		this.healthHistories = healthHistories;
		this.patientHasDoctors = patientHasDoctors;
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
		this.gluPatientMedicineRecords = gluPatientMedicineRecords;
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

	public String getTele() {
		return this.tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getTele1() {
		return this.tele1;
	}

	public void setTele1(String tele1) {
		this.tele1 = tele1;
	}

	public String getTele2() {
		return this.tele2;
	}

	public void setTele2(String tele2) {
		this.tele2 = tele2;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date date) {
		this.registerTime = date;
	}

	public Boolean getMarriage() {
		return this.marriage;
	}

	public void setMarriage(Boolean marriage) {
		this.marriage = marriage;
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

	public Set getHdPatientInfos() {
		return this.hdPatientInfos;
	}

	public void setHdPatientInfos(Set hdPatientInfos) {
		this.hdPatientInfos = hdPatientInfos;
	}

	public Set getHdPatientRecords() {
		return this.hdPatientRecords;
	}

	public void setHdPatientRecords(Set hdPatientRecords) {
		this.hdPatientRecords = hdPatientRecords;
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

	public Set getGluPatientInfos() {
		return this.gluPatientInfos;
	}

	public void setGluPatientInfos(Set gluPatientInfos) {
		this.gluPatientInfos = gluPatientInfos;
	}

	public Set getHealthHistories() {
		return this.healthHistories;
	}

	public void setHealthHistories(Set healthHistories) {
		this.healthHistories = healthHistories;
	}

	public Set getPatientHasDoctors() {
		return this.patientHasDoctors;
	}

	public void setPatientHasDoctors(Set patientHasDoctors) {
		this.patientHasDoctors = patientHasDoctors;
	}

	public Set getHdPatientMedicineRecords() {
		return this.hdPatientMedicineRecords;
	}

	public void setHdPatientMedicineRecords(Set hdPatientMedicineRecords) {
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
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