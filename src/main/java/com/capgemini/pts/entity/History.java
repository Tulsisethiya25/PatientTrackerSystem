package com.capgemini.pts.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int treatmentId;

	private int treatmentCost;
	private Date treatmentDate;
	private String treatmentType;
	private String medicine;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private Patient patient;

	public int getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(int treatmentId) {
		this.treatmentId = treatmentId;
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}
