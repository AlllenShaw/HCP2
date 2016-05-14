package com.hcp.domain;

import java.sql.Timestamp;

/**
 * AppVersion entity. @author MyEclipse Persistence Tools
 */

public class AppVersion implements java.io.Serializable {

	// Fields

	private Integer id;
	private String version;
	private String updateInfo;
	private Timestamp updateTime;

	// Constructors

	/** default constructor */
	public AppVersion() {
	}

	/** minimal constructor */
	public AppVersion(String version) {
		this.version = version;
	}

	/** full constructor */
	public AppVersion(String version, String updateInfo, Timestamp updateTime) {
		this.version = version;
		this.updateInfo = updateInfo;
		this.updateTime = updateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUpdateInfo() {
		return this.updateInfo;
	}

	public void setUpdateInfo(String updateInfo) {
		this.updateInfo = updateInfo;
	}

	public Timestamp getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}