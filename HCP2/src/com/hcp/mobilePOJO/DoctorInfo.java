package com.hcp.mobilePOJO;

public class DoctorInfo {
	private String doctorName;
	private String perfession;
	private String hospital;
	private int sex;
	private int age;
	private String address; // 办公地址
	private String nation; // 国籍
	private String info;
	private String telePhone;
	private String email;

	public DoctorInfo() {
	}

	public DoctorInfo(String doctorName, String perfession, String hospital, int sex, int age, String address, String nation,
			String info, String telePhone, String email) {
		super();
		this.doctorName = doctorName;
		this.perfession = perfession;
		this.hospital = hospital;
		this.sex = sex;
		this.age = age;
		this.address = address;
		this.nation = nation;
		this.info = info;
		this.telePhone = telePhone;
		this.email = email;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPerfession() {
		return perfession;
	}

	public void setPerfession(String perfession) {
		this.perfession = perfession;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
