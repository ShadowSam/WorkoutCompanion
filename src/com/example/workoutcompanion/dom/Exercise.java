package com.example.workoutcompanion.dom;

public class Exercise extends WorkoutComponent {

	private Long m_nWorkoutID;
	
	public Exercise(String a_sName) {
		super(a_sName);
	}

	public Long getWorkoutID() {
		return m_nWorkoutID;
	}

	public void setWorkoutID(Long m_nWorkoutID) {
		this.m_nWorkoutID = m_nWorkoutID;
	}

}
