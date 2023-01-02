package com.ty.event.event_management.exception;

public class NoSuchIdFoundException extends RuntimeException{
	String message="No Such Id Found";

	@Override
	public String getMessage() {
		return getMessage();
	}

	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundException() {
		super();
	}
	
	

}
