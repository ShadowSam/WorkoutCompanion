package com.example.workoutcompanion.dom;

import java.util.ArrayList;
import java.util.List;

public class Profile extends TableRecord {

	private List<WorkoutComponent> m_oWorkouts;
	
	protected Profile() {
		super();
		m_oWorkouts = new ArrayList<WorkoutComponent>();
	}

}
