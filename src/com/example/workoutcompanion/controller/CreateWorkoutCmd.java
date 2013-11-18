package com.example.workoutcompanion.controller;

import java.util.ArrayList;


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
		ArrayList<String> exerciseNames = new ArrayList<String>();
		
		for(int i = 1; i < names.length; i++) {
			exerciseNames.add(names[i]);
		}
		receiver.CreateWorkout(workoutName,exerciseNames);
	}
}
