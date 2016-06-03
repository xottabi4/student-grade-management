package com.sgm.spring.exceptions;

public class UserIsNotStudentException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5113921252235555733L;
	private String message = null;

	public UserIsNotStudentException(String message) {
		super(message);
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
