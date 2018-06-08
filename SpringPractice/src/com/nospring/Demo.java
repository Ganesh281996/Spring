package com.nospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo 
{
	public static void main(String[] args) 
	{
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Test.xml");
		NoSpring noSpring=(NoSpring)applicationContext.getBean("testing");
		System.out.println(noSpring);
	}
}
class NoSpring
{
	
}