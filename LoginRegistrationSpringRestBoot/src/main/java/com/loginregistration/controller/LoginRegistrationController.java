package com.loginregistration.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loginregistration.model.User;
import com.loginregistration.service.RestService;

@RestController
@RequestMapping("/ctrl")
public class LoginRegistrationController 
{
	@Autowired
	RestService restService;
	
	@RequestMapping(value="/register/",method=RequestMethod.POST)
	public ResponseEntity<User> register(@RequestBody User user)
	{
		System.out.println("Controller Register Method");
		System.out.println("Data in request = "+user);
		boolean flag=restService.insert(user);
		if(flag)
		{
			System.out.println("Insert Success");
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		}
		else
		{
			System.out.println("Insert Failed");
			return new ResponseEntity<>(null,HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value="/login/",method=RequestMethod.POST)
	public ResponseEntity<User> login(String email,String password, HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session=null;
		System.out.println("Controller Login Method");
		System.out.println("Data in request = "+email+"   "+password);
		User user=restService.login(email, password);
		if(user!=null)
		{
			session=request.getSession();
			session.setAttribute("user", user);
			return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="welcome",method=RequestMethod.GET)
	public ResponseEntity<String> welcome(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			return new ResponseEntity<>("Login First", HttpStatus.NOT_FOUND);
		}
		else
		{
			return new ResponseEntity<>(session.getAttribute("user").toString(), HttpStatus.OK); 
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.DELETE)
	public ResponseEntity<String> logout(HttpServletRequest request,HttpServletResponse response)
	{
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			return new ResponseEntity<>("Login First", HttpStatus.NOT_FOUND);
		}
		else
		{
			session.removeAttribute("user");
			session.invalidate();
			return new ResponseEntity<>("Successfully Logged Out", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/delete/",method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@RequestParam String email,@RequestParam String password)
	{
		System.out.println("Delete Controller Method");
		System.out.println("Data in request = "+email+"   "+password);
		User user=restService.login(email, password);
		if(user!=null)
		{
			restService.delete(email, password);
			System.out.println(user);
			return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<User> display()
	{
		return restService.display();
	}
	
	@RequestMapping(value="/test{id}",method=RequestMethod.GET)
	public void test(@PathVariable("id") String id)
	{
		System.out.println(id);
	}
}