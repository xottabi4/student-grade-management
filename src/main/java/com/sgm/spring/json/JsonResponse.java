package com.sgm.spring.json;

import java.io.Serializable;

public class JsonResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4971074534755464332L;
	
	private String message = null;
	private Boolean status = false;

	public JsonResponse(String message, Boolean status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}