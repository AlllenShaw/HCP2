package com.bean.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * ExaminationType entity. @author MyEclipse Persistence Tools
 */

public class ExaminationType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String value;
	private Set examinationEmrs = new HashSet(0);

	// Constructors

	/** default constructor */
	public ExaminationType() {
	}

	/** minimal constructor */
	public ExaminationType(String value) {
		this.value = value;
	}

	/** full constructor */
	public ExaminationType(String value, Set examinationEmrs) {
		this.value = value;
		this.examinationEmrs = examinationEmrs;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Set getExaminationEmrs() {
		return this.examinationEmrs;
	}

	public void setExaminationEmrs(Set examinationEmrs) {
		this.examinationEmrs = examinationEmrs;
	}

}