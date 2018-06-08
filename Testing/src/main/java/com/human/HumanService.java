package com.human;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HumanService 
{
	@Autowired
	@Qualifier("Human")
	Human human;
	
	void serviceMethod()
	{
		System.out.println(human);
	}
}