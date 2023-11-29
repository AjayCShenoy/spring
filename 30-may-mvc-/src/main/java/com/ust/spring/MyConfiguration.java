package com.ust.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyConfiguration {
	@GetMapping
	public String home()
	{
		return "index";
	}
	
}
