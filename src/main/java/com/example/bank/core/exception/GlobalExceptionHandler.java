package com.example.bank.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rami Ammous
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = RecordNotFoundException.class)
	public ResponseEntity<ErrorResponse> handelRecordNotFound(RecordNotFoundException ex) {

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), Arrays.asList(ex.getMessage()));
		return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<ErrorResponse> handelRecordNotFound(BadRequestException ex) {

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), Arrays.asList(ex.getMessage()));
		return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = OperationFailedException.class)
	public ResponseEntity<ErrorResponse> handelRecordNotFound(OperationFailedException ex) {

		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), Arrays.asList(ex.getMessage()));
		return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<ErrorResponse> HandleMethodArgumentNotValid(MethodArgumentNotValidException ex){
				
	List<String> lstError = new ArrayList<>();
	ex.getBindingResult().getFieldErrors().forEach(error ->
	lstError.add(error.getField()  +" : " + error.getDefaultMessage()));
	
	ErrorResponse errorResponse = new ErrorResponse("Validation failed for argument", lstError);
	return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);	
	}
	

	//gestion de l'exception global
	@ExceptionHandler(value = {Exception.class})
	public final ResponseEntity<Object> handleAllException(Exception ex , WebRequest request){
		
		ex.printStackTrace();
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse errorResponse =  new ErrorResponse(ex.toString(), details);
		return new ResponseEntity<Object>(errorResponse, HttpStatus.CONFLICT);
	}
}
