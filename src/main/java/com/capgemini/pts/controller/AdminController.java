package com.capgemini.pts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pts.entity.Doctor;
import com.capgemini.pts.service.AdminService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@GetMapping("/doctors")
	public List<Doctor> getAllApplicants() {
		return adminservice.getAllDoctors();
	}
	
	@DeleteMapping("/deletedoctor/{doctorId}")
	public ResponseEntity<Doctor> deleteDoctorByDoctorId(@PathVariable int doctorId){
		Doctor doctordeleteInfo = adminservice.deleteDoctorByDoctorId(doctorId);
		return new ResponseEntity<>(doctordeleteInfo, HttpStatus.OK);
	}
	
	@GetMapping("/viewDoctorByDoctorId/{doctorId}")
	public ResponseEntity<Doctor> findAllByDoctorId(@PathVariable int doctorId){
		Doctor d = adminservice.viewDoctorByDoctorId(doctorId);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}
	
	@GetMapping("/viewDoctorByStatus/{status}")
	public List<Doctor> findAllByStatus(@PathVariable String status) {
		return adminservice.viewDoctorByStatus(status);
	}
	
	@PutMapping("/updateDoctorStatus/{doctorId}/{status}")
	public String updateDoctorByStatus(@PathVariable int doctorId, @PathVariable String status) {
		return adminservice.updateDoctorStatus(doctorId, status);
	}

}
