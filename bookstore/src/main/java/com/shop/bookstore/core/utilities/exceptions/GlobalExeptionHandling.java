package com.shop.bookstore.core.utilities.exceptions;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExeptionHandling {	
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinnessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}
	
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST) // @ResponseStatus ile geriye dönülen response kodunun statüsünü beliriyoruz
    public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
        validationProblemDetails.setMessage("VALIDATION.EXCEPTION");
        validationProblemDetails.setStatus(400);
        validationProblemDetails.setPath(methodArgumentNotValidException.getNestedPath());
        
        validationProblemDetails.setValidationErrors(new HashMap<String,String>());
        // MethodArgumentNotValidException gelen validation hatalarının bulunduğu bir yapı ve içinden tek tek o hataları çekip map yapımıza atıyruz
        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {   
            validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return validationProblemDetails;
    }
    
    

    @ExceptionHandler(Exception.class)  // Herhangi bir runtime exeption'da çalışır
    public String otherAllException(Exception exception) {
    	String message = "Exception Message: " + exception.getMessage();
        return message;
    }

	
	
	
}
