package com.example.workoutcompanion.dom;

import java.util.ArrayList;
import java.util.List;

public class Workout extends WorkoutComponent {
	
	private Long m_nProfileID;
	private List<Exercise> m_oExcercises;
	
	public Workout(String a_sName) {
		super(a_sName);
		setM_oExcercises(new ArrayList<Exercise>());
	}

	public Long getProfileID() {
		return m_nProfileID;
	}

	public void setProfileID(Long m_nProfileID) {
		this.m_nProfileID = m_nProfileID;
	}

	public List<Exercise> getM_oExcercises() {
		return m_oExcercises;
	}

	public void setM_oExcercises(List<Exercise> m_oExcercises) {
		this.m_oExcercises = m_oExcercises;
	}

}
