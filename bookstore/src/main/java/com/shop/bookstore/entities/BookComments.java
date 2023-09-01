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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Table(name = "bookComments")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
	

}
