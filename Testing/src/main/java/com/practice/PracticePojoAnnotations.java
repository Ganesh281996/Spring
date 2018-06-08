package com.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class PracticePojoAnnotations
{
	@Autowired
	int id;
	
	String name;
	
	AnotherPojo address;
	
	@Autowired(required=false)
	public PracticePojoAnnotations() 
	{
		
	}
	
	@Bean(name="beanName", initMethod="", destroyMethod="")
	void method()
	{
		System.out.println("");
	}
}
class AnotherPojo
{
	
}