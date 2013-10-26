package com.example.workoutcompanion.dom;

public abstract class TableRecord {
	protected int m_nID;
	
	public int getM_nID() {
		return m_nID;
	}

	protected TableRecord(int a_nID) {
		m_nID = a_nID;
	}
	
}
