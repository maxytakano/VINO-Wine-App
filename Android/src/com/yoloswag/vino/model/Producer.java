package com.yoloswag.vino.model;

import java.io.Serializable;

public class Producer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String producer;

	public Producer(String producer)
	{
		this.producer = producer;
	}

	public String getName() {
		return "Generic Producer";
	}

}