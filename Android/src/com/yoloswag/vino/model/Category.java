package com.yoloswag.vino.model;

import java.io.Serializable;

public class Category implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String category;

	public Category(String category)
	{
		this.category = category;		
	}

	//returns a Category array containing arbitrary data
	//so we can begin implementing our other methods
	public static Category[] getAll() 
	{
		return  new Category[] { 
				new Category("BLEND"), 
				new Category("DESSERT"),
				new Category("FORTIFIED"), 
				new Category("FRUIT"),
				new Category("RED"), 
				new Category("ROSE"),
				new Category("SPARKLING"), 
				new Category("WHITE")
		};
	}
}