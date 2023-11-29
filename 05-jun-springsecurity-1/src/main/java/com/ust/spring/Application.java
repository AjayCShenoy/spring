package com.ust.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication //(exclude = SecurityAutoConfiguration.class)
@RestController
public class Application {
	@GetMapping
	public String home()
	{
		return "Hello World........!!!";
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Its working ..!!");
	}

}
