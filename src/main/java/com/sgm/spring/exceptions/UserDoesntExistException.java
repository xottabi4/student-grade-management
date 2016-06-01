package com.sgm.spring.exceptions;

public class UserDoesntExistException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6428849063802622879L;
	private String message = null;

	public UserDoesntExistException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
