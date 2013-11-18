package com.example.workoutcompanion.controller;


public class EditExercise implements Command
{
	Receiver receiver;

	public EditExercise(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute(String... name)
	{
		receiver.EditExercise(name[0]);
	}
}
