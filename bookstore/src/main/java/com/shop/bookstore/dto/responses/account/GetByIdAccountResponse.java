package com.shop.bookstore.dto.responses.account;

import java.util.List;

import com.shop.bookstore.dto.responses.bookComments.GetAllCommentsResponses;


public class GetByIdAccountResponse {
	private Long id;
	private String userName;
	private String password;
	private String gmail;
	
	private List<GetAllCommentsResponses> comments;
	
	
	
	
	public GetByIdAccountResponse() {
	}

	public GetByIdAccountResponse(Long id, String userName, String password, String gmail,
			List<GetAllCommentsResponses> comments) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gmail = gmail;
		this.comments = comments;
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

	public List<GetAllCommentsResponses> getComments() {
		return comments;
	}

	public void setComments(List<GetAllCommentsResponses> comments) {
		this.comments = comments;
	}
	
	
	
	
	
	
}
