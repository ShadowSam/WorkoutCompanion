package com.example.workoutcompanion.db;

import java.util.List;

import com.example.workoutcompanion.dom.TableRecord;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Handler interface that defines how database should be interacted with.
 * 
 * @author Peter-John Rowe
 *
 */
public interface TableHandler {
	public void createTable(SQLiteDatabase db);
	public void upgradeTable(SQLiteDatabase db);
	public TableRecord find(SQLiteDatabase db,long id);
	public List<TableRecord> findAll(SQLiteDatabase db);
	public TableRecord add(SQLiteDatabase db,TableRecord e);
	public int update(SQLiteDatabase db,TableRecord e);
	public void remove(SQLiteDatabase db,TableRecord e);
	public int entityCount(SQLiteDatabase db);
	public TableRecord cursorToRecord(Cursor cursor);
}
