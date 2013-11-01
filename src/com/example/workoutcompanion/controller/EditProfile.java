package com.example.workoutcompanion.controller;

import Command;
import Receiver;

public class EditProfile implements Command
{
	Receiver receiver;

	public EditProfile(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute()
	{
		receiver.EditProfile();
	}
}
