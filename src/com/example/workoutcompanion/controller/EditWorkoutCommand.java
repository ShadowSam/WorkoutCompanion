package com.example.workoutcompanion.controller;

import Command;
import Receiver;

public class EditWorkoutCommand implements Command
{
	Receiver receiver;

	public EditWorkoutCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute()
	{
		receiver.EditWorkout();
	}
}
