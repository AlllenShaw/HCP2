package com.bean.domain;

import java.util.Date;
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
	private Date registerTime;
	private Set tranformFieldsTables = new HashSet(0);
	private Set doctors = new HashSet(0);
	private Set protocolsForOtherHospitalId = new HashSet(0);
	private Set protocolsForMyHospitalId = new HashSet(0);
	private Set hospitalAdministrators = new HashSet(0);

	// Constructors

	/** default constructor */
	public Hospital() {
	}

	/** minimal constructor */
	public Hospital(String name, String address, String level, Date registerTime) {
		this.name = name;
		this.address = address;
		this.level = level;
		this.registerTime = registerTime;
	}

	/** full constructor */
	public Hospital(String name, String address, String level,
			Date registerTime, Set tranformFieldsTables, Set doctors,
			Set protocolsForOtherHospitalId, Set protocolsForMyHospitalId,
			Set hospitalAdministrators) {
		this.name = name;
		this.address = address;
		this.level = level;
		this.registerTime = registerTime;
		this.tranformFieldsTables = tranformFieldsTables;
		this.doctors = doctors;
		this.protocolsForOtherHospitalId = protocolsForOtherHospitalId;
		this.protocolsForMyHospitalId = protocolsForMyHospitalId;
		this.hospitalAdministrators = hospitalAdministrators;
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

	public Date getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public Set getTranformFieldsTables() {
		return this.tranformFieldsTables;
	}

	public void setTranformFieldsTables(Set tranformFieldsTables) {
		this.tranformFieldsTables = tranformFieldsTables;
	}

	public Set getDoctors() {
		return this.doctors;
	}

	public void setDoctors(Set doctors) {
		this.doctors = doctors;
	}

	public Set getProtocolsForOtherHospitalId() {
		return this.protocolsForOtherHospitalId;
	}

	public void setProtocolsForOtherHospitalId(Set protocolsForOtherHospitalId) {
		this.protocolsForOtherHospitalId = protocolsForOtherHospitalId;
	}

	public Set getProtocolsForMyHospitalId() {
		return this.protocolsForMyHospitalId;
	}

	public void setProtocolsForMyHospitalId(Set protocolsForMyHospitalId) {
		this.protocolsForMyHospitalId = protocolsForMyHospitalId;
	}

	public Set getHospitalAdministrators() {
		return this.hospitalAdministrators;
	}

	public void setHospitalAdministrators(Set hospitalAdministrators) {
		this.hospitalAdministrators = hospitalAdministrators;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", address=" + address
				+ ", level=" + level + ", registerTime=" + registerTime
				+ ", tranformFieldsTables=" + tranformFieldsTables
				+ ", doctors=" + doctors + ", protocolsForOtherHospitalId="
				+ protocolsForOtherHospitalId + ", protocolsForMyHospitalId="
				+ protocolsForMyHospitalId + ", hospitalAdministrators="
				+ hospitalAdministrators + "]";
	}

}