package com.hcp.domain;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Hospital entity. @author MyEclipse Persistence Tools
 */

public class Hospital implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String address;
	private String level;
	private String introduction;
	private Timestamp registerTime;
	private Set hospitalAdministrators = new HashSet(0);
	private Set hospitalHasHospitalsForHospital1 = new HashSet(0);
	private Set doctors = new HashSet(0);
	private Set hospitalHasHospitalsForHospital2 = new HashSet(0);
	private Set userGroups = new HashSet(0);
	private Set patients = new HashSet(0);

	// Constructors

	/** default constructor */
	public Hospital() {
	}

	/** minimal constructor */
	public Hospital(String name, String address, String level, Timestamp registerTime) {
		this.name = name;
		this.address = address;
		this.level = level;
		this.registerTime = registerTime;
	}

	/** full constructor */
	public Hospital(String name, String address, String level, String introduction, Timestamp registerTime,
			Set hospitalAdministrators, Set hospitalHasHospitalsForHospital1, Set doctors, Set hospitalHasHospitalsForHospital2,
			Set userGroups, Set patients) {
		this.name = name;
		this.address = address;
		this.level = level;
		this.introduction = introduction;
		this.registerTime = registerTime;
		this.hospitalAdministrators = hospitalAdministrators;
		this.hospitalHasHospitalsForHospital1 = hospitalHasHospitalsForHospital1;
		this.doctors = doctors;
		this.hospitalHasHospitalsForHospital2 = hospitalHasHospitalsForHospital2;
		this.userGroups = userGroups;
		this.patients = patients;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	public Set getHospitalAdministrators() {
		return this.hospitalAdministrators;
	}

	public void setHospitalAdministrators(Set hospitalAdministrators) {
		this.hospitalAdministrators = hospitalAdministrators;
	}

	public Set getHospitalHasHospitalsForHospital1() {
		return this.hospitalHasHospitalsForHospital1;
	}

	public void setHospitalHasHospitalsForHospital1(Set hospitalHasHospitalsForHospital1) {
		this.hospitalHasHospitalsForHospital1 = hospitalHasHospitalsForHospital1;
	}

	public Set getDoctors() {
		return this.doctors;
	}

	public void setDoctors(Set doctors) {
		this.doctors = doctors;
	}

	public Set getHospitalHasHospitalsForHospital2() {
		return this.hospitalHasHospitalsForHospital2;
	}

	public void setHospitalHasHospitalsForHospital2(Set hospitalHasHospitalsForHospital2) {
		this.hospitalHasHospitalsForHospital2 = hospitalHasHospitalsForHospital2;
	}

	public Set getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(Set userGroups) {
		this.userGroups = userGroups;
	}

	public Set getPatients() {
		return this.patients;
	}

	public void setPatients(Set patients) {
		this.patients = patients;
	}

}