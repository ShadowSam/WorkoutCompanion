package com.example.workoutcompanion.dom;

import java.util.ArrayList;
import java.util.List;

public class Profile {
	private String name;
	private List<Workout> workouts;
	private static Profile instance;
	public Profile() {
		setWorkouts(new ArrayList<Workout>());
		this.name = null;
	}

	public static Profile getProfile(){
		if (Profile.instance == null){
			Profile.instance = new Profile();
			Profile.instance.name = "Pop";
		} 
		return Profile.instance;
	}
	public void addWorkout(Workout workout) {
		workouts.add(workout);
	}
	
	public void removeWorkout(Workout workout) {
		workouts.remove(workout);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Workout> getWorkouts() {
		return workouts;
	}

	public void setWorkouts(List<Workout> workouts) {
		this.workouts = workouts;
	}
}
