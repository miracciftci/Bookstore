package com.shop.bookstore.dto.responses.bookComments;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class GetAllCommentsResponses {
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date commentDate;
	
	private double point;
	private String comment;
	
	private Long bookId;
	private Long accountId;
	
	
	public GetAllCommentsResponses() {
	}


	public GetAllCommentsResponses(Long id, Date commentDate, double point, String comment, Long bookId,
			Long accountId) {
		super();
		this.id = id;
		this.commentDate = commentDate;
		this.point = point;
		this.comment = comment;
		this.bookId = bookId;
		this.accountId = accountId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getCommentDate() {
		return commentDate;
	}


	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}


	public double getPoint() {
		return point;
	}


	public void setPoint(double point) {
		this.point = point;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public Long getBookId() {
		return bookId;
	}


	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}


	public Long getAccountId() {
		return accountId;
	}


	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	
	
	
	
	
}
