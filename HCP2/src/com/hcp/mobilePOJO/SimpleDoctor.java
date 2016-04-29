package com.hcp.mobilePOJO;

public class SimpleDoctor {

	private int doctorID;
	private String doctorName;
	private String perfession;
	private String hospital;

	public SimpleDoctor() {
	}

	public SimpleDoctor(int doctorID, String doctorName, String perfession, String hospital) {
		super();
		this.doctorID = doctorID;
		this.doctorName = doctorName;
		this.perfession = perfession;
		this.hospital = hospital;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
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

}
