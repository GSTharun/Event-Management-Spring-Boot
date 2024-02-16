package com.ty.event.event_management.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.event.event_management.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchIdFoundHandler(NoSuchIdFoundException exception)
	{
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Id Found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(NoSuchIdFoundToUpdate.class)
	public ResponseEntity<ResponseStructure<String>> noSuchDataIdFoundHandler(NoSuchIdFoundToUpdate exception)
	{
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Id Found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoSuchIdFoundToDelete.class)
	public ResponseEntity<ResponseStructure<String>> noSuchIdFound(NoSuchIdFoundToDelete exception)
	{
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Id Found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<ObjectError> errors= ex.getAllErrors();
		Map<String, String> map= new LinkedHashMap<>();
		for(ObjectError error:errors) {
			String message= error.getDefaultMessage();
			String field=((FieldError)error).getField();
			map.put(field, message);
		}
		ResponseStructure<Map<String,String>> responseStructure= new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage(HttpStatus.BAD_REQUEST.name());
		responseStructure.setData(map);
		
		return new ResponseEntity<Object>(responseStructure,HttpStatus.BAD_REQUEST);	
	}
	
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> ForeignKeyTableCantBeDeleted(SQLIntegrityConstraintViolationException exception)
	{
		ResponseEntity<ResponseStructure<String>> responseEntity;
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("Cannot delete a foreign key constraint fails");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.BAD_REQUEST);
	}
	
	
	
}