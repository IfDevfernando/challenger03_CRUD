package com.challenger03.challenger03_crud.dto;

public class FieldMessage {
	
	private String FielddName;
	private String message;
	
	
	public FieldMessage(String fielddName, String message) {
		super();
		FielddName = fielddName;
		this.message = message;
	}


	public String getFielddName() {
		return FielddName;
	}


	public String getMessage() {
		return message;
	}
	
	

}
