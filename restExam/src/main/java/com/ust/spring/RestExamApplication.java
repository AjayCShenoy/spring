package com.ust.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestExamApplication.class, args);
		System.out.println("hi product is working");
	}
	
}
