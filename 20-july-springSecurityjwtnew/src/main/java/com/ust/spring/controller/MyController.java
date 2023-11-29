package com.ust.spring.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.spring.model.MyUser;
import com.ust.spring.service.MyUserDetailsService;

@RestController
public class MyController {

	private MyUserDetailsService ms;
	
	@GetMapping
	public String home() {
		return "welcome to home";
	}
	
	@GetMapping("/contact")
	public String contact(){
		return "contact us";
	}
	
	@PostMapping("/login")
	public String login(@RequestBody MyUser user) {
		UserDetails temp = ms.loadUserByUsername(user.getUsername());
		if(temp!=null)
		{
			if(temp.getPassword().equals(user.getPassword()))
				return "Success";
			else
				return "Failure";
		}
		else
			return "Failure";
	}
	
	@PostMapping("/signup")
	public MyUser signup(@RequestBody MyUser user)
	{
		return ms.create(user);
	}
	
}
