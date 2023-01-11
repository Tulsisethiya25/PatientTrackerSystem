package com.capgemini.pts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pts.dto.DoctorLogin;
import com.capgemini.pts.dto.DoctorRegister;
import com.capgemini.pts.dto.HistoryDto;
import com.capgemini.pts.dto.PatientDto;
import com.capgemini.pts.entity.Doctor;
import com.capgemini.pts.entity.History;
import com.capgemini.pts.entity.Patient;
import com.capgemini.pts.service.DoctorService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	DoctorService doctorservice;
	
	@PostMapping("/doctorregister")
	public Doctor registerDoctor(@RequestBody DoctorRegister doctorregister) {
		return doctorservice.registerDoctor(doctorregister);
	}
	
	@PostMapping("/doctorlogin")
	public ResponseEntity<String> doctorLogin(@RequestBody DoctorLogin doctorlogin) {
		return doctorservice.loginDoctor(doctorlogin);
	}
	
	@PostMapping("/addpatient")
	public ResponseEntity<String> addPatient(@RequestBody PatientDto patientdto){
		doctorservice.addPatient(patientdto);
		return new ResponseEntity<>("Patient Added", HttpStatus.OK);
	}
	
	@GetMapping("/getpatient/{patientId}")
	public Optional<Patient> getPatient(@PathVariable int patientId) {
		return doctorservice.getPatient(patientId);
	}
	
	@PostMapping("/addhistory")
	public ResponseEntity<String> addHistory(@RequestBody HistoryDto historydto){
		doctorservice.addHistory(historydto);
		return new ResponseEntity<String>("Treatment Details Added", HttpStatus.OK);
	}
	
	@GetMapping("/gethistory/{patientId}")
	public List<History> getHistory(@PathVariable int patientId) {
		return doctorservice.getHistoryByPatientId(patientId);
	}
	
	@GetMapping("/getpatientbydoctorid/{doctorId}")
	public List<Patient> getPatientByDoctorId(@PathVariable int doctorId){
		return doctorservice.getPatientByDoctorId(doctorId);
	}

}
