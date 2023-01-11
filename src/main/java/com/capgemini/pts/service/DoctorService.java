package com.capgemini.pts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.capgemini.pts.dto.DoctorLogin;
import com.capgemini.pts.dto.DoctorRegister;
import com.capgemini.pts.dto.HistoryDto;
import com.capgemini.pts.dto.PatientDto;
import com.capgemini.pts.entity.Doctor;
import com.capgemini.pts.entity.History;
import com.capgemini.pts.entity.Patient;

public interface DoctorService {
	
	public Doctor registerDoctor(DoctorRegister doctorregister);
	
	public ResponseEntity<String> loginDoctor(DoctorLogin doctorlogin);
	
	public Patient addPatient(PatientDto patientdto);
	
	public Optional<Patient> getPatient(int patientId);
	
	public History addHistory(HistoryDto historydto);
	
	public List<History> getHistoryByPatientId(int patientId);
	
	public List<Patient> getPatientByDoctorId(int doctorId);
	
}
