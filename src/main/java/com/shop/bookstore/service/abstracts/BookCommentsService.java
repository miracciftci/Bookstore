package com.shop.bookstore.service.abstracts;

import java.util.List;
import com.shop.bookstore.dto.requests.bookComments.CreateBookCommentsRequest;
import com.shop.bookstore.dto.responses.bookComments.GetAllCommentsResponses;
import com.shop.bookstore.entities.BookComments;


public interface BookCommentsService {
	List<GetAllCommentsResponses> getAllComments();
	List<GetAllCommentsResponses> getAllForBook(Long bookId);
	List<GetAllCommentsResponses> getAllForAccount(Long accountId);	
	BookComments add(CreateBookCommentsRequest createBookCommentsRequest);
	void delete(Long id);
}
