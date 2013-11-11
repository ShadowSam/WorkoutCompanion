package com.example.workoutcompanion.controller;


public class EditExercise implements Command
{
	Receiver receiver;

	public EditExercise(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute()
	{
		receiver.EditExercise("test");
	}
}
