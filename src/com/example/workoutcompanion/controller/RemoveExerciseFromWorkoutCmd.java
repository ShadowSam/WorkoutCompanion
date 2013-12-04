package com.example.workoutcompanion.controller;

import java.util.Arrays;

public class RemoveExerciseFromWorkoutCmd extends EditWorkoutCmd {

	public RemoveExerciseFromWorkoutCmd(Receiver receiver) {
		super(receiver);
	}
	
	public void execute(String... names)
	{
		String workoutName = names[0];
		String[] exerciseNames = Arrays.copyOfRange(names, 1, names.length);
				
		receiver.EditWorkout(workoutName,null,exerciseNames);
	}

}
