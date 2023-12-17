package com.shop.bookstore.dto.requests.book;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;


public class UpdateBookRequest {
	
	@Size(min = 3,max = 255)
	private String name;
	
	@Positive(message = "{bookstore.constraint.book.Positive}")
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
	
	@PositiveOrZero(message = "{bookstore.constraint.book.PositiveOrZero}")
	private double oldPrice;
	
	@PositiveOrZero(message = "{bookstore.constraint.book.PositiveOrZero}")
	private double newPrice;

	
	
	
	
	public UpdateBookRequest() {
	}

	public UpdateBookRequest(@Size(min = 3, max = 255) String name,
			@Positive(message = "{bookstore.constraint.book.Positive}") int numberOfPages, @NotBlank String writer,
			String typeOfBook, @Past Date dateOfIssue, @Min(0) @Max(10) double point, String image,
			@PositiveOrZero(message = "{bookstore.constraint.book.PositiveOrZero}") double oldPrice,
			@PositiveOrZero(message = "{bookstore.constraint.book.PositiveOrZero}") double newPrice) {
		super();
		this.name = name;
		this.numberOfPages = numberOfPages;
		this.writer = writer;
		this.typeOfBook = typeOfBook;
		this.dateOfIssue = dateOfIssue;
		this.point = point;
		this.image = image;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTypeOfBook() {
		return typeOfBook;
	}

	public void setTypeOfBook(String typeOfBook) {
		this.typeOfBook = typeOfBook;
	}

	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}	
	
	
	
	
	
	
}
