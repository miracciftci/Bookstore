package com.shop.bookstore.dto.requests.bookComments;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;


public class CreateBookCommentsRequest {
	
	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date commentDate;
	
	@Min(0)
	@Max(10)
	private double point;
	
	@NotBlank
	private String comment;
	
	private Long bookId;
	private Long accountId;
	
	
	
	public CreateBookCommentsRequest() {
	}



	public CreateBookCommentsRequest(@Past Date commentDate, @Min(0) @Max(10) double point, @NotBlank String comment,
			Long bookId, Long accountId) {
		super();
		this.commentDate = commentDate;
		this.point = point;
		this.comment = comment;
		this.bookId = bookId;
		this.accountId = accountId;
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
