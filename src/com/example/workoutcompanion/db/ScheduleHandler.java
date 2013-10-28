package com.example.workoutcompanion.db;

import java.util.List;

import com.example.workoutcompanion.dom.TableRecord;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ScheduleHandler implements TableHandler {

	@Override
	public void createTable(SQLiteDatabase db) {
		// TODO Auto-generated method stub

	}

	@Override
	public void upgradeTable(SQLiteDatabase db) {
		// TODO Auto-generated method stub

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
	public TableRecord add(SQLiteDatabase db, TableRecord e) {
		return e;
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

	@Override
	public TableRecord cursorToRecord(Cursor cursor) {
		// TODO Auto-generated method stub
		return null;
	}

}
