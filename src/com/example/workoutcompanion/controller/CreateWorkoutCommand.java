package com.example.workoutcompanion.controller;

public class CreateWorkoutCommand implements Command
{
	Receiver receiver;

	public CreateWorkoutCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute()
	{
		receiver.CreateWorkout();
	}
}
