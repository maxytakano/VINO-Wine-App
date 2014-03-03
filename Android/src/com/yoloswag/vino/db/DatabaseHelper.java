package com.yoloswag.vino.db;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.yoloswag.vino.model.Entry;
import com.yoloswag.vino.model.Wine;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	// name of the database file for your application -- change to something appropriate for your app
	private static final String DATABASE_NAME = "VxIxNxOdDxB.sqlite";

	// any time you make changes to your database objects, you may have to increase the database version
	private static final int DATABASE_VERSION = 1;

	// the DAO object we use to access the SimpleData table
	private Dao<Entry, Integer> entryDao = null;
	private Dao<Wine, Integer> wineDao = null;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database,ConnectionSource connectionSource) {
		try {
			TableUtils.createTable(connectionSource, Entry.class);
			TableUtils.createTable(connectionSource, Wine.class);
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
		
		{
			// Here is your example @Jasmine
			// (Some of these details are made up)
			// The wine we are inserting for this example is:
			// Name				: Barefoot Chardonnay
			// Region			: USA
			// Vintage			: 1940
			// Category			: White
			// Varietal			: Chardonnay
			// Sweet/Dry		: Dry
			// Producer/Winery	: Barefoot

			String region = "USA";
			String vintage = "1940";
			String category = "White";
			String varietal = "Chardonnay";
			String sweetdry = "Dry";
			String producer = "Barefoot";

			// Create the wine
			Wine example = new Wine(producer, varietal, category, region, sweetdry, vintage);

			// Save the wine to the db
			example.save();
			
			
			Wine barefoot1  = new Wine("Barefoot", "Chardonnay", "White", "California", "Dry", "2000");
			Wine barefoot2  = new Wine("Barefoot", "Cabernet Sauvignon", "Red", "California", "Dry", "2000");
			Wine barefoot3  = new Wine("Barefoot", "Impression, Red Blend", "Red", "California", "Dry", "2000");
			Wine barefoot4  = new Wine("Barefoot", "Merlot", "Red", "California", "Dry", "2000");
			Wine barefoot5  = new Wine("Barefoot", "Moscato", "White", "California", "Sweet", "2000");
			Wine barefoot6  = new Wine("Barefoot", "Pinot Grigio", "White", "California", "Dry", "2000");
			Wine barefoot7  = new Wine("Barefoot", "Pinot Noir", "Red", "California", "Dry", "2000");
			Wine barefoot8  = new Wine("Barefoot", "Riesling", "White", "California", "Sweet", "2000");
			Wine barefoot9  = new Wine("Barefoot", "Sauvignon Blanc", "White", "California", "Dry", "2000");
			Wine barefoot10 = new Wine("Barefoot", "Shiraz", "Red", "California", "Dry", "2000");
			Wine barefoot11 = new Wine("Barefoot", "White Zinfandel", "Rose", "California", "Sweet", "2000");
			Wine barefoot12 = new Wine("Barefoot", "Zinfandel", "White", "California", "Dry", "2000");
			barefoot1.save(); barefoot2.save(); barefoot3.save(); barefoot4.save(); barefoot5.save(); barefoot6.save();
			barefoot7.save(); barefoot8.save(); barefoot9.save(); barefoot10.save(); barefoot11.save(); barefoot12.save();

			Wine chuckShaw1 = new Wine("Charles Shaw", "Cabernet Sauvignon", "Red", "California", "Dry", "2000");
			Wine chuckShaw2 = new Wine("Charles Shaw", "Chardonnay", "White", "California", "Dry", "2000");
			Wine chuckShaw3 = new Wine("Charles Shaw", "Merlot", "Red", "California", "Dry", "2000");
			Wine chuckShaw4 = new Wine("Charles Shaw", "Pinot Grigio", "White", "California", "Dry", "2000");
			Wine chuckShaw5 = new Wine("Charles Shaw", "Sauvignon Blanc", "White", "California", "Dry", "2000");
			Wine chuckShaw6 = new Wine("Charles Shaw", "Shiraz", "Red", "California", "Dry", "2000");
			Wine chuckShaw7 = new Wine("Charles Shaw", "White Zinfandel", "Rose", "California", "Sweet", "2000");
			chuckShaw1.save(); chuckShaw2.save(); chuckShaw3.save(); chuckShaw4.save(); chuckShaw5.save(); 
			chuckShaw6.save(); chuckShaw7.save();
			
			Wine csmichelle1  = new Wine("Chateau Ste. Michelle", "Cabernet Sauvignon", "Red", "Washington", "Dry", "2000");
			Wine csmichelle2  = new Wine("Chateau Ste. Michelle", "Chardonnay", "White", "Washington", "Dry", "2000");
			Wine csmichelle3  = new Wine("Chateau Ste. Michelle", "Chenin Blanc", "White", "Washington", "Dry", "2000");
			Wine csmichelle4  = new Wine("Chateau Ste. Michelle", "Gewurztraminer", "White", "Washington", "Sweet", "2000");
			Wine csmichelle5  = new Wine("Chateau Ste. Michelle", "Malbec", "Red", "Washington", "Dry", "2000");
			Wine csmichelle6  = new Wine("Chateau Ste. Michelle", "Merlot", "Red", "Washington", "Dry", "2000");
			Wine csmichelle7  = new Wine("Chateau Ste. Michelle", "Pinot Gris", "White", "Washington", "Dry", "2000");
			Wine csmichelle8  = new Wine("Chateau Ste. Michelle", "Riesling", "White", "Washington", "Sweet", "2000");
			Wine csmichelle9  = new Wine("Chateau Ste. Michelle", "Sauvignon Blanc", "White", "Washington", "Dry", "2000");
			Wine csmichelle10 = new Wine("Chateau Ste. Michelle", "Syrah", "Red", "Washington", "Dry", "2000");
			csmichelle1.save(); csmichelle2.save(); csmichelle3.save(); csmichelle4.save(); csmichelle5.save(); 
			csmichelle6.save(); csmichelle7.save(); csmichelle8.save(); csmichelle9.save(); csmichelle10.save(); 
			
			Wine cupcake1  = new Wine("Cupcake", "Angel Food", "White", "California", "Dry", "2000");
			Wine cupcake2  = new Wine("Cupcake", "Cabernet Sauvignon", "Red", "California", "Dry", "2000");
			Wine cupcake3  = new Wine("Cupcake", "Chianti", "Red", "California", "Dry", "2000");
			Wine cupcake4  = new Wine("Cupcake", "Gewurztraminer", "White", "California", "Sweet", "2000");
			Wine cupcake5  = new Wine("Cupcake", "Malbec", "Red", "California", "Dry", "2000");
			Wine cupcake6  = new Wine("Cupcake", "Merlot", "Red", "California", "Dry", "2000");
			Wine cupcake7  = new Wine("Cupcake", "Moscato D'Asti", "Sparkling", "California", "Sweet", "2000");
			Wine cupcake8  = new Wine("Cupcake", "Petite Sirah", "Red", "California", "Dry", "2000");
			Wine cupcake9  = new Wine("Cupcake", "Pinot Grigio", "White", "California", "Dry", "2000");
			Wine cupcake10 = new Wine("Cupcake", "Prosecco", "Sparkling", "California", "Sweet", "2000");
			Wine cupcake11 = new Wine("Cupcake", "Pinot Noir", "Red", "California", "Dry", "2000");
			Wine cupcake12 = new Wine("Cupcake", "Red Velvet", "Red", "California", "Dry", "2000");
			Wine cupcake13 = new Wine("Cupcake", "Riesling", "White", "California", "Sweet", "2000");
			Wine cupcake14 = new Wine("Cupcake", "Rose", "White", "California", "Dry", "2000");
			Wine cupcake15 = new Wine("Cupcake", "Sauvignon Blanc", "White", "California", "Dry", "2000");
			Wine cupcake16 = new Wine("Cupcake", "Shiraz", "Red", "California", "Dry", "2000");
			Wine cupcake17 = new Wine("Cupcake", "Zinfandel", "Red", "California", "Dry", "2000");
			cupcake1.save(); cupcake2.save(); cupcake3.save(); cupcake4.save(); cupcake5.save(); cupcake6.save(); 
			cupcake7.save(); cupcake8.save(); cupcake9.save(); cupcake10.save(); cupcake11.save(); cupcake12.save(); 
			cupcake13.save(); cupcake14.save(); cupcake15.save(); cupcake16.save(); cupcake17.save();
			
			Wine k_j1  = new Wine("Kendall-Jackson", "Cabernet Sauvignon", "Red", "California", "Dry", "2000");
			Wine k_j2  = new Wine("Kendall-Jackson", "Chardonnay", "White", "California", "Dry", "2000");
			Wine k_j3  = new Wine("Kendall-Jackson", "Late Harvest Chardonnay", "Dessert", "California", "Dry", "2000");
			Wine k_j4  = new Wine("Kendall-Jackson", "Merlot", "Red", "California", "Dry", "2000");
			Wine k_j5  = new Wine("Kendall-Jackson", "Pinot Gris", "White", "California", "Dry", "2000");
			Wine k_j6  = new Wine("Kendall-Jackson", "Pinot Noir", "Red", "California", "Dry", "2000");
			Wine k_j7  = new Wine("Kendall-Jackson", "Riesling", "White", "California", "Sweet", "2000");
			Wine k_j8  = new Wine("Kendall-Jackson", "Sauvignon Blanc", "White", "California", "Dry", "2000");
			Wine k_j9  = new Wine("Kendall-Jackson", "Summation", "White", "California", "Dry", "2000");
			Wine k_j10 = new Wine("Kendall-Jackson", "Syrah", "Red", "California", "Dry", "2000");
			Wine k_j11 = new Wine("Kendall-Jackson", "Viognier", "White", "California", "Dry", "2000");
			Wine k_j12 = new Wine("Kendall-Jackson", "Zinfandel", "Red", "California", "Dry", "2000");
			k_j1.save(); k_j2.save(); k_j3.save(); k_j4.save(); k_j5.save(); k_j6.save(); 
			k_j7.save(); k_j8.save(); k_j9.save(); k_j10.save(); k_j11.save(); k_j12.save(); 
			
			Wine skinnygirl1 = new Wine("Skinnygirl", "California Red Blend", "Red", "California", "Dry", "2000");
			Wine skinnygirl2 = new Wine("Skinnygirl", "California Rose Blend", "Rose", "California", "Sweet", "2000");
			Wine skinnygirl3 = new Wine("Skinnygirl", "California White Blend", "White", "California", "Dry", "2000");
			Wine skinnygirl4 = new Wine("Skinnygirl", "Moscato", "White", "California", "Sweet", "2000");
			skinnygirl1.save(); skinnygirl2.save(); skinnygirl3.save(); skinnygirl4.save(); 
			
			Wine sutter1  = new Wine("Sutter Homes", "Cabernet Sauvignon", "Red", "California", "Dry", "2000");
			Wine sutter2  = new Wine("Sutter Homes", "Chardonnay", "White", "California", "Dry", "2000");
			Wine sutter3  = new Wine("Sutter Homes", "Chenin Blanc", "White", "California", "Dry", "2000");
			Wine sutter4  = new Wine("Sutter Homes", "Gewurztraminer", "White", "California", "Dry", "2000");
			Wine sutter5  = new Wine("Sutter Homes", "Merlot", "Red", "California", "Dry", "2000");
			Wine sutter6  = new Wine("Sutter Homes", "Moscato", "White", "California", "Sweet", "2000");
			Wine sutter7  = new Wine("Sutter Homes", "Pink Moscato", "Rose", "California", "Sweet", "2000");
			Wine sutter8  = new Wine("Sutter Homes", "Pink Pinot Grigio", "Rose", "California", "Dry", "2000");
			Wine sutter9  = new Wine("Sutter Homes", "Pinot Grigio", "White", "California", "Dry", "2000");
			Wine sutter10 = new Wine("Sutter Homes", "Pinot Noir", "Red", "California", "Dry", "2000");
			Wine sutter11 = new Wine("Sutter Homes", "Red Moscato", "Red", "California", "Sweet", "2000");
			Wine sutter12 = new Wine("Sutter Homes", "Riesling", "White", "California", "Sweet", "2000");
			Wine sutter13 = new Wine("Sutter Homes", "Sauvignon Blanc", "White", "California", "Dry", "2000");
			Wine sutter14 = new Wine("Sutter Homes", "Sweet Red", "Red", "California", "Sweet", "2000");
			Wine sutter15 = new Wine("Sutter Homes", "Sweet White", "White", "California", "Sweet", "2000");
			Wine sutter16 = new Wine("Sutter Homes", "White Merlot", "Rose", "California", "Dry", "2000");
			Wine sutter17 = new Wine("Sutter Homes", "White Zinfandel", "Rose", "California", "Sweet", "2000");
			Wine sutter18 = new Wine("Sutter Homes", "Zinfandel", "Red", "California", "Dry", "2000");
			sutter1.save(); sutter2.save(); sutter3.save(); sutter4.save(); sutter5.save(); sutter6.save(); 
			sutter7.save(); sutter8.save(); sutter9.save(); sutter10.save(); sutter11.save(); sutter12.save(); 
			sutter13.save(); sutter14.save(); sutter15.save(); sutter16.save(); sutter17.save(); sutter18.save(); 
			
			Wine woodbridge1  = new Wine("Woodbridge", "Cabernet Sauvignon", "Red", "California", "Dry", "2000");
			Wine woodbridge2  = new Wine("Woodbridge", "Cabernet Merlot", "Red", "California", "Dry", "2000");
			Wine woodbridge3  = new Wine("Woodbridge", "Chardonnay", "White", "California", "Dry", "2000");
			Wine woodbridge4  = new Wine("Woodbridge", "Lightly Oaked Chardonnay", "White", "California", "Dry", "2000");
			Wine woodbridge5  = new Wine("Woodbridge", "Malbec", "Red", "California", "Dry", "2000");
			Wine woodbridge6  = new Wine("Woodbridge", "Merlot", "Red", "California", "Dry", "2000");
			Wine woodbridge7  = new Wine("Woodbridge", "Moscato", "White", "California", "Sweet", "2000");
			Wine woodbridge8  = new Wine("Woodbridge", "Pinot Grigio", "White", "California", "Dry", "2000");
			Wine woodbridge9  = new Wine("Woodbridge", "Pinot Noir", "Red", "California", "Dry", "2000");
			Wine woodbridge10 = new Wine("Woodbridge", "Riesling", "White", "California", "Sweet", "2000");
			Wine woodbridge11 = new Wine("Woodbridge", "Sauvignon Blanc", "White", "California", "Dry", "2000");
			Wine woodbridge12 = new Wine("Woodbridge", "Shiraz", "Red", "California", "Dry", "2000");
			Wine woodbridge13 = new Wine("Woodbridge", "White Zinfandel", "Rose", "California", "Sweet", "2000");
			Wine woodbridge14 = new Wine("Woodbridge", "Zinfandel", "Red", "California", "Dry", "2000");
			woodbridge1.save(); woodbridge2.save(); woodbridge3.save(); woodbridge4.save(); woodbridge5.save(); 
			woodbridge6.save(); woodbridge7.save(); woodbridge8.save(); woodbridge9.save(); woodbridge10.save(); 
			woodbridge11.save(); woodbridge12.save(); woodbridge13.save(); woodbridge14.save(); 
			
			Wine yt1  = new Wine("Yellow Tail", "Cabernet Sauvignon", "Red", "Australia", "Dry", "2000");
			Wine yt2  = new Wine("Yellow Tail", "Cabernet-Merlot", "Red", "Australia", "Dry", "2000");
			Wine yt3  = new Wine("Yellow Tail", "Chardonnay", "White", "Australia", "Dry", "2000");
			Wine yt4  = new Wine("Yellow Tail", "Merlot", "Red", "Australia", "Dry", "2000");
			Wine yt5  = new Wine("Yellow Tail", "Pinot Grigio", "White", "Australia", "Dry", "2000");
			Wine yt6  = new Wine("Yellow Tail", "Pinot Noir", "Red", "Australia", "Dry", "2000");
			Wine yt7  = new Wine("Yellow Tail", "Riesling", "White", "Australia", "Sweet", "2000");
			Wine yt8  = new Wine("Yellow Tail", "Sauvignon Blanc", "White", "Australia", "Dry", "2000");
			Wine yt9  = new Wine("Yellow Tail", "Shiraz", "Red", "Australia", "Dry", "2000");
			Wine yt10 = new Wine("Yellow Tail", "Shiraz-Cabernet", "Red", "Australia", "Dry", "2000");
			Wine yt11 = new Wine("Yellow Tail", "Shiraz-Grenache", "Red", "Australia", "Dry", "2000");
			yt1.save(); yt2.save(); yt3.save(); yt4.save(); yt5.save(); yt6.save(); yt7.save(); 
			yt8.save(); yt9.save(); yt10.save(); yt11.save();
			
			
		}

		//Wine a = new Wine("Castello Banfi", "Italy", "2008", 12.9, "red", "Chianti", "dry");
		//new Wine("Chardonnay", "USA","2013",3,"white","Barefoot","dry").save();
		//a.save();
		Entry b = new Entry(Wine.a, "title1", "France", "yoloswaging it up", 3);
		b.save();
		/*
		Entry.a.save();
		Entry.b.save();
		Entry.c.save();
		Entry.d.save();
		Entry.e.save();*/
		Entry e = new Entry(Wine.c, "title2", "New Zealand", "hi", 1);
		e.save();
		Entry d = new Entry(Wine.d, "title3", "California", "WHISTLE GOES WOO WOO", 5);
		d.save();
		Entry c = new Entry(Wine.a, "title4", "France", "If you see this it doesn't work ]:", 3);
		c.save();
		c.comment = "If you see this then it works [:";
		c.save();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db,ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			List<String> allSql = new ArrayList<String>(); 
			switch(oldVersion) 
			{
			case 1: 
				//allSql.add("alter table AdData add column `new_col` VARCHAR");
				//allSql.add("alter table AdData add column `new_col2` VARCHAR");
			}
			for (String sql : allSql) {
				db.execSQL(sql);
			}
		} catch (SQLException e) {
			Log.e(DatabaseHelper.class.getName(), "exception during onUpgrade", e);
			throw new RuntimeException(e);
		}

	}

	public Dao<Entry, Integer> getEntryDao() {
		if (null == entryDao) {
			try {
				entryDao = getDao(Entry.class);
			}catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return entryDao;
	}

	public Dao<Wine, Integer> getWineDao() {
		if (null == wineDao) {
			try {
				wineDao = getDao(Wine.class);
			}catch (java.sql.SQLException e) {
				e.printStackTrace();
			}
		}
		return wineDao;
	}

}
