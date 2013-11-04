package com.example.workoutcompanion.controller;

public class CreateExercise implements Command
{
	Receiver receiver;

	public CreateExercise(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute()
	{
		receiver.CreateExercise("");
	}
}
