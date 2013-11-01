package com.example.workoutcompanion.controller;

import Command;
import Receiver;

public class CreateExercise implements Command
{
	Receiver receiver;

	public CreateExercise(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute()
	{
		receiver.CreateExercise();
	}
}
