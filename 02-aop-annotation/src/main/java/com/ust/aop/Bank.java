package com.ust.aop;

import org.springframework.stereotype.Component;

@Component
public class Bank {
	public void withdraw()
	{
		System.out.println("withraw is completed..");
	}
	public void deposit()
	{
		System.out.println("deposit is completed..");
	}
}
