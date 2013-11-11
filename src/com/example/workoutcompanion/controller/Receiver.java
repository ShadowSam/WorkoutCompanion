package com.example.workoutcompanion.controller;

import android.content.Context;
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
		DBH.addWorkout(buildWorkout(workoutName));
		for (Object e : exercises.toArray()) {
			// We know that everything in the Array is a String, so
			// it is not necessary to check before casting
			CreateExercise((String)e);
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
		if (DBH.updateWorkout(buildWorkout(workoutName)) == 0)
			return false;
		return true;
	}
	
	/**
	 * 
	 * @param exerciseName
	 * @return
	 */
	public boolean CreateExercise(String exerciseName) {
		// If exercise exists in db, return false
		DBH.addExercise(buildExercise(exerciseName));
		return true;
	}
	
	/**
	 * 
	 * @param exerciseName
	 * @return
	 */
	public boolean EditExercise(String exerciseName) {
		if (DBH.updateExercise(buildExercise(exerciseName)) == 0)
			return false;
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
