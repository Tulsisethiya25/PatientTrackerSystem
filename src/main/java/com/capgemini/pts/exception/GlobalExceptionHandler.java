package com.capgemini.pts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = DoctorAlreadyExistsException.class)
	public ResponseEntity<String> DoctorAlreadyExistsExceptionHandler(DoctorAlreadyExistsException ex){
		return new ResponseEntity<String>("Doctor already exists", HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(value = HistoiryDoesNotExistsException.class)
	public ResponseEntity<String> HistoiryDoesNotExistsExceptionHandler(HistoiryDoesNotExistsException ex){
		return new ResponseEntity<String>("History Does not exists", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = PatientDoesNotExistsException.class)
	public ResponseEntity<String> PatientDoesNotExistsExceptionHandler(PatientDoesNotExistsException ex){
		return new ResponseEntity<String>("Patient Does not exists", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = PatientAlreadyExistsExcetion.class)
	public ResponseEntity<String> PatientAlreadyExistsExcetionHandler(PatientAlreadyExistsExcetion ex){
		return new ResponseEntity<String>("Patient already exists", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = DoctorIdNotFoundException.class)
	public ResponseEntity<String> DoctorIdNotFoundExceptionHandler(DoctorIdNotFoundException ex){
		return new ResponseEntity<String>("Doctor Does not exists", HttpStatus.NOT_FOUND);
	}

}
