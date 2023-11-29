package com.ust.aop.aspect;

public class RBIAspect {
	public void validatePin()
	{
		System.out.println("pin number is validated");
	}
	public void checkBalance() {
		System.out.println("balance is checked");
	}
	public void printReceipt() {
		System.out.println("receipt is printed..");
	}
}
