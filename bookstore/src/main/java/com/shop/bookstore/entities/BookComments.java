package com.shop.bookstore.entities;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Table(name = "bookComments")
@Entity
public class BookComments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="account_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)  
	@JsonIgnore
	private Account account;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="book_id",nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)  // bir kitap silinirse onun tüm yorumlarıda silinir
	@JsonIgnore
	private Book book;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date commentDate;
	private double point;
	private String comment;
	
	
	
	public BookComments() {
	}



	public BookComments(long id, Account account, Book book, Date commentDate, double point, String comment) {
		super();
		this.id = id;
		this.account = account;
		this.book = book;
		this.commentDate = commentDate;
		this.point = point;
		this.comment = comment;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Account getAccount() {
		return account;
	}



	public void setAccount(Account account) {
		this.account = account;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	public Date getCommentDate() {
		return commentDate;
	}



	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}



	public double getPoint() {
		return point;
	}



	public void setPoint(double point) {
		this.point = point;
	}



	public String getComment() {
		return comment;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
	
	
	

}
