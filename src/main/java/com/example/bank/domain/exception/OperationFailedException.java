package com.example.bank.domain.exception;

/**
 * @author Rami Ammous
 */
public class OperationFailedException extends RuntimeException{

	/**
	 *
	 */
	public OperationFailedException() {
		super();

	}

	/**
	 * @param message
	 */
	public OperationFailedException(String message) {
		super(message);
	}

	
}
