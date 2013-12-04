package com.example.workoutcompanion.controller;

import java.util.Arrays;

public class AddExerciseToWorkoutCmd extends EditWorkoutCmd {

	public AddExerciseToWorkoutCmd(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute(String... names) {
		String workoutName = names[0];
		String[] exerciseNames = Arrays.copyOfRange(names, 1, names.length);
				
		receiver.EditWorkout(workoutName,exerciseNames,null);
	}

}
