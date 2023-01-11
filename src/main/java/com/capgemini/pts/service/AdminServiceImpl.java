package com.capgemini.pts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pts.entity.Doctor;
import com.capgemini.pts.exception.DoctorIdNotFoundException;
import com.capgemini.pts.repository.DoctorRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	DoctorRepository doctorrepo;

	@Override
	public List<Doctor> getAllDoctors() {
		return doctorrepo.findAll();
	}

	@Override
	public Doctor deleteDoctorByDoctorId(int doctorId) {
		Doctor doctor = doctorrepo.findByDoctorId(doctorId);
		if(doctor != null) {
			doctorrepo.deleteById(doctorId);
			return doctor;
		}
		else {
			throw new DoctorIdNotFoundException();
		}
	}

	@Override
	public Doctor viewDoctorByDoctorId(int doctorId) {
		Doctor doctor = doctorrepo.findByDoctorId(doctorId);
		if(doctor != null) {
			return doctor;
		}
		else {
			throw new DoctorIdNotFoundException();
		}
	}

	@Override
	public List<Doctor> viewDoctorByStatus(String status) {
		return doctorrepo.findAllByStatus(status);
	}

	@Override
	public String updateDoctorStatus(int doctorId, String status) {
		Doctor doctor = doctorrepo.findByDoctorId(doctorId);
		doctor.setStatus(status);
		doctorrepo.save(doctor);
		return "Status Update Successfully";
	}

}
