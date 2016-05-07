package com.hcp.mobilePOJO;

public class MedicineInfo {

	private String id;
	private String medicineName;
	private String way;
	private Double number; // takingMedicineNumberEachtime
	private String unit;
	private String count; // takingMedicineTimesEachday
	private String time;
	private String createTime;

	public MedicineInfo() {
	}

	public MedicineInfo(String id, String medicineName, String way, Double number, String unit, String count, String time,
			String createTime) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.way = way;
		this.number = number;
		this.unit = unit;
		this.count = count;
		this.time = time;
		this.createTime = createTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
