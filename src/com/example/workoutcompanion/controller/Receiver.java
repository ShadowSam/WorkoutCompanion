package com.example.workoutcompanion.controller;

import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import com.example.workoutcompanion.db.*;
import com.example.workoutcompanion.dom.*;

public class Receiver {

	private DatabaseHandler DBH;
	
	private Workout buildWorkout(String wN) {
		return new Workout(wN);
	}
	private Exercise buildExercise(String eN) {
		return new Exercise(eN);
	}
	
	/**
	 * 
	 * @param context
	 */
	public Receiver(Context context) {
		DBH = new DatabaseHandler(context);
	}
	
	/**
	 * 
	 * @param workoutName
	 * @return
	 */
	public boolean CreateWorkout(String workoutName, 
			ArrayList<String> exercises) {
		Workout workout = buildWorkout(workoutName);
		try {
			DBH.addOrUpdateWorkout(workout);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (Object e : exercises.toArray()) {
			// We know that everything in the Array is a String, so
			// it is not necessary to check before casting
			CreateExercise((String)e, workout.getName());
		} // Unsure how to connect Exercises and Workouts -- not impl yet?
		return true;
	}
	
	/**
	 * 
	 * @param workoutName
	 * @return
	 */
	public boolean EditWorkout(String workoutName,
			ArrayList<String> exToAdd, ArrayList<String> exToRem) {
		for (Object e : exToAdd.toArray()) {
			// If exercise is not in database, create it
			// Finally, add exercise to workout
		} // Adding exercises to workout
		for (Object e : exToRem.toArray()) {
			// Remove exercise from workout
		} // Removing exercises from workouts; exercises exist in DB
		try {
			if (DBH.addOrUpdateWorkout(buildWorkout(workoutName)) == null)
				return false;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 
	 * @param exerciseName
	 * @return
	 */
	public boolean CreateExercise(String exerciseName) {
		// If exercise exists in db, return false
		Exercise exercise = buildExercise(exerciseName);
		try {
			DBH.addOrUpdateExercise(exercise);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	/**
	 * 
	 * @param exerciseName
	 * @return
	 */
	public boolean EditExercise(String exerciseName) {
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
