package com.challenger03.challenger03_crud.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidatorError extends CustomError {
	
	

	private List<FieldMessage> errors=new ArrayList<>();
	
	
	public ValidatorError(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
		
	}


	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName,String fieldMessage) {
		errors.add(new FieldMessage(fieldName, fieldMessage));
	}
}
