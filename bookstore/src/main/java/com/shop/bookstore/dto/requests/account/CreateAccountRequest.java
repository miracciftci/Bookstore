package com.shop.bookstore.dto.requests.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateAccountRequest {
	
	@NotEmpty
	private String userName;
	
	@Email(message = "Geçerli bir Email adresi giriniz!")
	private String gmail;
	
	private String password;
}
