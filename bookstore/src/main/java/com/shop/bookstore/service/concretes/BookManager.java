package com.shop.bookstore.service.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import com.shop.bookstore.core.utilities.mappers.ModelMapperService;
import com.shop.bookstore.dto.requests.book.CreateBookRequest;
import com.shop.bookstore.dto.requests.book.UpdateBookRequest;
import com.shop.bookstore.dto.responses.book.GetAllBooksResponse;
import com.shop.bookstore.dto.responses.book.GetByIdBookResponse;
import com.shop.bookstore.dto.responses.bookComments.GetAllCommentsResponses;
import com.shop.bookstore.entities.Book;
import com.shop.bookstore.repository.BookRepository;
import com.shop.bookstore.service.abstracts.BookService;
import com.shop.bookstore.service.rules.BookBusinessRules;
import lombok.AllArgsConstructor;



@AllArgsConstructor
@Service
public class BookManager implements BookService{
	private BookRepository bookRepository;
	private ModelMapperService modelMapperService;
	private BookBusinessRules bookBusinessRules;

	
	@Override
	public List<GetAllBooksResponse> getAll() {
		List<Book> books = bookRepository.findAll();
		
		List<GetAllBooksResponse> responses = books.stream().
				map(book ->modelMapperService.forResponse().
						map(book,GetAllBooksResponse.class)).toList();
		
		return responses;
	}

	@Override
	public GetByIdBookResponse getById(Long id){
		bookBusinessRules.checkBookId(id);
		Optional<Book> book = bookRepository.findById(id);
		GetByIdBookResponse response = modelMapperService.forResponse().map(book, GetByIdBookResponse.class);
		
		return response;
		
	}

	@Override
	public Book add(CreateBookRequest createBookRequest) {		
		Book book = modelMapperService.forRequest().map(createBookRequest, Book.class);
		book.setPoint(0);
		return bookRepository.save(book);
	}

	@Override
	public Book update(UpdateBookRequest updateBookRequest, Long id) {
		bookBusinessRules.checkBookId(id);
		
		double point = getById(id).getPoint();
		Book book = modelMapperService.forRequest().map(updateBookRequest, Book.class);
		book.setId(id);
		book.setPoint(point);
		return bookRepository.save(book);
	}

	@Override
	public void delete(Long id){
		bookBusinessRules.checkBookId(id);
		bookRepository.deleteById(id);	
	}
	
	
	public void updatePoint(Long id) {
		GetByIdBookResponse getByIdBookResponse = getById(id);
		
		double total = 0;
		int size = getByIdBookResponse.getComments().size();
		
		// stream kütüphanesi kullanılacak 
		for(GetAllCommentsResponses comments : getByIdBookResponse.getComments()) {
			total += comments.getPoint();
		}
		
		UpdateBookRequest updateBookRequest = modelMapperService.forRequest().map(getByIdBookResponse, UpdateBookRequest.class) ;
		
		if(size == 0) {   // no comment
			updateBookRequest.setPoint(0.0);
			update(updateBookRequest, id);
		}else {
			double result = total/size; 
			updateBookRequest.setPoint(result);
			update(updateBookRequest, id);
		}
		
	}
	
	

	
	
	
	
	
}
