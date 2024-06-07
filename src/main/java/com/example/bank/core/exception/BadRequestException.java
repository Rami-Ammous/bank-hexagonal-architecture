package com.example.bank.core.exception;

/**
 * @author Rami Ammous
 */
public class BadRequestException extends RuntimeException{

	/**
	 *
	 */
	public BadRequestException() {
		super();

	}

	/**
	 * @param message
	 */
	public BadRequestException(String message) {
		super(message);
	}

	
}
