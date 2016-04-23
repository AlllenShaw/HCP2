package com.hcp.domain;

/**
 * UserGroupPermission entity. @author MyEclipse Persistence Tools
 */

public class UserGroupPermission implements java.io.Serializable {

	// Fields

	private Integer id;
	private UserGroup userGroupByUserGroup1Id;
	private Permission permission;
	private UserGroup userGroupByUserGroup2Id;
	private Boolean feasible;

	// Constructors

	/** default constructor */
	public UserGroupPermission() {
	}

	/** minimal constructor */
	public UserGroupPermission(UserGroup userGroupByUserGroup1Id, Permission permission, UserGroup userGroupByUserGroup2Id) {
		this.userGroupByUserGroup1Id = userGroupByUserGroup1Id;
		this.permission = permission;
		this.userGroupByUserGroup2Id = userGroupByUserGroup2Id;
	}

	/** full constructor */
	public UserGroupPermission(UserGroup userGroupByUserGroup1Id, Permission permission, UserGroup userGroupByUserGroup2Id,
			Boolean feasible) {
		this.userGroupByUserGroup1Id = userGroupByUserGroup1Id;
		this.permission = permission;
		this.userGroupByUserGroup2Id = userGroupByUserGroup2Id;
		this.feasible = feasible;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserGroup getUserGroupByUserGroup1Id() {
		return this.userGroupByUserGroup1Id;
	}

	public void setUserGroupByUserGroup1Id(UserGroup userGroupByUserGroup1Id) {
		this.userGroupByUserGroup1Id = userGroupByUserGroup1Id;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public UserGroup getUserGroupByUserGroup2Id() {
		return this.userGroupByUserGroup2Id;
	}

	public void setUserGroupByUserGroup2Id(UserGroup userGroupByUserGroup2Id) {
		this.userGroupByUserGroup2Id = userGroupByUserGroup2Id;
	}

	public Boolean getFeasible() {
		return this.feasible;
	}

	public void setFeasible(Boolean feasible) {
		this.feasible = feasible;
	}

}