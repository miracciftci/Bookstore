package com.shop.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.bookstore.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
