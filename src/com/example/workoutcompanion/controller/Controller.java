package com.example.workoutcompanion.controller;

import android.content.Context;

public class Controller {

	public Controller(Context context){
		Receiver receiver = new Receiver(context);
		
		//Create commands
		Command createExercise = new CreateExerciseCmd(receiver);
		// INSERT REST OF COMMANDS HERE
	}
	
}
