package com.scm.Exception;

public class ValidationException extends RuntimeException {

	public ValidationException(String message) {
		super(message);
		
	}
	
	public ValidationException() {
		super("Resource Not Found");
	}


}
