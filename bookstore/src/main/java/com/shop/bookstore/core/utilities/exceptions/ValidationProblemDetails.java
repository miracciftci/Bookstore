package com.shop.bookstore.core.utilities.exceptions;

import java.util.Date;
import java.util.Map;

public class ValidationProblemDetails extends ProblemDetails{

	private int status;
	private String message;
	private String path;
	private long timestamp = new Date().getTime();
	private Map<String, String> validationErrors;
	
	
	public ValidationProblemDetails() {
	}
	
	public ValidationProblemDetails(int status, String message, String path, long timestamp,
			Map<String, String> validationErrors) {
		super();
		this.status = status;
		this.message = message;
		this.path = path;
		this.timestamp = timestamp;
		this.validationErrors = validationErrors;
	}
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}
	public void setValidationErrors(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}
	
	
}
