package com.shop.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.shop.bookstore.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	boolean existsByUserName(String name);
	boolean existsByGmail(String gmail);
}
