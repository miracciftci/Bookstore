package com.shop.bookstore.service.rules;

import com.shop.bookstore.entities.Book;
import org.springframework.stereotype.Service;
import com.shop.bookstore.core.utilities.exceptions.BusinessException;
import com.shop.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class BookBusinessRules {
	
	BookRepository bookRepository;
	
	public void checkBookId(Long id){
		Book book = bookRepository.findById(id).orElseThrow(()-> new BusinessException("Book Id is not found yyee"));
	}
	
	
}
