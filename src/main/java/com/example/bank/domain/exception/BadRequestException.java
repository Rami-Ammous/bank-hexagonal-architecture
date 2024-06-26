package com.example.bank.domain.exception;

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
