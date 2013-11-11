package com.example.workoutcompanion.controller;


public class EditWorkoutCommand implements Command
{
	Receiver receiver;

	public EditWorkoutCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute()
	{
		receiver.EditWorkout("test");
	}
}
