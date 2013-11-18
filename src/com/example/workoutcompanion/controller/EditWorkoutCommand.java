package com.example.workoutcompanion.controller;


public abstract class EditWorkoutCommand implements Command
{
	Receiver receiver;

	public EditWorkoutCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

//	public void execute(String... names)
//	{
//		receiver.EditWorkout("test",null,null);
//	}
}
