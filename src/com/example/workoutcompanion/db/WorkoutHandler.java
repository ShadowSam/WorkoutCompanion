package com.example.workoutcompanion.db;

import java.util.ArrayList;
import java.util.List;

import com.example.workoutcompanion.dom.Exercise;
import com.example.workoutcompanion.dom.TableRecord;
import com.example.workoutcompanion.dom.Workout;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class WorkoutHandler implements TableHandler {

	// Contacts table name
	private static final String TABLE_WORKOUTS = "exercises";

	// Contacts Table Columns names
	public static final String KEY_ID = "id";
	public static final String KEY_NAME = "name";

	public static final String[] COLUMN_NAMES = new String[]{KEY_ID,KEY_NAME};

	
	@Override
	public void createTable(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_WORKOUTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"+ ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	@Override
	public void upgradeTable(SQLiteDatabase db) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORKOUTS);
		// Create tables again
		createTable(db);
	}

	@Override
	public int entityCount(SQLiteDatabase db) {
		String countQuery = "SELECT  * FROM " + TABLE_WORKOUTS;
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

	@Override
	public TableRecord find(SQLiteDatabase db, long id) {
		Cursor cursor = db.query(TABLE_WORKOUTS, COLUMN_NAMES, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		Workout newWorkout = new Workout(cursor.getString(1));
		newWorkout.setID(Long.parseLong(cursor.getString(0)));
		cursor.close();

		return newWorkout;
	}

	@Override
	public List<TableRecord> findAll(SQLiteDatabase db) {
		List<TableRecord> workoutList = new ArrayList<TableRecord>();

		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_WORKOUTS;
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				TableRecord aWorkout = cursorToRecord(cursor);
				// Adding contact to list
				workoutList.add(aWorkout);
			} while (cursor.moveToNext());
		}

		cursor.close();

		// return contact list
		return workoutList;
	}

	@Override
	public TableRecord add(SQLiteDatabase db, TableRecord e) {
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, ((Workout) e).getName());

		// Inserting Row
		long insertID = db.insert(TABLE_WORKOUTS, null, values);
		Cursor cursor = db.query(TABLE_WORKOUTS, COLUMN_NAMES, KEY_ID + "=?",
				new String[] { String.valueOf(insertID) }, null, null, null, null);

		Exercise newExercise = (Exercise) cursorToRecord(cursor);
		cursor.close();
		db.close(); // Closing database connection

		return newExercise;
	}

	@Override
	public int update(SQLiteDatabase db, TableRecord e) {
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, ((Exercise) e).getName());

		// updating row
		return db.update(TABLE_WORKOUTS, values, KEY_ID + " = ?",new String[] { String.valueOf(((Exercise) e).getID()) });
	}

	@Override
	public void remove(SQLiteDatabase db, TableRecord e) {
		db.delete(TABLE_WORKOUTS, KEY_ID + " = ?",
				new String[] { String.valueOf(e.getID()) });
		db.close();
	}

	@Override
	public TableRecord cursorToRecord(Cursor cursor) {
		Workout aWorkout = new Workout(cursor.getString(1));
		aWorkout.setID(Long.parseLong(cursor.getString(0)));
		return aWorkout;
	}

}
