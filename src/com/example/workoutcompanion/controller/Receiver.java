package com.example.workoutcompanion.controller;

import android.content.Context;
import com.example.workoutcompanion.db.*;
import com.example.workoutcompanion.dom.*;

public class Receiver {

	private DatabaseHandler DBH;
	
	public Receiver(Context context) {
		DBH = new DatabaseHandler(context);
	}
	
	public boolean CreateWorkout(String workoutName) {
		Workout newWorkout = new Workout(workoutName);
		DBH.addWorkout(newWorkout);
		return true;
	}
	
	public boolean EditWorkout() {
		return true;
	}
	
	public boolean CreateExercise(String exerciseName) {
		Exercise newExercise = new Exercise(exerciseName);
		DBH.addExercise(newExercise);
		return true;
	}
	
	public boolean EditExercise() {
		return true;
	}
	
	public boolean EditProfile() {
		return true;

	}
	
}
