package com.shop.bookstore.dto.responses.book;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBooksResponse {
	private Long id;
	private String name;
	private int numberOfPages;
	private String writer;
	private double point;
	private String typeOfBook;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfIssue;
	
	private String image;
	private double oldPrice;
	private double newPrice;
}


