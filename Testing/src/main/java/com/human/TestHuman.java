package com.human;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class TestHuman 
{
	public static void main(String[] args) 
	{
		ApplicationContext context=new AnnotationConfigApplicationContext(ConfigHuman.class);
//		AbstractApplicationContext context=new AnnotationConfigApplicationContext(ConfigHuman.class);
		Human human1=context.getBean("Human", Human.class);
		human1.setId(423534534);
//		human1.setName("JasVim");
		System.out.println(human1);
		Human human2=context.getBean("Human",Human.class);
		System.out.println(human2);
		HumanService humanService=context.getBean(HumanService.class);
		humanService.serviceMethod();
		
		((AbstractApplicationContext)context).close();
	}
}