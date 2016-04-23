package com.hcp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Security entity. @author MyEclipse Persistence Tools
 */

public class Security implements java.io.Serializable {

	// Fields

	private Integer id;
	private String question;
	private Set patientsForSecurity2 = new HashSet(0);
	private Set patientsForSecurity1 = new HashSet(0);
	private Set patientsForSecurity3 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Security() {
	}

	/** minimal constructor */
	public Security(String question) {
		this.question = question;
	}

	/** full constructor */
	public Security(String question, Set patientsForSecurity2, Set patientsForSecurity1, Set patientsForSecurity3) {
		this.question = question;
		this.patientsForSecurity2 = patientsForSecurity2;
		this.patientsForSecurity1 = patientsForSecurity1;
		this.patientsForSecurity3 = patientsForSecurity3;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Set getPatientsForSecurity2() {
		return this.patientsForSecurity2;
	}

	public void setPatientsForSecurity2(Set patientsForSecurity2) {
		this.patientsForSecurity2 = patientsForSecurity2;
	}

	public Set getPatientsForSecurity1() {
		return this.patientsForSecurity1;
	}

	public void setPatientsForSecurity1(Set patientsForSecurity1) {
		this.patientsForSecurity1 = patientsForSecurity1;
	}

	public Set getPatientsForSecurity3() {
		return this.patientsForSecurity3;
	}

	public void setPatientsForSecurity3(Set patientsForSecurity3) {
		this.patientsForSecurity3 = patientsForSecurity3;
	}

}