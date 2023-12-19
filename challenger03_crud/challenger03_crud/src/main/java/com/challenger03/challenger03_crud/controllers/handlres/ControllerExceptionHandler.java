package com.challenger03.challenger03_crud.controllers.handlres;

import java.time.Instant;

import org.hibernate.LazyInitializationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.challenger03.challenger03_crud.dto.CustomError;
import com.challenger03.challenger03_crud.dto.ValidatorError;
import com.challenger03.challenger03_crud.servicies.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		HttpStatus status=HttpStatus.NOT_FOUND;
		
		CustomError err=new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException e,HttpServletRequest request){
		
		HttpStatus status=HttpStatus.UNPROCESSABLE_ENTITY;
		
		ValidatorError err= new ValidatorError(Instant.now(), status.value(),"invalid data" , request.getRequestURI());
		e.getBindingResult().getFieldErrors();
		
		for(FieldError f:e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage());
		}
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(LazyInitializationException.class)
	public ResponseEntity<CustomError> resourceIdNotFound(LazyInitializationException e, HttpServletRequest request){
		
		HttpStatus status=HttpStatus.NOT_FOUND;
		
		CustomError err=new CustomError(Instant.now(), status.value(), "Client not found", request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	

}
