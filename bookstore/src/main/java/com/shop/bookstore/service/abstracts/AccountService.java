package com.shop.bookstore.service.abstracts;

import java.util.List;
import com.shop.bookstore.dto.requests.account.CreateAccountRequest;
import com.shop.bookstore.dto.requests.account.UpdateAccountRequest;
import com.shop.bookstore.dto.responses.account.GetAllAccountsResponse;
import com.shop.bookstore.dto.responses.account.GetByIdAccountResponse;


public interface AccountService {
	List<GetAllAccountsResponse> getAll();
	GetByIdAccountResponse getById(Long id);
	void add(CreateAccountRequest createAccountRequest);
    void update(UpdateAccountRequest updateAccountRequest, Long id);
	void delete(Long id);
	
}
