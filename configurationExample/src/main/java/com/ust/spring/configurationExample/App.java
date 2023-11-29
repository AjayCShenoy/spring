package com.ust.spring.configurationExample;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext(MyConfiguration.class);
        Department dept= (Department) ctx.getBean("dept");
        System.out.println(dept);
    }
}
