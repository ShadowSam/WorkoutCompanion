package com.example.workoutcompanion.controller;

import Command;
import Receiver;

public class EditExercise implements Command
{
	Receiver receiver;

	public EditExercise(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute()
	{
		receiver.EditExercise();
	}
}
