package com.shop.bookstore.service.concretes;

import java.util.List;
import org.springframework.stereotype.Service;
import com.shop.bookstore.core.utilities.exceptions.BusinessException;
import com.shop.bookstore.core.utilities.mappers.ModelMapperService;
import com.shop.bookstore.dto.requests.account.CreateAccountRequest;
import com.shop.bookstore.dto.requests.account.UpdateAccountRequest;
import com.shop.bookstore.dto.responses.account.GetAllAccountsResponse;
import com.shop.bookstore.dto.responses.account.GetByIdAccountResponse;
import com.shop.bookstore.entities.Account;
import com.shop.bookstore.repository.AccountRepository;
import com.shop.bookstore.service.abstracts.AccountService;
import com.shop.bookstore.service.rules.AccountBusinessRules;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class AccountManager implements AccountService{
	private AccountRepository accountRepository;
	private AccountBusinessRules accountBusinessRules;
	private ModelMapperService modelMapperService;
	
	
	@Override
	public List<GetAllAccountsResponse> getAll() {
		List<Account> array = accountRepository.findAll();
		
		List<GetAllAccountsResponse> responses = array.stream().
				map(account ->modelMapperService.forResponse().
						map(account,GetAllAccountsResponse.class)).toList();
		
		return responses;
	}

	
	@Override
	public GetByIdAccountResponse getById(Long id){
		Account account = accountRepository.findById(id).orElseThrow(()-> new BusinessException("Account Id is not found"));
		GetByIdAccountResponse response = modelMapperService.forResponse().map(account, GetByIdAccountResponse.class);
		
		return response;
	}

	
	@Override
	public CreateAccountRequest add(CreateAccountRequest createAccountRequest) {
		Account account = modelMapperService.forRequest().map(createAccountRequest, Account.class);
		accountRepository.save(account);
		return createAccountRequest;
	}

	
	@Override
	public UpdateAccountRequest update(UpdateAccountRequest updateAccountRequest ,Long id){
		accountBusinessRules.accountCheckId(id);

		Account account = modelMapperService.forRequest().map(updateAccountRequest, Account.class);
		account.setId(id);
		accountRepository.save(account);
		return updateAccountRequest;
	}
	

	@Override
	public void delete(Long id){
		accountBusinessRules.accountCheckId(id);
		
		accountRepository.deleteById(id);
	}
	
	

}
