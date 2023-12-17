package com.shop.bookstore.dto.responses.book;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


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
	
	
	public GetAllBooksResponse() {
	}


	public GetAllBooksResponse(Long id, String name, int numberOfPages, String writer, double point, String typeOfBook,
			Date dateOfIssue, String image, double oldPrice, double newPrice) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfPages = numberOfPages;
		this.writer = writer;
		this.point = point;
		this.typeOfBook = typeOfBook;
		this.dateOfIssue = dateOfIssue;
		this.image = image;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public double getPoint() {
		return point;
	}


	public void setPoint(double point) {
		this.point = point;
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


