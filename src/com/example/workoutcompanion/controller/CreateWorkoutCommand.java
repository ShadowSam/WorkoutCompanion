package com.example.workoutcompanion.controller;

import Command;
import Receiver;

public class CreateWorkoutCommand implements Command
{
	Receiver receiver;

	public CreateWorkoutCommand(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute()
	{
		receiver.CreateWorkout();
	}
}
