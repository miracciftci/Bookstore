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
import com.shop.bookstore.dto.requests.account.CreateAccountRequest;
import com.shop.bookstore.dto.requests.account.UpdateAccountRequest;
import com.shop.bookstore.dto.responses.account.GetAllAccountsResponse;
import com.shop.bookstore.dto.responses.account.GetByIdAccountResponse;
import com.shop.bookstore.service.abstracts.AccountService;
import com.shop.bookstore.shared.GenericMessage;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/account")
public class AccountController {

	AccountService accountService;

	private AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	@GetMapping()
	public List<GetAllAccountsResponse> getAll() {
		return accountService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdAccountResponse getById(@PathVariable Long id){
		return accountService.getById(id);
	}
	
	
	@PostMapping("/add")
	public GenericMessage add(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
		accountService.add(createAccountRequest);
		return new GenericMessage("Account successfully registered");
	}
	
	@PutMapping("/update/{id}")
	public GenericMessage update(@RequestBody @Valid UpdateAccountRequest updateAccountRequest,@PathVariable Long id) {
		accountService.update(updateAccountRequest,id);
		return new GenericMessage("Account updated successfully");
	} 
	
	@DeleteMapping("/delete/{id}")
	public GenericMessage delete(@PathVariable Long id) {
		accountService.delete(id);
		return new GenericMessage("Account deleted successfully");
	}
	
	
	
	
	
}
