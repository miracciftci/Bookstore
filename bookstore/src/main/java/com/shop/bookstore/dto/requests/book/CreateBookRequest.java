package com.shop.bookstore.dto.requests.book;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
	
	@NotEmpty
	@Size(min = 3,max = 100)
	private String name;
	
	@Positive
	private int numberOfPages;
	
	@NotEmpty
	private String writer;
	
	private String typeOfBook;
	
	@Past   // tarih geçmişteki bir tarih olmak zorunda
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfIssue;
	
	private String image;
	
	@Min(value = 0)
	private double oldPrice;
	
	@Min(value = 0)
	private double newPrice;	
	
	
}
