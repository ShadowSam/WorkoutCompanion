package com.example.workoutcompanion.controller;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveExerciseFromWorkout extends EditWorkoutCommand {

	public RemoveExerciseFromWorkout(Receiver receiver) {
		super(receiver);
	}
	
	public void execute(String... names)
	{
		String workoutName = names[0];
		String exerciseNames = names[1];
		
		ArrayList<String> exercisesToRemove = (ArrayList<String>) Arrays.asList(exerciseNames);
		
		receiver.EditWorkout(workoutName,null,exercisesToRemove);
	}

}
