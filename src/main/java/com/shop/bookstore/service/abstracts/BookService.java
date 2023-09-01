package com.shop.bookstore.service.abstracts;

import java.util.List;
import com.shop.bookstore.dto.requests.book.CreateBookRequest;
import com.shop.bookstore.dto.requests.book.UpdateBookRequest;
import com.shop.bookstore.dto.responses.book.GetAllBooksResponse;
import com.shop.bookstore.dto.responses.book.GetByIdBookResponse;
import com.shop.bookstore.entities.Book;


public interface BookService {
	List<GetAllBooksResponse> getAll();
	GetByIdBookResponse getById(Long id);
	Book add(CreateBookRequest createBookRequest);
	Book update(UpdateBookRequest updateBookRequest, Long id);
	void delete(Long id);
	void updatePoint(Long id);
}
