package com.hcp.mobilePOJO;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.hcp.domain.Doctor;
import com.hcp.domain.Emr;
import com.hcp.domain.Medicine;
import com.hcp.domain.MedicineUnit;
import com.hcp.domain.TakingMedicineWay;

public class Prescription {

	private Integer id;
	private Medicine medicine;
	private Doctor doctor;
	private TakingMedicineWay takingMedicineWay;
	private MedicineUnit medicineUnit;
	private Double takingMedicineNumberEachtime;
	private Integer takingMedicineTimesEachday;
	private String note;
	private Integer mealTime;
	private Timestamp createTime;
	
	
}
