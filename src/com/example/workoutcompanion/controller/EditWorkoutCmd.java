package com.example.workoutcompanion.controller;


public abstract class EditWorkoutCmd implements Command
{
	Receiver receiver;

	public EditWorkoutCmd(Receiver receiver)
	{
		this.receiver = receiver;
	}

//	public void execute(String... names)
//	{
//		receiver.EditWorkout("test",null,null);
//	}
}
