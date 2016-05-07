package com.hcp.domain;

/**
 * MealTime entity. @author MyEclipse Persistence Tools
 */

public class MealTime implements java.io.Serializable {

	// Fields

	private Integer id;
	private String mealTime;

	// Constructors

	/** default constructor */
	public MealTime() {
	}

	/** full constructor */
	public MealTime(String mealTime) {
		this.mealTime = mealTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMealTime() {
		return this.mealTime;
	}

	public void setMealTime(String mealTime) {
		this.mealTime = mealTime;
	}

}