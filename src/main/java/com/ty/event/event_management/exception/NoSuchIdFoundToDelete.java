package com.ty.event.event_management.exception;

public class NoSuchIdFoundToDelete extends RuntimeException {

	private String message = "no such id found to delete the data in database";

	public NoSuchIdFoundToDelete(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundToDelete() {

	}

	@Override
	public String getMessage() {

		return message;
	}

}
