package com.example.workoutcompanion.db;

import java.util.List;

import com.example.workoutcompanion.dom.TableRecord;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class ExerciseHandler implements TableHandler {

	// Contacts table name
    private static final String TABLE_EXERCISES = "exercises";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
	
	@Override
	public void createTable(SQLiteDatabase db) {
		// TO DO
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_EXERCISES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PH_NO + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void upgradeTable(SQLiteDatabase db) {
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        // Create tables again
        createTable(db);
	}

	@Override
	public TableRecord find(SQLiteDatabase db, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TableRecord> findAll(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(SQLiteDatabase db, TableRecord e) {
		// TODO Auto-generated method stub

	}

	@Override
	public int update(SQLiteDatabase db, TableRecord e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove(SQLiteDatabase db, TableRecord e) {
		// TODO Auto-generated method stub

	}

	@Override
	public int entityCount(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		return 0;
	}

}
