package com.shop.bookstore.dto.requests.bookComments;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
	
	@Min(0)
	@Max(10)
	private double point;
	
	@NotBlank
	private String comment;
	
	private Long bookId;
	private Long accountId;
	
}
