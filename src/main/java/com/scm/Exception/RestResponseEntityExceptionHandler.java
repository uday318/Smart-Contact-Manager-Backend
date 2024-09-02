package com.scm.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.scm.Entities.ErrorMessage;



public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<ErrorMessage> handleDataValidationException(ValidationException exception,
			WebRequest request)  {
		
		ErrorMessage message = new ErrorMessage(500, exception.getMessage());
		
		
		
		return new  ResponseEntity<ErrorMessage>(message,HttpStatus.PRECONDITION_FAILED);
	}

}
