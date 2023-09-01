package com.shop.bookstore.dto.requests.bookComments;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookCommentsRequest {
	
	@Past
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date commentDate;
	
	@Max(value = 10, message = "0-10 değerleri arasında olmalı!")
	@Min(value = 0, message = "0-10 değerleri arasında olmalı!")
	private double point;
	
	@NotEmpty
	private String comment;
	
	private Long bookId;
	private Long accountId;
	
}
