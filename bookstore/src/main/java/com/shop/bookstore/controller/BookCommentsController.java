package com.shop.bookstore.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shop.bookstore.dto.requests.bookComments.CreateBookCommentsRequest;
import com.shop.bookstore.dto.responses.bookComments.GetAllCommentsResponses;
import com.shop.bookstore.entities.BookComments;
import com.shop.bookstore.service.abstracts.BookCommentsService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/bookComment")
public class BookCommentsController {
	BookCommentsService bookCommentsService;

	private BookCommentsController(BookCommentsService bookCommentsService) {
		this.bookCommentsService = bookCommentsService;
	}
	
	@GetMapping
	public List<GetAllCommentsResponses> getAll(){
		return bookCommentsService.getAllComments();
	}
	
	@GetMapping("/forBook/{id}")
	public List<GetAllCommentsResponses> getAllForBook(@PathVariable Long id) {
		return bookCommentsService.getAllForBook(id);
	}
	
	
	@GetMapping("/forAccount/{id}")
	public List<GetAllCommentsResponses> getAllForAccount(@PathVariable Long id) {
		return bookCommentsService.getAllForAccount(id);
	}
	
	
	@PostMapping("/add")
	public BookComments add(@RequestBody @Valid CreateBookCommentsRequest createBookCommentsRequest) {
		return bookCommentsService.add(createBookCommentsRequest);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id){
		bookCommentsService.delete(id);
		
	}
	
	
	

}
