package com.yoloswag.vino.model;

import java.io.Serializable;

public class Region implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String region;
	
	public Region(String region)
	{
		this.region = region;		
	}
	
	public static Region[] getAll()
	{
		return new Region[]{new Region("NAPA VALLEY"),
							new Region("SONOMA"),
							new Region("TUSCANY"),
							new Region("AUSTRAILIA"),
							new Region("TEMECULA"),
							new Region("SAN DIEGO"),
							new Region("FRANCE"),
							};
	}
}
