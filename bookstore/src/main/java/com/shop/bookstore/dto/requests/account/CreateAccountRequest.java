package com.shop.bookstore.dto.requests.account;

import com.shop.bookstore.core.utilities.exceptions.validation.UniqueEmail;
import com.shop.bookstore.core.utilities.exceptions.validation.UniqueUsername;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateAccountRequest {
	
	@Size(min = 3, max = 255)
	@UniqueUsername
	private String userName;
	
	@Email
	@UniqueEmail
	@NotBlank
	private String gmail;
	
	@Size(min = 8, max = 255)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message = "The password must contain at least 1 uppercase letter, 1 lowercase letter and 1 number.")
	private String password;
}
