package com.shop.bookstore.core.utilities.exceptions.validation;

import org.springframework.beans.factory.annotation.Autowired;
import com.shop.bookstore.repository.AccountRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public boolean isValid(String gmail, ConstraintValidatorContext context) {
		if(accountRepository.existsByGmail(gmail)) {
			return false;
		}
		return true;
	}
	
	
}
