package com.bean.domain;

import java.sql.Timestamp;
import java.util.Set;

/**
 * Patient entity. @author MyEclipse Persistence Tools
 */
public class Patient extends AbstractPatient implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Patient() {
	}

	/** minimal constructor */
	public Patient(String username, String password) {
		super(username, password);
	}

	/** full constructor */
	public Patient(String username, String realname, String nickname, String password, String token, String mail, String tele,
			String tele1, String tele2, Boolean gluState, Boolean hplState, Boolean htnState, Boolean hdState, String gender,
			String age, String height, String weight, String address, String nation, String profession, String company,
			Timestamp registerTime, Boolean marriage, Set htnPatientRecords, Set emrs, Set hplPatientInfos, Set hdPatientInfos,
			Set hdPatientRecords, Set htnPatientMedicineRecords, Set gluPatientRecords, Set gluPatientInfos, Set healthHistories,
			Set patientHasDoctors, Set hdPatientMedicineRecords, Set hplPatientMedicineRecords, Set gluPatientMedicineRecords,
			Set hplPatientRecords, Set htnPatientInfos) {
		super(username, realname, nickname, password, token, mail, tele, tele1, tele2, gluState, hplState, htnState, hdState,
				gender, age, height, weight, address, nation, profession, company, registerTime, marriage, htnPatientRecords,
				emrs, hplPatientInfos, hdPatientInfos, hdPatientRecords, htnPatientMedicineRecords, gluPatientRecords,
				gluPatientInfos, healthHistories, patientHasDoctors, hdPatientMedicineRecords, hplPatientMedicineRecords,
				gluPatientMedicineRecords, hplPatientRecords, htnPatientInfos);
	}

}
