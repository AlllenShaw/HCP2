package com.bean.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Authority entity. @author MyEclipse Persistence Tools
 */

public class Authority implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer authority;
	private String state;
	private Set hospitalAdministrators = new HashSet(0);
	private Set superAdministrators = new HashSet(0);

	// Constructors

	/** default constructor */
	public Authority() {
	}

	/** minimal constructor */
	public Authority(Integer authority, String state) {
		this.authority = authority;
		this.state = state;
	}

	/** full constructor */
	public Authority(Integer authority, String state,
			Set hospitalAdministrators, Set superAdministrators) {
		this.authority = authority;
		this.state = state;
		this.hospitalAdministrators = hospitalAdministrators;
		this.superAdministrators = superAdministrators;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAuthority() {
		return this.authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set getHospitalAdministrators() {
		return this.hospitalAdministrators;
	}

	public void setHospitalAdministrators(Set hospitalAdministrators) {
		this.hospitalAdministrators = hospitalAdministrators;
	}

	public Set getSuperAdministrators() {
		return this.superAdministrators;
	}

	public void setSuperAdministrators(Set superAdministrators) {
		this.superAdministrators = superAdministrators;
	}

}