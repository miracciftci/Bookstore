package com.shop.bookstore.service.rules;

import org.springframework.stereotype.Service;
import com.shop.bookstore.core.utilities.exceptions.BusinessException;
import com.shop.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class BookBusinessRules {
	
	BookRepository bookRepository;
	
	public void checkBookId(Long id){
		if(!bookRepository.existsById(id)) 
			throw new BusinessException("Book Id is not found");		
	}
	
	
}
