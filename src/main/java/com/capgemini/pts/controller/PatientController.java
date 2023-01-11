package com.capgemini.pts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pts.entity.History;
import com.capgemini.pts.entity.Patient;
import com.capgemini.pts.service.DoctorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	DoctorService doctorservice;
	
	@GetMapping("/getpatient/{patientId}")
	public Optional<Patient> getpatientById(@PathVariable int patientId) {
		return doctorservice.getPatient(patientId);
	}
	
	@GetMapping("gethistory/{patientId}")
	public List<History> getHistory(@PathVariable int patientId) {
		return doctorservice.getHistoryByPatientId(patientId);
	}

}
