package com.hcp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Family entity. @author MyEclipse Persistence Tools
 */

public class Family implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String relation;
	private String tele;
	private String address;
	private String email;
	private Set patientsForFamlily2 = new HashSet(0);
	private Set patientsForFamlily1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public Family() {
	}

	/** minimal constructor */
	public Family(String name, String tele) {
		this.name = name;
		this.tele = tele;
	}

	/** full constructor */
	public Family(String name, String relation, String tele, String address, String email, Set patientsForFamlily2,
			Set patientsForFamlily1) {
		this.name = name;
		this.relation = relation;
		this.tele = tele;
		this.address = address;
		this.email = email;
		this.patientsForFamlily2 = patientsForFamlily2;
		this.patientsForFamlily1 = patientsForFamlily1;
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

	public String getRelation() {
		return this.relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getTele() {
		return this.tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getPatientsForFamlily2() {
		return this.patientsForFamlily2;
	}

	public void setPatientsForFamlily2(Set patientsForFamlily2) {
		this.patientsForFamlily2 = patientsForFamlily2;
	}

	public Set getPatientsForFamlily1() {
		return this.patientsForFamlily1;
	}

	public void setPatientsForFamlily1(Set patientsForFamlily1) {
		this.patientsForFamlily1 = patientsForFamlily1;
	}

}