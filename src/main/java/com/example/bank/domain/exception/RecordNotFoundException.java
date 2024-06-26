package com.example.bank.domain.exception;

/**
 * @author Rami Ammous
 */
public class RecordNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	public RecordNotFoundException() {
		super();

	}

	/**
	 * @param message
	 */
	public RecordNotFoundException(String message) {
		super(message);
	}

	
}
