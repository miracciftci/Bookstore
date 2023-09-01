package com.shop.bookstore.dto.responses.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAccountsResponse {
	private Long id;
	private String userName;
	private String password;
	private String gmail;

}
