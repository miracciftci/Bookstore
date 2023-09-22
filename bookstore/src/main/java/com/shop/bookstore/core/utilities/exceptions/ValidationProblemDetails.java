package com.shop.bookstore.core.utilities.exceptions;

import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationProblemDetails extends ProblemDetails{
	
	
	private int status;
	private String message;
	private String path;
	private long timestamp = new Date().getTime();
	private Map<String, String> validationErrors;
}
