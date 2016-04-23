package com.hcp.domain;

import java.sql.Timestamp;

/**
 * HospitalAdministrator entity. @author MyEclipse Persistence Tools
 */

public class HospitalAdministrator implements java.io.Serializable {

	// Fields

	private Integer id;
	private Hospital hospital;
	private String username;
	private String realname;
	private String idNumber;
	private String password;
	private String mail;
	private String tele;
	private Timestamp registerTime;

	// Constructors

	/** default constructor */
	public HospitalAdministrator() {
	}

	/** minimal constructor */
	public HospitalAdministrator(Hospital hospital, String username, String realname, String idNumber, String password) {
		this.hospital = hospital;
		this.username = username;
		this.realname = realname;
		this.idNumber = idNumber;
		this.password = password;
	}

	/** full constructor */
	public HospitalAdministrator(Hospital hospital, String username, String realname, String idNumber, String password,
			String mail, String tele, Timestamp registerTime) {
		this.hospital = hospital;
		this.username = username;
		this.realname = realname;
		this.idNumber = idNumber;
		this.password = password;
		this.mail = mail;
		this.tele = tele;
		this.registerTime = registerTime;
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

	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

}