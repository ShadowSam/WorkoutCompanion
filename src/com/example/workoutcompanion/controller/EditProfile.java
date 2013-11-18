package com.example.workoutcompanion.controller;


public class EditProfile implements Command
{
	Receiver receiver;

	public EditProfile(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute(String... names)
	{
		receiver.EditProfile();
	}
}
