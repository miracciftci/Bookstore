package com.shop.bookstore;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@RestControllerAdvice
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	
	@Bean  // bir tane ModelMapper nesnesi uretir ve ioc containera atar
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
	
	
	// spring security'inin tüm özelliklerini kullanmak istemediğimiz için exclude tanımladık ve encoderı bean olarak tanımladık servis katmanında da
	// dependicy injection yaptık
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
