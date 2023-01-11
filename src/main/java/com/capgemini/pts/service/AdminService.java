package com.capgemini.pts.service;

import java.util.List;

import com.capgemini.pts.entity.Doctor;

public interface AdminService {
	public List<Doctor> getAllDoctors();

	public Doctor deleteDoctorByDoctorId(int doctorId);

	public Doctor viewDoctorByDoctorId(int doctorId);

	public List<Doctor> viewDoctorByStatus(String status);

	public String updateDoctorStatus(int doctorId, String status);
}
