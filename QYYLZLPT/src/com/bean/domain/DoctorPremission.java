package com.bean.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * DoctorPremission entity. @author MyEclipse Persistence Tools
 */

public class DoctorPremission implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String url;
	private Set doctorOperPremissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public DoctorPremission() {
	}

	/** minimal constructor */
	public DoctorPremission(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public DoctorPremission(String id, String name, String url,
			Set doctorOperPremissions) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.doctorOperPremissions = doctorOperPremissions;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set getDoctorOperPremissions() {
		return this.doctorOperPremissions;
	}

	public void setDoctorOperPremissions(Set doctorOperPremissions) {
		this.doctorOperPremissions = doctorOperPremissions;
	}

}