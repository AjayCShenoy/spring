package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/main")
@SpringBootApplication
public class Application {

	@Autowired
	private RestTemplate rt;

	@GetMapping
	public String home()
	{
	
	
		// RestTemplate rt=new RestTemplate();
		ResponseEntity <Employee> result= rt.getForEntity("http://localhost:8383/employee/1", Employee.class);
		return "Hello World: "+result.getBody();
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("helloo....!!");
	}

}
