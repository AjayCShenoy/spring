package com.ust.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
@Aspect
@EnableAspectJAutoProxy
@Component

public class  MyAspect {
	
	@Pointcut("execution(* com.ust.aop.*.w*(..))")
	public void pce1()
	{
		
	}
	
	@Before("pce1()")
	public void validatePin()
	{
		System.out.println("validating pin..");
	}
	
	@Before("pce1()")
	public void checkBalance()
	{
		System.out.println("checking account balance");
	}
	
	@After("pce1()")
	public void printReceipt()
	{
		System.out.println("printing receipt..");
	}
	
}
