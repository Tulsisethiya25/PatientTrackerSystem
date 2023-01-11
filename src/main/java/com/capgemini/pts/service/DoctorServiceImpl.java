package com.capgemini.pts.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.pts.dto.DoctorLogin;
import com.capgemini.pts.dto.DoctorRegister;
import com.capgemini.pts.dto.HistoryDto;
import com.capgemini.pts.dto.PatientDto;
import com.capgemini.pts.entity.Doctor;
import com.capgemini.pts.entity.History;
import com.capgemini.pts.entity.Patient;
import com.capgemini.pts.exception.DoctorAlreadyExistsException;
import com.capgemini.pts.exception.HistoiryDoesNotExistsException;
import com.capgemini.pts.exception.PatientAlreadyExistsExcetion;
import com.capgemini.pts.exception.PatientDoesNotExistsException;
import com.capgemini.pts.repository.DoctorRepository;
import com.capgemini.pts.repository.HistoryRepository;
import com.capgemini.pts.repository.PatientRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepository doctorrepo;
	
	@Autowired
	PatientRepository patientrepo;
	
	@Autowired
	HistoryRepository historyrepo;
	
	@Override
	public Doctor registerDoctor(DoctorRegister doctorregister) {
		Optional<Doctor> opt = doctorrepo.findByDoctorEmail(doctorregister.getDoctorEmail());
		if(opt.isPresent()) {
			throw new DoctorAlreadyExistsException();
		}
		else {
			Doctor doc = new Doctor();
			doc.setDoctorName(doctorregister.getDoctorName());
			doc.setDoctorEmail(doctorregister.getDoctorEmail());
			doc.setDoctorQualification(doctorregister.getDoctorQualification());
			doc.setExpertise(doctorregister.getExpertise());
			doc.setPassword(doctorregister.getPassword());
			doc.setStatus("Pending");
			return doctorrepo.save(doc);
		}
	}

	@Override
	public Patient addPatient(PatientDto patientdto) {
		Optional<Patient> opt = patientrepo.findByEmail(patientdto.getEmail());
		if(opt.isPresent()) {
			throw new PatientAlreadyExistsExcetion();
		}
		else {
			Patient patient = new Patient();
			patient.setPatientName(patientdto.getPatientName());
			patient.setEmail(patientdto.getEmail());
			patient.setPatientAddress(patientdto.getPatientAddress());
			patient.setPatientDob(patientdto.getPatientDob());
			patient.setPatientMobile(patientdto.getPatientMobile());
			patient.setArrivalDate(patientdto.getArrivalDate());
			patient.setPatientProblem(patientdto.getPatientProblem());
			patient.setDoctor(patientdto.getDoctor());
			return patientrepo.save(patient);
		}
	}

	@Override
	public Optional<Patient> getPatient(int patientId) throws PatientDoesNotExistsException{
//		if(patientrepo.existsById(patientId)) {
//			return patientrepo.findById(patientId);
//		}else {
//			throw new PatientDoesNotExistsException();
//		}
		Optional<Patient> opt = patientrepo.findById(patientId);
		if(opt.isPresent()) {
			return patientrepo.findById(patientId);
		}
		else {
			throw new PatientDoesNotExistsException();
		}
	}

	@Override
	public History addHistory(HistoryDto historydto) {
		History history = new History();
		history.setPatient(historydto.getPatientId());
		history.setTreatmentCost(historydto.getTreatmentCost());
		history.setMedicine(historydto.getMedicine());
		history.setTreatmentDate(historydto.getTreatmentDate());
		history.setTreatmentType(historydto.getTreatmentType());
		return historyrepo.save(history);
	}

	@Override
	public List<History> getHistoryByPatientId(int patientId) {
//		if(!historyrepo.existsById(patientId)){
//			throw new HistoiryDoesNotExistsException();
//			
//		}
//		else if(!patientrepo.existsById(patientId)) {
//			throw new PatientDoesNotExistsException();
//		}
//		else {
//			return historyrepo.findHistoryByPatientPatientId(patientId);
//		}
		return historyrepo.findHistoryByPatientPatientId(patientId);
	}

	@Override
	public List<Patient> getPatientByDoctorId(int doctorId) {
		return patientrepo.findPatientByDoctorDoctorId(doctorId);
	}

	@Override
	public ResponseEntity<String> loginDoctor(DoctorLogin doctorlogin) {
		Doctor doctorexists = doctorrepo.findByDoctorId(doctorlogin.getDoctorId());
		if(doctorexists != null && doctorexists.getPassword().equals(doctorlogin.getPassword())) {
			return new ResponseEntity<String>("Doctor Login Successful", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Login failed", HttpStatus.BAD_REQUEST);
		}

	}
}
