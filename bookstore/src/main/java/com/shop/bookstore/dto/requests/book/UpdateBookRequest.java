package com.shop.bookstore.dto.requests.book;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateBookRequest {
	
	@Size(min = 3,max = 255)
	private String name;
	
	@Positive
	private int numberOfPages;
	
	@NotBlank
	private String writer;
	
	private String typeOfBook;
	
	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfIssue;
	
	@Min(0)
	@Max(10)
	private double point;
	
	private String image;
	
	@PositiveOrZero
	private double oldPrice;
	
	@PositiveOrZero
	private double newPrice;	
	
}
