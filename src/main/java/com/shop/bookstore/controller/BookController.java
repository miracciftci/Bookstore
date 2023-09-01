package com.shop.bookstore.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shop.bookstore.dto.requests.book.CreateBookRequest;
import com.shop.bookstore.dto.requests.book.UpdateBookRequest;
import com.shop.bookstore.dto.responses.book.GetAllBooksResponse;
import com.shop.bookstore.dto.responses.book.GetByIdBookResponse;
import com.shop.bookstore.entities.Book;
import com.shop.bookstore.service.abstracts.BookService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/book")
public class BookController {
	
	BookService bookService;

	private BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping
	public List<GetAllBooksResponse> getAll() {
		return bookService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBookResponse getById(@PathVariable Long id) {
		return bookService.getById(id);
	}
	
	@PostMapping("/add")
	public Book add(@RequestBody @Valid CreateBookRequest createBookRequest) {
		return bookService.add(createBookRequest);
	}
	
	@PutMapping("/update/{id}")
	public Book update(@RequestBody @Valid UpdateBookRequest updateBookRequest, @PathVariable Long id) {
		return bookService.update(updateBookRequest, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		bookService.delete(id);
	}
	

	
	
	
	
	
	
}
