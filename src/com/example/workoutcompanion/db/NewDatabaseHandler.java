package com.example.workoutcompanion.db;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.workoutcompanion.dom.Exercise;
import com.example.workoutcompanion.dom.Workout;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class NewDatabaseHandler extends OrmLiteSqliteOpenHelper {

	// name of the database file for your application -- change to something appropriate for your app
		private static final String DATABASE_NAME = "WorkoutCompanion.db";
		// any time you make changes to your database objects, you may have to increase the database version
		private static final int DATABASE_VERSION = 1;

		// the DAO object we use to access the Exercise table
		private Dao<Exercise, Integer> exerciseDao = null;
		private RuntimeExceptionDao<Exercise, Integer> exerciseRuntimeDao = null;

		// the DAO object we use to access the Workout table
		private Dao<Workout, Integer> workoutDao = null;
		private RuntimeExceptionDao<Workout, Integer> workoutRuntimeDao = null;
		
		public NewDatabaseHandler(Context aContext) {
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

		public Dao<Exercise, Integer> getExerciseDao() throws SQLException {
			if(exerciseDao == null) {
				exerciseDao = getDao(Exercise.class);
			}
			return exerciseDao;
		}

		public RuntimeExceptionDao<Exercise, Integer> getExerciseRuntimeDao() {
			if (exerciseRuntimeDao == null) {
				exerciseRuntimeDao = getRuntimeExceptionDao(Exercise.class);
			}
			return exerciseRuntimeDao;
		}

		public Dao<Workout, Integer> getWorkoutDao() throws SQLException {
			if(workoutDao == null) {
				workoutDao = getDao(Workout.class);
			}
			return workoutDao;
		}

		public RuntimeExceptionDao<Workout, Integer> getWorkoutRuntimeDao() {
			if (workoutRuntimeDao == null) {
				workoutRuntimeDao = getRuntimeExceptionDao(Workout.class);
			}
			return workoutRuntimeDao;
		}

		
}
