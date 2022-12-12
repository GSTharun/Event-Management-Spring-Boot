package com.ty.event.event_management.exception;

public class UnableToUpdateException extends RuntimeException{
	String message="Unable To Update";

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return getMessage();
	}

	public UnableToUpdateException(String message) {
		super();
		this.message = message;
	}

	public UnableToUpdateException() {
		super();
	}
	
	

}
