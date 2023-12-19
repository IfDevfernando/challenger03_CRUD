package com.challenger03.challenger03_crud.servicies.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		
		super(msg);
	}

}
