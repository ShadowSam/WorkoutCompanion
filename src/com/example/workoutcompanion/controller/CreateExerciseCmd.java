package com.example.workoutcompanion.controller;

public class CreateExerciseCmd implements Command
{
	Receiver receiver;

	public CreateExerciseCmd(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute(String... names)
	{
		String exerciseName = names[0];
		
		receiver.CreateExercise(exerciseName);
	}
}
