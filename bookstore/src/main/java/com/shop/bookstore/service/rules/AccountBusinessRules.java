package com.shop.bookstore.service.rules;

import com.shop.bookstore.entities.Account;
import org.springframework.stereotype.Service;
import com.shop.bookstore.core.utilities.exceptions.BusinessException;
import com.shop.bookstore.repository.AccountRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class AccountBusinessRules {
	// Business rules exapmle
	
	AccountRepository accountRepository;
	
	public void accountCheckId(Long id){
		Account account = accountRepository.findById(id).orElseThrow(()-> new BusinessException("Account Id is not found"));
	}
	
	public void accountCheckUserName(String userName) {
		if(accountRepository.existsByUserName(userName))
			throw new BusinessException("The entered Username exists");
	}
	
	public void accountCheckGmail(String gmail) {
		if(accountRepository.existsByGmail(gmail))
			throw new BusinessException("The entered gmail exists");
	}
	
	
	
}
