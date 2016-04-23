package com.bean.domain;

import java.util.Date;

/**
 * Protocol entity. @author MyEclipse Persistence Tools
 */

public class Protocol implements java.io.Serializable {

	// Fields

	private ProtocolId id;
	private String filepath;
	private Date createTime;

	// Constructors

	/** default constructor */
	public Protocol() {
	}

	/** full constructor */
	public Protocol(ProtocolId id, String filepath, Date createTime) {
		this.id = id;
		this.filepath = filepath;
		this.createTime = createTime;
	}

	// Property accessors

	public ProtocolId getId() {
		return this.id;
	}

	public void setId(ProtocolId id) {
		this.id = id;
	}

	public String getFilepath() {
		return this.filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}