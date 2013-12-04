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
	
	private DatabaseHandler DBH;

	private Workout buildWorkout(String wN) {
		return new Workout(wN);
	}
	private Exercise buildExercise(String eN) {
		return new Exercise(eN);
	}

	/**
	 * Creates workout for given string name and array of string exercises.
	 * @param workoutName String Name of workout
	 * @param exercises String[] Array of exercise names
	 * @return boolean success
	 */
	public boolean CreateWorkout(String workoutName,String[] exercises) {
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
	 * @param workoutName String Name of workout to edit
	 * @param exToAdd String[] Names of exercises to add to workout
	 * @param exToRem String[] Names of exercises to remove from workout
	 * @return boolean success
	 */
	public boolean EditWorkout(String workoutName,
			String[] exToAdd, String[] exToRem) {
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
					return false; // doesn't exist
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
				workout.getExercises().remove(DBH.findExercise(e));
				// It is possible to remove something from the list if it is not
				// even in the list; this is not a problem, generally.
				// Also a necessity: Removing the workout from the exercise
			} catch (SQLException e1) {
				// The exercise does not exist in the database
				e1.printStackTrace();
				return false; // do this for now
			}
			// Remove exercise from workout
		} // Removing exercises from workouts; exercises exist in DB
		
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
				return false; // exercise present in db already
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
		try {
			if (DBH.addOrUpdateExercise(buildExercise(exerciseName)) == null)
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
