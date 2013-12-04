package com.example.workoutcompanion.controller;

import java.util.Arrays;


public class CreateWorkoutCmd implements Command
{
	Receiver receiver;

	public CreateWorkoutCmd(Receiver receiver)
	{
		this.receiver = receiver;
	}

	/**
	 * names[0] - name of the workout
	 * names[...] - names of workouts
	 */
	public void execute(String... names)
	{
		String workoutName = names[0];
		String[] exerciseNames = Arrays.copyOfRange(names, 1, names.length);
		
		receiver.CreateWorkout(workoutName,exerciseNames);
	}
}
