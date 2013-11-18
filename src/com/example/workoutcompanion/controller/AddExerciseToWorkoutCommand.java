package com.example.workoutcompanion.controller;

import java.util.ArrayList;
import java.util.Arrays;

public class AddExerciseToWorkoutCommand extends EditWorkoutCommand {

	public AddExerciseToWorkoutCommand(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute(String... names) {
		String workoutName = names[0];
		String exerciseNames = names[1];
		
		ArrayList<String> exercisesToAdd = (ArrayList<String>) Arrays.asList(exerciseNames);
		
		receiver.EditWorkout(workoutName,exercisesToAdd,null);
	}

}
