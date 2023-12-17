package com.shop.bookstore.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Table(name = "account", uniqueConstraints = @UniqueConstraint(columnNames = {"gmail"}))  // uniqueConstraints hangi kolonların uniq olmasını istiyorsak onları liste türünde bizden istiyor
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	private String userName;
	private String password;
	private String gmail;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	private List<BookComments> comments;


	
	public Account() {
	}



	public Account(long id, String userName, String password, String gmail, List<BookComments> comments) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gmail = gmail;
		this.comments = comments;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getGmail() {
		return gmail;
	}



	public void setGmail(String gmail) {
		this.gmail = gmail;
	}



	public List<BookComments> getComments() {
		return comments;
	}



	public void setComments(List<BookComments> comments) {
		this.comments = comments;
	}
	
	
	
	
	
	
}
