package com.shop.bookstore.dto.responses.bookComments;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCommentsResponses {
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date commentDate;
	
	private double point;
	private String comment;
	
	private Long bookId;
	private Long accountId;
	
}
