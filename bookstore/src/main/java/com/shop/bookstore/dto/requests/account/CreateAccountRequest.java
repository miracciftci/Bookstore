package com.shop.bookstore.dto.requests.account;

import com.shop.bookstore.core.utilities.exceptions.validation.UniqueEmail;
import com.shop.bookstore.core.utilities.exceptions.validation.UniqueUsername;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public class CreateAccountRequest {
	
	@Size(min = 3, max = 255)
	@UniqueUsername
	private String userName;
	
	@Email
	@UniqueEmail
	@NotBlank
	private String gmail;
	
	@Size(min = 8, max = 255)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message = "{bookstore.constraint.password.pattern}")
	private String password;

	
	
	
	public CreateAccountRequest() {

	}

	
	
	public CreateAccountRequest(@Size(min = 3, max = 255) String userName, @Email @NotBlank String gmail,
			@Size(min = 8, max = 255) @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{bookstore.constraint.password.pattern}") String password) {
		super();
		this.userName = userName;
		this.gmail = gmail;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
