package com.shop.bookstore.service.concretes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.shop.bookstore.core.utilities.mappers.ModelMapperService;
import com.shop.bookstore.dto.requests.bookComments.CreateBookCommentsRequest;
import com.shop.bookstore.dto.responses.bookComments.GetAllCommentsResponses;
import com.shop.bookstore.entities.BookComments;
import com.shop.bookstore.repository.BookCommentsRepository;
import com.shop.bookstore.service.abstracts.AccountService;
import com.shop.bookstore.service.abstracts.BookCommentsService;
import com.shop.bookstore.service.abstracts.BookService;
import com.shop.bookstore.service.rules.AccountBusinessRules;
import com.shop.bookstore.service.rules.BookBusinessRules;
import com.shop.bookstore.service.rules.BookCommentsBusinnesRules;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class BookCommentsManager implements BookCommentsService{
	BookCommentsRepository bookCommentsRepository;
	ModelMapperService modelMapperService;
	BookCommentsBusinnesRules bookCommentsBusinnesRules;
	AccountBusinessRules accountBusinessRules;
	BookBusinessRules bookBusinessRules;
	AccountService accountService;
	BookService bookService;
	
	
	@Override
	public List<GetAllCommentsResponses> getAllComments() {
		List<BookComments> bookComments = bookCommentsRepository.findAll();
		List<GetAllCommentsResponses> response = new ArrayList<>();
		
		for(BookComments comment : bookComments) {
			GetAllCommentsResponses get = modelMapperService.forResponse().map(comment, GetAllCommentsResponses.class);
			response.add(get);
		}
			
		return response;
	}
	
	
	@Override
	public List<GetAllCommentsResponses> getAllForBook(Long bookId){
		bookBusinessRules.checkBookId(bookId);
		List<GetAllCommentsResponses> response = bookService.getById(bookId).getComments();
		
		return response;
	}

	
	@Override
	public List<GetAllCommentsResponses> getAllForAccount(Long accountId){
		accountBusinessRules.accountCheckId(accountId);
		List<GetAllCommentsResponses> response = accountService.getById(accountId).getComments();
		
		return response;
	}

	@Override
	public BookComments add(CreateBookCommentsRequest createBookCommentsRequest) {
		accountBusinessRules.accountCheckId(createBookCommentsRequest.getAccountId());
		bookBusinessRules.checkBookId(createBookCommentsRequest.getBookId());
		bookCommentsBusinnesRules.checkCommentAgain(createBookCommentsRequest.getAccountId(), createBookCommentsRequest.getBookId());
		
		BookComments bookComments = modelMapperService.forRequest().map(createBookCommentsRequest, BookComments.class);
		bookCommentsRepository.save(bookComments);
		bookService.updatePoint(createBookCommentsRequest.getBookId());
		
		return bookComments;
	}
	

	@Override
	public void delete(Long id) {
		bookCommentsBusinnesRules.checkCommentId(id);
		
		long bookId = bookCommentsRepository.findById(id).get().getBook().getId();
		
		bookCommentsRepository.deleteById(id);
		
		bookService.updatePoint(bookId);
	}

	
}
