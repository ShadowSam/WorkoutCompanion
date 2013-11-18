package com.example.workoutcompanion.controller;


public class EditExerciseCmd implements Command
{
	Receiver receiver;

	public EditExerciseCmd(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute(String... name)
	{
		receiver.EditExercise(name[0]);
	}
}
