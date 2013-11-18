package com.example.workoutcompanion.db;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.workoutcompanion.dom.Exercise;
import com.example.workoutcompanion.dom.TableRecord;
import com.example.workoutcompanion.dom.Workout;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHandler extends OrmLiteSqliteOpenHelper {

	// name of the database file for your application -- change to something appropriate for your app
	private static final String DATABASE_NAME = "WorkoutCompanion.db";
	// any time you make changes to your database objects, you may have to increase the database version
	private static final int DATABASE_VERSION = 1;

	// the DAO object we use to access the Exercise table
	private Dao<Exercise, String> exerciseDao = null;
	private RuntimeExceptionDao<Exercise, String> exerciseRuntimeDao = null;

	// the DAO object we use to access the Workout table
	private Dao<Workout, String> workoutDao = null;
	private RuntimeExceptionDao<Workout, String> workoutRuntimeDao = null;

	public DatabaseHandler(Context aContext) {
		super(aContext, DATABASE_NAME, null, DATABASE_VERSION, 0x7f040000);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0, ConnectionSource arg1) {
		try {
			//Log.i(DatabaseHelper.class.getName(), "onCreate");
			TableUtils.createTable(connectionSource, Workout.class);
			TableUtils.createTable(connectionSource, Exercise.class);
		} catch (SQLException e) {
			//Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, ConnectionSource arg1, int arg2,
			int arg3) {
		try {
			//Log.i(DatabaseHelper.class.getName(), "onUpgrade");
			TableUtils.dropTable(connectionSource, Exercise.class, true);
			TableUtils.dropTable(connectionSource, Workout.class, true);
			// after we drop the old databases, we create the new ones
			onCreate(arg0, connectionSource);
		} catch (SQLException e) {
			//Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
			throw new RuntimeException(e);
		}
	}

	/**
	 * Close the database connections and clear any cached DAOs.
	 */
	@Override
	public void close() {
		super.close();
		exerciseRuntimeDao = null;
		workoutRuntimeDao = null;
	}

	private Dao<Exercise, String> getExerciseDao() throws SQLException {
		if(exerciseDao == null) {
			exerciseDao = getDao(Exercise.class);
		}
		return exerciseDao;
	}

	private RuntimeExceptionDao<Exercise, String> getExerciseRuntimeDao() {
		if (exerciseRuntimeDao == null) {
			exerciseRuntimeDao = getRuntimeExceptionDao(Exercise.class);
		}
		return exerciseRuntimeDao;
	}

	private Dao<Workout, String> getWorkoutDao() throws SQLException {
		if(workoutDao == null) {
			workoutDao = getDao(Workout.class);
		}
		return workoutDao;
	}

	private RuntimeExceptionDao<Workout, String> getWorkoutRuntimeDao() {
		if (workoutRuntimeDao == null) {
			workoutRuntimeDao = getRuntimeExceptionDao(Workout.class);
		}
		return workoutRuntimeDao;
	}

	public Workout findWorkout(String workoutName) throws SQLException {
		return getWorkoutDao().queryForId(workoutName);
	}

	public List<Workout> findAllWorkouts() throws SQLException {
		return getWorkoutDao().queryForAll();
	}

	public Exercise findExercise(String exerciseName) throws SQLException {
		return getExerciseDao().queryForId(exerciseName);
	}

	public Exercise changeExerciseName(String oldName,String newName) throws SQLException {
		getExerciseDao().updateId(findExercise(oldName), newName);
		return findExercise(newName);
		
	}

	public Workout changeWorkoutName(String oldName,String newName) throws SQLException {
		getWorkoutDao().updateId(findWorkout(oldName), newName);
		return findWorkout(newName);
	}

	public List<Exercise> findAllExercises() throws SQLException {
		return getExerciseDao().queryForAll();
	}

	public Workout addOrUpdateWorkout(Workout aWorkout) throws SQLException {
		getWorkoutDao().createOrUpdate(aWorkout);
		return findWorkout(aWorkout.getName());
	}

	public Exercise addOrUpdateExercise(Exercise aExercise) throws SQLException {
		getExerciseDao().createOrUpdate(aExercise);
		return findExercise(aExercise.getName());
	}

	public void removeWorkout(String name) throws SQLException {
		getWorkoutDao().deleteById(name);
	}

	public void removeExercise(String name) throws SQLException {
		getExerciseDao().deleteById(name);
	}

}
