package com.example.workoutcompanion.controller;


public class EditProfileCmd implements Command
{
	Receiver receiver;

	public EditProfileCmd(Receiver receiver)
	{
		this.receiver = receiver;
	}

	public void execute(String... names)
	{
		receiver.EditProfile();
	}
}
