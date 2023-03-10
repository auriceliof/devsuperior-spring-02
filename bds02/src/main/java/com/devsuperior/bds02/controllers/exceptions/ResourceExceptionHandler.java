package com.devsuperior.bds02.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.services.exceptions.BadRequest;
import com.devsuperior.bds02.services.exceptions.IdNotFound;
import com.devsuperior.bds02.services.exceptions.NotFound;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(NotFound.class)
	public ResponseEntity<StandardError> entityNotFound(NotFound e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}	
	
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<StandardError> database(BadRequest e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setError("Database exception");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}	
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<EventDTO> entityNotFound(){
		return ResponseEntity.notFound().build();
	}	
}





































