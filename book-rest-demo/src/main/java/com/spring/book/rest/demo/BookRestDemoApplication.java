package com.spring.book.rest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookRestDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookRestDemoApplication.class, args);
		System.out.println("HELLO BOOK IS WORKING");
	}

}
