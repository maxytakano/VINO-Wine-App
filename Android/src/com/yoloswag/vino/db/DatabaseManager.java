package com.yoloswag.vino.db;

import java.sql.SQLException;
import java.util.List;

import com.yoloswag.vino.model.Entry;
import com.yoloswag.vino.model.Wine;

import android.content.Context;

public class DatabaseManager {

    static private DatabaseManager instance;

    static public void init(Context ctx) {
        if (null==instance) {
            instance = new DatabaseManager(ctx);
        }
    }

    static public DatabaseManager getInstance() {
        return instance;
    }

    private DatabaseHelper helper;
    private DatabaseManager(Context ctx) {
        helper = new DatabaseHelper(ctx);
    }

    private DatabaseHelper getHelper() {
        return helper;
    }

    public List<Entry> getAllEntries() {
        List<Entry> entries = null;
        try {
            entries = getHelper().getEntryDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entries;
    }

    public List<Wine> getAllWines() {
        List<Wine> entries = null;
        try {
            entries = getHelper().getWineDao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entries;
    }

	public void updateEntry(Entry entry) {
		// TODO Auto-generated method stub
        try {
            getHelper().getEntryDao().createOrUpdate(entry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void updateWine(Wine wine) {
		// TODO Auto-generated method stub
        try {
            getHelper().getWineDao().createOrUpdate(wine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}