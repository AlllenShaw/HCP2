package com.bean.domain;

import java.util.Date;

/**
 * SuperAdministrator entity. @author MyEclipse Persistence Tools
 */

public class SuperAdministrator implements java.io.Serializable {

	// Fields

	private Integer id;
	private Authority authority;
	private String username;
	private String password;
	private String mail;
	private String tele;
	private Date createTime;

	// Constructors

	/** default constructor */
	public SuperAdministrator() {
	}

	/** minimal constructor */
	public SuperAdministrator(Authority authority, String username,
			String password, Date createTime) {
		this.authority = authority;
		this.username = username;
		this.password = password;
		this.createTime = createTime;
	}

	/** full constructor */
	public SuperAdministrator(Authority authority, String username,
			String password, String mail, String tele, Date createTime) {
		this.authority = authority;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.tele = tele;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}