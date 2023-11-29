package com.ust.spring.configurationExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com"})
public class MyConfiguration {
	
	@Bean
	public Department dept(){
		return new Department(1,"EEE","Ernakulam");
	}
	
}
