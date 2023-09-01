package com.shop.bookstore.service.rules;

import org.springframework.stereotype.Service;
import com.shop.bookstore.core.utilities.exceptions.BusinessException;
import com.shop.bookstore.repository.AccountRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class AccountBusinessRules {
	//is kurallari
	
	AccountRepository accountRepository;
	
	public void accountCheckId(Long id){
		if(!accountRepository.existsById(id)) 
			throw new BusinessException("Account Id is not found!");	
	}
	
	public void accountCheckUserName(String userName) {
		if(accountRepository.existsByUserName(userName))
			throw new BusinessException("The entered Username exists!");	
	}
	
	public void accountCheckGmail(String gmail) {
		if(accountRepository.existsByGmail(gmail))
			throw new BusinessException("The entered gmail exists!");
	}
	
	
	
}
