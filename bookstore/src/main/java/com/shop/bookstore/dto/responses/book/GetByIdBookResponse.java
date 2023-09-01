package com.shop.bookstore.dto.responses.book;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.bookstore.dto.responses.bookComments.GetAllCommentsResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdBookResponse {
	private Long id;
	private String name;
	private int numberOfPages;
	private String writer;
	private double point;
	private String typeOfBook;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfIssue;
	private String image;
	
	
	private List<GetAllCommentsResponses> comments;
	private double oldPrice;
	private double newPrice;
}
