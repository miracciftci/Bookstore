package com.shop.bookstore.core.utilities.exceptions;

public class ProblemDetails {
	String message;
	
	
	
	public ProblemDetails() {
	}
	
	public ProblemDetails(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
