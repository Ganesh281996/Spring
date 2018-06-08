package com.human;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Lazy
@Configuration
@ComponentScan("com.human")
@Scope(scopeName="prototype")
public class ConfigHuman 
{
	@Bean(name="Human")
	Human getHuman()
	{
		Human human=new Human();
//		human.setId(14334);
//		human.setName("sdgrdfeg");
		return human;
	}
}