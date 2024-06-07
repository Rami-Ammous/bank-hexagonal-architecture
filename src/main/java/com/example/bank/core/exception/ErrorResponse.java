
package com.example.bank.core.exception;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Rami Ammous
 */
public class ErrorResponse {

	private Boolean succes;
	private String message;
	private LocalDateTime dateTime;
	private List<String> details;
	
	

	public ErrorResponse( String message, List<String> details) {
		this.succes = Boolean.FALSE;
		this.message = message;
		this.dateTime = LocalDateTime.now();
		this.details = details;
	}
	/**
	 * 
	 */
	public ErrorResponse() {
	
	}
	/**
	 * @return the succes
	 */
	public Boolean getSucces() {
		return succes;
	}
	/**
	 * @param succes the succes to set
	 */
	public void setSucces(Boolean succes) {
		this.succes = succes;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the dateTime
	 */
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	/**
	 * @return the details
	 */
	public List<String> getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(List<String> details) {
		this.details = details;
	}



	
}
