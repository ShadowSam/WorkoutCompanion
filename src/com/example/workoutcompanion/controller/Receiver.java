package com.example.workoutcompanion.controller;

import android.content.Context;
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
	public boolean CreateWorkout(String workoutName) {
		DBH.addWorkout(buildWorkout(workoutName));
		// there will ofc be logic in here to determine pass/fail
		// some error catching and whatever
		// same with succeeding functions
		return true;
	}
	
	/**
	 * 
	 * @param workoutName
	 * @return
	 */
	public boolean EditWorkout(String workoutName) {
		DBH.updateWorkout(buildWorkout(workoutName));
		return true;
	}
	
	/**
	 * 
	 * @param exerciseName
	 * @return
	 */
	public boolean CreateExercise(String exerciseName) {
		DBH.addExercise(buildExercise(exerciseName));
		return true;
	}
	
	/**
	 * 
	 * @param exerciseName
	 * @return
	 */
	public boolean EditExercise(String exerciseName) {
		DBH.updateExercise(buildExercise(exerciseName));
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
