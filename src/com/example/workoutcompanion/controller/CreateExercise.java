package com.example.workoutcompanion.controller;

public class CreateExercise implements Command
{
	Receiver receiver;

	public CreateExercise(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute(String... names)
	{
		String exerciseName = names[0];
		String workoutName = names[1];
		
		receiver.CreateExercise(exerciseName,workoutName);
	}
}
