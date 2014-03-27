package com.example.moletracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class AddMoleAdapter {
	static final String DATABASE_NAME = "moles.db";
	static final int DATABASE_VERSION = 1;
	public static final int NAME_COLUMN = 1;
	
	static final String DATABASE_CREATE = "CREATE TABLE " + "MOLES" +
			"( " +"ID"+" integer primary key autoincrement, "+ "LOCATION text, AREA text " + ")";
	
	
	public SQLiteDatabase db;
	private final Context context;
	private DataBaseHelper dbHelper;
	
	//public String ButtonList(int ID) {
		
	//}
	
	public AddMoleAdapter(Context _context) {
		context = _context;
		dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public AddMoleAdapter open() throws SQLException {
		db = dbHelper.getWritableDatabase();
		return this;
	}
	
	public void Close() {
		db.close();
	}
	
	public SQLiteDatabase getDatabaseInstance() {
		return db;
	}
	
	public void insertEntry(String mlocation, String area) {
		ContentValues newValues = new ContentValues();
		newValues.put("LOCATION", mlocation);
		newValues.put("AREA", area);
		db.insert("MOLES", null, newValues);
	}
	
	public int deleteEntry(String mlocation) {
		String where = "LOCATION=?";
		int numberOfEntriesDeleted = db.delete("MOLES", where, new String[]{mlocation});
		return numberOfEntriesDeleted;
	}
	
	public String getSingleEntry(String mlocation) {
		Cursor cursor = db.query("MOLES", null, "LOCATION=?", new String[]{mlocation}, null, null, null);
		if ( cursor.getCount()<1 ) {
			cursor.close();
			return "NOT EXIST";
		}
		
		cursor.moveToFirst();
		String area = cursor.getString(cursor.getColumnIndex("AREA"));
		cursor.close();
		return area;
	}
	
	public int countButtons(String area) {
		Cursor c = db.rawQuery("SELECT LOCATION FROM MOLES WHERE AREA = \"" + area + "\"", null);
		int count = c.getCount();
		c.close();
		return count;
	}
	
	public String[] buttonName(String area) {
		Cursor c = db.rawQuery("SELECT LOCATION FROM MOLES WHERE AREA = \"" + area + "\"", null);
		int count = c.getCount();
		String arr[]=new String[count];
		int i=0;
		c.moveToFirst();
		while (c.isAfterLast() == false) 
		{
		    arr[i]  = c.getString(0);
		    i++;
		    c.moveToNext();
		}
		return arr;
	}
	
	public void updateEntry(String mlocation, String area) {
		ContentValues updatedValues = new ContentValues();
		updatedValues.put("LOCATION", mlocation);
		updatedValues.put("AREA", area);
		
		String where = "LOCATION=?";
		db.update("MOLES", updatedValues, where, new String[]{mlocation});
	}

}

