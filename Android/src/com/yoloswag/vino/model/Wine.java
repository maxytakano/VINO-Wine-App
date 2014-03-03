package com.yoloswag.vino.model;

import java.util.List;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.yoloswag.vino.db.DatabaseManager;

public class Wine 
{
	@DatabaseField(generatedId=true)
	public int id;
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public Vintage vintage;
//	@DatabaseField
//	public double alcoholContent;
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public Name name;
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public Region region;
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public Category category;
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public Varietal varietal;
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public SweetOrDry sweetOrDry;
	@DatabaseField(dataType=DataType.SERIALIZABLE)
	public Producer producer;
//	@DatabaseField(dataType=DataType.SERIALIZABLE)
//	public ServingTemp servingTemp;
	@DatabaseField
	public double rating;
	@DatabaseField
	public double ratings;
	
	
	/**  Fake database of Wine (to be deleted later)
	 */
	// these are wrong. refer to databasehelper.java for a correct example
	public static Wine a = new Wine("Castello Banfi", "Chianti", "Red", "Italy", "dry", "2008");
	public static Wine b = new Wine("Yellow Tail", "Moscato", "White", "California", "sweet", "2009");
	public static Wine c = new Wine("Montana", "Sauvignon Blanc", "White", "New Zealand", "dry", "2011");
	public static Wine d = new Wine("Yellow Tail", "Cabernet Sauvignon", "Red", "Australia", "dry", "2011");
	public static Wine e = new Wine("Chateau Ste. Michelle", "Riesling", "White", "Florida", "sweet", "2012");
	
	/**  Default constructor
	 */
	public Wine() 
	{
	}
	
	/**  All-member constructor for fake database
	 */
	public Wine(String name, String varietal, String category, String region,
	            String sweetOrDry, String vintage)
	{
		this.name           = new Name(name);
		this.varietal       = new Varietal(varietal); 
		this.category       = new Category(category);
		this.region         = new Region(region);
		this.sweetOrDry     = new SweetOrDry(sweetOrDry);
		this.vintage        = new Vintage(vintage);
		this.rating = 0;
		this.ratings = 0;
	}
	
	public void addRating(double newRating) {
		rating = (rating * ratings + newRating) / ++ratings;
	}
	
	/**  Getter for Entry
	 */
	public static Wine get(Wine wine) 
	{
		return wine;
	}
	
	/**  Returns all wines with their corresponding data
	 */
	public static Wine[] getAll() 
	{	
		//return new Wine[] {a, b, c, d, e};
		// from the database
		List<Wine> wines = DatabaseManager.getInstance().getAllWines();
		return wines.toArray(new Wine[wines.size()]);
	}
	
	/*public Producer getProducer() 
	{
		// TODO actual implementation that works
		return new Producer();
	}*/


	public SweetOrDry getSweetOrDry() {
		return new SweetOrDry("SWEET");
	}

	public Varietal getVarietal() {
		// would usually load from database
		return new Varietal("CAYETANA");
	}

	public Category getCategory() {
		return new Category("RED");
	}

	public void save() {
        DatabaseManager.getInstance().updateWine(this);
	}
}
