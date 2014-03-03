package com.yoloswag.vino.favorites;

import com.yoloswag.vino.model.Wine;

public class RowItem {

	private int imageID;
	private String name;
	
	public RowItem(int imageID, String name)
	{
		this.imageID = imageID;
		this.name = name;
	}
	
	public RowItem()
	{
		
	}
	
	public int getImageID()
	{
		return imageID;
	}
	
	public void setImageID(int imageID)
	{
		this.imageID = imageID;
	}
	
	/* public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	} */
	
}
