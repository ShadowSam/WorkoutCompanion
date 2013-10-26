package com.example.workoutcompanion.db;

import java.util.List;

import com.example.workoutcompanion.dom.Exercise;
import com.example.workoutcompanion.dom.Profile;
import com.example.workoutcompanion.dom.Schedule;
import com.example.workoutcompanion.dom.TableRecord;
import com.example.workoutcompanion.dom.Workout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This class is the brain behind database access and modifications.
 * 
 * @author Peter-John Rowe
 *
 */
public class DatabaseHandler extends SQLiteOpenHelper {
	// All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
 
    // Database Name
    private static final String DATABASE_NAME = "fitnessManager";
 
    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
 
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PH_NO = "phone_number";
	
	private TableHandler workouts;
	private TableHandler exercises;
	private TableHandler profiles;
	private TableHandler schedules;
	
	public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
		workouts = new WorkoutHandler();
		exercises = new ExerciseHandler();
		profiles = new ProfileHandler();
		schedules = new ScheduleHandler();
    }
	
	 // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        workouts.createTable(db);
		exercises.createTable(db);
		profiles.createTable(db);
		schedules.createTable(db);
    }
	
	 // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        workouts.upgradeTable(db);
		exercises.upgradeTable(db);
		profiles.upgradeTable(db);
		schedules.upgradeTable(db);
    }
	
	public void addWorkout(Workout newWorkout) {
		workouts.add(getWritableDatabase(),newWorkout);
	}
	
	public void addExercise(Exercise newExercise) {
		exercises.add(getWritableDatabase(),newExercise);
	}
	
	public void addprofile(Profile newProfile) {
		profiles.add(getWritableDatabase(),newProfile);
	}
	
	public void addSchedule(Schedule newSchedule) {
		schedules.add(getWritableDatabase(),newSchedule);
	}
	
	public TableRecord getWorkout(int id) {
		return workouts.find(getReadableDatabase(),id);
	}
	
	public TableRecord getExercise(int id) {
		return exercises.find(getReadableDatabase(),id);
	}
	
	public TableRecord getProfile(int id) {
		return profiles.find(getReadableDatabase(),id);
	}
	
	public TableRecord getSchedule(int id) {
		return schedules.find(getReadableDatabase(),id);
	}
	
	public List<TableRecord> getAllWorkouts() {
		return workouts.findAll(getWritableDatabase());
	}
	
	public List<TableRecord> getAllExercises() {
		return exercises.findAll(getWritableDatabase());
	}
	
	public List<TableRecord> getAllProfiles() {
		return profiles.findAll(getWritableDatabase());
	}
	
	public List<TableRecord> getAllSchedules() {
		return schedules.findAll(getWritableDatabase());
	}
	
	public int updateWorkout(Workout aWorkout) {
		return workouts.update(getWritableDatabase(),aWorkout);
	}
	
	public int updateExercise(Exercise aExercise) {
		return exercises.update(getWritableDatabase(),aExercise);
	}
	
	public int updateProfile(Profile aProfile) {
		return profiles.update(getWritableDatabase(),aProfile);
	}
	
	public int updateSchedule(Schedule aSchedule) {
		return schedules.update(getWritableDatabase(),aSchedule);
	}
	
	public void deleteWorkout(Workout aWorkout) {
		workouts.remove(getWritableDatabase(),aWorkout);
	}
	
	public void deleteExercise(Exercise aExercise) {
		exercises.remove(getWritableDatabase(),aExercise);
	}
	
	public void deleteProfile(Profile aProfile) {
		profiles.remove(getWritableDatabase(),aProfile);
	}
	
	public void deleteSchedule(Schedule aSchedule) {
		schedules.remove(getWritableDatabase(),aSchedule);
	}
	
	public int getWorkoutCount() {
		return workouts.entityCount(getReadableDatabase());
	}
	
	public int getExerciseCount() {
		return exercises.entityCount(getReadableDatabase());
	}
	
	public int getProfileCount() {
		return profiles.entityCount(getReadableDatabase());
	}
	
	public int getScheduleCount() {
		return schedules.entityCount(getReadableDatabase());
	}
}
