package com.capgemini.pts.dto;

import java.util.Date;

import com.capgemini.pts.entity.Doctor;

public class PatientDto {

	private String patientName;
	private Long patientMobile;
	private String email;
	private String patientAddress;
	private Date patientDob;

	private String patientProblem;
	private Date arrivalDate;
	private Doctor doctor;


	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Long getPatientMobile() {
		return patientMobile;
	}

	public void setPatientMobile(Long patientMobile) {
		this.patientMobile = patientMobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public Date getPatientDob() {
		return patientDob;
	}

	public void setPatientDob(Date patientDob) {
		this.patientDob = patientDob;
	}

	public String getPatientProblem() {
		return patientProblem;
	}

	public void setPatientProblem(String patientProblem) {
		this.patientProblem = patientProblem;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

}
