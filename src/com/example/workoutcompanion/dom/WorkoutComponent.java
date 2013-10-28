package com.example.workoutcompanion.dom;

public abstract class WorkoutComponent extends TableRecord {

	protected String m_sName;
	
	protected WorkoutComponent(String a_sName) {
		super();
		m_sName = a_sName;
	}
	
	public String getName() {
		return m_sName;
	}

	public void setName(String m_sName) {
		this.m_sName = m_sName;
	}

}
