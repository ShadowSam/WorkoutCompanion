package com.example.workoutcompanion.db;

import java.util.ArrayList;
import java.util.List;

import com.example.workoutcompanion.dom.Exercise;
import com.example.workoutcompanion.dom.TableRecord;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ExerciseHandler implements TableHandler {

	// Contacts table name
	private static final String TABLE_EXERCISES = "exercises";

	// Contacts Table Columns names
	public static final String KEY_ID = "id";
	public static final String KEY_NAME = "name";
	public static final String FOREIGN_KEY_WORKOUT = "workoutid";

	public static final String[] COLUMN_NAMES = new String[]{KEY_ID,KEY_NAME,FOREIGN_KEY_WORKOUT};

	@Override
	public void createTable(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_EXERCISES + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ FOREIGN_KEY_WORKOUT + " ID" + ")";
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
	public TableRecord find(SQLiteDatabase db, long id) {
		Cursor cursor = db.query(TABLE_EXERCISES, COLUMN_NAMES, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		Exercise newExercise = new Exercise(cursor.getString(1));
		newExercise.setID(Long.parseLong(cursor.getString(0)));
		newExercise.setWorkoutID(Long.parseLong(cursor.getString(2)));
		cursor.close();

		return newExercise;
	}

	@Override
	public List<TableRecord> findAll(SQLiteDatabase db) {
		List<TableRecord> exerciseList = new ArrayList<TableRecord>();

		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_EXERCISES;
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				TableRecord aExercise = cursorToRecord(cursor);
				// Adding contact to list
				exerciseList.add(aExercise);
			} while (cursor.moveToNext());
		}

		cursor.close();

		// return contact list
		return exerciseList;
	}

	@Override
	public TableRecord add(SQLiteDatabase db, TableRecord e) {
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, ((Exercise) e).getName()); // Contact Name
		values.put(FOREIGN_KEY_WORKOUT, ((Exercise) e).getWorkoutID()); // Contact Phone

		// Inserting Row
		long insertID = db.insert(TABLE_EXERCISES, null, values);
		Cursor cursor = db.query(TABLE_EXERCISES, COLUMN_NAMES, KEY_ID + "=?",
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
		values.put(FOREIGN_KEY_WORKOUT, ((Exercise) e).getWorkoutID());

		// updating row
		return db.update(TABLE_EXERCISES, values, KEY_ID + " = ?",new String[] { String.valueOf(((Exercise) e).getID()) });
	}

	@Override
	public void remove(SQLiteDatabase db, TableRecord e) {
		db.delete(TABLE_EXERCISES, KEY_ID + " = ?",
				new String[] { String.valueOf(e.getID()) });
		db.close();
	}

	@Override
	public int entityCount(SQLiteDatabase db) {
		String countQuery = "SELECT  * FROM " + TABLE_EXERCISES;
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

	@Override
	public TableRecord cursorToRecord(Cursor cursor) {
		Exercise aExercise = new Exercise(cursor.getString(1));
		aExercise.setID(Long.parseLong(cursor.getString(0)));
		((Exercise) aExercise).setWorkoutID(Long.parseLong(cursor.getString(2)));
		return aExercise;
	}

}
