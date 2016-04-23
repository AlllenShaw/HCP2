package com.hcp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Permission entity. @author MyEclipse Persistence Tools
 */

public class Permission implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String description;
	private Set userGroupPermissions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Permission() {
	}

	/** minimal constructor */
	public Permission(String name) {
		this.name = name;
	}

	/** full constructor */
	public Permission(String name, String description, Set userGroupPermissions) {
		this.name = name;
		this.description = description;
		this.userGroupPermissions = userGroupPermissions;
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getUserGroupPermissions() {
		return this.userGroupPermissions;
	}

	public void setUserGroupPermissions(Set userGroupPermissions) {
		this.userGroupPermissions = userGroupPermissions;
	}

}