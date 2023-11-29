package com.ust.spring._05_2023;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("bean.xml");
        
       Book books= (Book) ctx.getBean("book");
       System.out.println(books);
        
    }
    
}
