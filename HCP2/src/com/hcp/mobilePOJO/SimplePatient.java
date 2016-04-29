package com.hcp.mobilePOJO;

public class SimplePatient {

	private String username;
	private String name;
	private String idNumber;
	private int sex;
	private String age;
	private String phoneNum;

	public SimplePatient() {
	}

	public SimplePatient(String username, String name, String idNumber, int sex, String age, String phoneNum) {
		super();
		this.username = username;
		this.name = name;
		this.idNumber = idNumber;
		this.sex = sex;
		this.age = age;
		this.phoneNum = phoneNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
