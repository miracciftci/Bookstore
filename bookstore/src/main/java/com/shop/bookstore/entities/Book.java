package com.shop.bookstore.entities;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Table(name = "book")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	private String name;
	private int numberOfPages;
	private String writer;
	private double point;
	private String typeOfBook;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfIssue;
	
	private String image;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "book")
	private List<BookComments> comments;
	
	private double oldPrice;
	private double newPrice;	
	
	
	
	
	
	
	
}








