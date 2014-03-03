package com.yoloswag.vino.model;

public class Rating 
{
	protected int rating;
	protected Entry entries[] = Entry.getAll();
	
	public Rating(int rating)
	{
		this.rating = rating;		
	}
	
	/**  Returns array of ratings of wines from our fake database of Entry
	 */
	/*public static Rating[] getAll() 
	{
		return new Rating[] { Entry.a.rating,
							  Entry.b.rating,
							  Entry.c.rating,
							  Entry.d.rating,
							  Entry.e.rating };
	}*/
}
