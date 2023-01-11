package com.capgemini.pts.dto;

import java.util.Date;

import com.capgemini.pts.entity.Patient;

public class HistoryDto {
	
	private int treatmentCost;
	private Date treatmentDate;
	private String treatmentType;
	private String medicine;
	private Patient patientId;

	public Patient getPatientId() {
		return patientId;
	}

	public void setPatientId(Patient patientId) {
		this.patientId = patientId;
	}

	public int getTreatmentCost() {
		return treatmentCost;
	}

	public void setTreatmentCost(int treatmentCost) {
		this.treatmentCost = treatmentCost;
	}

	public Date getTreatmentDate() {
		return treatmentDate;
	}

	public void setTreatmentDate(Date treatmentDate) {
		this.treatmentDate = treatmentDate;
	}

	public String getTreatmentType() {
		return treatmentType;
	}

	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

}
