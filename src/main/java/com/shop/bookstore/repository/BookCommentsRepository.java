package com.shop.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.bookstore.entities.BookComments;

public interface BookCommentsRepository extends JpaRepository<BookComments, Long>{

}
