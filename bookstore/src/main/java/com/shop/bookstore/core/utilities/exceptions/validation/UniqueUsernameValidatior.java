package com.shop.bookstore.core.utilities.exceptions.validation;

import org.springframework.beans.factory.annotation.Autowired;
import com.shop.bookstore.repository.AccountRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidatior implements ConstraintValidator<UniqueUsername, String>{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(accountRepository.existsByUserName(value)) {
			return false;
		}
		return true;
	}

}
