package com.yoloswag.vino.model;

import java.io.Serializable;

public class Varietal implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String varietal_name;

	public Varietal(String varietal)
	{
		this.varietal_name = varietal;		
	}

	//returns a varietal array containing arbitrary data so we can
	//begin implementing our other methods
	public static Varietal[] getAll() 
	{
		return  new Varietal[] { new Varietal("BARBERA"), 
				new Varietal("CABERNET_FRANC"),
				new Varietal("CABERNET_SAUVIGNON"),
				new Varietal("CAYETANA"),
				new Varietal("CHARDONNAY"),
				new Varietal("CHARBONO"),
				new Varietal("CHENIN_BLANC"),
				new Varietal("CHIANTI"),
				new Varietal("CINSAULT"),
				new Varietal("GAMAY"),
				new Varietal("GEWURZTRAMINER"),
				new Varietal("GRENACHE"),
				new Varietal("MACABEO"),
				new Varietal("MALBEC"),
				new Varietal("MERLOT"),
				new Varietal("MOSCATO"),
				new Varietal("PINOT_BLANC"),
				new Varietal("PINOT_GRIGIO"),
				new Varietal("PINOT_NOIR"),
				new Varietal("RIESLING"),
				new Varietal("SANGIOVESE"),
				new Varietal("SAUVIGNON_BLANC"),
				new Varietal("SYRAH"),
				new Varietal("ZINFANDEL"),
		};
	}
}