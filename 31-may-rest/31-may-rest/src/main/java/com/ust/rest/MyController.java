package com.ust.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyController {
	
	@GetMapping
	public String home() {
		System.out.println("My first rest Api ");
		return "hello world";
	}
}

