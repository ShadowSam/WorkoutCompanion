package com.example.workoutcompanion.controller;

import java.util.ArrayList;


public class CreateWorkoutCommand implements Command
{
	Receiver receiver;

	public CreateWorkoutCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

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
