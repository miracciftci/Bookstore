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
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/account")
public class AccountController {

	//new commit
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
	public CreateAccountRequest add(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
		return accountService.add(createAccountRequest);
	}
	
	@PutMapping("/update/{id}")
	public UpdateAccountRequest update(@RequestBody @Valid UpdateAccountRequest updateAccountRequest,@PathVariable Long id) {
		return accountService.update(updateAccountRequest,id);
	} 
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable Long id) {
		accountService.delete(id);
	}
	
	
	
	
	
}
