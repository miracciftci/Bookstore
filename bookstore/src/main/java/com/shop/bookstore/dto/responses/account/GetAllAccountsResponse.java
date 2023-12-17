package com.shop.bookstore.dto.responses.account;

public class GetAllAccountsResponse {
	private Long id;
	private String userName;
	private String password;
	private String gmail;
	
	

	
	public GetAllAccountsResponse() {
	}


	public GetAllAccountsResponse(Long id, String userName, String password, String gmail) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gmail = gmail;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	
	
	

}
