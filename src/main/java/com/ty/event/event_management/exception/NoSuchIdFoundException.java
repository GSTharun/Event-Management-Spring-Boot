package com.ty.event.event_management.exception;

public class NoSuchIdFoundException extends RuntimeException{
<<<<<<< HEAD
	String message="No Such Id Found";

	@Override
	public String getMessage() {
		return getMessage();
	}
=======
	
	private String message="no such id found in database";
	
	
	
	
>>>>>>> e762a131c120dfee176f5c322929552e5ad9b5d4

	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundException() {
		
	}

	@Override
	public String getMessage() {
		
		return message;
	}
	
}
