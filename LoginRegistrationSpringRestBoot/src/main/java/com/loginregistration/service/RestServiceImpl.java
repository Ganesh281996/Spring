package com.loginregistration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginregistration.dao.RestDao;
import com.loginregistration.model.User;

@Service
public class RestServiceImpl implements RestService 
{
	@Autowired
	RestDao restDao;

	public User getUserByEmail(String email) 
	{
		return restDao.getUserByEmail(email);
	}

	public boolean insert(User user) 
	{
		System.out.println("Service Insert Method");
		if(!restDao.checkAddress(user.getAddress()) && getUserByEmail(user.getEmail())==null)
		{
			restDao.insert(user);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public User login(String email, String password)
	{
		System.out.println("Service Login Method");
		return restDao.login(email, password);
	}

	@Override
	public User delete(String email, String password) 
	{
		System.out.println("Service Delete Method");
		User user=restDao.login(email, password);
		System.out.println(user);
		if(user!=null)
		{
			System.out.println("User Present");
			restDao.delete(email, password);
		}
		System.out.println("Deleted");
		return user;
	}

	@Override
	public List<User> display() 
	{
		return restDao.display();
	}	
}