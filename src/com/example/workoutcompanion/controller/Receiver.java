package com.example.workoutcompanion.controller;

import com.example.workoutcompanion.db.*;
import com.example.workoutcompanion.dom.*;

public class Receiver {

	private DatabaseHandler DBH = new DatabaseHandler(null);
	
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
