package com.supra.entretien.ClientRegister.exception;

import com.supra.entretien.ClientRegister.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?> badRequestExceptionHandler(BadRequestException ex) {
		ErrorResponse errorDetails = new ErrorResponse("bad request", ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RessourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundExceptionHandler(RessourceNotFoundException ex) {
		ErrorResponse errorDetails = new ErrorResponse("resource not found", ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception ex) {
		ErrorResponse errorDetails = new ErrorResponse("error",ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
