package com.hcp.domain;

import java.sql.Timestamp;

/**
 * SuperAdministrator entity. @author MyEclipse Persistence Tools
 */

public class SuperAdministrator implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String realname;
	private String idNumber;
	private String password;
	private String mail;
	private String tele;
	private Timestamp registerTime;

	// Constructors

	/** default constructor */
	public SuperAdministrator() {
	}

	/** minimal constructor */
	public SuperAdministrator(String username, String realname, String idNumber, String password, Timestamp registerTime) {
		this.username = username;
		this.realname = realname;
		this.idNumber = idNumber;
		this.password = password;
		this.registerTime = registerTime;
	}

	/** full constructor */
	public SuperAdministrator(String username, String realname, String idNumber, String password, String mail, String tele,
			Timestamp registerTime) {
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