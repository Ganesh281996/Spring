package com.human;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class Human 
{
	private int id;
	private String name;

	public Human()	{}

	public int getId() {
		return id;
	}

//	@Required
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Human [id=" + id + ", name=" + name + "]";
	}
}