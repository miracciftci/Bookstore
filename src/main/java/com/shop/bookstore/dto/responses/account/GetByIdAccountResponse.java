package com.shop.bookstore.dto.responses.account;

import java.util.List;

import com.shop.bookstore.dto.responses.bookComments.GetAllCommentsResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdAccountResponse {
	private Long id;
	private String userName;
	private String password;
	private String gmail;
	
	private List<GetAllCommentsResponses> comments;
	
}
