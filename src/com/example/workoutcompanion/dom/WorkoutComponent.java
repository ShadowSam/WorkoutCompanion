package com.example.workoutcompanion.dom;

public abstract class WorkoutComponent extends TableRecord {

	protected String m_sName;

	protected WorkoutComponent(int a_nID,String a_sName) {
		super(a_nID);
		m_sName = a_sName;
	}
	
	public String getM_sName() {
		return m_sName;
	}

	public void setM_sName(String m_sName) {
		this.m_sName = m_sName;
	}

}
