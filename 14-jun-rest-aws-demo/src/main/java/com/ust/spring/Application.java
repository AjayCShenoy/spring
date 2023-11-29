package com.ust.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@SpringBootApplication
public class Application {
	
	@GetMapping("hi")
	public String home()
	{
		return "Ajay: Hi! welcome home.this is your AWS server";
	}
	
	@GetMapping("hello")
	public String hello() {
		return "Hello world from ajay";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
