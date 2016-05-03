package com.hcp.mobilePOJO;

public class MedicineDetail {
	private String medicineName; // 药名
	private String constituent; // 成分
	private String adaptation_disease; // 适应症
	private String adverse_reaction; // 不良反应
	private String taboo; // 用药禁忌
	private String attentions; // 注意事项
	private String direction; // 药品说明

	public MedicineDetail() {
	}

	public MedicineDetail(String medicineName, String constituent, String adaptation_disease, String adverse_reaction,
			String taboo, String attentions, String direction) {
		super();
		this.medicineName = medicineName;
		this.constituent = constituent;
		this.adaptation_disease = adaptation_disease;
		this.adverse_reaction = adverse_reaction;
		this.taboo = taboo;
		this.attentions = attentions;
		this.direction = direction;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getConstituent() {
		return constituent;
	}

	public void setConstituent(String constituent) {
		this.constituent = constituent;
	}

	public String getAdaptation_disease() {
		return adaptation_disease;
	}

	public void setAdaptation_disease(String adaptation_disease) {
		this.adaptation_disease = adaptation_disease;
	}

	public String getAdverse_reaction() {
		return adverse_reaction;
	}

	public void setAdverse_reaction(String adverse_reaction) {
		this.adverse_reaction = adverse_reaction;
	}

	public String getTaboo() {
		return taboo;
	}

	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}

	public String getAttentions() {
		return attentions;
	}

	public void setAttentions(String attentions) {
		this.attentions = attentions;
	}

}
