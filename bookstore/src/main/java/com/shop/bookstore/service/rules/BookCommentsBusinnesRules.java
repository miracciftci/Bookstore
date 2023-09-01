package com.shop.bookstore.service.rules;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shop.bookstore.core.utilities.exceptions.BusinessException;
import com.shop.bookstore.entities.BookComments;
import com.shop.bookstore.repository.BookCommentsRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class BookCommentsBusinnesRules {
	BookCommentsRepository bookCommentsRepository;
	
	
	public void checkCommentId(Long id) {
		if(!bookCommentsRepository.existsById(id)) {
			throw new BusinessException("Comment id is not found");
		}
	}
	
	public void checkCommentAgain(Long accountId, Long bookId) {
		List<BookComments> gets = bookCommentsRepository.findAll();
		
	
		for(BookComments bookComments : gets) {
			if(accountId == bookComments.getAccount().getId() && bookId == bookComments.getBook().getId()) {
				throw new BusinessException("2 comments cannot be shared from 1 account");
			}
		}
		
	}
	
	
	
}
