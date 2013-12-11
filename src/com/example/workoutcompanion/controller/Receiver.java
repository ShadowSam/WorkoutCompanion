package com.example.workoutcompanion.controller;

import android.content.Context;

import java.sql.SQLException;
import com.example.workoutcompanion.db.*;
import com.example.workoutcompanion.dom.*;

public class Receiver {

	/**
	 * Constructor for receiver. Creates DatabaseHandler based on supplied context.
	 * @param context Some context
	 */
	public Receiver(Context context) {
		DBH = new DatabaseHandler(context);
	}
	
	/**
	 * The handler for the database.
	 */
	private DatabaseHandler DBH;

	/**
	 * Helper function to build workouts so that code is not replicated.
	 * @param wN Name of the workout to build
	 * @return Workout object
	 */
	private Workout buildWorkout(String wN) {
		return new Workout(wN);
	}
	
	/**
	 * Helper function to build exercises so that code is not replicated.
	 * @param eN Name of the exercise to build
	 * @return Exercise object
	 */
	private Exercise buildExercise(String eN) {
		return new Exercise(eN);
	}

	/**
	 * Creates workout for given string name and array of string exercises.
	 * @param workoutName Name of workout
	 * @param exercises Array of exercise names
	 * @return boolean success
	 */
	public boolean CreateWorkout(String workoutName,String[] exercises) {
		/*
		 * Function to create a workout and enter it into the database.
		 * If a workout is successfully created, then the function will return
		 * TRUE. If there is an error with the connection to the database, then
		 * a stack trace will be printed and the function will return FALSE.
		 * There is no other situation where FALSE will be returned -- even if
		 * a workout is already in the database, it can still be added.
		 */
		Workout workout = buildWorkout(workoutName);
		try {
			for(String exerciseName: exercises) {
				workout.getExercises().add(DBH.findExercise(exerciseName));
			}
			DBH.addOrUpdateWorkout(workout);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Edits the database entry for given workout to hold new exercises
	 * @param workoutName Name of workout to edit
	 * @param exToAdd Array of exercise names to add to workout
	 * @param exToRem Array of exercise names to remove from workout
	 * @return boolean success
	 */
	public boolean EditWorkout(String workoutName,
			String[] exToAdd, String[] exToRem) {
		/*
		 * 
		 */
		Workout workout;
		try {
			workout = DBH.findWorkout(workoutName);
		} catch (SQLException e2) {
			// There is no such workout in the database
			e2.printStackTrace();
			return false;
		}
		
		for (String e : exToAdd) {
			try {
				// Attempt to find exercise in DB, then add exercise to workout
				Exercise exercise;
				if ((exercise = DBH.findExercise(e)) == null)
					return false; // doesn't exist; create exercise?
				workout.getExercises().add(exercise);
				exercise.getWorkouts().add(workout);
			} catch (SQLException e1) {
				// Database malfunction.
				e1.printStackTrace();
				return false; // just do this for now
			}
		}
		
		for (String e : exToRem) {
			try {
				Exercise exercise;
				if ((exercise = DBH.findExercise(e)) == null)
					return false; // exercise doesn't exist
				workout.getExercises().remove(exercise);
				exercise.getWorkouts().remove(workout);
				/* 
				 * It is possible to remove something from the list if it is not
				 * even in the list; this is not a problem, generally.
				 */
			} catch (SQLException e1) {
				// The exercise does not exist in the database
				e1.printStackTrace();
				return false; // do this for now
			}
		}
		
		try {
			if (DBH.addOrUpdateWorkout(workout) == null)
				return false; // Workout can't be added to the DB
		} catch (SQLException e1) {
			// There was some exception that broke things.
			e1.printStackTrace();
			return false;
		}
		
		return true;
	}

	/**
	 * Creates an exercise for the given name.
	 * @param exerciseName String Name of the exercise
	 * @return boolean success
	 */
	public boolean CreateExercise(String exerciseName) {
		// If exercise exists in db, return false :)
		try {
			if (DBH.findExercise(exerciseName) != null)
				return false;
			/*
			 * The database already contains an entry for an exercise of this name.
			 * You shouldn't be creating duplicate entries, so we want this to fail.
			 */
		} catch (SQLException e) {
			// Database failure
			e.printStackTrace();
			return false;
		}
		
		// We want to have separate try statements for each point of access to
		// the database, so that we can discover where exactly errors are prone
		// to occur. Thanks.
		
		try {
			Exercise exercise = buildExercise(exerciseName);
			DBH.addOrUpdateExercise(exercise);
		} catch (SQLException e) {
			// Something broke, RIP
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Edits an exercise that is present in the database.
	 * @param exerciseName String Name of exercise
	 * @return boolean success
	 */
	public boolean EditExercise(String exerciseName) {
		// The functionality of this depends on what we want to be editable.
		// Obviously incomplete.
		try {
			if (DBH.addOrUpdateExercise(buildExercise(exerciseName)) == null)
				return false;
			/*
			 * in theory, this should never be null, since an exercise run through
			 * this function will be added to the database if it does not exist
			 * to be updated. however, it is appropriate to consider so-called
			 * "impossible" scenarios.
			 */
		} catch (SQLException e) {
			// SQL DB failure
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @return
	 */
	public boolean EditProfile() {
		return true;

	}

}
