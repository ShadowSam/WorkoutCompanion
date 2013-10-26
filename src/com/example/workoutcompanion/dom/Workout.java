package com.example.workoutcompanion.dom;

import java.util.ArrayList;
import java.util.List;

public class Workout extends WorkoutComponent {

	private List<WorkoutComponent> exerciseList;
	
	protected Workout(int a_nID,String a_sName) {
		super(a_nID,a_sName);
		exerciseList = new ArrayList<WorkoutComponent>();
	}

}
