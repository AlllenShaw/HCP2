package com.hcp.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Medicine entity. @author MyEclipse Persistence Tools
 */

public class Medicine implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String constituent;
	private String adaptationDisease;
	private String usage;
	private String dosage;
	private String adverseReaction;
	private String taboo;
	private String attentions;
	private String direction;
	private Set prescriptions = new HashSet(0);
	private Set hplPatientMedicineRecords = new HashSet(0);
	private Set hdPatientMedicineRecords = new HashSet(0);
	private Set htnPatientMedicineRecords = new HashSet(0);
	private Set gluPatientMedicineRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Medicine() {
	}

	/** minimal constructor */
	public Medicine(String name) {
		this.name = name;
	}

	/** full constructor */
	public Medicine(String name, String constituent, String adaptationDisease, String usage, String dosage,
			String adverseReaction, String taboo, String attentions, String direction, Set prescriptions,
			Set hplPatientMedicineRecords, Set hdPatientMedicineRecords, Set htnPatientMedicineRecords,
			Set gluPatientMedicineRecords) {
		this.name = name;
		this.constituent = constituent;
		this.adaptationDisease = adaptationDisease;
		this.usage = usage;
		this.dosage = dosage;
		this.adverseReaction = adverseReaction;
		this.taboo = taboo;
		this.attentions = attentions;
		this.direction = direction;
		this.prescriptions = prescriptions;
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
		this.gluPatientMedicineRecords = gluPatientMedicineRecords;
	}

	// Property accessors

	public Medicine(String name, String adaptationDisease, String usage, String dosage,
			String adverseReaction, String taboo, String attentions) {
		this.name = name;
		this.adaptationDisease = adaptationDisease;
		this.usage = usage;
		this.dosage = dosage;
		this.adverseReaction = adverseReaction;
		this.taboo = taboo;
		this.attentions = attentions;
	}

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

	public String getConstituent() {
		return this.constituent;
	}

	public void setConstituent(String constituent) {
		this.constituent = constituent;
	}

	public String getAdaptationDisease() {
		return this.adaptationDisease;
	}

	public void setAdaptationDisease(String adaptationDisease) {
		this.adaptationDisease = adaptationDisease;
	}

	public String getUsage() {
		return this.usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	public String getDosage() {
		return this.dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getAdverseReaction() {
		return this.adverseReaction;
	}

	public void setAdverseReaction(String adverseReaction) {
		this.adverseReaction = adverseReaction;
	}

	public String getTaboo() {
		return this.taboo;
	}

	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}

	public String getAttentions() {
		return this.attentions;
	}

	public void setAttentions(String attentions) {
		this.attentions = attentions;
	}

	public String getDirection() {
		return this.direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Set getPrescriptions() {
		return this.prescriptions;
	}

	public void setPrescriptions(Set prescriptions) {
		this.prescriptions = prescriptions;
	}

	public Set getHplPatientMedicineRecords() {
		return this.hplPatientMedicineRecords;
	}

	public void setHplPatientMedicineRecords(Set hplPatientMedicineRecords) {
		this.hplPatientMedicineRecords = hplPatientMedicineRecords;
	}

	public Set getHdPatientMedicineRecords() {
		return this.hdPatientMedicineRecords;
	}

	public void setHdPatientMedicineRecords(Set hdPatientMedicineRecords) {
		this.hdPatientMedicineRecords = hdPatientMedicineRecords;
	}

	public Set getHtnPatientMedicineRecords() {
		return this.htnPatientMedicineRecords;
	}

	public void setHtnPatientMedicineRecords(Set htnPatientMedicineRecords) {
		this.htnPatientMedicineRecords = htnPatientMedicineRecords;
	}

	public Set getGluPatientMedicineRecords() {
		return this.gluPatientMedicineRecords;
	}

	public void setGluPatientMedicineRecords(Set gluPatientMedicineRecords) {
		this.gluPatientMedicineRecords = gluPatientMedicineRecords;
	}

}