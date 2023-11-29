package com.spring.julemployeeh2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Julemployeeh2Application {

	public static void main(String[] args) {
		SpringApplication.run(Julemployeeh2Application.class, args);
		System.out.println("Hai....");
	}

}
