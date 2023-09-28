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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Table(name = "account", uniqueConstraints = @UniqueConstraint(columnNames = {"gmail"}))  // uniqueConstraints hangi kolonların uniq olmasını istiyorsak onları liste türünde bizden istiyor
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
	
}
